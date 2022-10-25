package com.bilalachraf.webservicetp2.repositories;

import com.bilalachraf.webservicetp2.entities.BankAccount;
import com.bilalachraf.webservicetp2.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path = "/byCurrency")
    List<BankAccount> findByCurrency(@Param("t") String currency);
}
