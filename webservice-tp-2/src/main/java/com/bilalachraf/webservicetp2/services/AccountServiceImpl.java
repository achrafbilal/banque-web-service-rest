package com.bilalachraf.webservicetp2.services;

import com.bilalachraf.webservicetp2.dto.requests.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.dto.responses.BankAccountDTOResponse;
import com.bilalachraf.webservicetp2.entities.BankAccount;
import com.bilalachraf.webservicetp2.repositories.BankAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountDTOResponse getAccount(String id) {
        Optional<BankAccount> bankAccountOptional=bankAccountRepository.findById(id);
        if(bankAccountOptional.isPresent())
        {
            BankAccount account=bankAccountOptional.get();
            BankAccountDTOResponse response=BankAccountDTOResponse.builder().
                id(account.getId()).
                balance(account.getBalance()).
                currency(account.getCurrency()).
                dateCreated(account.getDateCreated()).
                type(account.getType()).
                build();
            return response;
        }
        return null;
    }

    @Override
    public List<BankAccountDTOResponse> getAccounts() {
        List<BankAccountDTOResponse> response=new ArrayList<>();
        List<BankAccount> accounts=bankAccountRepository.findAll();
        for (BankAccount account:         accounts) {
            BankAccountDTOResponse accountResponse=BankAccountDTOResponse.builder().
                        id(account.getId()).
                        balance(account.getBalance()).
                        currency(account.getCurrency()).
                        dateCreated(account.getDateCreated()).
                        type(account.getType()).
                        build();
            response.add(accountResponse);
        }
        return response;
    }

    @Override
    public BankAccountDTOResponse addAccount(BankAccountDTORequest bankAccount) {
        BankAccount account=BankAccount.builder().
                id(UUID.randomUUID().toString()).
                dateCreated(new Date()).
                type(bankAccount.getType()).
                currency(bankAccount.getCurrency()).
                balance(bankAccount.getBalance()).
                build();
        BankAccount savedBankAccount=bankAccountRepository.save(account);
        BankAccountDTOResponse response=BankAccountDTOResponse.builder().
                id(savedBankAccount.getId()).
                balance(savedBankAccount.getBalance()).
                currency(savedBankAccount.getCurrency()).
                dateCreated(savedBankAccount.getDateCreated()).
                type(savedBankAccount.getType()).
                build();
        return response;
    }

    @Override
    public BankAccountDTOResponse editAccount(BankAccountDTORequest bankAccount,String id) {
        return null;
    }

    @Override
    public BankAccountDTOResponse deleteAccount(String id) {
        return null;
    }
}
