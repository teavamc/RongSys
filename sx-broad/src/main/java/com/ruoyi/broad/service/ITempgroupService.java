package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Tempgroup;

import java.util.List;

/**
 * Created by ASUS on 2019/7/29.
 * @author 陈霞
 */

public interface ITempgroupService {

    /**
     * 查询终端临时列表
     *
     * @return 终端临时列表
     */
    public List<Tempgroup> selectAllTempgroup();

    /**
     * 更新终端临时列表
     *
     * @return 终端临时列表
     */
    public int updateTempgroup(Tempgroup tempgroup);

    /**
     * 删除终端临时列表
     *
     * @return 终端临时列表
     */
    public int deleteTempgroup(int tgid);

    /**
     * 插入终端临时列表
     *
     * @return 终端临时列表
     */
    public int insertTempgroup(Tempgroup tempgroup);
}
