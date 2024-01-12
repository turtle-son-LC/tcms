package org.edu.tcms.service;

import org.edu.tcms.domain.ExperimentOnlineResponse;
import org.edu.tcms.domain.ExperimentDetailResponse;
import org.springframework.stereotype.Service;

@Service
public class ExperimentService {
    String summary = "本实验教学项目内容的选择针对现在病理剖检诊断课的问题和不足。在现有的教学模式中，单胃动物如兔，小鼠应用较多，北京宠物临床行业发达，学生有较多的机会接触到犬猫疾病，反而是反刍动物因动物形体大，价格昂贵，对剖检硬件要求高等因素，近年来在动物病理剖检课程中几乎没有使用，该项目选择奶牛作为实验动物，正是弥补该课程在反刍动物方面的欠缺。疾病模型方面上，我们选择了一例疑似淋巴白血病病例，这是临床病理的真实病例，牛淋巴白血病是一类严重危害养牛业的疾病，本实验的目的为排查是否是白血病，而且病理剖检诊断结果与临床诊断结果并不一致，非常具有代表性。在评价体系方面，该项目将评价体系嵌入到课程软件程序之中，在学生运用该程序的同时会面对十项选择题目，每个题目分值五分，合计五十分，通过正确的选择才可以顺利进入下一步环节，而最后提交的病理报告分值是50分，分别从报告撰写、病例分析、病变描述和结论分析方面进行评价。";

    public ExperimentOnlineResponse getOnlineExperiment() {
        ExperimentOnlineResponse onlineResponse = new ExperimentOnlineResponse();
        onlineResponse.setPicUrl("picUrl");
        onlineResponse.setName("奶牛结核病虚拟剖检诊断实验");
        onlineResponse.setOfficeName("动物医学院");
        onlineResponse.setTeacherName("刘天龙");
        onlineResponse.setSummary(summary);

        return onlineResponse;
    }

    public ExperimentDetailResponse getExperimentDetail() {
        ExperimentDetailResponse detailResponse = new ExperimentDetailResponse();
        detailResponse.setSummary(summary);
        detailResponse.setOutline("1，病史及临床表现：动物消瘦，精神沉郁，淋巴结肿大，产奶中止，已淘汰 2，反刍动物剖检步骤 反刍动物剖检体位选择左侧卧，乳腺环切，消化道结扎方法 3，组织取材注意事项 材料新鲜，组织块力求小而薄，勿使组织块受挤压，尽量保持组织的原有形态，熟悉取材部位，选好组织块的切面，保持材料的清洁，切除不需要的部位，核对存放。 4，细菌病毒材料取材方法 采集细菌学检查用的病料,要求无菌操作,以避免污染。使用");
        detailResponse.setObjective("1. 掌握反刍动物的剖检步骤 2. 掌握反刍动物剖检肠道结扎方法 3. 掌握牛分枝杆菌和动物组织取材染色鉴别方法 4. 掌握病变识别及描述方法 5. 掌握病理报告的撰写方法 6. 确诊病例是否为奶牛结核病。");
        detailResponse.setDescription("");
        return detailResponse;
    }
}
