package clone.object.shallowClone;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/14
 */
public class ShallowClone {
    public static void main(String[] args){
        /**
         * 测试不实现Cloneable接口
         */
        testNoCloneable();

        /**
         * 测试实现Cloneable接口
         * 测试Cloneable接口能否实现深拷贝
         */
        testCloneable();
    }

    /**
     * 测试不实现Cloneable接口
     */
    private static void testNoCloneable(){
        StudentNoCloneable studentNoCloneable = new StudentNoCloneable();
        studentNoCloneable.setName("张三");
        studentNoCloneable.setNumber(1);
        StudentNoCloneable studentNoCloneableClone = studentNoCloneable;
        //这种写法会报错，
        //StudentNoCloneable studentNoCloneableClone = (StudentNoCloneable)studentNoCloneable.clone();

        System.out.println("studentNoCloneable=" + studentNoCloneable + ",studentNoCloneable.hashCode="+ System.identityHashCode(studentNoCloneable));
        System.out.println("studentNoCloneableClone=" + studentNoCloneableClone + ",studentNoCloneableClone.hashCode="+ System.identityHashCode(studentNoCloneableClone));
        studentNoCloneable.setName("李四");
        studentNoCloneable.setNumber(2);
        System.out.println("studentNoCloneable=" + studentNoCloneable + ",studentNoCloneable.hashCode="+ System.identityHashCode(studentNoCloneable));
        System.out.println("studentNoCloneableClone=" + studentNoCloneableClone + ",studentNoCloneableClone.hashCode="+ System.identityHashCode(studentNoCloneableClone));
        System.out.println("不实现Cloneable接口，被克隆的对象发生了变化");
        System.out.println();
    }

    /**
     * 测试实现Cloneable接口
     * 测试Cloneable接口能否实现深拷贝
     */
    private static void testCloneable(){
        StudentCloneable studentCloneable = new StudentCloneable();
        studentCloneable.setName("张三");
        studentCloneable.setNumber(1);
        School school = new School();
        school.setName("大一");
        school.setNum(1);
        studentCloneable.setSchool(school);
        StudentCloneable studentCloneableClone = (StudentCloneable)studentCloneable.clone();
        System.out.println("studentCloneable=" + studentCloneable + ",studentCloneable.hashCode="+ System.identityHashCode(studentCloneable));
        System.out.println("studentCloneableClone=" + studentCloneableClone + ",studentCloneableClone.hashCode="+ System.identityHashCode(studentCloneableClone));
        studentCloneable.setName("李四");
        studentCloneable.setNumber(2);
        studentCloneable.getSchool().setName("大二");
        studentCloneable.getSchool().setNum(2);
        System.out.println("studentCloneable=" + studentCloneable + ",studentCloneable.hashCode="+ System.identityHashCode(studentCloneable));
        System.out.println("studentCloneableClone=" + studentCloneableClone + ",studentCloneableClone.hashCode="+ System.identityHashCode(studentCloneableClone));
        System.out.println("实现Cloneable接口，被克隆的对象未发生变化，但是引用类型发生了变化");
        System.out.println();
    }

}