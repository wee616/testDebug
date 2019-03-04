package clone.beanCopy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/16
 */
@Getter
@Setter
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer num;

    private School school;

    public Student() {
    }

    public Student(String name, Integer num, School school) {
        this.name = name;
        this.num = num;
        this.school = school;
    }

    @Override
    public Student clone(){
        Student student = null;
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            student = (Student) ois.readObject();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return student;
    }
}