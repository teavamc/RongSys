package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Area;
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
 * 公共节目单
 *
 * @author 周博
 * @date 2019-03-20
 */
@Controller
@RequestMapping("/broad/pannel")
public class BroadPannelController extends BaseController {
    private String prefix = "broad/pannel";

    @Autowired
    private IBcountService bcountService;

    @GetMapping()
    public String pannel() {
        return prefix + "/bPannel";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<BroadCount> list = bcountService.select();
        return getDataTable(list);
    }
}
