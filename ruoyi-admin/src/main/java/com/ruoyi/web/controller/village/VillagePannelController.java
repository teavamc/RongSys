package com.ruoyi.web.controller.village;

import com.ruoyi.broad.domain.BroadCount;
import com.ruoyi.broad.service.IBcountService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName VillagePannelController
 * @date 2019/3/27 15:49
 **/
@Controller
@RequestMapping("/village/pannel")
public class VillagePannelController  extends BaseController{
    private String prefix = "village/pannel";

    @GetMapping()
    public String pannel() {
        return prefix + "/pannel";
    }
}

