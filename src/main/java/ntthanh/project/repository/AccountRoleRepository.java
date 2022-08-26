package ntthanh.project.repository;

import ntthanh.project.entity.Account;
import ntthanh.project.entity.AccountRole;
import ntthanh.project.entity.AccountRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRoleKey> {
    List<AccountRole> findAllByAccount(Account account);
}

