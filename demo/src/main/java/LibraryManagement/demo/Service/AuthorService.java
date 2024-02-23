package LibraryManagement.demo.Service;

import LibraryManagement.demo.Model.Author;
import LibraryManagement.demo.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import LibraryManagement.demo.Model.Book;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author){

        Author author1 = authorRepository.save(author);

        return  author1;
    }

    public List<Book> bookList(Integer authorId) throws Exception{

        // Aurhor exist or not

        Optional<Author> author = authorRepository.findById(authorId);

        if(author.isEmpty()) throw new Exception("exception");

        return author.get().getBookList();
    }

}
