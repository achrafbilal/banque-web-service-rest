package com.bilalachraf.webservicetp2.mappers;

import com.bilalachraf.webservicetp2.dto.requests.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.dto.responses.BankAccountDTOResponse;
import com.bilalachraf.webservicetp2.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {
    public BankAccountDTOResponse fromBankAccount(BankAccount bankAccount)
    {
        BankAccountDTOResponse response=new BankAccountDTOResponse();
        BeanUtils.copyProperties(bankAccount,response);
        return response;
    }
    public List<BankAccountDTOResponse> fromBankAccount(List<BankAccount> bankAccounts)
    {
        return bankAccounts.stream().map(this::fromBankAccount).toList();
    }

    public BankAccount fromBankAccountRequest(BankAccountDTORequest bankAccountDTORequest)
    {
        BankAccount bankAccount=new BankAccount();
        BeanUtils.copyProperties(bankAccountDTORequest,bankAccount);
        return bankAccount;
    }
}
