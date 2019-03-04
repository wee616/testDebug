package clone.object.deepClone;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/16
 */
public class DeepClone {

    public static void main(String[] args){

        School school = new School("大一",1);
        Student student = new Student("张三",1,school);
        Student studentClone = student.clone();
        System.out.println("student=" + student + ",student.hashCode="+ System.identityHashCode(student));
        System.out.println("studentClone=" + studentClone + ",studentClone.hashCode="+ System.identityHashCode(studentClone));
        System.out.println();

        student.setName("李四");
        student.setNum(2);
        student.getSchool().setName("大二");
        student.getSchool().setNum(2);
        System.out.println("student=" + student + ",student.hashCode="+ System.identityHashCode(student));
        System.out.println("studentClone=" + studentClone + ",studentClone.hashCode="+ System.identityHashCode(studentClone));
    }
}