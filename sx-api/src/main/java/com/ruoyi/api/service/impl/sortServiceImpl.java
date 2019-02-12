package com.ruoyi.api.service.impl;

import com.ruoyi.api.service.sortService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName sortServiceImpl
 * @date 2019/2/12 13:44
 **/
public class sortServiceImpl implements sortService {


    @Override
    public void lQS(List list,String targetName){
        // 确定左右下标
        int left = 1;
        int right = list.size()-1;
        listQuickSort(list,targetName,left,right);
    }

    /**
        * List<HashMap>的快排算法中的分治法
        * @author 张超 teavamc
        * @date 2019/2/13
        * @param [list, targetName, left, right]
        * @return int
        */
    @Override
    public int lQS_getMiddle(List list,String targetName,int left,int right){
        // 确定 基准值 和 基准元素
        int target = Integer.valueOf((list.get(left)).get(targetName));
        //如果左右下标未相遇
        while (left < right){
            // 若R下标若大于基准值则向左移动，若小于则 停止并交换
            while (left < right && Integer.valueOf((list.get(right)).get(targetName)) > target){
                right--;
            }
            Collections.swap(list,left,right);
            // 若L下标若小于基准值则向右移动，若大于则 停止并交换
            while (left < right && Integer.valueOf((list.get(left)).get(targetName)) < target){
                left++;
            }
            Collections.swap(list,right,left);
        }
        //将基准元素放入中位，前序均小于自己，后序均大于自己
        list.add(left+1,list.get(0));
        list.remove(0);
        return left;
    }

    /**
        * List<HashMap>的快排算法中的递归排序
        * @author 张超 teavamc
        * @date 2019/2/13
        * @param [list, targetName, left, right]
        * @return void
        */
    @Override
    public void listQuickSort(List list,String targetName,int left,int right){
        if(left < right){
            int middle = lQS_getMiddle(list,targetName,left,right);
            listQuickSort(list,targetName,left,middle-1);
            listQuickSort(list,targetName,middle+1,right);
        }
    }
}
