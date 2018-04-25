package beautifulOfCode.count1From1ToN;

/**
 * 给一个十进制的正整数N，计算出从1到N出现的所有‘1’的个数
 * 
 * @author 11941
 *
 */
public class Count1From1ToN {
	/**
	 * 思路：遍历1至N,对10取余判断，循环对10取模，时间复杂度O(nlgN)
	 * 
	 * @param n
	 * @return
	 */
	public int doThis1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num != 0) {
				if(num%10==1){
					count++;
				}
				num/=10;
			}
		}
		return count;
	}
	
	//原书举了很多例子，总结出规律，得出了一个数学上的一般规律，理解数学规律实在太难了...
	public int doThis2(int n) {
		return n;
	}
}
