package com.lp.test.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPR161 on 2016-12-16.
 * 水仙花数
 */
public class NarcissisticNumber {
    public static void main(String[] args) {
        int [] num = new int[30];
        List<String> data = new ArrayList<String>();
        for (int i=1;i<=400000000;i++) {
            int len = String.valueOf(i).length();
            String td = String.valueOf(i);
            int tmp = i;
            int total = 0;
            for(int j=0;j<len;j++){
                int c = Integer.valueOf(td.substring(j,j+1));
                int a=1;
                for (int k = 0; k < len; k++) {
                    a=a*c;
                }
                total = total + a;
            }
            if(total == i){
                System.out.println(i);
            }
        }


    }
}
