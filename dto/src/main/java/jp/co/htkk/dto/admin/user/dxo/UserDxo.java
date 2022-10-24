package jp.co.htkk.dto.admin.user.dxo;

import jp.co.htkk.dto.common.DXO;
import jp.co.htkk.dto.common.PRM;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;

@Data
public class UserDxo extends DXO {
    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }
}
