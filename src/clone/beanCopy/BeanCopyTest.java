package clone.beanCopy;

import org.springframework.beans.BeanUtils;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/20
 */
public class BeanCopyTest {

    public static void main(String[] args){

        demoOne();
        demoTwo();
        demoThree();
        demoFour();
    }

    /**
     * 测试包装类与非包装类之间的clone
     */
    public static void demoOne(){
        StudentOne studentOne = new StudentOne(1,"One");
        StudentTwo studentTwo = new StudentTwo();
        BeanUtils.copyProperties(studentOne,studentTwo);
        System.out.println(studentTwo);
        System.out.println("包装类可以clone");
        System.out.println();
    }

    /**
     * 测试int与String之间的clone
     */
    public static void demoTwo(){
        StudentOne studentOne = new StudentOne(1,"One");
        StudentThree studentThree = new StudentThree();
        BeanUtils.copyProperties(studentOne,studentThree);
        System.out.println(studentThree);
        System.out.println("int不能clone为String类型");
        System.out.println();
    }

    /**
     * 测试深拷贝
     */
    public static void demoThree(){
        School school = new School("School One",1);
        Student student = new Student("One",1,school);
        student.setSchool(school);

        Student studentCopy = new Student();
        BeanUtils.copyProperties(student,studentCopy);
        System.out.println(studentCopy);
        System.out.println();

        student.setName("Two");
        student.setNum(2);
        student.getSchool().setName("School Two");
        student.getSchool().setNum(2);
        System.out.println("student=" + student + ",student.hashCode="+ System.identityHashCode(student));
        System.out.println("studentCopy=" + studentCopy + ",studentCopy.hashCode="+ System.identityHashCode(studentCopy));
        System.out.println("copyProperties实际是浅拷贝");
        System.out.println();
    }

    /**
     * 测试目标类没有写方法
     */
    public static void demoFour(){
        StudentOne studentOne = new StudentOne(1,"One");
        StudentFour studentFour = new StudentFour();
        BeanUtils.copyProperties(studentOne,studentFour);
        System.out.println(studentFour);
        System.out.println("目标类没有写方法时，无法clone");
        System.out.println();
    }

}