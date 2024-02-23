package LibraryManagement.demo.Controller;

import LibraryManagement.demo.Model.Book;
import LibraryManagement.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/author")
public class BookController{
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {

        return bookService.addBook(book);
    }

    @GetMapping("/assignAuthor")
    public String assignAuthor(@RequestParam("authorId") Integer authorId,
                               @RequestParam("bookId") Integer bookId) {
        return bookService.assignAuthor(bookId , authorId);
    }
}
