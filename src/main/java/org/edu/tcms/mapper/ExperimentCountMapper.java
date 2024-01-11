package org.edu.tcms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.edu.tcms.domain.ExperimentCount;

import java.util.List;

@Mapper
public interface ExperimentCountMapper {
    List<ExperimentCount> queryAll();

    void createNew(ExperimentCount experimentCount);

    void updateViewCount(String id, Integer viewCount);

    void updateOngoingCount(String id, Integer ongoingCount);

    void updateFinishCount(String id, Integer finishCount);
}
