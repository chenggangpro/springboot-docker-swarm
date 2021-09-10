package pro.chegngang.project.sample.springbootwebmvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: chenggang
 * @date 9/10/21.
 */
@Slf4j
@RestController
public class RequestController {

    @GetMapping("/request")
    public DataDetail request(){
        DataDetail dataDetail = new DataDetail();
        dataDetail.setSn(UUID.randomUUID().toString());
        dataDetail.setTime(LocalDateTime.now());
        dataDetail.setSymbol("WEB-MVC");
        log.info("DataInfo:{}",dataDetail);
        return dataDetail;
    }
}
