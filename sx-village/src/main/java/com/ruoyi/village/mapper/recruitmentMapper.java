package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.recruitment;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 求职招聘
 * @author: Mr.Liu
 * @create: 2019-01-15 14:05
 **/
public interface recruitmentMapper {
    /**
     * 获取所有招聘信息
     * @return
     */
    List<recruitment> selectRecruitmentList();
}
