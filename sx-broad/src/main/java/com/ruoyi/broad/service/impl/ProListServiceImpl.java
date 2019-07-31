package com.ruoyi.broad.service.impl;

import java.util.HashMap;
import java.util.List;

import com.ruoyi.broad.domain.Progbroad;
import com.ruoyi.broad.domain.Program_List;
import com.ruoyi.broad.domain.TerReceives;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.broad.mapper.ProListMapper;
import com.ruoyi.broad.domain.ProList;
import com.ruoyi.broad.service.IProListService;
import com.ruoyi.common.support.Convert;

/**
 * 节目单记录 服务层实现
 * 
 * @author 张超
 * @date 2019-03-02
 */
@Service
public class ProListServiceImpl implements IProListService 
{
	@Autowired
	private ProListMapper proListMapper;

	/**
     * 查询节目单记录信息
     * 
     * @param pid 节目单记录ID
     * @return 节目单记录信息
     */
    @Override
	@DataSource(value = DataSourceType.SLAVE)
    public ProList selectProListById(String id)
	{
	    return proListMapper.selectProListById(id);
	}
	
	/**
     * 查询节目单记录列表
     * 
     * @param proList 节目单记录信息
     * @return 节目单记录集合
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<ProList> selectProListList(ProList proList)
	{
	    return proListMapper.selectProListList(proList);
	}
	
    /**
     * 新增节目单记录
     * 
     * @param proList 节目单记录信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int insertProList(ProList proList)
	{
	    return proListMapper.insertProList(proList);
	}
	
	/**
     * 修改节目单记录
     * 
     * @param proList 节目单记录信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int updateProList(ProList proList)
	{
	    return proListMapper.updateProList(proList);
	}

	/**
     * 删除节目单记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public int deleteProListByIds(String ids)
	{
		return proListMapper.deleteProListByIds(Convert.toStrArray(ids));
	}


//	老业务
    /**
     * 根据用户编号和查询获取节目播出单（分页）
     * @return
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Progbroad> getProgBroadByUserid(String userid) throws Exception{
        return proListMapper.getProgBroadByUserid(userid);
    }
    /**
     * 根据编号列表查询节目单
     * @param pd
     * @return
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Progbroad> getProgBroadByIds(String[] ids) throws Exception{
        return proListMapper.getProgBroadByIds(ids);
    }
    /**
     * 根据编号列表查询节目单明细表
     * @param pd
     * @return
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Progbroad> getProgBroadDetails(Progbroad progbroad) throws Exception{
        return proListMapper.getProgBroadDetails(progbroad);
    }
    /**
     * 根据节目播出单编号获取节目明细
     * @param probroadid
     * @return
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<HashMap> selectProListByProid(String probroadid) throws Exception{
        return proListMapper.selectProListByProid(probroadid);
    }
    /**
     * 终端播出单下载情况
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<TerReceives> getTerReceive() throws Exception{
        return proListMapper.getTerReceive();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<HashMap> getTerReceiveByIdlist(String[] ids) throws Exception{
        return proListMapper.getTerReceiveByIdlist(ids);
    }
    /**
     * 根据节目单编号查询终端
     * @param probroadid
     * @return
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<HashMap> getBroadTerminals(String probroadid) throws Exception{
        return proListMapper.getBroadTerminals(probroadid);
    }

    /**
     * 添加播出单
     * @param pd
     * @return 播出单编号
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public Integer addProBroad(Progbroad pb) throws Exception{
        return proListMapper.addProBroad(pb);
    }
    /**
     * 添加播出单明细
     * @param prolist
     * @throws Exception
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public void addProList(Program_List prolist) throws Exception{
    }
    /**
     * 添加终端播出单关联
     * @param pdlist
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public void addProTerminal(List<HashMap> pdlist) throws Exception{
    }

    /**
     * 根据pid显示相应的播出单操作详情
     * @author 张超 teavamc
     * @date 2019/3/9
     * @param [pid]
     * @return java.util.List<com.ruoyi.broad.domain.Progbroad>
     */

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<ProList> 	selectProListListByPid(String pid){
        return proListMapper.selectProListListByPid(pid);
    }

}
