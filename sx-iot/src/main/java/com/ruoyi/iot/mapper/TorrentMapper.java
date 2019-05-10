package com.ruoyi.iot.mapper;

import com.ruoyi.iot.domain.IotgetPa;
import com.ruoyi.iot.domain.Torrent;
import java.util.List;	

/**
 * 终端运转 数据层
 * 
 * @author 张超
 * @date 2019-03-03
 */
public interface TorrentMapper 
{
	/**
     * 查询终端运转信息
     * 
     * @param dataid 终端运转ID
     * @return 终端运转信息
     */
	public Torrent selectTorrentById(Integer dataid);

	/**
	 * 统计物联网数据条目
	 *
	 * @param dataid 终端运转ID
	 * @return 终端运转信息
	 */
	public int countall();

	/**
	 * 统计物联网设备数量
	 *
	 * @param dataid 终端运转ID
	 * @return 终端运转信息
	 */
	public int devicecount();

	/**
     * 查询终端运转列表
     * 
     * @param torrent 终端运转信息
     * @return 终端运转集合
     */
	public List<Torrent> selectTorrentList(Torrent torrent);
	
	/**
     * 新增终端运转
     * 
     * @param torrent 终端运转信息
     * @return 结果
     */
	public int insertTorrent(Torrent torrent);
	
	/**
     * 修改终端运转
     * 
     * @param torrent 终端运转信息
     * @return 结果
     */
	public int updateTorrent(Torrent torrent);
	
	/**
     * 删除终端运转
     * 
     * @param dataid 终端运转ID
     * @return 结果
     */
	public int deleteTorrentById(Integer dataid);
	
	/**
     * 批量删除终端运转
     * 
     * @param dataids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTorrentByIds(String[] dataids);

	/**
	 * 根据IMEI号和时间范围和查询条数统计物联网数据
	 *
	 * @param torrent 终端信息
	 * @return 终端信息集合
	 */
	public List<Torrent> selectTorrentByitl(IotgetPa iotgetPa);
}