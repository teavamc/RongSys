package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Area;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;

import java.util.List;
import java.util.Map;

/**
 * 终端地域 服务层
 * 
 * @author 张超
 * @date 2019-01-17
 */
public interface IAreaService 
{
	/**
     * 查询终端地域信息
     * 
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
	public Area selectAreaById(String aid);

	/**
	 * 查询终端地区树
	 *
	 * @param area 部门信息
	 * @return 所有部门信息
	 */
	public List<Map<String, Object>> selectAreaTree(Area area);


	/**
     * 查询终端地域列表
     * 
     * @param area 终端地域信息
     * @return 终端地域集合
     */
	public List<Area> selectAreaList(Area area);
	
	/**
     * 新增终端地域
     * 
     * @param area 终端地域信息
     * @return 结果
     */
	public int insertArea(Area area);
	
	/**
     * 修改终端地域
     * 
     * @param area 终端地域信息
     * @return 结果
     */
	public int updateArea(Area area);
		
	/**
     * 删除终端地域信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAreaByIds(String ids);
	
}
