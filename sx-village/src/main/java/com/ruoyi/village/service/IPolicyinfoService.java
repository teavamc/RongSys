package com.ruoyi.village.service;

import com.ruoyi.village.domain.Policyinfo;

import java.util.List;

/**
 * @Description: 公告Service$
 * @Param: dyq_RongSys$
 * @return: $
 * @Author: Mr.DYQ
 * @Date: $
 */

public interface IPolicyinfoService {
    /**
     * 查询政策记录列表
     *
     * @return
     */
    public List<Policyinfo> selectPolicyinfoList(Policyinfo policyinfo);

    /**
     * 根据fbid删除数据
     * @param id
     */
    public int deletePolicyinfoByids(String id);

    /**
     * 添加公告信息数据
     * @param  policyinfo
     * @return
     */
    public int insertpolicyinfo(Policyinfo policyinfo);
    /**
     * 根据poinid选择数据
     * @param poinid
     * @return
     */
    public Policyinfo selectBypoinid(Integer poinid);
    /**
     * 保存用户修改
     * @param policyinfo
     * @return
     */
    public int updatePolicyinfo(Policyinfo policyinfo);
    /**
     * 删除公告信息
     * @param poinid
     * @return
     */
    public int deletePolicyinfoByIds(String poinid);

    /**
     * 按照时间倒序获取十条政策信息
     *
     * @return 最近的十条数据
     */
    public List<Policyinfo> selectpoliclimitten();
}
