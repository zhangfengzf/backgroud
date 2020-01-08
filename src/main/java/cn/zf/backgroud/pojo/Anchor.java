package cn.zf.backgroud.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;


/**
 * 类描述:
 * 〈主持人实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 17:06
 */
@Data
@Component
public class Anchor {

    /**
     * 变量描述:
     * 〈主持人id〉
     */
    private Integer id;
    /**
     * 变量描述:
     * 〈主持人名字〉
     */
    private String anchorName;
    /**
     * 变量描述:
     * 〈主持人介绍〉
     */
    private String anchorIntroduce;
    /**
     * 变量描述:
     * 〈是否删除〉
     */
    private Integer isDelete;
    /**
     * 变量描述:
     * 〈对应的会议id〉
     */
    private Integer meetingId;

}
