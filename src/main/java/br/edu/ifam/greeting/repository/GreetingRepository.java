package br.edu.ifam.greeting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifam.greeting.modelo.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
	List<Greeting> findByContent(String content);
}
