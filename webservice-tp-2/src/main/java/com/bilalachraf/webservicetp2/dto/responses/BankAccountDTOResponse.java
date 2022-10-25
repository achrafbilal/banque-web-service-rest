package com.bilalachraf.webservicetp2.dto.responses;

import com.bilalachraf.webservicetp2.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountDTOResponse {
    private String id;
    private Date dateCreated;
    private Double balance;
    private String currency;
    private AccountType type;
}
