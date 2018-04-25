package beautifulOfCode.countOneFromBinaryNumber;

/**
 * 对于一个字节8bit的无符号整型变量，求其二进制表示中1的个数
 * @author 11941 
 *
 */
public class CountOneFromBinaryNumber {

	//用了位操作，但是if判断也可以用与操作代替，时间复杂度O(log2n)
	public int doThis(int num){
		int result = 0;
		while(num != 0){
			if(num%2==1){
				result++;
			}
			num >>= 1;
		}
		return result;
	}
	
	// 将if判断改用与操作，有两个位移操作
	public int doThis2(int num){
		int result = 0;
		while(num != 0){
			result += (num & 1);
			num >>= 1;
		}
		return result;
	}
	
	//如果只有一个1，例如0x01000000,则01000000&(01000000-00000001)=01000000&00111111=0
	public int doThis3(int num){
		int result = 0;
		while(num != 0){
			num &= num-1;
			result++;
		}
		return result;
	}
	
	//其他方法：由于数据量有限，可以考虑将所有情况列举在数组里，直接得出结果。
}
