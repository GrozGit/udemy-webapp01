package hulld.redbridge.udemy.webapp01.repositories;

import hulld.redbridge.udemy.webapp01.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
