package com.sunil.springData.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { LocalDatePersistenceConverter.class })
public class LocalDatePersistenceConverterTest {

	@Autowired
	LocalDatePersistenceConverter localDatePersistenceConverter;

	@Test
	public void TestConvertToDatabaseColumn_whenLocalDate_ThenReturnSqlValueOfLocalDate() {
		assertThat(localDatePersistenceConverter.convertToDatabaseColumn(LocalDate.of(2014, Month.JANUARY, 1)),
				is(java.sql.Date.valueOf(LocalDate.of(2014, Month.JANUARY, 1))));
		System.out.println(java.sql.Date.valueOf(LocalDate.of(2014, Month.JANUARY, 1)));
	}

	@Test
	public void TestConvertToEntityAttribute_whenDatabaseValue_ThenReturnLocalDate() {
		assertThat(localDatePersistenceConverter.convertToEntityAttribute(java.sql.Date.valueOf("2014-01-01")),
				is(LocalDate.of(2014, Month.JANUARY, 1)));

	}

}
