package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.domain.TerminalTels;

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
	 * @param tid 终端地域ID
	 * @return 终端地域信息
	 */
	public Organization selectOrganizationById(String tid);

	public Organization selectAllOrganization();
	/**
	 * 查询终端地域信息
	 *
	 * @param tid 设备IMEI
	 * @return 终端地域信息
	 */
	public Organization selectOrganizationByTid(String tid);

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
	 * 新增终端地址图片
	 *
	 * @param organization 终端信息
	 * @return 结果
	 */
	public int insertOrganizationPic(Organization organization);

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
	/*public Organization getOrgnzByOid(String tid) throws Exception;*/
	/**
	 * 根据终端imei列表获取终端部分信息
	 * @param pd
	 * @return
	 */
	/*public List<PageData> getTerInfoBytids(PageData pd) throws Exception;*/
	/**
	 * 根据分组编号列表查询终端列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	/*public List<Organization> listTersByAids(PageData pd) throws Exception; */

	/**
	 * 查询节目单终端列表
	 *
	 * @param organization 终端信息
	 * @return 终端集合
	 */
	public List<Organization> selectProBroadList(Organization organization);

	/**
	 *
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 * @throws Exception 异常
	 */
//	public int addProIdAll(String ids) throws Exception;

	/**
	 * 设置终端的RDS码
	 *
	 * @return
	 */
	public int updateRdsByIds(String ids , String number);

	/**
	 * 设置终端的Fmfrequency码
	 *
	 * @return
	 */
	public int updateFmfrequencyByIds(String ids , String number);

	public int updateIsuseByTid(String tid, Boolean isuse);

	/**
	 * 获取到下面所有的 aid
	 * @param aid
	 * @return
	 */
	public  List<String> listNextAid(String aid);


	//	通过 aid 查询所有终端
	public List<Organization> listOrgByAid(List<String> aid);

	//	通过 tid 查询对应终端的RDS码
	public Organization selectRdsByTid(String tid);

	/**
	 * 通过IMEI获取终端维护员电话
	 * @param tid
	 * @return
	 */
	public  List<TerminalTels> selectTelsByTid(String tid);
}
