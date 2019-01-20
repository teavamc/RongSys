package com.ruoyi.broad.service;
import com.ruoyi.broad.domain.Termap;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import java.util.List;

/**
 * 地图管理 服务层
 * 
 * @author 张鸿权
 * @date 2019-01-18
 */
public interface ITermapService
{
	/**
	 * 获取所有经纬度信息(不分页,用于excel导出)
	 * @param @param pd
	 * @return List<MapInfo>
	 */
	@DataSource(value = DataSourceType.SLAVE)
	List<Termap> selectMap();
}
