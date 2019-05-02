package com.ruoyi.village.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.village.mapper.VillagerInfoMapper;
import com.ruoyi.village.domain.VillagerInfo;
import com.ruoyi.village.service.IVillagerInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 村民 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Service
public class VillagerInfoServiceImpl implements IVillagerInfoService 
{
	@Autowired
	private VillagerInfoMapper villagerInfoMapper;

	/**
     * 查询村民信息
     * 
     * @param vid 村民ID
     * @return 村民信息
     */
    @Override
	public VillagerInfo selectVillagerInfoById(Integer vid)
	{
	    return villagerInfoMapper.selectVillagerInfoById(vid);
	}
	
	/**
     * 查询村民列表
     * 
     * @param villagerInfo 村民信息
     * @return 村民集合
     */
	@Override
	public List<VillagerInfo> selectVillagerInfoList(VillagerInfo villagerInfo)
	{
	    return villagerInfoMapper.selectVillagerInfoList(villagerInfo);
	}
	
    /**
     * 新增村民
     * 
     * @param villagerInfo 村民信息
     * @return 结果
     */
	@Override
	public int insertVillagerInfo(VillagerInfo villagerInfo)
	{
	    return villagerInfoMapper.insertVillagerInfo(villagerInfo);
	}
	
	/**
     * 修改村民
     * 
     * @param villagerInfo 村民信息
     * @return 结果
     */
	@Override
	public int updateVillagerInfo(VillagerInfo villagerInfo)
	{
	    return villagerInfoMapper.updateVillagerInfo(villagerInfo);
	}

	/**
     * 删除村民对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteVillagerInfoByIds(String ids)
	{
		return villagerInfoMapper.deleteVillagerInfoByIds(Convert.toStrArray(ids));
	}
	
}
