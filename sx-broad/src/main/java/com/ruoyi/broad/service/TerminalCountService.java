package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.TerminalCount;

import java.util.List;

/**
 *
 * @author 陈霞
 * @data 2019/3/20.
 */
public interface TerminalCountService {
    /*统计故障终端，按时间分布
    * */
    List<TerminalCount> getAllTerminal();

}
