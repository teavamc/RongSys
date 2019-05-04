package com.ruoyi.iot.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.iot.domain.IotgetPa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.iot.mapper.TorrentMapper;
import com.ruoyi.iot.domain.Torrent;
import com.ruoyi.iot.service.ITorrentService;
import com.ruoyi.common.support.Convert;

/**
 * 终端运转 服务层实现
 * 
 * @author 张超
 * @date 2019-03-03
 */
@Service
public class TorrentServiceImpl implements ITorrentService 
{
	@Autowired
	private TorrentMapper torrentMapper;

	/**
     * 查询终端运转信息
     * 
     * @param dataid 终端运转ID
     * @return 终端运转信息
     */
    @Override
	@DataSource(value = DataSourceType.SXINFOM)
	public Torrent selectTorrentById(Integer dataid)
	{
	    return torrentMapper.selectTorrentById(dataid);
	}
	
	/**
     * 查询终端运转列表
     * 
     * @param torrent 终端运转信息
     * @return 终端运转集合
     */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public List<Torrent> selectTorrentList(Torrent torrent)
	{
	    return torrentMapper.selectTorrentList(torrent);
	}
	
    /**
     * 新增终端运转
     * 
     * @param torrent 终端运转信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public int insertTorrent(Torrent torrent)
	{
	    return torrentMapper.insertTorrent(torrent);
	}
	
	/**
     * 修改终端运转
     * 
     * @param torrent 终端运转信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public int updateTorrent(Torrent torrent)
	{
	    return torrentMapper.updateTorrent(torrent);
	}

	/**
     * 删除终端运转对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public int deleteTorrentByIds(String ids)
	{
		return torrentMapper.deleteTorrentByIds(Convert.toStrArray(ids));
	}

	/**
	 * 统计物联网数据条目
	 *
	 * @param dataid 终端运转ID
	 * @return 终端运转信息
	 */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public int countall(){
		return torrentMapper.countall();
	}

	/**
	 * 统计物联网设备数量
	 *
	 * @param dataid 终端运转ID
	 * @return 终端运转信息
	 */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public int devicecount(){
		return torrentMapper.devicecount();
	}

	/**
	 * 根据IMEI号和时间范围和查询条数统计物联网数据
	 *
	 * @param torrent 终端信息
	 * @return 终端信息集合
	 */
	@Override
	@DataSource(value = DataSourceType.SXINFOM)
	public List<Torrent> selectTorrentByitl(IotgetPa iotgetPa)
	{
		return torrentMapper.selectTorrentByitl(iotgetPa);
	}
}
