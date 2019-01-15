package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Management;
import java.util.List;

/**
 * 终端管理 服务层
 * 
 * @author 张超
 * @date 2019-01-15
 */
public interface IManagementService 
{
	/**
     * 查询终端管理信息
     * 
     * @param tid 终端管理ID
     * @return 终端管理信息
     */
	public Management selectManagementById(String tid);
	
	/**
     * 查询终端管理列表
     * 
     * @param management 终端管理信息
     * @return 终端管理集合
     */
	public List<Management> selectManagementList(Management management);
	
	/**
     * 新增终端管理
     * 
     * @param management 终端管理信息
     * @return 结果
     */
	public int insertManagement(Management management);
	
	/**
     * 修改终端管理
     * 
     * @param management 终端管理信息
     * @return 结果
     */
	public int updateManagement(Management management);
		
	/**
     * 删除终端管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteManagementByIds(String ids);
	
}
