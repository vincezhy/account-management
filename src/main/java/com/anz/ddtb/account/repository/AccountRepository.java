package com.anz.ddtb.account.repository;

import com.anz.ddtb.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.anz.ddtb.account.common.Constants.ACCOUNT_NUMBER;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    List<AccountEntity> findAll();

    @Transactional(isolation = Isolation.READ_COMMITTED)
    AccountEntity findByAccountNumber(@Param(value = ACCOUNT_NUMBER) String accountNumber);

}
