package org.edu.tcms.controller;

import jakarta.annotation.Resource;
import org.edu.tcms.domain.ExperimentCount;
import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.service.ExperimentCountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiment/count")
public class ExperimentCountController {
    @Resource
    private ExperimentCountService experimentCountService;

    @GetMapping("/all")
    public ResultResponse getAllCount() {
        ExperimentCount experimentCount = experimentCountService.getDbExperimentCount();
        return ResultResponse.success(experimentCount);
    }

    @PutMapping("/view")
    public ResultResponse updateViewCount() {
        experimentCountService.updateViewCount();
        return ResultResponse.success("update view count success.");
    }

    @PutMapping("/ongoing")
    public ResultResponse updateOngoingCount() {
        experimentCountService.updateOngoingCount();
        return ResultResponse.success("update ongoing count success.");
    }

    @PutMapping("/finish")
    public ResultResponse updateFinishCount() {
        experimentCountService.updateFinishCount();
        return ResultResponse.success("update finish count success.");
    }
}
