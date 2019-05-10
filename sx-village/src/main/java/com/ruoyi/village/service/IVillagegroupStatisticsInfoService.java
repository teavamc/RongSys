package com.ruoyi.village.service;

import com.ruoyi.village.domain.VillagegroupStatisticsInfo;
import java.util.List;

/**
 * 村组统计 服务层
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
public interface IVillagegroupStatisticsInfoService 
{
	/**
     * 查询村组统计信息
     * 
     * @param vgsid 村组统计ID
     * @return 村组统计信息
     */
	public VillagegroupStatisticsInfo selectVillagegroupStatisticsInfoById(Integer vgsid);
	
	/**
     * 查询村组统计列表
     * 
     * @param villagegroupStatisticsInfo 村组统计信息
     * @return 村组统计集合
     */
	public List<VillagegroupStatisticsInfo> selectVillagegroupStatisticsInfoList(VillagegroupStatisticsInfo villagegroupStatisticsInfo);
	
	/**
     * 新增村组统计
     * 
     * @param villagegroupStatisticsInfo 村组统计信息
     * @return 结果
     */
	public int insertVillagegroupStatisticsInfo(VillagegroupStatisticsInfo villagegroupStatisticsInfo);
	
	/**
     * 修改村组统计
     * 
     * @param villagegroupStatisticsInfo 村组统计信息
     * @return 结果
     */
	public int updateVillagegroupStatisticsInfo(VillagegroupStatisticsInfo villagegroupStatisticsInfo);
		
	/**
     * 删除村组统计信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteVillagegroupStatisticsInfoByIds(String ids);
	
}
