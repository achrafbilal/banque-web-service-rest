package com.bilalachraf.webservicetp2.web;

import com.bilalachraf.webservicetp2.dto.requests.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.dto.responses.BankAccountDTOResponse;
import com.bilalachraf.webservicetp2.mappers.BankAccountMapper;
import com.bilalachraf.webservicetp2.services.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/bankAccounts")
public class AccountRestController {
    private AccountService accountService;
    private BankAccountMapper bankAccountMapper=BankAccountMapper.getInstance();

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public List<BankAccountDTOResponse> bankAccounts()
    {
        return accountService.getAccounts();
    }

    @GetMapping("{id}")
    public BankAccountDTOResponse getAccount(@PathVariable String id)
    {
        return accountService.getAccount(id);
    }

    @PostMapping("")
    public BankAccountDTOResponse save(@RequestBody BankAccountDTORequest bankAccount)
    {
        return accountService.addAccount(bankAccount);
    }

    @PutMapping("{id}")
    public BankAccountDTOResponse update(@RequestBody  BankAccountDTORequest bankAccount,@PathVariable String id)
    {
        return accountService.editAccount(bankAccount,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable  String id)
    {
         accountService.deleteAccount(id);
    }

}
