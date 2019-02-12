package com.ruoyi.api.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName sortService
 * @date 2019/2/12 13:43
 **/
public interface sortService {

    public void lQS(List<HashMap<String,String>> list);

    public int lQS_getMiddle(List<HashMap<String,String>> list,int left,int right);

    public List<HashMap<String,String>> listQuickSort(List<HashMap<String,String>> list,String key,int left,int right);




}
