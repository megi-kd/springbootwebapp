package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("Publusher1", "Address", "city", "state", "zipcode");
        publisherRepository.save(publisher);

        Author megi = new Author("AuthorFirstName", "AuthorLastName");
        Book book = new Book("Book1", "isbn1");
        megi.getBooks().add(book);
        book.getAuthors().add(megi);
        publisher.getBooks().add(book);

        authorRepository.save(megi);
        bookRepository.save(book);

        Author sss = new Author("AuthorFirstNameSecond", "AuthorLastNameSecond");
        Book book2 = new Book("Book2", "isbn2");
        megi.getBooks().add(book2);
        book2.getAuthors().add(sss);
        publisher.getBooks().add(book2);

        authorRepository.save(sss);
        bookRepository.save(book2);
        publisherRepository.save(publisher);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println(("Number of publishers: "+ publisherRepository.count()));
        System.out.println(("Publisher books count: "+ publisher.getBooks().size()));



    }
}
