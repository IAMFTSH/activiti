package learn.springboot.activiti.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 邝明山
 * @Date 2020/6/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday implements Serializable {
    private static final long serialVersionUID = 7481674840698275288L;
    private Integer id;
    /**
     * 申请人名字
     */
    private String holidayName;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Float num;
    private String reason;
    private String type;
}
