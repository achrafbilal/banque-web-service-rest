package com.bilalachraf.webservicetp2.services;

import com.bilalachraf.webservicetp2.dto.requests.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.dto.responses.BankAccountDTOResponse;
import java.util.List;

public interface AccountService {
    BankAccountDTOResponse getAccount(String id);
    List<BankAccountDTOResponse> getAccounts();
    BankAccountDTOResponse addAccount(BankAccountDTORequest bankAccount);
    BankAccountDTOResponse editAccount(BankAccountDTORequest bankAccount,String id);
    BankAccountDTOResponse deleteAccount(String id);
}
