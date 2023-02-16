package elia.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import elia.Bookstore.domain.Book;
import elia.Bookstore.domain.BookRepository;
import elia.Bookstore.domain.Category;
import elia.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository catrepository) {
		return (args) -> {
			log.info("tallennetaan pari demo kirjaa");
			
			catrepository.save(new Category("Fantasy"));
			catrepository.save(new Category("Comedy"));
			catrepository.save(new Category("Horror"));
			catrepository.save(new Category("Gothic fiction"));

			bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "97800444", 22.99, catrepository.findByNameIgnoreCase("Fantasy").get(0)));
			bookRepository.save(new Book("Good Omens", "Neil Gaiman, Terry Pratchett", 1990, "978006085", 26.00, catrepository.findByNameIgnoreCase("Comedy").get(0)));
			bookRepository.save(new Book("Le Fantôme de l'Opéra", "Gaston Leroux", 1910, "978087905", 12.99, catrepository.findByNameIgnoreCase("Gothic Fiction").get(0)));
			
			/*log.info("get all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}*/

		};
	}

}
