package com.secondLifeMarket.general.admin.demo.ThreadPool.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 17:20 2018/8/1
 * @Modified By ：
 */
public class SelectSort {

    public static void  main(String[] args){

        int[] a = {0,23,89,56,33,11};
        selectSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    //选择排序
    private static void selectSort( int[] a){
        int length = a.length;
        for(int i= 0;i< length ;i++){
            int key = a[i];
            int position = i;
            for(int j = i+1;j<length;j++ ){
                if(a[j]<key){
                    key=a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = key;
        }
    }

}
