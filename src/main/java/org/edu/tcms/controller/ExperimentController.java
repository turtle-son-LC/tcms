package org.edu.tcms.controller;

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

import javax.annotation.Resource;


@RestController
@RequestMapping("/tcms/experiment")
public class ExperimentController {
    @Resource
    private ExperimentService experimentService;
    @Resource
    private ExperimentCountService experimentCountService;

    @GetMapping("/online")
    public ResultResponse getOnlineExperiment() {
        System.out.println("getOnlineExperiment");
        ExperimentOnlineResponse onlineResponse = experimentService.getOnlineExperiment();
        return ResultResponse.success(onlineResponse);
    }

    @GetMapping("/detail")
    public ResultResponse getExperimentDetail() {
        System.out.println("getExperimentDetail");
        ExperimentDetailResponse detailResponse = experimentService.getExperimentDetail();
        return ResultResponse.success(detailResponse);
    }

    @GetMapping("/count/all")
    public ResultResponse getAllCount() {
        System.out.println("getAllCount");
        ExperimentCount experimentCount = experimentCountService.getDbExperimentCount();
        return ResultResponse.success(experimentCount);
    }

    @PutMapping("/count/view")
    public ResultResponse updateViewCount() {
        System.out.println("updateViewCount");
        experimentCountService.updateViewCount();
        return ResultResponse.success("update view count success.");
    }

    @PutMapping("/count/ongoing")
    public ResultResponse updateOngoingCount() {
        System.out.println("updateOngoingCount");
        experimentCountService.updateOngoingCount();
        return ResultResponse.success("update ongoing count success.");
    }

    @PutMapping("/count/finish")
    public ResultResponse updateFinishCount() {
        System.out.println("updateFinishCount");
        experimentCountService.updateFinishCount();
        return ResultResponse.success("update finish count success.");
    }
}
