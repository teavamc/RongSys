package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Traffic;
import java.util.List;

/**
 * 流量 服务层
 *
 * @author 张超
 * @date 2019-01-15
 */
public interface ITrafficService
{
	/**
	 * 查询流量信息
	 *
	 * @param ttid 流量ID
	 * @return 流量信息
	 */
	public Traffic selectTrafficById(Integer ttid);

	/**
	 * 查询流量列表
	 *
	 * @param traffic 流量信息
	 * @return 流量集合
	 */
	public List<Traffic> selectTrafficList(Traffic traffic);

	/**
	 * 新增流量
	 *
	 * @param traffic 流量信息
	 * @return 结果
	 */
	public int insertTraffic(Traffic traffic);

	/**
	 * 修改流量
	 *
	 * @param traffic 流量信息
	 * @return 结果
	 */
	public int updateTraffic(Traffic traffic);

	/**
	 * 修改流量限制
	 *
	 * @param traffic 流量信息
	 * @return 结果
	 */
	public int updateTrafficSet(Traffic traffic);
	/**
	 * 删除流量信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTrafficByIds(String ids);

}
