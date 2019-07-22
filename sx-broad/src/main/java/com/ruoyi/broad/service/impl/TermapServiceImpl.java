package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.Termap;
import com.ruoyi.broad.mapper.TermapMapper;
import com.ruoyi.broad.service.ITermapService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
/**
 * 地图管理 服务层
 *
 * @author 张鸿权
 * @date 2019-01-18
 */
@Service
public class TermapServiceImpl implements ITermapService
{
	@Autowired
	private TermapMapper termapMapper;
	/**
	 * 获取所有经纬度信息
	 * @param @param pd
	 * @return List<MapInfo>
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Termap> selectMap(String aid)
	{
		List<Termap> menus = new LinkedList<Termap>();
			menus = termapMapper.getAllMapInfo(aid);
		return menus;
	}

	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Termap> getAllMapInfoForIot()
	{
		return termapMapper.getAllMapInfoForIot();
	}
}
