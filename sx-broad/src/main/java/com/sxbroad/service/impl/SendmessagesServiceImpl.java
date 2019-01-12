package com.sxbroad.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.sxbroad.domain.Sendmessages;
import com.sxbroad.mapper.SendmessagesMapper;
import com.sxbroad.service.ISendmessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.support.Convert;

/**
 * 短信发送记录 服务层实现
 * 
 * @author 张超
 * @date 2019-01-11
 */
@Service
public class SendmessagesServiceImpl implements ISendmessagesService
{
	@Autowired
	private SendmessagesMapper sendmessagesMapper;

	/**
     * 查询短信发送记录信息
     * 
     * @param smid 短信发送记录ID
     * @return 短信发送记录信息
     */
    @Override
	@DataSource(DataSourceType.SLAVE)
	public Sendmessages selectSendmessagesById(Integer smid)
	{
	    return sendmessagesMapper.selectSendmessagesById(smid);
	}
	
	/**
     * 查询短信发送记录列表
     * 
     * @param sendmessages 短信发送记录信息
     * @return 短信发送记录集合
     */
	@Override
	@DataSource(DataSourceType.SLAVE)
	public List<Sendmessages> selectSendmessagesList(Sendmessages sendmessages)
	{
	    return sendmessagesMapper.selectSendmessagesList(sendmessages);
	}
	
    /**
     * 新增短信发送记录
     * 
     * @param sendmessages 短信发送记录信息
     * @return 结果
     */
	@Override
	@DataSource(DataSourceType.SLAVE)
	public int insertSendmessages(Sendmessages sendmessages)
	{
	    return sendmessagesMapper.insertSendmessages(sendmessages);
	}
	
	/**
     * 修改短信发送记录
     * 
     * @param sendmessages 短信发送记录信息
     * @return 结果
     */
	@Override
	@DataSource(DataSourceType.SLAVE)
	public int updateSendmessages(Sendmessages sendmessages)
	{
	    return sendmessagesMapper.updateSendmessages(sendmessages);
	}

	/**
     * 删除短信发送记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(DataSourceType.SLAVE)
	public int deleteSendmessagesByIds(String ids)
	{
		return sendmessagesMapper.deleteSendmessagesByIds(Convert.toStrArray(ids));
	}
	
}
