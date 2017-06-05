


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		LocalDate start = LocalDate.now();
		Period period = Period.of(0, 1, 2);
		LocalDate end = start.plus(period);
		Period p = Period.ofDays(12);    
		Temporal l = p.addTo(LocalDate.now());
		System.out.println(l);

	}

}
