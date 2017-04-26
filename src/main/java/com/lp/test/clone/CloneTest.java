package com.lp.test.clone;

/**
 * Created by CPR161 on 2017-04-25.
 */
public class CloneTest implements Cloneable {

    public CloneTest() {
    }

    public CloneTest(String value) {
        this.value = value;
    }

    private String value ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        CloneTest ct = new CloneTest("leipeng");
        CloneTest ct2 = null;
        CloneTest ct3 = null;
        ct3 = ct;
        try {
            ct2 = (CloneTest) ct.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(ct==ct2);
        System.out.println(ct.equals(ct2));
        System.out.println(ct.hashCode());
        System.out.println(ct2.hashCode());
        System.out.println("------------------");
        System.out.println(ct==ct3);
        System.out.println(ct.equals(ct3));
        System.out.println(ct.getValue());
        System.out.println(ct3.getValue());
        ct.setValue("peng");
        System.out.println("------------------");
        System.out.println(ct==ct3);
        System.out.println(ct.equals(ct3));
        System.out.println(ct.getValue());
        System.out.println(ct3.getValue());
    }
}
