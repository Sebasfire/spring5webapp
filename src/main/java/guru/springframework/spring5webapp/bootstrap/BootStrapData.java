package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.Author;
import guru.springframework.spring5webapp.Book;
import guru.springframework.spring5webapp.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.Bookrepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final Bookrepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, Bookrepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Author steven = new Author("Stephen", "Erikson");
		Book gardens = new Book("Gardens of the Moon", "12345"); 
		Publisher penguin = new Publisher("Penguin", "Arctic street, 2014PR London");
		
		publisherRepository.save(penguin);
		
		steven.getBooks().add(gardens);
		gardens.getAuthors().add(steven);
		
		gardens.setPublisher(penguin);
		penguin.getBooks().add(gardens);
		
		authorRepository.save(steven);
		bookRepository.save(gardens);
		publisherRepository.save(penguin);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "5478635");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(penguin);
		penguin.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(penguin);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
		System.out.println("Publisher number of books: " + penguin.getBooks().size());
		
		
	}

}
