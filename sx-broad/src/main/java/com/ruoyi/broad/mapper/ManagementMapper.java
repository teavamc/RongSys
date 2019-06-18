package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.Conditions;
import com.ruoyi.broad.domain.Management;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.broad.domain.Tersga;

import java.util.List;

/**
 * 终端管理 数据层
 *
 * @author 张超
 * @date 2019-01-15
 */
public interface ManagementMapper
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
	public List selectManagementList(Management management);

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
	 * 删除终端管理
	 *
	 * @param tid 终端管理ID
	 * @return 结果
	 */
	public int deleteManagementById(String tid);

	/**
	 * 批量删除终端管理
	 *
	 * @param tids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteManagementByIds(String[] tids);

	/**
	 * 随机选取100个数据
	 *
	 * @param
	 * @return 结果
	 */
	public List<Managementgps> selectManagementByRandom();

	/**
	 * 所有数据
	 *
	 * @param
	 * @return 结果
	 */
	public List<Managementgps> selectManagementAll();

	/**
	 * 按照终端地址进行运行状态的分组统计
	 * @author 张超 teavamc
	 * @date 2019/1/25
	 * @param []
	 * @return java.util.List<com.ruoyi.broad.domain.Tersga>
	 */
	public List<Tersga> selecttersga();

	/**
	 * 回传目前设备挂载总数,运行数，停止数
	 * @author 张超 teavamc
	 * @date 2019/1/25
	 * @param []
	 * @return com.ruoyi.broad.domain.Tersga
	 */
	public Tersga sumters();

	/**
	 * 按照终端地址进行运行状态的分组统计,包括分组地区、挂在数量、运行数量、停止数量
	 * @author 张超 teavamc
	 * @date 2019/1/25
	 * @param []
	 * @return java.util.List<com.ruoyi.broad.domain.Tersga>
	 */
	public List<Tersga> sumterm();
}