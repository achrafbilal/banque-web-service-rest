package com.bilalachraf.webservicetp2.web;

import com.bilalachraf.webservicetp2.entities.BankAccount;
import com.bilalachraf.webservicetp2.repositories.BankAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bankAccounts")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("")
    public List<BankAccount> bankAccounts()
    {
        return bankAccountRepository.findAll();
    }

    @GetMapping("{id}")
    public BankAccount getAccount(@PathVariable String id)
    {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("")
    public BankAccount save(@RequestBody  BankAccount bankAccount)
    {
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("{id}")
    public BankAccount update(@RequestBody  BankAccount bankAccount,@PathVariable String id)
    {
        BankAccount account=getAccount(id);
        if(bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getDateCreated()!=null)account.setDateCreated(bankAccount.getDateCreated());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable  String id)
    {
         bankAccountRepository.deleteById(id);
    }

}
