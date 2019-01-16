package com.ruoyi.village.service;

import com.ruoyi.village.domain.Politics;

import java.util.List;

/**
 * @Description: 政策Service$
 * @Param: dyq_RongSys$
 * @return: $
 * @Author: Mr.DYQ
 * @Date: $
 */

public interface IPoliticsService {
    /**
     * 获取数据
     * @return
     */
    List<Politics> selectPoliticsList_first();
    /**
     * 查询村务政策记录列表
     *
     * @return
     */

    List<Politics> selectPoliticsList(Politics politics);

    /**
     * 根据fbid删除数据
     * @param id
     */
    int deletePoliticsByids(String id);
}
