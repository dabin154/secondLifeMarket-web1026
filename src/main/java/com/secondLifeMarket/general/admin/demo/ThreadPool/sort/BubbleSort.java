package com.secondLifeMarket.general.admin.demo.ThreadPool.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 17:34 2018/8/1
 * @Modified By ：
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] a = {0,23,89,56,33,11};
        bubbleSort(a);
        System.out.println(JSON.toJSONString(a));

    }
    //冒泡排序
    private static void bubbleSort(int[] a){
        int length = a.length;
        int temp = 0;
        for(int i = 0;i<length;i++){
            for(int j = 0;j<length-i-1;j++ ){
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

        }


    }

}
