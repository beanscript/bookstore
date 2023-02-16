package elia.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import elia.Bookstore.domain.Book;
import elia.Bookstore.domain.BookRepository;
import elia.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	private CategoryRepository catrepository;

	// kirjojen listaus
	@RequestMapping(value = { "/", "/booklist" })
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	// kirjojen lisääminen listaan
	@RequestMapping(value = "/addBook")
	public String add(Model model) {
		model.addAttribute("newBook", new Book());
		model.addAttribute("categories", catrepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}

	// kirjojen poistaminen
	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	// kirjojen muokkaaminen
	@RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("editBook", bookRepository.findById(bookId));
		model.addAttribute("categories", catrepository.findAll());
		return "editBook";
	}
	
	// alla "kysy kirja ja lisää listaan" tehtävän toiminnalisuudet /index -endpointiin
	/*
	private ArrayList<Book> books = new ArrayList<>();

	@GetMapping(value = "/index")
	public String kysyKirja(Model model) {
		model.addAttribute("booksList", books);
		model.addAttribute("index", new Book());
		return "books";
	}

	@PostMapping("/index")
	public String lisaaKirja(@ModelAttribute Book title) {
		books.add(title);
		return "redirect:/index";
	}*/

}