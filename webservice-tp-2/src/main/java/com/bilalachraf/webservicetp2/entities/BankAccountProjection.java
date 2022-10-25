package com.bilalachraf.webservicetp2.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = BankAccount.class,name ="p1")
public interface BankAccountProjection {
    public String getId();
    public Date getDateCreated();
}

