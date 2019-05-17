package com.ruoyi.village.service;

import com.ruoyi.village.domain.AssetAssessment;
import java.util.List;

/**
 * 资产清查 服务层
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
public interface IAssetAssessmentService 
{
	/**
     * 查询资产清查信息
     * 
     * @param aaid 资产清查ID
     * @return 资产清查信息
     */
	public AssetAssessment selectAssetAssessmentById(Integer aaid);
	
	/**
     * 查询资产清查列表
     * 
     * @param assetAssessment 资产清查信息
     * @return 资产清查集合
     */
	public List<AssetAssessment> selectAssetAssessmentList(AssetAssessment assetAssessment);
	
	/**
     * 新增资产清查
     * 
     * @param assetAssessment 资产清查信息
     * @return 结果
     */
	public int insertAssetAssessment(AssetAssessment assetAssessment);
	
	/**
     * 修改资产清查
     * 
     * @param assetAssessment 资产清查信息
     * @return 结果
     */
	public int updateAssetAssessment(AssetAssessment assetAssessment);
		
	/**
     * 删除资产清查信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAssetAssessmentByIds(String ids);
	
}
