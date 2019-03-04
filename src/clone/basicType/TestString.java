package clone.basicType;

import lombok.ToString;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/2/14
 */
@ToString
public final class TestString {
    private final char[] value;

    public TestString(char[] value) {
        this.value = value;
    }

    public char[] getValue() {
        return value;
    }

    public void changeValue(){
        this.value[0] = 'q';
    }

}