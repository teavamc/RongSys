package com.ruoyi.village.service;

import com.ruoyi.village.domain.SocialCircleComment;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 评论 服务层
 * @author: Mr.Liu
 * @create: 2019-01-18 09:35
 **/

public interface SocialCircleCommentService {
    /**
     * 根据暮云圈pcid 搜索所有评论
     * @param pcid
     * @return
     */
    public List<SocialCircleComment> selectAllByPcid(Integer pcid);
}
