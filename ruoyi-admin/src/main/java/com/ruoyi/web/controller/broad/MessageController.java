package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.broad.service.IMsmUsersService;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.common.utils.PageData;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短信播出端
 *
 * @author 周博
 * @date 2019-03-28
 */

@Controller
@RequestMapping("/broad/message")
public class MessageController extends BaseController {
    private String prefix = "broad/message";
    @Autowired
    private IMessageService messageService;
    @Autowired
    private IMsmUsersService usersService;

    @GetMapping()
    public String sms() {
        return prefix + "/message";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData() {
        List<Map<String, Object>> tree = messageService.selectMessageList((new BroadMessage()));
        return tree;
    }

    /**
     * 去发送短信
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toSendSms")
    public List<Map<String, Object>> toSendSms() throws Exception {
        return null;
    }

    /**
     * 发送短信
     *
     * @param
     * @return
     */

    @RequestMapping(value = "/sendsms")
    @ResponseBody
    public Object addProBroad(@PathVariable(value = "phones") String[] phones,
                              @PathVariable(value = "terids") String[] terids,
                              @PathVariable(value = "smstype") String[] smstype,
                              @PathVariable(value = "content") String[] content) throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        List<String> phonelist = new ArrayList<String>();
        List<PageData> pdlist = new ArrayList<PageData>();

        for (int i = 0; i < terids.length; i++) {
            if (phones[i] != null && !"".equals(phones[i])) {
                PageData tmpd = new PageData();
                phonelist.add(phones[i]);
                tmpd.put("sendtime", DateUtil.getTime());
                tmpd.put("scontent", content);
                tmpd.put("remark", smstype);
                tmpd.put("issend", 0);
                tmpd.put("tid", terids[i]);
                tmpd.put("smobile", phones[i]);
                pdlist.add(tmpd);
            }
        }
        //添加发送短信表
        messageService.addSendMessage(pdlist);
//		SendSms.sendSmsAll(phonelist, content);
        map.put("result", "success");
        return map;
    }

}
