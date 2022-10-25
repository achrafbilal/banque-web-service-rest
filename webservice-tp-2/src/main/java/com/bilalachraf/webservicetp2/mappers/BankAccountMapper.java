package com.bilalachraf.webservicetp2.mappers;

import com.bilalachraf.webservicetp2.dto.requests.BankAccountDTORequest;
import com.bilalachraf.webservicetp2.dto.responses.BankAccountDTOResponse;
import com.bilalachraf.webservicetp2.entities.BankAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BankAccountMapper {
    private static  BankAccountMapper instance;

    public static BankAccountMapper getInstance() {
        if(instance==null)
            instance=new BankAccountMapper();
        return instance;
    }

    public BankAccount mapRequestToEntity(BankAccountDTORequest request)
    {
        return new BankAccount();
    }

    public BankAccountDTOResponse mapRequestToResponse(BankAccountDTORequest request)
    {
        return new BankAccountDTOResponse();
    }

    public BankAccountDTOResponse mapEntityToResponse(BankAccount bankAccount)
    {
        return new BankAccountDTOResponse();
    }

    public List<BankAccount> mapRequestsToEntities(List<BankAccountDTORequest> bankAccounts)
    {
        List<BankAccount> responses=new ArrayList<>();
        for (BankAccountDTORequest request : bankAccounts) {
            responses.add(instance.mapRequestToEntity(request));
        }
        return responses;
    }

    public List<BankAccountDTOResponse> mapRequestToResponse(List<BankAccountDTORequest> bankAccounts)
    {
        List<BankAccountDTOResponse> responses=new ArrayList<>();
        for (BankAccountDTORequest request : bankAccounts) {
            responses.add(instance.mapRequestToResponse(request));
        }
        return responses;
    }

    public List<BankAccountDTOResponse> mapEntitiesToResponses(List<BankAccount> bankAccounts)
    {
        List<BankAccountDTOResponse> responses=new ArrayList<>();
        for (BankAccount account : bankAccounts) {
            responses.add(instance.mapEntityToResponse(account));
        }
        return responses;
    }

}
