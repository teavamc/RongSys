package com.ruoyi.broad.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.ProSinmanageMapper;
import com.ruoyi.broad.domain.ProSinmanage;
import com.ruoyi.broad.service.IProSinmanageService;
import com.ruoyi.common.support.Convert;

/**
 * 节目播出单 服务层实现
 * 
 * @author 张超
 * @date 2019-03-02
 */
@Service
public class ProSinmanageServiceImpl implements IProSinmanageService 
{
	@Autowired
	private ProSinmanageMapper proSinmanageMapper;

	/**
     * 查询节目播出单信息
     * 
     * @param sfid 节目播出单ID
     * @return 节目播出单信息
     */
    @Override
	@DataSource(value = DataSourceType.SLAVE)
	public ProSinmanage selectProSinmanageById(Integer sfid)
	{
	    return proSinmanageMapper.selectProSinmanageById(sfid);
	}
	
	/**
     * 查询节目播出单列表
     * 
     * @param proSinmanage 节目播出单信息
     * @return 节目播出单集合
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<ProSinmanage> selectProSinmanageList(ProSinmanage proSinmanage)
	{
	    return proSinmanageMapper.selectProSinmanageList(proSinmanage);
	}
	
    /**
     * 新增节目播出单
     * 
     * @param proSinmanage 节目播出单信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertProSinmanage(ProSinmanage proSinmanage)
	{
	    return proSinmanageMapper.insertProSinmanage(proSinmanage);
	}
	
	/**
     * 修改节目播出单
     * 
     * @param proSinmanage 节目播出单信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateProSinmanage(ProSinmanage proSinmanage)
	{
	    return proSinmanageMapper.updateProSinmanage(proSinmanage);
	}

	/**
     * 删除节目播出单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteProSinmanageByIds(String ids)
	{
		return proSinmanageMapper.deleteProSinmanageByIds(Convert.toStrArray(ids));
	}


	/**
	 * 通过 sfid 查询节目编号List
	 * @author 张超 teavamc
	 * @date 2019/3/9
	 * @param [sfids]
	 * @return java.util.List<com.ruoyi.broad.domain.ProSinmanage>
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<ProSinmanage> selectProSinmanageListbySfid(String sfid){
		return proSinmanageMapper.selectProSinmanageListbySfid(sfid);
	}

}
