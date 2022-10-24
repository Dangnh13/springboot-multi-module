package jp.co.htkk.business.service.admin;

import jp.co.htkk.dto.admin.user.dxo.UserDxo;
import jp.co.htkk.dto.admin.user.rst.UserRst;

public interface UserService {

	UserRst searchUser(UserDxo dxo);
}
