package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.ProSinmanage;
import java.util.List;

/**
 * 节目播出单 服务层
 * 
 * @author 张超
 * @date 2019-03-02
 */
public interface IProSinmanageService 
{
	/**
     * 查询节目播出单信息
     * 
     * @param sfid 节目播出单ID
     * @return 节目播出单信息
     */
	public ProSinmanage selectProSinmanageById(Integer sfid);
	
	/**
     * 查询节目播出单列表
     * 
     * @param proSinmanage 节目播出单信息
     * @return 节目播出单集合
     */
	public List<ProSinmanage> selectProSinmanageList(ProSinmanage proSinmanage);
	
	/**
     * 新增节目播出单
     * 
     * @param proSinmanage 节目播出单信息
     * @return 结果
     */
	public int insertProSinmanage(ProSinmanage proSinmanage);
	
	/**
     * 修改节目播出单
     * 
     * @param proSinmanage 节目播出单信息
     * @return 结果
     */
	public int updateProSinmanage(ProSinmanage proSinmanage);
		
	/**
     * 删除节目播出单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProSinmanageByIds(String ids);
	
}
