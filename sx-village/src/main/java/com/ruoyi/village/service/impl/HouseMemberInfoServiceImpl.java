package com.ruoyi.village.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.village.mapper.HouseMemberInfoMapper;
import com.ruoyi.village.domain.HouseMemberInfo;
import com.ruoyi.village.service.IHouseMemberInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 村户 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Service
public class HouseMemberInfoServiceImpl implements IHouseMemberInfoService 
{
	@Autowired
	private HouseMemberInfoMapper houseMemberInfoMapper;

	/**
     * 查询村户信息
     * 
     * @param hmid 村户ID
     * @return 村户信息
     */
    @Override
	public HouseMemberInfo selectHouseMemberInfoById(Integer hmid)
	{
	    return houseMemberInfoMapper.selectHouseMemberInfoById(hmid);
	}
	
	/**
     * 查询村户列表
     * 
     * @param houseMemberInfo 村户信息
     * @return 村户集合
     */
	@Override
	public List<HouseMemberInfo> selectHouseMemberInfoList(HouseMemberInfo houseMemberInfo)
	{
	    return houseMemberInfoMapper.selectHouseMemberInfoList(houseMemberInfo);
	}
	
    /**
     * 新增村户
     * 
     * @param houseMemberInfo 村户信息
     * @return 结果
     */
	@Override
	public int insertHouseMemberInfo(HouseMemberInfo houseMemberInfo)
	{
	    return houseMemberInfoMapper.insertHouseMemberInfo(houseMemberInfo);
	}
	
	/**
     * 修改村户
     * 
     * @param houseMemberInfo 村户信息
     * @return 结果
     */
	@Override
	public int updateHouseMemberInfo(HouseMemberInfo houseMemberInfo)
	{
	    return houseMemberInfoMapper.updateHouseMemberInfo(houseMemberInfo);
	}

	/**
     * 删除村户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHouseMemberInfoByIds(String ids)
	{
		return houseMemberInfoMapper.deleteHouseMemberInfoByIds(Convert.toStrArray(ids));
	}
	
}
