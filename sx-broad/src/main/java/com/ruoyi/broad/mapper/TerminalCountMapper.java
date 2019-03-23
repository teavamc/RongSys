package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.TerminalCount;

import java.util.List;

/**
 * Created by ASUS on 2019/3/20.
 * @author 陈霞
 */
public interface TerminalCountMapper {
   /*查询终端的设备号，与设备运行的时间
   * */
    List<TerminalCount> getAllTerminal();

}
