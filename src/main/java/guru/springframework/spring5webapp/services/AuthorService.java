package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAllAuthros() {
        return authorRepository.findAll();
    }
}
