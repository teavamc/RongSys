package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.mapper.OrganizationMapper;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 终端地域 服务层实现
 *
 * @author 张超
 * @date 2019-01-17
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService
{

		@Autowired
		private OrganizationMapper organizationMapper;

		/**
		 * 查询终端地域信息
		 *
		 * @param tid 终端地域ID
		 * @return 终端地域信息
		 */
		@Override
		@DataSource(value = DataSourceType.SLAVE)
		public Organization selectOrganizationById(String tid)
		{
			return organizationMapper.selectOrganizationById(tid);
		}


		/**
		 * 查询终端地域列表
		 *
		 * @param organization 终端地域信息
		 * @return 终端地域集合
		 */
		@Override
		@DataSource(value = DataSourceType.SLAVE)
		public List<Organization> selectOrganizationList(Organization organization)
		{
			return organizationMapper.selectOrganizationList(organization);
		}

		/**
		 * 新增终端地域
		 *
		 * @param organization 终端地域信息
		 * @return 结果
		 */
		@Override
		@DataSource(value = DataSourceType.SLAVE)
		public int insertOrganization(Organization organization)
		{
			return organizationMapper.insertOrganization(organization);
		}

		/**
		 * 修改终端地域
		 *
		 * @param organization 终端地域信息
		 * @return 结果
		 */
		@Override
		@DataSource(value = DataSourceType.SLAVE)
		public int updateOrganization(Organization organization)
		{
			return organizationMapper.updateOrganization(organization);
		}

		/**
		 * 删除终端地域对象
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
//
//	public List<Map<String, Object>> getTrees(List<SysDept> deptList, boolean isCheck, List<String> roleDeptList)
//	{
//
//		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
//		for (SysDept dept : deptList)
//		{
//			if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
//			{
//				Map<String, Object> deptMap = new HashMap<String, Object>();
//				deptMap.put("id", dept.getDeptId());
//				deptMap.put("pId", dept.getParentId());
//				deptMap.put("name", dept.getDeptName());
//				deptMap.put("title", dept.getDeptName());
//				if (isCheck)
//				{
//					deptMap.put("checked", roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
//				}
//				else
//				{
//					deptMap.put("checked", false);
//				}
//				trees.add(deptMap);
//			}
//		}
//		return trees;
//	}
	}
