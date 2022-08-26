package ntthanh.project.service;

import ntthanh.project.dto.AccountResponse;
import ntthanh.project.dto.ChangePasswordForm;

public interface LoginService {
    AccountResponse doLogin(String userName, String password);
    boolean doChangePassword(ChangePasswordForm form);
}
