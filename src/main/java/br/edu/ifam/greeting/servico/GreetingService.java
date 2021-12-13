package br.edu.ifam.greeting.servico;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ifam.greeting.modelo.Greeting;

@Service
public class GreetingService {
	List<Greeting> greetings = new ArrayList<Greeting>();
	
	public Greeting obterGreetings(int indice) {
		return greetings.get(indice);
	}
	
	public List<Greeting> obterGreetings() {
		return greetings;
	}
	
	public Greeting criarGreeting(Greeting greeting) {
		greetings.add(greeting);
		int i = greetings.size()-1;
		greetings.get(i).setId(i);
		return greetings.get(i);
		
	}
	public Greeting atualizarGreeting(int id, Greeting greeting) {
		greeting.setId(id);
		greetings.set(id, greeting);
		return greetings.get(id);
	}

	public void excluirGreeting(int id) {
		greetings.remove(id);
	}
}
