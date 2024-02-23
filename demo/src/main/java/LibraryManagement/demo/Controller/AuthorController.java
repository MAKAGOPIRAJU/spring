package LibraryManagement.demo.Controller;

import LibraryManagement.demo.Model.Author;
import LibraryManagement.demo.Model.Book;
import LibraryManagement.demo.Model.Student;
import LibraryManagement.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/createAuthor")
    public Author addAuthor(@RequestBody Author author) {

        return authorService.addAuthor(author);
    }

    @GetMapping("/allBooks")
    public List<Book> bookList(@RequestParam("authorId") Integer authorId) throws Exception{

        try {
            List<Book> list = authorService.bookList(authorId);

            return  list;
        }
       catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
       }
    }


}
