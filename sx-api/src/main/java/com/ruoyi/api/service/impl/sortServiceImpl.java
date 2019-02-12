package com.ruoyi.api.service.impl;

import com.ruoyi.api.service.sortService;

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
    public void lQS(List<HashMap<String,String>> list){

        int left = 0;
        int right = list.size()-1;
        this.lQS_getMiddle(list,left,right);

    }

    @Override
    public int lQS_getMiddle(List<HashMap<String,String>> list,int left,int right){
        int target =

    }

    @Override
    public List<HashMap<String,String>> listQuickSort(List<HashMap<String,String>> list,String key,int left,int right){

    }



}
