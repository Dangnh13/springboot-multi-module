package jp.co.htkk.batch.job.concrete;

import jp.co.htkk.batch.dto.job0001.Job0001Request;
import jp.co.htkk.batch.job.DefaultAbstractJobRunner;
import jp.co.htkk.batch.job.core.ClientRequest;
import jp.co.htkk.batch.job.core.Job;
import jp.co.htkk.batch.job.type.JobID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Job(JobID.JOB0001)
@Data
@AllArgsConstructor
@Slf4j
public class Job0001 extends DefaultAbstractJobRunner<Job0001Request> {

    private static final String USERNAME_KEY = "username";

    @Override
    public Class<?> getClassType() {
        return this.getClass();
    }

    @Override
    public Job0001Request convertToRequest(ClientRequest request) throws Exception {
        String username = request.getMetaData().get(USERNAME_KEY).get(0);
        return Job0001Request.builder()
                .username(username)
                .build();
    }

    @Override
    public boolean validate(Job0001Request request) {
        if (StringUtils.isBlank(request.getUsername())) {
            log.warn("Username must be required");
            return false;
        }
        return true;
    }

    @Override
    public void perform(Job0001Request request) throws Exception {
        log.info("Inside perform Job0001");

//        log.info("step service call: {}", stepService.syncStep(request.getUsername()));
        String result = "Perform logic success";

        this.result.setResponse(result);
    }
}
