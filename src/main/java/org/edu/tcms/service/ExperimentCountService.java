package org.edu.tcms.service;

import jakarta.annotation.Resource;
import org.edu.tcms.domain.ExperimentCount;
import org.edu.tcms.mapper.ExperimentCountMapper;
import org.edu.tcms.utls.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ExperimentCountService {
    @Resource
    private ExperimentCountMapper experimentCountMapper;

    private ExperimentCount createNew() {
        ExperimentCount newCount = new ExperimentCount();
        newCount.setId(UUIDUtil.getShortUUID());
        newCount.setViewCount(0);
        newCount.setOngoingCount(0);
        newCount.setFinishCount(0);
        experimentCountMapper.createNew(newCount);

        return newCount;
    }

    public ExperimentCount getDbExperimentCount() {
        List<ExperimentCount> experimentCountList = experimentCountMapper.queryAll();
        if (CollectionUtils.isEmpty(experimentCountList)) {
            return createNew();
        } else {
            return experimentCountList.get(0);
        }
    }

    public void updateViewCount() {
        ExperimentCount experimentCount = this.getDbExperimentCount();
        experimentCountMapper.updateViewCount(experimentCount.getId(), experimentCount.getViewCount() + 1);
    }

    public void updateOngoingCount() {
        ExperimentCount experimentCount = this.getDbExperimentCount();
        experimentCountMapper.updateOngoingCount(experimentCount.getId(), experimentCount.getOngoingCount() + 1);
    }

    public void updateFinishCount() {
        ExperimentCount experimentCount = this.getDbExperimentCount();
        experimentCountMapper.updateFinishCount(experimentCount.getId(), experimentCount.getFinishCount() + 1);
    }
}
