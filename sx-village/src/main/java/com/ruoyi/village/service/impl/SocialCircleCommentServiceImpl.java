package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.SocialCircleComment;
import com.ruoyi.village.mapper.SocialCircleCommentMapper;
import com.ruoyi.village.service.SocialCircleCommentService;
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
public class SocialCircleCommentServiceImpl implements SocialCircleCommentService {
    @Autowired
    private SocialCircleCommentMapper mapper;

    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<SocialCircleComment> selectAllByPcid(Integer pcid) {
        return mapper.selectAllByPcid(pcid);
    }
}
