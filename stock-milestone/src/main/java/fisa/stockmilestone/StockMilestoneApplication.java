package fisa.stockmilestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockMilestoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMilestoneApplication.class, args);
	}

}
