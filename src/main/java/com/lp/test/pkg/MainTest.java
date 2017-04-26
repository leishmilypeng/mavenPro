package com.lp.test.pkg;

import com.lp.test.pkg.extend.DefaultExtendTest;
import com.lp.test.pkg.extend.PrivateExtendTest;
import com.lp.test.pkg.extend.ProtectedExtendTest;
import com.lp.test.pkg.extend.PublicExtendTest;

/**
 * Created by CPR161 on 2017-01-09.
 * public>proected>默认>private
 */
public class MainTest {

    public static void main(String[] args) {
        PublicTest pt = new PublicTest();
        ProtectedTest pt2 = new ProtectedTest();
        DefaultTest dt = new DefaultTest();
        PrivateTest pt3 = new PrivateTest();

        pt.show();
        pt2.show();
        dt.show();      // 可以通过构建类直接访问

        System.out.println("------------------------");
        PublicExtendTest pet = new PublicExtendTest();
        ProtectedExtendTest pet2 = new ProtectedExtendTest();
        DefaultExtendTest det = new DefaultExtendTest();
        PrivateExtendTest pet3 = new PrivateExtendTest();

        pet.show();
        pet2.show();
        //det.show();       集成无法调用

    }

}
