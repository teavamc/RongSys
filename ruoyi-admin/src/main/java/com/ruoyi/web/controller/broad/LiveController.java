package com.ruoyi.web.controller.broad;

import com.ruoyi.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName LiveController
 * @date 2019/2/16 16:55
 **/
@Controller
@RequestMapping("/broad/live")
public class LiveController extends BaseController {
    private String prefix = "broad/live";

    @RequiresPermissions("broad:live:view")
    @GetMapping("/view")
    public String liveview()
    {
        return prefix + "/streamlive";
    }


}
