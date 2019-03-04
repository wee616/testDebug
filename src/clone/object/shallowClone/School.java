package clone.object.shallowClone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/16
 */
@Getter
@Setter
@ToString
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer num;

    public School() {
    }

    public School(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

}