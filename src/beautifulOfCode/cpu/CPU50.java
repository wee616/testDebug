package beautifulOfCode.cpu;

/**
 * 让CPU使用率画出一条直线，比如50%，可查资料，限时45分钟
 * @author 11941
 *
 */
public class CPU50 {

	/**
	 * 考虑点：
	 * 1、多核CPU如何工作的？
	 * 2、如何避免电脑上其他进程的干扰？
	 * 3、如何让程序均匀的保持50%的CPU占有？
	 * 
	 * 知识点补充：
	 * 在任务管理器刷新的一个周期内，CPU忙的时间和刷新周期总时间的比率，就是CPU的占用率
	 */
	
	/**
	 * 不考虑多核，不考虑其他进程干扰，只考虑指令的耗时，完成test1
	 * 由于CPU的转速存在差异性，这里不适用所有机器
	 * 在4核2.7GHz环境下测试，实际占用率只有8%左右
	 */
	public void test1(){
		while(true){
			//程序运行多久然后空闲,需要考虑到CPU的频率2.7GHz,CPU每个时间周期可以完成2条以上的指令。
			//2.7*10^9*2/5 = 1080000000,即1s可以执行1080000000个循环，考虑到平滑性，单位降低到ms,取1080000
			for(int i=0;i<1080000;i++){
				/**
				 * 这里的for循环实际执行了5条指令：
				 * 1、定义i初始化为1
				 * 2、i+1
				 * 3、将i+1的结果赋值给i
				 * 4、比较i
				 * 5、小于则继续循环
				 */
				;
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * 用System.currentTimeMillis()来判断需要执行多少时间、需要休眠多少时间
	 * 调用方法后，不能清晰的知道执行了多少指令，需要调整参数
	 * 在4核2.7GHz环境下测试，实际占用率28%左右
	 */
	public void test2(){
		long busyTime = 1;//1ms
		long sleepTime = busyTime;
		long startTime = 0;
		while(true){
			startTime = System.currentTimeMillis();
			while(System.currentTimeMillis() - startTime <= busyTime){
				;
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 利用windows提供的工具查询内存使用率，
	 * 使用调用java的Runtime.getRuntime().exec执行cmd应用程序
	 * 如果不到50%则循环判断，到50%则sleep()
	 * java代码比较复杂，没有进行测试
	 */
	public void test3(){
		
	}
}
