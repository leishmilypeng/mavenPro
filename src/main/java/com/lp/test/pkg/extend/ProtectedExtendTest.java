package com.lp.test.pkg.extend;

import com.lp.test.pkg.ProtectedTest;

/**
 * Created by CPR161 on 2017-01-09.
 * 继承类可以直接调用基类中的受保护方法及属性
 */
public class ProtectedExtendTest extends ProtectedTest{
    public void showExtend(){
        this.show();
    }
}
