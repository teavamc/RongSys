package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.mapper.OrganizationMapper;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 终端管理 服务层实现
 *
 * @author 张鸿权
 * @date 2019-01-17
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService
{
	/*@Resource(name = "daoSupport")
	private DaoSupport dao;*/

	@Autowired
	private OrganizationMapper organizationMapper;


	//		@Override
//		@DataSource(value = DataSourceType.SLAVE)
//		public Organization selectOrganizationById(String aid)
//		{
//			return organizationMapper.selectOrganizationById(aid);
//		}
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public Organization selectAllOrganization()
	{
		return organizationMapper.selectAllOrganization();
	}


	/**
	 * 查询终端地域信息
	 *
	 * @param tid 设备IMEI
	 * @return 终端地域信息
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public Organization selectOrganizationByTid(String tid){
		return organizationMapper.selectOrganizationByTid(tid);
	}


	/**
	 * 查询终端列表
	 *
	 * @param organization 终端信息
	 * @return 终端集合
	 */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Organization> selectOrganizationList(Organization organization){
        List<Organization> res;
        List<String> allaid = listNextAid(organization.getAid());
        // 判断是否有子 aid，如果有子 aid,有则获取到所有的子 aid 放入一个 list
        if (allaid.isEmpty()){
            res = findAll(organization);
        }else {
            //获得所有的子 aid 放入 list
            List<String> temp;
            temp = listNextAid(allaid.get(0));
            for (int i = 1; i < allaid.size(); i++){
                List<String> l = listNextAid(allaid.get(i));
                if (!l.isEmpty()){
                    temp.addAll(l);
                }
            }
            allaid.addAll(temp);
            // 遍历所有的 aid 信息然后装入结果
            res = listOrgByAid(allaid);
        }
        return res;
    }

    /**
     *  获取所有子 aid
     */
	public List<Organization> findAll(Organization organization)
	{
		List<Organization> list = organizationMapper.selectOrganizationList(organization) ;
		for(Organization data:list) {
            data.setIsused(data.getIsuse()?"是":"否");
		}
		return list;
	}

	/**
	 * 新增终端
	 *
	 * @param organization 终端信息
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertOrganization(Organization organization)
	{
		return organizationMapper.insertOrganization(organization);
	}

	/**
	 * 新增终端地址图片
	 *
	 * @param organization 终端信息
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertOrganizationPic(Organization organization)
	{
		return organizationMapper.insertOrganizationPic(organization);
	}
	/**
	 * 修改终端
	 *
	 * @param organization 终端信息
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateOrganization(Organization organization)
	{
		return organizationMapper.updateOrganization(organization);
	}

	/**
	 * 删除终端对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteOrganizationByIds(String ids)
	{
		return organizationMapper.deleteOrganizationByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询节目单终端列表
	 *
	 * @param organization 终端信息
	 * @return 终端集合
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Organization> selectProBroadList(Organization organization)
	{
		return organizationMapper.selectProBroadList(organization) ;
	}

	/**
	 * 查询终端信息
	 *
	 * @param tid 终端IMEI
	 * @return 终端信息
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public Organization selectOrganizationById(String tid)
	{
		return organizationMapper.selectOrganizationByTid(tid);
	}

	/**
	 * 设置终端的RDS码
	 *
	 * @return
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateRdsByIds(String id , String number)
	{
		return organizationMapper.updateRdsByIds(Convert.toStrArray(id),number);
	}

	/**
	 * 设置终端的频率码
	 ** @return
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateFmfrequencyByIds(String id , String number)
	{
		return organizationMapper.updateFmfrequencyByIds(Convert.toStrArray(id),number);
	}

	/**
	 * 获取所选择终端的编号
	 * @param pd
	 * @return List<PageData>
	 */
	/*	@Override
		@DataSource(value = DataSourceType.SLAVE)
		public List<PageData> getTerInfoBytids(PageData pd) throws Exception {
			return (List<PageData>) dao.findForList("OrganizationMapper.getTerInfoBytids",pd);
		}*/

	/**
	 * 根据分组编号列表查询终端列表
	 * @param pd
	 * @return List<Organization>
	 */
		/*@Override
		public List<Organization> listTersByAids(PageData pd) throws Exception {
			return (List<Organization>) dao.findForList("OrganizationMapper.listTersByAids",pd);
		}*/

	/**
	 * 批量删除用户信息
	 *
	 * @param //ids 需要删除的数据ID
	 * @return 结果
	 */
	/*@Override
	public int addProIdAll(String ids) throws BusinessException
	{
		Long[] userIds = Convert.toLongArray(ids);

		return  organizationMapper.addProIdAll(userIds);
	}*/

	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateIsuseByTid(String tid, Boolean isuse)
	{
		return organizationMapper.updateIsuseByTid(tid,isuse);
	}

	/**
	 * 获取到下面所有的 aid
	 * @param aid
	 * @return
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public  List<String> listNextAid(String aid){
		return organizationMapper.listNextAid(aid);
	}


	/**
	 * 	通过 aid 查询所有终端
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Organization> listOrgByAid(List<String> aid){
		List<Organization> organizations =  organizationMapper.listOrgByAid(aid);
		for(Organization o:organizations) {
			o.setIsused(o.getIsuse()?"是":"否");
		}
		return organizations;
	}
	/**
	 * 	通过 tid 查询对应终端的RDS码
	 */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public Organization selectRdsByTid(String tid){
		return organizationMapper.selectRdsByTid(tid);
	}
}