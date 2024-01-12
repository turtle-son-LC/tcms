package org.edu.tcms.domain;

import lombok.Data;

@Data
public class ExperimentDetailResponse {
    private String summary;
    private String outline;
    private String objective;
    private String description;
}
