package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.junit.jupiter.api.Test;

public class DateTest {

	 @Test
	 public void testaData() {
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     	
     	
		LocalDate	vencimento = LocalDate.parse("2019-10-15", formatter);
		LocalDate	pagamento = LocalDate.parse("2019-11-16", formatter);
			
		assertEquals(32, ChronoUnit.DAYS.between(vencimento, pagamento));		
	 }
}
