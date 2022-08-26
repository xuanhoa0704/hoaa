package ntthanh.project.service;

import ntthanh.project.dto.DtoCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ntthanh.project.entity.Account;
import ntthanh.project.entity.Customers;

import java.util.List;


public interface CustomerService {
    Page<Customers> finAll(Pageable pageable);
    Customers findById(String id);
    Customers findCustomerByAccount(String account);
    void saveCustomer(DtoCustomer customers);
    void updateCustomer(DtoCustomer customers);
    void delete(String id);
    Page<Customers> searchCustomer(String name, Pageable pageable);
    List<Account> finAllAccount();
    Account getAccountByIdCustomer(String id);
}
