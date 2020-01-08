package cn.zf.backgroud.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 类描述:
 * 〈会议议程实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 17:06
 */
@Data
@Component
public class MeetingAgenda implements Serializable {

    /**
     * 变量描述:
     * 〈议程id〉
     */
    private Integer id;
    /**
     * 变量描述:
     * 〈议程类型〉
     */
    private String type;
    /**
     * 变量描述:
     * 〈议程开始时间〉
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String startTime;
    /**
     * 变量描述:
     * 〈议程结束时间〉
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String endTime;
    /**
     * 变量描述:
     * 〈该议程的状态〉
     */
    private String isDelete;
    /**
     * 变量描述:
     * 〈议程对应的会议id〉
     */
    private String meetingId;
    /**
     * 变量描述:
     * 〈演讲人〉
     */
    private Speaker speaker;

}
