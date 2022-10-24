package jp.co.htkk.api.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jp.co.htkk.api.controller.AbstractBaseController;
import jp.co.htkk.business.service.admin.UserService;
import jp.co.htkk.dto.admin.user.request.UserRequest;
import jp.co.htkk.dto.admin.user.response.UserResponse;
import jp.co.htkk.dto.admin.user.rst.UserRst;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

/**
 * Dashboard APIs: Get user data by user id or phone number
 *
 * @author TuanDS
 * @version 1.0.
 */
@Tag(name = "UserController", description = "ユーザー検索・検索結果用API")
@RestController
@AllArgsConstructor
public class UserController extends AbstractBaseController {

    private final UserService userService;

    /**
     * Get user data by user id or phone number
     * @param request query data
     * @return user data search
     * @throws BindException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Operation(summary = "ユーザーID，電話番号でユーザー情報を取得")
    @GetMapping(value = "${endpoint.admin.user.userSearch}")
    public ResponseEntity<UserResponse> getMonthlyPoint(@Valid UserRequest request, BindingResult bindingResult) throws BindException, InvocationTargetException, IllegalAccessException, InstantiationException {
	    UserRst result = (UserRst) bindingResultWithValidate(bindingResult, request, userService::searchUser);
        return ResponseEntity.status(HttpStatus.OK).body(UserResponse.of(result));
    }

}
