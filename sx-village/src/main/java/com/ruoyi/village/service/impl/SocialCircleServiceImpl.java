package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.SocialCircle;
import com.ruoyi.village.mapper.SocialCircleMapper;
import com.ruoyi.village.service.SocialCircleService;
import com.ruoyi.village.util.FilterText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    private List<SocialCircle> ov2 = null;
    /**
     * 获取暮云圈 留言
     * 最新数据
     * @param in 开始行 index 结束行
     * @return 暮云圈留言数据
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialCircle> selectSocialCircleList(int in,int index) {
        return mapper.selectSocialCircleList(in,index);
    }

    /**
     * 获取暮云圈 留言
     * 热度数据
     * @param in 起始行 index 结束行
     * @return 暮云圈留言热度数据
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialCircle> selectSocialCircleList_Heat(int in,int index) {
                return mapper.selectSocialCircleList_Heat(in,index);

    }

}
