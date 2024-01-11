package org.edu.tcms.domain;

import lombok.Data;

@Data
public class ExperimentCount {
    private String id;
    private Integer viewCount;
    private Integer ongoingCount;
    private Integer finishCount;
}
