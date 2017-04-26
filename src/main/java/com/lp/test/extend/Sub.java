package com.lp.test.extend;

/**
 * Created by CPR161 on 2017-01-23.
 */
public class Sub extends Super {
    public int field=1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}
