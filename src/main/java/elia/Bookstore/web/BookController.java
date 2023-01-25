package elia.Bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import elia.Bookstore.domain.Book;


@Controller
public class BookController {

	private ArrayList<Book> books = new ArrayList<>();

	@GetMapping(value = "/index")
	public String askBook(Model model) {
		model.addAttribute("booksList", books);
		model.addAttribute("index", new Book());
		return "books";
	}
	
	@PostMapping("/index")
	public String addBook(@ModelAttribute Book title) {
		books.add(title);
		return "redirect:/index";
	}
	
}