package com.ruoyi.broad.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.TrafficMapper;
import com.ruoyi.broad.domain.Traffic;
import com.ruoyi.broad.service.ITrafficService;
import com.ruoyi.common.support.Convert;

/**
 * 流量 服务层实现
 *
 * @author 张超
 * @date 2019-01-15
 */
@Service
public class TrafficServiceImpl implements ITrafficService
{
	@Autowired
	private TrafficMapper trafficMapper;

	/**
	 * 查询流量信息
	 *
	 * @param ttid 流量ID
	 * @return 流量信息
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public Traffic selectTrafficById(Integer ttid)
	{
		return trafficMapper.selectTrafficById(ttid);
	}

	/**
	 * 查询流量列表
	 *
	 * @param traffic 流量信息
	 * @return 流量集合
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Traffic> selectTrafficList(Traffic traffic)
	{
		return trafficMapper.selectTrafficList(traffic);
	}

	/**
	 * 新增流量
	 *
	 * @param traffic 流量信息
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertTraffic(Traffic traffic)
	{
		return trafficMapper.insertTraffic(traffic);
	}

	/**
	 * 修改流量
	 *
	 * @param traffic 流量信息
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateTraffic(Traffic traffic)
	{
		return trafficMapper.updateTraffic(traffic);
	}

	/**
	 * 修改流量限制
	 *
	 * @param traffic 流量信息
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateTrafficSet(Traffic traffic)
	{
		return trafficMapper.updateTrafficSet(traffic);
	}

	/**
	 * 删除流量对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteTrafficByIds(String ids)
	{
		return trafficMapper.deleteTrafficByIds(Convert.toStrArray(ids));
	}

	/**
	 * 批量设置流量限制
	 *
	 * @return
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateRdsByIds(String id , String number)
	{
		return trafficMapper.updateRdsByIds(Convert.toStrArray(id),number);
	}
}
