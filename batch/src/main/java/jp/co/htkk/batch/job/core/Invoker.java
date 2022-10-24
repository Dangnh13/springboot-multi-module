package jp.co.htkk.batch.job.core;

import jp.co.htkk.batch.constant.Constant;
import jp.co.htkk.batch.job.JobRunner;
import jp.co.htkk.batch.job.type.JobID;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class Invoker implements BeanPostProcessor {

    protected ConcurrentMap<JobID, JobRunner> channels = new ConcurrentHashMap<>();

    private ApplicationContext context;

    public Invoker(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean.getClass().isAnnotationPresent(Job.class) && (bean instanceof JobRunner)) {
            JobID id = bean.getClass().getAnnotation(Job.class).value();
            channels.put(id, (JobRunner) bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    public void invoke(ClientRequest clientRequest) {
        JobRunner runner = channels.get(clientRequest.getJobID());
        int exitCode = Constant.EXIT_CODE.EXIT_NORMAL;

        try {
            runner.prepare();
            runner.execute(clientRequest);
            runner.onComplete();

        } catch (Exception e) {
            exitCode = Constant.EXIT_CODE.EXIT_ABNORMAL_ERROR;
            runner.onError(e);

        } finally {
            SpringApplication.exit(context);
            System.exit(exitCode);
        }
    }

}
