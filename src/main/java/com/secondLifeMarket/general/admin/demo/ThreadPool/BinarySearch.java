package com.secondLifeMarket.general.admin.demo.ThreadPool;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 17:32 2018/8/2
 * @Modified By ：
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] a = {12,13,45,78,95,108,201};
        System.out.println(binarySearch(a,109));

    }

    private static int binarySearch(int[] array, int aim) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if(array[mid] == aim){
                return mid;
            } else if (array[mid] < aim) {
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        return -1;

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

    //选择排序
    private static void selectSort(int[] b){
        int len = b.length;
        for(int i= 0;i<len;i++){
            int temp = b[i];
            int prosion = i;
            for(int j = i+1;j<len;j++){
                if(b[j] < temp){

                    temp = b[j];
                    prosion = j;


                }
            }

            b[prosion] = b[i];


        }


    }

}
