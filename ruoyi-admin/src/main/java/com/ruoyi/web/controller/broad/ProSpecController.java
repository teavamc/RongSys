package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.ProSpec;
import com.ruoyi.broad.service.IProSpecService;
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
 * 特种节目管理
 *
 * @author 周博
 * @date 2019-03-27
 */

@Controller
@RequestMapping("/broad/spec")
public class ProSpecController extends BaseController {
    private String prefix = "broad/spec";

    @Autowired
    private IProSpecService proSpecService;

    @GetMapping()
    public String spec()
    {
        return prefix + "/spec";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProSpec proSpec)
    {
        startPage();
        List<ProSpec> list = proSpecService.selectProSpecList(proSpec);
        return getDataTable(list);
    }
}
