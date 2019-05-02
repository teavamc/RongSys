package com.ruoyi.village.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.village.mapper.HouseInfoMapper;
import com.ruoyi.village.domain.HouseInfo;
import com.ruoyi.village.service.IHouseInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 房屋 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Service
public class HouseInfoServiceImpl implements IHouseInfoService 
{
	@Autowired
	private HouseInfoMapper houseInfoMapper;

	/**
     * 查询房屋信息
     * 
     * @param hid 房屋ID
     * @return 房屋信息
     */
    @Override
	public HouseInfo selectHouseInfoById(Integer hid)
	{
	    return houseInfoMapper.selectHouseInfoById(hid);
	}
	
	/**
     * 查询房屋列表
     * 
     * @param houseInfo 房屋信息
     * @return 房屋集合
     */
	@Override
	public List<HouseInfo> selectHouseInfoList(HouseInfo houseInfo)
	{
	    return houseInfoMapper.selectHouseInfoList(houseInfo);
	}
	
    /**
     * 新增房屋
     * 
     * @param houseInfo 房屋信息
     * @return 结果
     */
	@Override
	public int insertHouseInfo(HouseInfo houseInfo)
	{
	    return houseInfoMapper.insertHouseInfo(houseInfo);
	}
	
	/**
     * 修改房屋
     * 
     * @param houseInfo 房屋信息
     * @return 结果
     */
	@Override
	public int updateHouseInfo(HouseInfo houseInfo)
	{
	    return houseInfoMapper.updateHouseInfo(houseInfo);
	}

	/**
     * 删除房屋对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHouseInfoByIds(String ids)
	{
		return houseInfoMapper.deleteHouseInfoByIds(Convert.toStrArray(ids));
	}
	
}
