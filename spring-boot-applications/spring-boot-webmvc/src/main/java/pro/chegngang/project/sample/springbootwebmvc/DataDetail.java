package pro.chegngang.project.sample.springbootwebmvc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author: chenggang
 * @date 9/10/21.
 */
@Getter
@Setter
@ToString
public class DataDetail {

    private String symbol;
    private String sn;
    private LocalDateTime time;
}
