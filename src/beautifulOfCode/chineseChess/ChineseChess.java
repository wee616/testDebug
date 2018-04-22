package beautifulOfCode.chineseChess;

/**
 * 假设棋盘上只有将与帅，将帅不能在一条直线上，写出将帅的所有位置可能，只能使用一个变量
 * 帅{d1,d3,f1,f3}  将{d8,d10,f8,f10}
 * @author 11941
 *
 */
public class ChineseChess {
	
	public void test1(){
		/**
		 * 思考1：用穷举法，直接输出坐标，可以不用变量啊
		 * 思考2：题目限制了变量，那常量算不算呢？将位置定义为常量可以满足要求，不过题目似乎不是考察这个
		 * 如果不用这种方法，思路为：
		 * 遍历A，
		 * 		遍历B，
		 * 		判断AB位置是否满足要求
		 * 		满足则输出
		 */
		//书上的逻辑用C语言实现，分别用1~9表示将帅的位置，有很多的宏定义，大意是用byte或者int型的变量，分别取高四位第四位做循环
		//感觉有点像思考2的方式
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				if(i%3 == j%3){
					continue;
				}
				System.out.println("A space:"+ i + " B space:" + j);
			}
		}
	}
	
	//这种方式没看懂...
	public void test2(){
		int i = 81;
		while(i-- != 0){
			if(i/9%3 == i%9%3){
				continue;
			}
			System.out.println("A space:"+ (i/9 + 1) + " B space:" + (i%9 + 1));
		}
	}
}
