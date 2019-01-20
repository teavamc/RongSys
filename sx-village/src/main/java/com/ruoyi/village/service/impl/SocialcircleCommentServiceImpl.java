package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.SocialcircleComment;
import com.ruoyi.village.mapper.SocialcircleCommentMapper;
import com.ruoyi.village.service.SocialcircleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 评论 服务层实现
 * @author: Mr.Liu
 * @create: 2019-01-18 09:35
 **/
@Service
public class SocialcircleCommentServiceImpl implements SocialcircleCommentService {
    @Autowired
    private SocialcircleCommentMapper mapper;

    /**
     * 根据暮云圈pcid 搜索所有评论
     * @param pcid 暮云圈pcid号
     * @return  暮云圈数据
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialcircleComment> selectAllByPcid(Integer pcid) {
        return mapper.selectAllByPcid(pcid);
    }
}
