package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.Book;

public interface Bookrepository extends CrudRepository<Book, Long> {

}
 