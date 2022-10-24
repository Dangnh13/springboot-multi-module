package jp.co.htkk.batch.job;

import jp.co.htkk.batch.job.core.ClientRequest;

public interface JobRunner {
    default void prepare() {
    }

    void execute(ClientRequest request) throws Exception;

    default void onComplete() {
    }

    default void onError(Throwable throwable) {
    }
}
