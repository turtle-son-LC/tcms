package org.edu.tcms.controller;

import jakarta.annotation.Resource;
import org.edu.tcms.domain.ExperimentCount;
import org.edu.tcms.domain.ExperimentOnlineResponse;
import org.edu.tcms.domain.ExperimentDetailResponse;
import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.service.ExperimentCountService;
import org.edu.tcms.service.ExperimentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiment")
public class ExperimentController {
    @Resource
    private ExperimentService experimentService;
    @Resource
    private ExperimentCountService experimentCountService;

    @GetMapping("/online")
    public ResultResponse getOnlineExperiment() {
        ExperimentOnlineResponse onlineResponse = experimentService.getOnlineExperiment();
        return ResultResponse.success(onlineResponse);
    }

    @GetMapping("/detail")
    public ResultResponse getExperimentDetail() {
        ExperimentDetailResponse detailResponse = experimentService.getExperimentDetail();
        return ResultResponse.success(detailResponse);
    }

    @GetMapping("/count/all")
    public ResultResponse getAllCount() {
        ExperimentCount experimentCount = experimentCountService.getDbExperimentCount();
        return ResultResponse.success(experimentCount);
    }

    @PutMapping("/count/view")
    public ResultResponse updateViewCount() {
        experimentCountService.updateViewCount();
        return ResultResponse.success("update view count success.");
    }

    @PutMapping("/count/ongoing")
    public ResultResponse updateOngoingCount() {
        experimentCountService.updateOngoingCount();
        return ResultResponse.success("update ongoing count success.");
    }

    @PutMapping("/count/finish")
    public ResultResponse updateFinishCount() {
        experimentCountService.updateFinishCount();
        return ResultResponse.success("update finish count success.");
    }
}
