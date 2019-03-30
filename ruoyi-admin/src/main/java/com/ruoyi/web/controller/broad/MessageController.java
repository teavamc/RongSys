package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping()
    public String sms() {
        return prefix + "/message";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData()
    {
        List<Map<String, Object>> tree = messageService.selectMessageList((new BroadMessage()));
        return tree;
    }

}
