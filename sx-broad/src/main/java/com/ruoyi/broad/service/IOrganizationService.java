package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.common.utils.PageData;

import java.util.List;

/**
 * 终端地域 服务层
 * 
 * @author 张鸿权
 * @date 2019-01-17
 */
public interface IOrganizationService
{
	/**
     * 查询终端地域信息
     *
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
	public Organization selectOrganizationById(String aid);

	/**
	 * 查询终端列表
	 *
	 * @param organization 终端信息
	 * @return 终端集合
	 */
	public List<Organization> selectOrganizationList(Organization organization);

	/**
     * 新增终端
     * 
     * @param organization 终端信息
     * @return 结果
     */
	public int insertOrganization(Organization organization);
	
	/**
     * 修改终端
     * 
     * @param organization 终端信息
     * @return 结果
     */
	public int updateOrganization(Organization organization);
		
	/**
     * 删除终端信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrganizationByIds(String ids);

	/**
	 * 根据tid查询终端信息
	 *
	 * @param tid 终端IMEI
	 * @return 终端信息
	 */
	public Organization getOrgnzByOid(String tid) throws Exception;
	/**
	 * 根据终端imei列表获取终端部分信息
	 * @param pd
	 * @return
	 */
	public List<PageData> getTerInfoBytids(PageData pd) throws Exception;
	/**
	 * 根据分组编号列表查询终端列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Organization> listTersByAids(PageData pd) throws Exception;
}
