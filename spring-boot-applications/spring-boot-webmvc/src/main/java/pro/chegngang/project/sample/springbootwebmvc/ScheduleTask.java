package pro.chegngang.project.sample.springbootwebmvc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: chenggang
 * @date 9/10/21.
 */
@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class ScheduleTask {

    private final RequestController requestController;

    @Scheduled(fixedRateString = "PT5S")
    public void schedule(){
        DataDetail dataDetail = requestController.request();
        log.info("Log From Schedule -> {}", dataDetail);
    }
}
