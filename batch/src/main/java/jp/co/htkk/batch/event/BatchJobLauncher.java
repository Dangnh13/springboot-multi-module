package jp.co.htkk.batch.event;

import jp.co.htkk.batch.constant.Constant;
import jp.co.htkk.batch.job.core.ClientRequest;
import jp.co.htkk.batch.job.core.Invoker;
import jp.co.htkk.batch.job.type.JobID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class BatchJobLauncher implements ApplicationRunner {

    @Value("${batch_id}")
    private String batchId;

    @Autowired
    private Invoker invoker;

    @Override
    public void run(ApplicationArguments args) {
        if (StringUtils.isEmpty(batchId)) {
            log.warn("BatchId must not null!");
        }
        ClientRequest clientRequest = null;
        try {
            clientRequest = new ClientRequest(args);
            clientRequest.setJobID(JobID.valueOf(batchId));
            log.info("--- Client request info: {}", clientRequest.toString());
        } catch (IllegalArgumentException ex) {
            log.warn(ex.getMessage());
            System.exit(Constant.EXIT_CODE.EXIT_ABNORMAL_ERROR);
        }

        invoker.invoke(clientRequest);
    }

}
