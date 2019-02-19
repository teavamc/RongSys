package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.mapper.OrganizationMapper;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.dao.DaoSupport;

import javax.annotation.Resource;
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

		/**
		 * 查询终端地域
		 *
		 * @param aid 终端地域ID
		 * @return 终端信息
		 */
		@Override
		@DataSource(value = DataSourceType.SLAVE)
		public Organization selectOrganizationById(String aid)
		{
			return organizationMapper.selectOrganizationById(aid);
		}


		/**
		 * 查询终端列表
		 *
		 * @param organization 终端信息
		 * @return 终端集合
		 */
		@Override
		@DataSource(value = DataSourceType.SLAVE)
		public List<Organization> selectOrganizationList(Organization organization)
		{
			return organizationMapper.selectOrganizationList(organization);
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
		 * 查询终端信息
		 *
		 * @param tid 终端IMEI
		 * @return 终端信息
		 */
	/*	@Override
		@DataSource(value = DataSourceType.SLAVE)
		public Organization getOrgnzByOid(String tid)
		{
			return organizationMapper.selectOrganizationById(tid);
		}
*/
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
	}
