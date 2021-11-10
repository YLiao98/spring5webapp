package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Foo", "bar");
        Book newBook = new Book("testbook", "123456");

        newBook.getAuthors().add(author);
        author.getBooks().add(newBook);

        authorRepository.save(author);
        bookRepository.save(newBook);

        System.out.println("BOOTSTRAPREPO");
        System.out.println("Book count: "+ bookRepository.count());
    }
}
