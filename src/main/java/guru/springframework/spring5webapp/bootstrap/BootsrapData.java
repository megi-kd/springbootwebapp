package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootsrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author megi = new Author("AuthorFirstName", "AuthorLastName");
        Book book = new Book("Book1", "isbn1");
        megi.getBooks().add(book);
        book.getAuthors().add(megi);

        authorRepository.save(megi);
        bookRepository.save(book);

        Author sss = new Author("AuthorFirstNameSecond", "AuthorLastNameSecond");
        Book book2 = new Book("Book2", "isbn2");
        megi.getBooks().add(book2);
        book.getAuthors().add(sss);

        authorRepository.save(sss);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());


    }
}
