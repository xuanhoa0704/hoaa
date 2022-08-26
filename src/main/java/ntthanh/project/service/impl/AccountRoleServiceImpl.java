package ntthanh.project.service.impl;

import ntthanh.project.entity.AccountRole;
import ntthanh.project.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntthanh.project.repository.AccountRoleRepository;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Override
    public void save(AccountRole accountRole) {
     this.accountRoleRepository.save(accountRole);
    }
}
