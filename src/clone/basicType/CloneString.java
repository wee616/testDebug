package clone.basicType;

import java.lang.reflect.Field;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/14
 */
public class CloneString {

    public static void main(String[] args){

        /**
         * 观察mm与nn的地址、观察class文件
         */
        String mm = "abc";
        String nn = "abc";
        System.out.println("mm=" + mm + ",mm.hashCode="+ System.identityHashCode(mm));
        System.out.println("nn=" + nn + ",nn.hashCode="+ System.identityHashCode(nn));
        System.out.println("String类型存储时按照UTF-8编码的字符串进行分配内存，长度小于2个字节都会存放在栈里。");
        System.out.println();

        /**
         * 观察String的克隆
         */
        String tt = mm;
        mm = "dd";
        System.out.println("mm=" + mm + ",mm.hashCode="+ System.identityHashCode(mm));
        System.out.println("tt=" + tt + ",tt.hashCode="+ System.identityHashCode(tt));
        System.out.println("现象与基本类型基本相同，mm指向了新地址，tt地址不变。String虽然不是基本类型，但是clone的表现与基本类型一致。");
        System.out.println();

        /**
         * 针对final的实验
         * 1、仿造String，写final的TestString，值可以改变，地址不变
         * 2、用反射破坏final，clone发生了变化
         */
        TestString testString = new TestString("aaa".toCharArray());
        System.out.println("testString=" + testString + ",testString.hashCode="+ System.identityHashCode(testString));
        testString.changeValue();
        System.out.println("testString=" + testString + ",testString.hashCode="+ System.identityHashCode(testString));

        try {
            Field field = nn.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.set(nn, "aa".toCharArray());
            System.out.println("nn=" + nn + ",nn.hashCode="+ System.identityHashCode(nn));
            System.out.println("tt=" + tt + ",tt.hashCode="+ System.identityHashCode(tt));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("网上一些说法，说String的clone特性是因为其final，final并不能保护String的这一特性。" +
                "与基本类型相似，在编译时，String类型的变量会放在方法区或者栈里，引用会指向常量。");


    }
}