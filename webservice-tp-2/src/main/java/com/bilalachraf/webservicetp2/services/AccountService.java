package com.bilalachraf.webservicetp2.services;

import com.bilalachraf.webservicetp2.DTORequest.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.DTOResponse.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO getAccount(String id);
    BankAccountResponseDTO addAccount(BankAccountDTORequest bankAccount);
    BankAccountResponseDTO editAccount(BankAccountDTORequest bankAccount);
    BankAccountResponseDTO deleteAccount(BankAccountDTORequest bankAccount);
}
