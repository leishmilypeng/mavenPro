package com.lp.test.generic;

import com.lp.entity.Animal;

import java.util.Collections;
import java.util.List;

/**
 * Created by CPR161 on 2016-12-29.
 */
public class GenericTest {

    public <T extends   Comparable<T>> T getMax(T x,T y,T z){
        T max = x;
        if(y.compareTo(x)>0){
           max = y;
        }
        if(z.compareTo(max)>0){
            max = z;
        }
        return max;
    }

    /**
     *
     * @param x
     * @param y
     * @param z
     * @param <TmUser>  此处的TmUser就是一普通的名字
     * @return
     */
    public <TmUser extends   Comparable<TmUser>> TmUser getMax2(TmUser x,TmUser y,TmUser z){
        TmUser max = x;
        if(y.compareTo(x)>0){
            max = y;
        }
        if(z.compareTo(max)>0){
            max = z;
        }
        return max;
    }

    public static void mySort4(List<? extends Animal> list)
    {
        //Collections.sort(list);
    }

    public static void main(String[] args) {
        GenericTest gt = new GenericTest();
        System.out.println(gt.getMax("a","b","c"));
    }
}
