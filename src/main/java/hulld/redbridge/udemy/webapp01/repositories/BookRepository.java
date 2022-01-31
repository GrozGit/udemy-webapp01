package hulld.redbridge.udemy.webapp01.repositories;

import hulld.redbridge.udemy.webapp01.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
