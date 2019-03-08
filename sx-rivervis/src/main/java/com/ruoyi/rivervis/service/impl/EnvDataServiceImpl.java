package com.ruoyi.rivervis.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rivervis.mapper.EnvDataMapper;
import com.ruoyi.rivervis.domain.EnvData;
import com.ruoyi.rivervis.service.IEnvDataService;
import com.ruoyi.common.support.Convert;

/**
 * 环境监测 服务层实现
 * 
 * @author 张超
 * @date 2019-03-05
 */
@Service
public class EnvDataServiceImpl implements IEnvDataService 
{
	@Autowired
	private EnvDataMapper envDataMapper;

	/**
     * 查询环境监测信息
     * 
     * @param id 环境监测ID
     * @return 环境监测信息
     */
    @Override
	@DataSource(value = DataSourceType.SXRIVERVIS)
	public EnvData selectEnvDataById(Integer id)
	{
	    return envDataMapper.selectEnvDataById(id);
	}
	
	/**
     * 查询环境监测列表
     * 
     * @param envData 环境监测信息
     * @return 环境监测集合
     */
	@Override
	@DataSource(value = DataSourceType.SXRIVERVIS)
	public List<EnvData> selectEnvDataList(EnvData envData)
	{
	    return envDataMapper.selectEnvDataList(envData);
	}
	
    /**
     * 新增环境监测
     * 
     * @param envData 环境监测信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXRIVERVIS)
	public int insertEnvData(EnvData envData)
	{
	    return envDataMapper.insertEnvData(envData);
	}
	
	/**
     * 修改环境监测
     * 
     * @param envData 环境监测信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXRIVERVIS)
	public int updateEnvData(EnvData envData)
	{
	    return envDataMapper.updateEnvData(envData);
	}

	/**
     * 删除环境监测对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXRIVERVIS)
	public int deleteEnvDataByIds(String ids)
	{
		return envDataMapper.deleteEnvDataByIds(Convert.toStrArray(ids));
	}
	
}
