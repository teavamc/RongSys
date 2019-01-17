package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.recruitment;
import com.ruoyi.village.mapper.recruitmentMapper;
import com.ruoyi.village.service.IrecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 求职招聘
 * @author: Mr.Liu
 * @create: 2019-01-15 14:06
 **/
@Service
public class recruitmentServiceImpl implements IrecruitmentService {
    @Autowired
    private recruitmentMapper mapper;

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<recruitment> selectRecruitmentList() {
        return mapper.selectRecruitmentList();
    }
}
