package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.SocialCircle;
import com.ruoyi.village.mapper.SocialCircleMapper;
import com.ruoyi.village.service.SocialCircleService;
import com.ruoyi.village.util.FilterText;
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
public class SocialCircleServiceImpl implements SocialCircleService {
    @Autowired
    private SocialCircleMapper mapper;

    /**
     * 获取暮云圈 留言
     * index!=0 最新数据  index==0 热度数据
     * @return 暮云圈数据
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialCircle> selectSocialCircleList(int index) {
        List<SocialCircle> list = mapper.selectSocialCircleList(index);
        if(index != 0){
            List<SocialCircle> ov = null;
            for (int i = 0;i<list.size();i++){
               ov.add(list.get(i));
            }
            return ov;
        }else {
            int left = 0 , right = list.size()-1;
            return FilterText.quickSort(list,left,right);
        }
    }

}
