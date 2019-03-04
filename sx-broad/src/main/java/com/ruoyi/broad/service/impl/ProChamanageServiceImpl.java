package com.ruoyi.broad.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.ProChamanageMapper;
import com.ruoyi.broad.domain.ProChamanage;
import com.ruoyi.broad.service.IProChamanageService;
import com.ruoyi.common.support.Convert;

/**
 * 节目转播管理 服务层实现
 * 
 * @author 张超
 * @date 2019-03-02
 */
@Service
public class ProChamanageServiceImpl implements IProChamanageService 
{
	@Autowired
	private ProChamanageMapper proChamanageMapper;

	/**
     * 查询节目转播管理信息
     * 
     * @param cid 节目转播管理ID
     * @return 节目转播管理信息
     */
    @Override
	@DataSource(value = DataSourceType.SLAVE)
	public ProChamanage selectProChamanageById(Integer cid)
	{
	    return proChamanageMapper.selectProChamanageById(cid);
	}
	
	/**
     * 查询节目转播管理列表
     * 
     * @param proChamanage 节目转播管理信息
     * @return 节目转播管理集合
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<ProChamanage> selectProChamanageList(ProChamanage proChamanage)
	{
	    return proChamanageMapper.selectProChamanageList(proChamanage);
	}
	
    /**
     * 新增节目转播管理
     * 
     * @param proChamanage 节目转播管理信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertProChamanage(ProChamanage proChamanage)
	{
	    return proChamanageMapper.insertProChamanage(proChamanage);
	}
	
	/**
     * 修改节目转播管理
     * 
     * @param proChamanage 节目转播管理信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateProChamanage(ProChamanage proChamanage)
	{
	    return proChamanageMapper.updateProChamanage(proChamanage);
	}

	/**
     * 删除节目转播管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteProChamanageByIds(String ids)
	{
		return proChamanageMapper.deleteProChamanageByIds(Convert.toStrArray(ids));
	}
	
}
