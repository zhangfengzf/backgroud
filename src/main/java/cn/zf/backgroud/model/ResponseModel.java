package cn.zf.backgroud.model;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * 〈主持人实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 17:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    private Object data;

    private String error;

    private String msg;

    private boolean success;


}
