package ntthanh.project.service.impl;

import ntthanh.project.dto.DtoAccount;
import ntthanh.project.entity.Account;
import ntthanh.project.entity.Customers;
import ntthanh.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ntthanh.project.repository.AccountRepository;
import ntthanh.project.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Account findById(String userName) {
        return this.accountRepository.findById(userName).orElse(null);
    }

    @Override
    public void save(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public void changePassWord(DtoAccount dto) {
        Customers customers = this.customerRepository.getById(dto.getCustomerId());
        Account account1 = this.accountRepository.getById(dto.getAccount());
        account1.setAccount(dto.getAccount());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(dto.getPassword());
        account1.setPassword(pass);
        account1.setDateCreate(dto.getDateCreate());
        account1.setCustomer(customers);
        this.accountRepository.save(account1);

    }
}
