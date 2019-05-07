package jdk8.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试过滤
 * @author wuyc
 * @version 0.0.1
 * @date 2019/5/7
 */
public class Test {
    public static void main(String[] args){
        List<Demo> demos = new ArrayList<>();
        Demo demo1 = new Demo("张三","111",1L);
        Demo demo2 = new Demo("张三","111",1L);
        Demo demo3 = new Demo("张三","222",1L);
        Demo demo4 = new Demo("李四","222",1L);
        demos.add(demo1);
        demos.add(demo2);
        demos.add(demo3);
        demos.add(demo4);

        List<Demo> demos2 = new ArrayList<>();
        Demo demoTwo = new Demo("李四","111",1L);
        demos2.add(demoTwo);


        List<String> names = demos2.stream().map(d -> d.getName()).collect(Collectors.toList());

        List<Demo> result = demos.stream().filter(demo -> names.contains(demo.getName())).collect(Collectors.toList());

        result.stream().forEach(System.out::println);
    }
}