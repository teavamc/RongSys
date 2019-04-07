package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.Termap;
import com.ruoyi.common.utils.PageData;

import java.util.List;

/**
 * 地图管理 服务层
 *
 * @author 张鸿权
 * @date 2019-01-15
 */
public interface TermapMapper
{
	/**
	 * 获取所有经纬度信息(不分页,用于excel导出)
	 *
	 * @param @param pd
	 * @return List<MapInfo>
	 */
	public List<Termap> getAllMapInfo(String aid);

}