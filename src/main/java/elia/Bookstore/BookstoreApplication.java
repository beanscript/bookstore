package elia.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import elia.Bookstore.domain.Book;
import elia.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		log.info("tallennetaan pari kirjaa");
		
		Book kirja1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 97800444, 22.99);
		Book kirja2 = new Book("Good Omens", "Neil Gaiman, Terry Pratchett", 1990, 978006085, 26.00);
		Book kirja3 = new Book("Le Fantôme de l'Opéra", "Gaston Leroux", 1910, 978087905, 12.99);
		repository.save(kirja1);
		repository.save(kirja2);
		repository.save(kirja3);

	};
	}

}
