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

    public void lQS(List list,String targetName);

    public int lQS_getMiddle(List list,String targetName,int left,int right);

    public void listQuickSort(List list,String targetName,int left,int right);




}
