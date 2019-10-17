package com.example.spring.batch.mapper;

import com.example.spring.batch.model.Report;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReportFieldSetMapper implements FieldSetMapper<Report> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public Report mapFieldSet(FieldSet fieldSet) {

        Report report = new Report();
        report.setId(fieldSet.readInt(0));
        report.setFirstName(fieldSet.readString(1));
        report.setLastName(fieldSet.readString(2));
        String date = fieldSet.readString(3);
        try {
            report.setDob(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return report;
    }
}
