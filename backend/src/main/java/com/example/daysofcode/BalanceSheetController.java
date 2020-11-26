package com.example.daysofcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/fin/")
public class BalanceSheetController {
    Integer totalExpense = 0;
    Integer totalIncome = 0;

    private BalanceSheetRepository balanceSheetRepository;

    @Autowired
    BalanceSheetController(BalanceSheetRepository balanceSheetRepository){
        this.balanceSheetRepository = balanceSheetRepository;
    }

    @RequestMapping(value="/{customer}", method= RequestMethod.GET)
    public String customerBalanceSheets(
            @PathVariable("customer") String customer, Model model) {
        List<BalanceSheet> incomeRecords = balanceSheetRepository.findByCustomerAndRecordType(customer, "Income");
        List<BalanceSheet> expenseRecords = balanceSheetRepository.findByCustomerAndRecordType(customer, "Expense");
        List<BalanceSheet> assetsRecords = balanceSheetRepository.findByCustomerAndRecordType(customer, "Assets");
        List<BalanceSheet> liabilitiesRecords = balanceSheetRepository.findByCustomerAndRecordType(customer, "Liabilities");

        ListIterator incomeRecordsIterator = incomeRecords.listIterator();

        totalIncome = 0;
        while(incomeRecordsIterator.hasNext()){
            totalIncome += ((BalanceSheet)incomeRecordsIterator.next()).getValue();
        }

        model.addAttribute("total_income", totalIncome);

        ListIterator expenseRecordsIterator = expenseRecords.listIterator();

        totalExpense = 0;
        while(expenseRecordsIterator.hasNext()){
            totalExpense += ((BalanceSheet)expenseRecordsIterator.next()).getValue();
        }

        model.addAttribute("total_expense", totalExpense);

        model.addAttribute("payday", totalIncome-totalExpense);

        if (incomeRecords != null) {
            model.addAttribute("income_records", incomeRecords);
        }
        if (expenseRecords != null) {
            model.addAttribute("expense_records", expenseRecords);
        }
        if (assetsRecords != null) {
            model.addAttribute("assets_records", assetsRecords);
        }
        if (liabilitiesRecords != null) {
            model.addAttribute("liabilities_records", liabilitiesRecords);
        }
        return "balanceSheetList";
    }

    @RequestMapping(value="/{customer}", method=RequestMethod.POST)
    public String addToBalanceSheetList(
            @PathVariable("customer") String customer, BalanceSheet balanceSheet) {
        balanceSheet.setCustomer(customer);
        balanceSheetRepository.save(balanceSheet);
        return "redirect:/{customer}";
    }
}
