package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.SocialCircle;
import com.ruoyi.village.mapper.SocialCircleMapper;
import com.ruoyi.village.service.SocialCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 留言 服务层实现
 * @author: Mr.Liu
 * @create: 2019-01-17 15:53
 **/
@Service
public class SocialCircleImpl implements SocialCircleService {
    @Autowired
    private SocialCircleMapper mapper;

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialCircle> selectSocialCircleList() {
        return mapper.selectSocialCircleList();
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialCircle> selectSocialCircleList_Heat() {
        List<SocialCircle> list = mapper.selectSocialCircleList();
        SocialCircle socialCircle = list.get(0);
        int left = 0 , right = mapper.selectSocialCircleList().size()-1;
        return quickSort(list,left,right);
    }
    /**快速排序*/
    public List<SocialCircle> quickSort(List<SocialCircle> list,int left,int right) {
        if (left < right) {
            int plot = left;
            int index = plot +1;
            for(int i = index;i<=right;i++){
                if(list.get(i).getPcsennum() > list.get(plot).getPcsennum()){
                    swap(list,index,i);
                    index++;
                }
            }
            swap(list,plot,index-1);
            int plots = index-1;
            quickSort(list,left,plots-1);
            quickSort(list,plots+1,right);
        }
        return list;
    }
    /**交换两个值*/
    public void swap(List<?> list , int i , int j){
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }
}
