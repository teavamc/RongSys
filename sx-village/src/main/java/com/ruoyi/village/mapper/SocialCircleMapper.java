package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.SocialCircle;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 留言 数据
 * @author: Mr.Liu
 * @create: 2019-01-17 15:49
 **/
public interface SocialCircleMapper {

    /**
     * 获取暮云圈 留言
     * @return
     */
    List<SocialCircle> selectSocialCircleList();
}
