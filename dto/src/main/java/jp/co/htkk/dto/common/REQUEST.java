package jp.co.htkk.dto.common;

import java.lang.reflect.InvocationTargetException;

public abstract class REQUEST {

    public abstract <T extends DXO> T toDxo() throws IllegalAccessException, InstantiationException, InvocationTargetException;

}
