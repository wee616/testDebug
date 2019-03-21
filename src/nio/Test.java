package nio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/3/12
 */
public class Test {


    public static void main(String[] args) {

//        testBuffer();
        testFileOutputStream();
        testChannel();
        testMappedByteBuffer();
//        testFileLock();

    }

    /**
     * 观察缓冲区基本属性
     * position位置：下一个要读写的位置
     * limit限制：最大读写限制
     * capacity容量：buffer最大数据容量
     * flip：从写模式切换到读模式
     */
    private static void testBuffer() {
        LongBuffer longBuffer = LongBuffer.allocate(10);
        System.out.println(longBuffer.position() + " " + longBuffer.limit() + " " + longBuffer.capacity());
        longBuffer.put(1L);
        longBuffer.put(2L);
        System.out.println(longBuffer.position() + " " + longBuffer.limit() + " " + longBuffer.capacity());
        longBuffer.flip();
        System.out.println(longBuffer.position() + " " + longBuffer.limit() + " " + longBuffer.capacity());
    }

    /**
     * 使用文件流写文件
     */
    private static void testFileOutputStream() {
        String info = "1111111111";
        File file = new File("d:/testFileOutputStream.txt");
        FileOutputStream output = null;
        BufferedOutputStream bufferedOutputStream = null;
        Date begin = new Date();
        try {
            output = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(output);
            for(int i = 0;i< 500000;i++){
                bufferedOutputStream.write(info.getBytes());
            }
            Date end = new Date();
            System.out.println((end.getTime() - begin.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (output != null) {
                try {
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用FileChannel写文件
     * channel通道负责传输，Buffer负责存储
     */
    private static void testChannel() {
        String info = "1111111111";
        File file = new File("d:/testChannel.txt");
        FileOutputStream output = null;
        FileChannel fout = null;
        try {
            Date begin = new Date();
            output = new FileOutputStream(file);
            fout = output.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(5000000);
            for(int i = 0;i< 500000;i++){
                buf.put(info.getBytes());
            }
            buf.flip();
            fout.write(buf);
            Date end = new Date();
            System.out.println((end.getTime() - begin.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试MappedByteBuffer
     */
    private static void testMappedByteBuffer() {
        String info = "1111111111";
        RandomAccessFile output = null;
        FileChannel fout = null;
        try {
            Date begin = new Date();
            output = new RandomAccessFile("d:/testChannel1.txt","rw");
            fout = output.getChannel();
            MappedByteBuffer buf1 =  fout.map(FileChannel.MapMode.READ_WRITE, 0, 5000000);
            for(int i = 0;i< 500000;i++){
                buf1.put(info.getBytes());
            }
            buf1.flip();
            Date end = new Date();
            System.out.println((end.getTime() - begin.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试FileLock文件锁
     * FileLock基于FileCHannel
     * lock()阻塞的方法，锁定范围可以随着文件的增大而增加。
     * 无参lock()默认为独占锁；有参lock(0L, Long.MAX_VALUE, true)为共享锁。
     *
     * tryLock()非阻塞,当未获得锁时,返回null。
     * 无参tryLock()默认为独占锁；有参tryLock(0L, Long.MAX_VALUE, true)为共享锁。
     */
    private static void testFileLock() {
        String info = "运满满让公路物流更美好";
        File file = new File("d:/testChannel.txt");
        FileOutputStream output = null;
        FileChannel fout = null;
        try {
            output = new FileOutputStream(file);
            fout = output.getChannel();
            FileLock lock = fout.tryLock();
            if(lock != null){
                System.out.println("获取到锁");
                Thread.sleep(2000);
                lock.release();
                System.out.println("释放锁");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}