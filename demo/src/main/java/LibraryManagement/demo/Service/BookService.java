package LibraryManagement.demo.Service;


import LibraryManagement.demo.Model.Author;
import LibraryManagement.demo.Model.Book;
import LibraryManagement.demo.Repository.AuthorRepository;
import LibraryManagement.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book addBook(Book book) {

        Book book1 = bookRepository.save(book);

        return book1;
    }

    public String assignAuthor(Integer bookId , Integer authorId) {

        // add Exceptions

        Book book = bookRepository.findById(bookId).get();

        Author author = authorRepository.findById(authorId).get();

        author.getBookList().add(book); // add in book lists

        book.setAuthor(author);

        authorRepository.save(author);

        return book.getBookName() + " is writtend by " + author.getName();
    }
}


