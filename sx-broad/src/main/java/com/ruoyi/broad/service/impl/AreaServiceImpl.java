package com.ruoyi.broad.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.AreaMapper;
import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.common.support.Convert;

/**
 * 终端地域 服务层实现
 *
 * @author 张超
 * @date 2019-01-17
 */
@Service
public class AreaServiceImpl implements IAreaService
{
	@Autowired
	private AreaMapper areaMapper;

	/**
     * 查询终端地域信息
     *
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
    @Override
	@DataSource(value = DataSourceType.SLAVE)
	public Area selectAreaById(String aid)
	{
	    return areaMapper.selectAreaById(aid);
	}

	/**
	    * 查询终端地区树
	    * @author 张超 teavamc
	    * @date 2019/2/14
	    * @param [area]
	    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	    */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Map<String, Object>> selectAreaTree(Area area){
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		List<Area> areaList = areaMapper.selectAreaList(area);
		trees = getTrees(areaList);
		return trees;
	}


	/**
	    * 根据List生产tree，前提是模型中包含id和父id关系
	    * @author 张超 teavamc
	    * @date 2019/2/14
	    * @param [areaList]
	    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	    */
	public List<Map<String, Object>> getTrees(List<Area> areaList)
	{

		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		for (Area area : areaList)
		{
			Map<String, Object> areaMap = new HashMap<String, Object>();
			areaMap.put("id", area.getAid());
			areaMap.put("pId", area.getParentaid());
			areaMap.put("name", area.getAname());
			areaMap.put("title", area.getAname());
			trees.add(areaMap);
		}
		return trees;
	}

	/**
     * 查询终端地域列表
     *
     * @param area 终端地域信息
     * @return 终端地域集合
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<Area> selectAreaList(Area area)
	{
	    return areaMapper.selectAreaList(area);
	}

    /**
     * 新增终端地域
     *
     * @param area 终端地域信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertArea(Area area)
	{
	    return areaMapper.insertArea(area);
	}

	/**
     * 修改终端地域
     *
     * @param area 终端地域信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateArea(Area area)
	{
	    return areaMapper.updateArea(area);
	}

	/**
     * 删除终端地域对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteAreaByIds(String ids)
	{
		return areaMapper.deleteAreaByIds(Convert.toStrArray(ids));
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
