package jdk8.groupby;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/5/6
 */
public class Demo {

    String name;

    String piz_name;

    Long num;

    Demo(String name,String piz_name,Long num){
        this.name = name;
        this.piz_name = piz_name;
        this.num = num;
    }

    public String fetchGroupKey(){
        return this.name+this.piz_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPiz_name() {
        return piz_name;
    }

    public void setPiz_name(String piz_name) {
        this.piz_name = piz_name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}