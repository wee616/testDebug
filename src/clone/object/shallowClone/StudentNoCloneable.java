package clone.object.shallowClone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/15
 */
@Getter
@Setter
@ToString
public class StudentNoCloneable {

    private int number;

    private String name;

    public StudentNoCloneable() {
    }

    public StudentNoCloneable(int number, String name) {
        this.number = number;
        this.name = name;
    }
}