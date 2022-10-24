package jp.co.htkk.business.service.impl.admin;

import jp.co.htkk.business.service.AbstractBaseService;
import jp.co.htkk.business.service.admin.UserService;
import jp.co.htkk.dto.admin.user.dxo.UserDxo;
import jp.co.htkk.dto.admin.user.rst.UserRst;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Override
    public UserRst searchUser(UserDxo dxo) {
        return null;
    }
}
