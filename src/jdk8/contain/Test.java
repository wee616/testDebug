package jdk8.contain;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 从List<bean>中根据属性进行过滤，剔除部分bean
 * @author wuyc
 * @version 0.0.1
 * @date 2019/6/19
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

        System.out.println(filteDemo(demos));
    }

    public static List<Demo> filteDemo(List<Demo> demos){

        //提前失败策略
        if(CollectionUtils.isEmpty(demos)){
            return demos;
        }
        //对两种属性进行过滤
        List<String> names = demos.stream().map(demo->demo.getName()).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(names)){
            return demos;
        }
        if(names.contains("张三")&&names.contains("李四")){
            List<Demo> filteDemos = demos.stream().filter(demo->!demo.getName().equals("李四")).collect(Collectors.toList());
            return filteDemos;
        }
        return demos;
    }
}