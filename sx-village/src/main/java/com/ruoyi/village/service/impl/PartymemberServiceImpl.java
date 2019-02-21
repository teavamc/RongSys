package com.ruoyi.village.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.Pmcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.village.mapper.PartymemberMapper;
import com.ruoyi.village.domain.Partymember;
import com.ruoyi.village.service.IPartymemberService;
import com.ruoyi.common.support.Convert;

/**
 * 暮云党员 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-01-20
 */
@Service
public class PartymemberServiceImpl implements IPartymemberService 
{
	@Autowired
	private PartymemberMapper partymemberMapper;

	/**
     * 查询暮云党员信息
     * 
     * @param pid 暮云党员ID
     * @return 暮云党员信息
     */
    @Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public Partymember selectPartymemberById(Integer pid)
	{
	    return partymemberMapper.selectPartymemberById(pid);
	}
	
	/**
     * 查询暮云党员列表
     * 
     * @param partymember 暮云党员信息
     * @return 暮云党员集合
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public List<Partymember> selectPartymemberList(Partymember partymember)
	{
	    return partymemberMapper.selectPartymemberList(partymember);
	}
	
    /**
     * 新增暮云党员
     * 
     * @param partymember 暮云党员信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int insertPartymember(Partymember partymember)
	{
	    return partymemberMapper.insertPartymember(partymember);
	}
	
	/**
     * 修改暮云党员
     * 
     * @param partymember 暮云党员信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int updatePartymember(Partymember partymember)
	{
	    return partymemberMapper.updatePartymember(partymember);
	}

	/**
     * 删除暮云党员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int deletePartymemberByIds(String ids)
	{
		return partymemberMapper.deletePartymemberByIds(Convert.toStrArray(ids));
	}

	/**
	 * 按照地区统计党员信息
	 *
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public List<Pmcount> countbygroup(){
		return partymemberMapper.countbygroup();
	}
	
}
