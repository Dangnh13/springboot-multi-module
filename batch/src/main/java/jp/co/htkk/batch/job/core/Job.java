package jp.co.htkk.batch.job.core;

import jp.co.htkk.batch.job.type.JobID;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Job {
	JobID value();
}
