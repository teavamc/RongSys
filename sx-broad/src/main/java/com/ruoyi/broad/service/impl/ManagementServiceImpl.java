package com.ruoyi.broad.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.ManagementMapper;
import com.ruoyi.broad.domain.Management;
import com.ruoyi.broad.service.IManagementService;
import com.ruoyi.common.support.Convert;

/**
 * 终端管理 服务层实现
 * 
 * @author 张超
 * @date 2019-01-15
 */
@Service
public class ManagementServiceImpl implements IManagementService 
{
	@Autowired
	private ManagementMapper managementMapper;

	/**
     * 查询终端管理信息
     * 
     * @param tid 终端管理ID
     * @return 终端管理信息
     */
    @Override
	@DataSource(value = DataSourceType.SLAVE)
	public Management selectManagementById(String tid)
	{
	    return managementMapper.selectManagementById(tid);
	}
	
	/**
     * 查询终端管理列表
     * 
     * @param management 终端管理信息
     * @return 终端管理集合
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Management> selectManagementList(Management management)
	{
	    return managementMapper.selectManagementList(management);
	}
	
    /**
     * 新增终端管理
     * 
     * @param management 终端管理信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertManagement(Management management)
	{
	    return managementMapper.insertManagement(management);
	}
	
	/**
     * 修改终端管理
     * 
     * @param management 终端管理信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateManagement(Management management)
	{
	    return managementMapper.updateManagement(management);
	}

	/**
     * 删除终端管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteManagementByIds(String ids)
	{
		return managementMapper.deleteManagementByIds(Convert.toStrArray(ids));
	}
	
}
