package beautifulOfCode.divList;

/**
 * 写一个方法，返回一个数组中的所有元素被第一个元素除的结果
 * @author 11941
 *
 */
public class DivList {
	
	/**
	 * 未看书时的尝试
	 * 有两个地方做的不好：
	 * 1、入参校验的还不够，未考虑除数为0的情况
	 * 2、定义了responce，空间复杂度增加了，如果不定义responce还需要考虑正序第一个数据的处理
	 * 避免第一个数据变成了1
	 */
	public Double[] test1(Double[] request){
		//入参做校验
		if(request == null || request.length <= 0){
			return request;
		}
		Double[] responce = new Double[request.length];
		Double div = request[0];
		for(int i=0;i<request.length;i++){
			responce[i] = div/request[i];
		}
		return responce;
	}
	
	/**
	 * 看书后尝试
	 * @param request
	 * @return
	 */
	public Double[] test2(Double[] request){
		//入参做校验
		if(request == null || request.length <= 0){
			return request;
		}
		for(int i=request.length-1;i>=0;i--){
			if(request[i] != 0){
				request[i] = request[0]/request[i];
			}
		}
		return request;
	}
	
	public void showResponce(Double[] responce){
		if(responce != null && responce.length > 0){
			for(Double param:responce){
				System.out.println(param);
			}
		}
	}
}
