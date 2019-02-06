package com.ruoyi.api.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName listQuickSort
 * @date 2019/2/6 18:16
 **/
public class listQuickSort {


    /**
     * 将list进行快速排序，返回排序完成的结果
     * @author 张超 teavamc
     * @date 2019/2/5
     * @param [list]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     */
    public static List<HashMap<String,String>> list_quickSort(List<HashMap<String,String>> list){
        HashMap<String,String> preMap = (list.get(0));
        //1.取list[0]的数据，放入keys数组
        Object[] keys = (preMap.keySet()).toArray();
        String aim_key;
        //2.遍历这个数组，在list[0]比对每一个key对应的value数值， 拿到value最大的key，map获得value的方法是 MapName.get(key)
        for (int i=1;i<keys.length;i++){
            if (Integer.parseInt(preMap.get(keys[i-0])) >= Integer.parseInt(preMap.get(keys[i]))){
                aim_key = keys[i-1].toString();
            }else {
                aim_key = keys[i].toString();
            }
        }
        //3.list就按照这个Key的Value进行快排，最后改变list的顺序， java中互换list的方法是 Collections.swap(data,index1,index2);


        return list;
    }

    public void  sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];


        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

}
