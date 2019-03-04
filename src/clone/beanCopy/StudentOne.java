package clone.beanCopy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/20
 * age 为int的类型的
 */
@Getter
@Setter
@ToString
public class StudentOne {

    private int age;

    private String name;

    public StudentOne() {
    }

    public StudentOne(int age, String name) {
        this.age = age;
        this.name = name;
    }

}