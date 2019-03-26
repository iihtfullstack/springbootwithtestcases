package com.sunil.springData.service;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements
    AttributeConverter<LocalDate, Date> {
    public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
        return java.sql.Date.valueOf(entityValue);
    }

    public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
        return databaseValue.toLocalDate();
    }

	
}
   
