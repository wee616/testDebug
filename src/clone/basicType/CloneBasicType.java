package clone.basicType;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/3
 */
public class CloneBasicType {

    public static final int tt = 1;

    public static void main(String[] args){
        /**
         * int的克隆，n克隆m，观察结果以及地址、观察class文件
         */
        int m = 1;
        int n = m;
        System.out.println("m=" + m + ",m.hashCode="+ System.identityHashCode(m));
        System.out.println("n=" + n + ",n.hashCode="+ System.identityHashCode(n));
        System.out.println("tt=" + tt + ",tt.hashCode="+ System.identityHashCode(tt));
        System.out.println("思考：tt、m、n为何指向同样的地址呢？");
        System.out.println("此思考结果不一定正确：经过观察class文件、借助javap -verbose ***指令、参阅资料了解到，" +
                "1作为静态常量tt的字面值存在方法区中，tt指向1，当定义局部变量m和n时，先从常量池中寻找是否有此常量，" +
                "若有此常量，m和n也直接指向1的地址。若无此常量，按照顺序在栈中开辟地址存放1，并将m和n指向1。");
        System.out.println();

        /**
         * 对m重新赋值，发现m的地址发生了变化，n的未变，为什么？
         */
        m=2;
        System.out.println("new m=" + m + ",m.hashCode="+ System.identityHashCode(m));
        System.out.println("new n=" + n + ",n.hashCode="+ System.identityHashCode(n));
        System.out.println("对m重新赋值，发现m指向了新地址，用上面的解释可以解释通。");
        System.out.println();

        /**
         * 常量池是否有范围？
         * 理解基本类型的==与equal
         */
        int s = 128;
        int w = 128;
        System.out.println("思考：整形常量池是否有范围？经观察，-127~127是整形常量池范围。");
        System.out.println("s=" + s + ",s.hashCode="+ System.identityHashCode(s));
        System.out.println("w=" + w + ",w.hashCode="+ System.identityHashCode(w));
        System.out.println("s==w ?  " + (s==w?true:false));
        System.out.println("思考：基本类型和非基本类型用==与equal有什么区别？" +
                "基本类型用==与equal都是比较值，非基本类型用==是比较内存地址，equal是比较值。");
        System.out.println();

        /**
         * 包装类的==与equal
         */
        Integer i = 1;
        Integer j = 1;
        System.out.println("i=" + i + ",i.hashCode="+ System.identityHashCode(i));
        System.out.println("j=" + j + ",j.hashCode="+ System.identityHashCode(j));
        System.out.println("i==j ?  " + (i==j?true:false));
        Integer ii = new Integer(1);
        Integer jj = new Integer(1);
        System.out.println("ii=" + ii + ",ii.hashCode="+ System.identityHashCode(ii));
        System.out.println("jj=" + jj + ",jj.hashCode="+ System.identityHashCode(jj));
        System.out.println("ii==jj ?  " + (ii==jj?true:false));
        System.out.println("包装类定义的对象地址是否相等跟写法也有关系");
        System.out.println();

    }
}