package com.example.spring.batch.processor;

import com.example.spring.batch.model.Report;
import org.springframework.batch.item.ItemProcessor;

public class ReportItemProcessor implements ItemProcessor<Report, Report> {

    @Override
    public Report process(Report item) {
        System.out.println("########## Processing Record ########### " + item);
        String firstName = item.getFirstName();
        String lastName = item.getLastName();

        item.setFirstName(firstName.toUpperCase());
        item.setLastName(lastName.toUpperCase());
        return item;
    }
}