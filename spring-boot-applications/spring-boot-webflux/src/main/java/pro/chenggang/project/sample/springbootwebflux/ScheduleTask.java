package pro.chenggang.project.sample.springbootwebflux;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Objects;

/**
 * @author: chenggang
 * @date 9/10/21.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduleTask implements InitializingBean, DisposableBean {

    private final WebClient webClient = WebClient.builder().baseUrl("http://127.0.0.1:10001/request").build();
    private final Scheduler scheduler = Schedulers.newParallel("schedule-task");
    private Disposable disposable;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Init Task] Init Flux subscription");
        disposable = Flux.interval(Duration.ofSeconds(5))
                .publishOn(scheduler)
                .flatMap(value -> webClient.get()
                        .retrieve()
                        .bodyToMono(DataDetail.class)
                )
                .doOnNext(dataDetail -> {
                    log.info("Log From Schedule -> {}", dataDetail);
                })
                .subscribe();
    }

    @Override
    public void destroy() throws Exception {
        if(Objects.nonNull(disposable) && !disposable.isDisposed()){
            log.info("[Destroy Task] Destroy Flux subscription");
            disposable.dispose();
        }
    }
}
