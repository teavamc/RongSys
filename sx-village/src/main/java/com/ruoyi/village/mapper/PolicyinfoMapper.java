package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.Policyinfo;

import java.util.List;

/**
 * @Description: 政策Mapper$
 * @Param: dyq_RongSys$
 * @return: $
 * @Author: Mr.DYQ
 * @Date: $
 */
public interface PolicyinfoMapper {
       /**
     * 政策记录列表
     *
     * @return
     */
    List<Policyinfo> selectPolicyinfoList(Policyinfo policyinfo);

    /**
     * 根据shiid删除数据
     * @param id
     */
    int deletePolicyinfoByids(String[] id);

    /**
     * 添加公告信息
     * @param policyinfo
     * @return
     */
    int insertpolicyinfo(Policyinfo policyinfo);

    /**
     * 根据shiid选择数据
     * @param shiid
     * @return
     */
    Policyinfo selectBypoinid(Integer shiid);

    /**
     * 保存用户修改
     * @param policyinfo
     * @return
     */
    int updatePolicyinfo(Policyinfo policyinfo);

    /**
     * 删除政策信息
     * @param poinid
     * @return
     */
    int deletePolicyinfoByIds(String poinid);
}
