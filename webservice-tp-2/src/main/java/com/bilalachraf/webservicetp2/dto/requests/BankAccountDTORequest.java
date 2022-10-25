package com.bilalachraf.webservicetp2.dto.requests;

import com.bilalachraf.webservicetp2.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountDTORequest {
    private Double balance;
    private String currency;
    private AccountType type;
}
