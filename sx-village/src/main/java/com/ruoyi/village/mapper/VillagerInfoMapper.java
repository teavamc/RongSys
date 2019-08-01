package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.VillagerInfo;
import java.util.List;	

/**
 * 村民 数据层
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
public interface VillagerInfoMapper 
{
	/**
     * 查询村民信息
     * 
     * @param vid 村民ID
     * @return 村民信息
     */
	public VillagerInfo selectVillagerInfoById(Integer vid);
	
	/**
     * 查询村民列表
     * 
     * @param villagerInfo 村民信息
     * @return 村民集合
     */
	public List<VillagerInfo> selectVillagerInfoList(VillagerInfo villagerInfo);
	
	/**
     * 新增村民
     * 
     * @param villagerInfo 村民信息
     * @return 结果
     */
	public int insertVillagerInfo(VillagerInfo villagerInfo);
	
	/**
     * 修改村民
     * 
     * @param villagerInfo 村民信息
     * @return 结果
     */
	public int updateVillagerInfo(VillagerInfo villagerInfo);
	
	/**
     * 删除村民
     * 
     * @param vid 村民ID
     * @return 结果
     */
	public int deleteVillagerInfoById(Integer vid);
	
	/**
     * 批量删除村民
     * 
     * @param vids 需要删除的数据ID
     * @return 结果
     */
	public int deleteVillagerInfoByIds(String[] vids);

}