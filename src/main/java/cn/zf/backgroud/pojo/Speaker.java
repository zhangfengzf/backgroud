package cn.zf.backgroud.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;


/**
 * 类描述:
 * 〈演讲人实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 17:06
 */
@Data
@Component
public class Speaker {

    /**
     * 变量描述:
     * 〈演讲人id〉
     */
    private Integer id;
    /**
     * 变量描述:
     * 〈演讲人姓名〉
     */
    private String speakerName;
    /**
     * 变量描述:
     * 〈演讲人介绍〉
     */
    private String speakerIntroduce;
    /**
     * 变量描述:
     * 〈演讲人照片地址〉
     */
    private String photo;
    /**
     * 变量描述:
     * 〈演讲的主题〉
     */
    private String title;
    /**
     * 变量描述:
     * 〈是否删除了该演讲人〉
     */
    private String isDelete;
    /**
     * 变量描述:
     * 〈会议议程id〉
     */
    private Integer agendaId;
    /**
     * 变量描述:
     * 〈会议id〉
     */
    private Integer meetingId;


}
