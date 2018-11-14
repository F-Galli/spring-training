package galli.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import galli.spring5webapp.model.Author;
import galli.spring5webapp.model.Book;
import galli.spring5webapp.model.Publisher;
import galli.spring5webapp.repositories.AuthorRepository;
import galli.spring5webapp.repositories.BookRepository;
import galli.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData()
	{
		// Eric
		Author eric = new Author("Eric", "Evans");
		Publisher harperCollins = new Publisher("Harper Collins");
		Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		publisherRepository.save(harperCollins);
		bookRepository.save(ddd);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx");
		Book noEJB = new Book("J2EE Develpment without EJB", "23444", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		publisherRepository.save(worx);
		bookRepository.save(noEJB);
	}

}
