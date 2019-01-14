package com.ruoyi.broad.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.LedshowMapper;
import com.ruoyi.broad.domain.Ledshow;
import com.ruoyi.broad.service.ILedshowService;
import com.ruoyi.common.support.Convert;

/**
 * led显示 服务层实现
 * 
 * @author 张超
 * @date 2019-01-14
 */
@Service
public class LedshowServiceImpl implements ILedshowService 
{
	@Autowired
	private LedshowMapper ledshowMapper;

	/**
     * 查询led显示信息
     * 
     * @param lsid led显示ID
     * @return led显示信息
     */
    @Override
	@DataSource(value = DataSourceType.SLAVE)
	public Ledshow selectLedshowById(Integer lsid)
	{
	    return ledshowMapper.selectLedshowById(lsid);
	}
	
	/**
     * 查询led显示列表
     * 
     * @param ledshow led显示信息
     * @return led显示集合
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Ledshow> selectLedshowList(Ledshow ledshow)
	{
	    return ledshowMapper.selectLedshowList(ledshow);
	}
	
    /**
     * 新增led显示
     * 
     * @param ledshow led显示信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertLedshow(Ledshow ledshow)
	{
	    return ledshowMapper.insertLedshow(ledshow);
	}
	
	/**
     * 修改led显示
     * 
     * @param ledshow led显示信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateLedshow(Ledshow ledshow)
	{
	    return ledshowMapper.updateLedshow(ledshow);
	}

	/**
     * 删除led显示对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteLedshowByIds(String ids)
	{
		return ledshowMapper.deleteLedshowByIds(Convert.toStrArray(ids));
	}
	
}
