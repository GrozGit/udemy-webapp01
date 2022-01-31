package hulld.redbridge.udemy.webapp01.bootstrap;

import hulld.redbridge.udemy.webapp01.model.Author;
import hulld.redbridge.udemy.webapp01.model.Book;
import hulld.redbridge.udemy.webapp01.model.Publisher;
import hulld.redbridge.udemy.webapp01.repositories.AuthorRepository;
import hulld.redbridge.udemy.webapp01.repositories.BookRepository;
import hulld.redbridge.udemy.webapp01.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher oxfordPress = new Publisher("OxfordPress", "1 Hash Drive", "Blackburn", "Lancashire", "BL1 1AA");
        publisherRepository.save(oxfordPress);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(oxfordPress);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "789012");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(oxfordPress);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        oxfordPress.getBooks().add(ddd);
        oxfordPress.getBooks().add(noEJB);
        publisherRepository.save(oxfordPress);

        System.out.println("Started in BootstrapData");
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
        System.out.println("Publisher books: " + oxfordPress.getBooks().size());

    }
}
