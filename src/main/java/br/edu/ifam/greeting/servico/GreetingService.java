package br.edu.ifam.greeting.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifam.greeting.modelo.Greeting;
import br.edu.ifam.greeting.repository.GreetingRepository;

@Service
public class GreetingService {
	List<Greeting> greetings = new ArrayList<Greeting>();
	
	@Autowired
	GreetingRepository greetingRepository;
	
	public Optional<Greeting> obterGreetings(long id) {
		return greetingRepository.findById(id);
	}
	
	public List<Greeting> obterGreetings() {
		return greetingRepository.findAll();
	}
	
	public List<Greeting> obterGreetings(String content) {
		return greetingRepository.findByContent(content);
	}
	
	
	
	public Greeting criarGreeting(Greeting greeting) {
		return greetingRepository.save(greeting);
		
	}
	public Greeting atualizarGreeting(long id, Greeting greeting) {
		greeting.setId(id);
		return greetingRepository.save(greeting);
	}

	public void excluirGreeting(long id) {
		greetingRepository.deleteById(id);
	}
}
