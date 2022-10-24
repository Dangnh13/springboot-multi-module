package jp.co.htkk.batch.job;

import jp.co.htkk.batch.job.core.ClientRequest;
import jp.co.htkk.batch.dto.base.request.BaseRequest;
import jp.co.htkk.batch.dto.base.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DefaultAbstractJobRunner<T extends BaseRequest> implements JobRunner {

    private static final Logger logger = LoggerFactory.getLogger(DefaultAbstractJobRunner.class);

    protected BaseResponse result = null;

    public abstract Class<?> getClassType();

    public abstract T convertToRequest(ClientRequest request) throws Exception;

    public abstract boolean validate(T request);

    public abstract void perform(T request) throws Exception;

    @Override
    public void prepare() {
        result = new BaseResponse(getClassType());
    }

    @Override
    public final void execute(ClientRequest request) throws Exception {
        logger.info("run job {}", request.getJobID());
        try {
            T rqs = convertToRequest(request);
            if (!validate(rqs)) {
                throw new Exception("VALIDATE REQUEST ERROR!!!");
            }
            logger.info("VALIDATE REQUEST SUCCESS!!!");
            perform(rqs);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void onComplete() {
        result.finish(result.getResponse());
        logger.info("*** Complete : {}", result.toString());
    }

    @Override
    public void onError(Throwable throwable) {
        result.finish();
        logger.info(result.toString());
        logger.error("*** error " + getClass().getSimpleName(), throwable);
    }
}