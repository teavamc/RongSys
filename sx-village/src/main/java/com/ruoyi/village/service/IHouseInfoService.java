package com.ruoyi.village.service;

import com.ruoyi.village.domain.HouseInfo;
import java.util.List;

/**
 * 房屋 服务层
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
public interface IHouseInfoService 
{
	/**
     * 查询房屋信息
     * 
     * @param hid 房屋ID
     * @return 房屋信息
     */
	public HouseInfo selectHouseInfoById(Integer hid);
	
	/**
     * 查询房屋列表
     * 
     * @param houseInfo 房屋信息
     * @return 房屋集合
     */
	public List<HouseInfo> selectHouseInfoList(HouseInfo houseInfo);
	
	/**
     * 新增房屋
     * 
     * @param houseInfo 房屋信息
     * @return 结果
     */
	public int insertHouseInfo(HouseInfo houseInfo);
	
	/**
     * 修改房屋
     * 
     * @param houseInfo 房屋信息
     * @return 结果
     */
	public int updateHouseInfo(HouseInfo houseInfo);
		
	/**
     * 删除房屋信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHouseInfoByIds(String ids);
	
}
