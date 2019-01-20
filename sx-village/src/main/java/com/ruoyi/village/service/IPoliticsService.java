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
     * 查询政策记录列表
     *
     * @return
     */
    public List<Politics> selectPoliticsList(Politics politics);

    /**
     * 根据shiid删除数据
     * @param id
     */
    public int deletePoliticsByids(String id);

    /**
     * 添加政策公告数据
     * @param  politics
     * @return
     */
    public int insertpolitics(Politics politics);
    /**
     * 根据shiid选择数据
     * @param shiid
     * @return
     */
    public Politics selectByshiid(Integer shiid);
    /**
     * 保存用户修改
     * @param politics
     * @return
     */
    public int updatePolitics(Politics politics);
    /**
     * 删除政策信息
     * @param shiid
     * @return
     */
    public int deletePoliticsByIds(String shiid);
}
