package clone.beanCopy;

import com.alibaba.fastjson.JSONObject;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/26
 */
public class BeanCopierTest {

    public static void main(String[] args){
        testOne();
        testThree();
        testFour();
    }

    public static<T> T convert(Object src, Class<T> clazz) {
        String json = JSONObject.toJSONString(src);
        T object = JSONObject.parseObject(json, clazz);
        return object;
    }

    /**
     * 测试包装类，无converter
     */
    public static void testOne(){
        StudentOne studentOne = new StudentOne(1,"张三");
        StudentTwo studentTwo = new StudentTwo();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\testDebug\\target\\classes\\clone\\beanCopy");

        BeanCopier beanCopier = BeanCopier.create(StudentOne.class, StudentTwo.class, false);
        beanCopier.copy(studentOne,studentTwo,null);
        System.out.println(studentTwo);
        System.out.println();
    }

    /**
     * 测试包装类，有converter
     */
    public static void testTwo(){
        StudentOne studentOne = new StudentOne(1,"张三");
        StudentTwo studentTwo = new StudentTwo();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\testDebug\\target\\classes\\clone\\beanCopy");

        BeanCopier beanCopier = BeanCopier.create(StudentOne.class, StudentTwo.class, true);
        Converter converter = new Converter() {
            @Override
            public Object convert(Object value, Class target, Object context) {
                if (value instanceof Integer) {
                    return (Integer) value;
                }
                return null;
            }
        };

        beanCopier.copy(studentOne,studentTwo,converter);
        System.out.println(studentTwo);
        System.out.println();
    }

    /**
     * 测试深拷贝
     */
    public static void testThree(){
        School school = new School("School One",1);
        Student student = new Student("One",1,school);
        student.setSchool(school);

        Student studentCopy = new Student();
        BeanCopier beanCopier = BeanCopier.create(Student.class, Student.class, false);
        beanCopier.copy(student,studentCopy,null);
        System.out.println(studentCopy);
        System.out.println();

        student.setName("Two");
        student.setNum(2);
        student.getSchool().setName("School Two");
        student.getSchool().setNum(2);
        System.out.println("student=" + student + ",student.hashCode="+ System.identityHashCode(student));
        System.out.println("studentCopy=" + studentCopy + ",studentCopy.hashCode="+ System.identityHashCode(studentCopy));
        System.out.println("beanCopier实际是浅拷贝");
        System.out.println();
    }

    /**
     * 测试目标类没有写方法
     */
    public static void testFour(){
        StudentOne studentOne = new StudentOne();
        studentOne.setAge(1);
        studentOne.setName("One");
        StudentFour studentFour = new StudentFour();
        BeanCopier beanCopier = BeanCopier.create(StudentOne.class, StudentFour.class, false);
        beanCopier.copy(studentOne,studentFour,null);
        System.out.println(studentFour);
        System.out.println("目标类没有写方法时，无法clone");
        System.out.println();
    }
}