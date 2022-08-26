package ntthanh.project.repository;

import ntthanh.project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    Account findByAccount(String userName);
    Account findAccountByCustomer_IdCustomer(String id);
}
