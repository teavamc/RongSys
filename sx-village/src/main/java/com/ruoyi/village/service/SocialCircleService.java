package com.ruoyi.village.service;

import com.ruoyi.village.domain.SocialCircle;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 留言 服务层
 * @author: Mr.Liu
 * @create: 2019-01-17 15:51
 **/

public interface SocialCircleService {
    /**
     * 获取暮云圈 留言
     * 最新数据
     * @return
     */
    public List<SocialCircle> selectSocialCircleList();

    /**
     * 获取暮云圈 留言
     * 热度数据
     * @return
     */
    public List<SocialCircle> selectSocialCircleList_Heat();
}
