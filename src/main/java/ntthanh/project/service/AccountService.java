package ntthanh.project.service;

import ntthanh.project.dto.DtoAccount;
import ntthanh.project.entity.Account;

public interface AccountService {
    Account findById(String userName);
    void save(Account account);
    void changePassWord(DtoAccount account);
}
