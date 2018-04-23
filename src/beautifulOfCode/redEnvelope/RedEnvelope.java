package beautifulOfCode.redEnvelope;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.util.Assert;

/**
 * 抢红包算法，N个人，抢总量为M的红包，设计出方案 思考一：随机法：第一个人在M的基础上随机，第二个人在剩余金额上随机，依次类推
 * 这种方案有个缺点，第一个人random(100)，平均值为50。如果他拿了50，第二个人random(50)，平均值只有25了。
 * 思考二：二倍均值法：每次抢到的金额=random(M/N*2)，M为剩余金额，N为剩余人数，考虑的关键点是平均值都一样。
 * 这种方案有个缺点，限制了每个人的随机自由度，更趋向于平均
 * 思考三：线段切割法：每次都random(M)，执行N-1次，按照顺序将N-1次结果进行排列，取其间值作为红包，按序发给N个人
 * 这种方案需要解决的问题：random结果相同时如何处理？ 考虑：如果有相同的，说明某个红包可能没钱，设置最小红包0.01
 * 
 * @author 11941
 *
 */
public class RedEnvelope {

	// 最大人数
	private Integer MAX_NUM = 100;
	// 最小金额
	private Double MIN_PRICE = 0.01;

	public void allotRedEnvelope(Integer n, Double m) {
		// 入参做校验
		checkParam(n, m);
		// 生成random，放入linkedList中
		List<Double> randomList = createRandomList(n, m);
		// 排序
		Collections.sort(randomList);
		// 去重以及设置最小值
		dealList(randomList);
		// 取差值，作为红包进行输出
		List<Double> out = subList(randomList);
		//输出红包值
		sysOutRedEnvelope(out);
	}

	private List<Double> subList(List<Double> randomList) {
		List<Double> out = new LinkedList<Double>();
		DecimalFormat df = new DecimalFormat("#.00");
		for (int i = 0; i < randomList.size()-1; i++) {
			out.add(Double.valueOf(df.format(randomList.get(i+1)-randomList.get(i))));
		}
		return out;
	}

	private void dealList(List<Double> randomList) {
		for (int i = 0; i < randomList.size(); i++) {
			// 给0值加上最小红包
			if (i > 0 && randomList.get(i) < 0.0000001 && randomList.get(i) > -0.0000001) {
				randomList.set(i, randomList.get(i) + MIN_PRICE * (i + 1));
			}
			// 给相同值加上最小红包
			if (i < randomList.size() - 1 && randomList.get(i).equals(randomList.get(i + 1))) {
				randomList.set(i, randomList.get(i) + MIN_PRICE);
			}
		}
	}

	private List<Double> createRandomList(Integer n, Double m) {
		List<Double> result = new LinkedList<Double>();
		Random rand = new Random();
		for (int i = 0; i < n-1; i++) {
			// 取精度为0.1
			Double val = (double) rand.nextInt((int) (m * 10)) / 10;
			result.add(val);
		}
		result.add(0.0);
		result.add(m);
		return result;
	}

	private void checkParam(Integer n, Double m) {
		Assert.isTrue((n > 0) && (n <= MAX_NUM), "总人数 >= 0 && 总人数 <= 阈值");
		Assert.notNull(m, "m must not be null");
		Assert.isTrue(m / n >= MIN_PRICE, "总金额/总人数 >= 最小红包");
	}
	
	private void sysOutRedEnvelope(List<Double> param){
		for(int i=0;i<param.size();i++){
			System.out.println(param.get(i));
		}
	}
}
