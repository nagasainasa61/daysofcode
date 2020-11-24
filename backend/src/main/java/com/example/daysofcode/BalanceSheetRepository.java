package com.example.daysofcode;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {
    List<BalanceSheet> findByCustomer(String customer);
    List<BalanceSheet> findByCustomerAndRecordType(String customer, String recordType);
}
