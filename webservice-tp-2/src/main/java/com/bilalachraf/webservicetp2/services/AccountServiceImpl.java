package com.bilalachraf.webservicetp2.services;

import com.bilalachraf.webservicetp2.dto.requests.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.dto.responses.BankAccountDTOResponse;
import com.bilalachraf.webservicetp2.entities.BankAccount;
import com.bilalachraf.webservicetp2.mappers.AccountMapper;
import com.bilalachraf.webservicetp2.repositories.BankAccountRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
//@WebService(serviceName = "BanqueWs")
public class AccountServiceImpl implements AccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    AccountMapper accountMapper;

//    @WebMethod
    @Override
    public BankAccountDTOResponse getAccount(/*@WebParam(name = "id")*/String id) {
        Optional<BankAccount> bankAccountOptional=bankAccountRepository.findById(id);
        if(bankAccountOptional.isPresent())
        {
            BankAccount account=bankAccountOptional.get();
            return accountMapper.fromBankAccount(account);
        }
        return null;
    }
//    @WebMethod
    @Override
    public List<BankAccountDTOResponse> getAccounts() {
        List<BankAccount> accounts=bankAccountRepository.findAll();
        return accountMapper.fromBankAccount(accounts);
    }
//    @WebMethod
    @Override
    public BankAccountDTOResponse addAccount(/*@WebParam(name = "bankAccount")*/BankAccountDTORequest bankAccount) {
        BankAccount account=accountMapper.fromBankAccountRequest(bankAccount);
        account.setDateCreated(new Date());
        account.setId(UUID.randomUUID().toString());
        BankAccount savedBankAccount=bankAccountRepository.save(account);
        return accountMapper.fromBankAccount(savedBankAccount);
    }
//    @WebMethod
    @Override
    public BankAccountDTOResponse editAccount(/*@WebParam(name = "bankAccount")*/BankAccountDTORequest bankAccount,@WebParam(name = "id")String id) {
        Optional<BankAccount> bankAccountOptional=bankAccountRepository.findById(id);
        if(bankAccountOptional.isPresent())
        {
            BankAccount account=bankAccountOptional.get();
            if(bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
            if(bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
            if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
            BankAccount savedBankAccount=bankAccountRepository.save(account);
            return accountMapper.fromBankAccount(savedBankAccount);
        }
        return null;
    }
//    @WebMethod
    @Override
    public void deleteAccount(/*@WebParam(name = "id")*/String id) {
        bankAccountRepository.deleteById(id);

    }
}
