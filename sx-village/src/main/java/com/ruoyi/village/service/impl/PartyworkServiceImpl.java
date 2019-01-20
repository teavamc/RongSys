package com.ruoyi.village.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.village.mapper.PartyworkMapper;
import com.ruoyi.village.domain.Partywork;
import com.ruoyi.village.service.IPartyworkService;
import com.ruoyi.common.support.Convert;

/**
 * 党员值班 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-01-20
 */
@Service
public class PartyworkServiceImpl implements IPartyworkService 
{
	@Autowired
	private PartyworkMapper partyworkMapper;

	/**
     * 查询党员值班信息
     * 
     * @param id 党员值班ID
     * @return 党员值班信息
     */
    @Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public Partywork selectPartyworkById(Integer id)
	{
	    return partyworkMapper.selectPartyworkById(id);
	}
	
	/**
     * 查询党员值班列表
     * 
     * @param partywork 党员值班信息
     * @return 党员值班集合
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public List<Partywork> selectPartyworkList(Partywork partywork)
	{
	    return partyworkMapper.selectPartyworkList(partywork);
	}
	
    /**
     * 新增党员值班
     * 
     * @param partywork 党员值班信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int insertPartywork(Partywork partywork)
	{
	    return partyworkMapper.insertPartywork(partywork);
	}
	
	/**
     * 修改党员值班
     * 
     * @param partywork 党员值班信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int updatePartywork(Partywork partywork)
	{
	    return partyworkMapper.updatePartywork(partywork);
	}

	/**
     * 删除党员值班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int deletePartyworkByIds(String ids)
	{
		return partyworkMapper.deletePartyworkByIds(Convert.toStrArray(ids));
	}
	
}
