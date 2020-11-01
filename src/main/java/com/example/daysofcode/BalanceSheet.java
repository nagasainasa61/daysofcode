package com.example.daysofcode;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String customer;

    private String recordType;
    private String purpose;
    private Integer value;

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getRecordType() {
        return recordType;
    }

    public Integer getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
