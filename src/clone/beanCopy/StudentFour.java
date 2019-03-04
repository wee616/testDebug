package clone.beanCopy;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/20
 * 目标没有写方法
 */
public class StudentFour {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"age\":")
                .append(age);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}