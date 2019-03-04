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
public class StudentCloneable implements Cloneable{

    private int number;

    private String name;

    private School school;

    public StudentCloneable() {
    }

    public StudentCloneable(int number, String name, School school) {
        this.number = number;
        this.name = name;
        this.school = school;
    }

    @Override
    public Object clone() {
        StudentCloneable stu = null;
        try{
            stu = (StudentCloneable)super.clone();
        }catch (Exception e){
            System.out.println(e);
        }
        return stu;
    }
}