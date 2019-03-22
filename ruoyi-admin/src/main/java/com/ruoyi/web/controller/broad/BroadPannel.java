package com.ruoyi.web.controller.broad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共节目单
 *
 * @author 周博
 * @date 2019-03-20
 */
@Controller
@RequestMapping("/broad/pannel")
public class BroadPannel {
    private String prefix = "broad/pannel";

    @GetMapping()
    public String list() {
        return prefix + "/bPannel";
    }
}
