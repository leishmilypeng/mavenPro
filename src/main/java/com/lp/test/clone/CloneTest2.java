package com.lp.test.clone;

/**
 * Created by CPR161 on 2017-04-25.
 */
public class CloneTest2 {
    public CloneTest2() {
    }

    public CloneTest2(String value) {
        this.value = value;
    }

    private String value ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * java.lang.CloneNotSupportedException: com.lp.test.clone.CloneTest2
     at java.lang.Object.clone(Native Method)
     at com.lp.test.clone.CloneTest2.main(CloneTest2.java:27)
     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     at java.lang.reflect.Method.invoke(Method.java:606)
     at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
     * @param args
     */
    public static void main(String[] args) {
        CloneTest2 ct2 = new CloneTest2("leipeng");
        try {
            ct2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
