package jdk8.groupby;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 测试分组与统计
 * @author wuyc
 * @version 0.0.1
 * @date 2019/5/6
 */
public class Test {
    public static void main(String[] args){

        List<Demo> demoList = new ArrayList<Demo>();
        Demo demo1 = new Demo("张三","111",1L);
        Demo demo2 = new Demo("张三","111",1L);
        Demo demo3 = new Demo("张三","222",1L);
        Demo demo4 = new Demo("李四","222",1L);
        demoList.add(demo1);
        demoList.add(demo2);
        demoList.add(demo3);
        demoList.add(demo4);

        //根据name+piz_name对demoList进行分组
        Map<String,List<Demo>> demoMaps = demoList.stream().collect(Collectors.groupingBy(d -> d.fetchGroupKey()));

        //统计num、count
        demoMaps.forEach((key, value) -> {
            LongSummaryStatistics num = value.stream().mapToLong(u -> u.getNum())
                    .summaryStatistics();
            System.out.println(key + " sum of num: "+num.getSum());
            System.out.println(key + " count of num: "+num.getCount());
        });
    }
}