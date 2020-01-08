package cn.zf.backgroud.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述:
 * 〈会议实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 17:06
 */
@Data
@Component
public class Meeting implements Serializable {

    /**
     * 变量描述:
     * 〈会议id〉
     */
    private Integer id;
    /**
     * 变量描述:
     * 〈会议类型〉
     */
    private String  meetingType;
    /**
     * 变量描述:
     * 〈会议名字〉
     */
    private String  meetingName;
    /**
     * 变量描述:
     * 〈会议地点〉
     */
    private String  address;
    /**
     * 变量描述:
     * 〈会议规模〉
     */
    private String  meetingScale;
    /**
     * 变量描述:
     * 〈会议海报〉
     */
    private String  meetingBill;
    /**
     * 变量描述:
     * 〈会议简介〉
     */
    private String  meetingContext;
    /**
     * 变量描述:
     * 〈会议开始时间〉
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String startTime;
    /**
     * 变量描述:
     * 〈会议结束时间〉
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String endTime;
    /**
     * 变量描述:
     * 〈该会议是否被删除〉
     */
    private String isDelete;
    /**
     * 变量描述:
     * 〈会议的开启状态〉
     */
    private String state;
    /**
     * 变量描述:
     * 〈主会议id〉
     */
    private int  mainId;
    /**
     * 变量描述:
     * 〈添加该会议的用户〉
     */
    private User user;
    /**
     * 变量描述:
     * 〈会议议程〉
     */
    private List<MeetingAgenda> meetingAgenda;
    /**
     * 变量描述:
     * 〈主持人〉
     */
    private List<Anchor> anchors;
    /**
     * 变量描述:
     * 〈分会议〉
     */
    private List<Meeting> children;

}
