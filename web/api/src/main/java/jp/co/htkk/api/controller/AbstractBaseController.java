package jp.co.htkk.api.controller;

import jp.co.htkk.dto.common.DXO;
import jp.co.htkk.dto.common.REQUEST;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

@Slf4j
public abstract class AbstractBaseController {

    protected <T extends REQUEST> T createRequest(T request, Class<T> classType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (request == null) {
            request = classType.getConstructor(null).newInstance(null);
        }
        return request;
    }

    protected <D extends DXO> Object bindingResultWithValidate(BindingResult result,
                                                               REQUEST request,
                                                               Function<D, ?> method)
            throws BindException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
        return method.apply(request.toDxo());
    }
}
