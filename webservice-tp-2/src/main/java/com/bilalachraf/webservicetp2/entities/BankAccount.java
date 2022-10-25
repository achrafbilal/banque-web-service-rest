package com.bilalachraf.webservicetp2.entities;

import com.bilalachraf.webservicetp2.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
/*@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)*/
public class BankAccount {
    @Id
    private String id;
    private Date dateCreated;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
