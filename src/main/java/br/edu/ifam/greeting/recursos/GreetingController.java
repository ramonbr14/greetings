package br.edu.ifam.greeting.recursos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifam.greeting.modelo.Greeting;
import br.edu.ifam.greeting.servico.GreetingService;

@RestController 
@RequestMapping(value="greeting")
public class GreetingController {
   
	//private Greeting greeting; -> linha não é necessaria 1:54
	@Autowired
	GreetingService greetingService;
	
	@GetMapping
	public ResponseEntity<List<Greeting>> getGreeting(){
		return ResponseEntity.ok(greetingService.obterGreetings());
	}
	
	@GetMapping("/busca")
	public ResponseEntity<List<Greeting>> getGreetingByContent(String content){
		return ResponseEntity.ok(greetingService.obterGreetings());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Greeting> getGreeting(@PathVariable("id") long id){
		Optional<Greeting> optionalGreeting = greetingService.obterGreetings(id);
		if(optionalGreeting.isPresent())
			return ResponseEntity.ok(optionalGreeting.get());
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<Greeting> postGreeting(@RequestBody Greeting greeting){
		Greeting g = greetingService.criarGreeting(greeting);
		return ResponseEntity.status(HttpStatus.CREATED).body(g);
	}
	
	@PutMapping
	@RequestMapping(value="/{id}")
	public ResponseEntity<Greeting> putGreeting(@RequestBody Greeting greeting,
			@PathVariable("id") int id){
		return ResponseEntity.ok(greetingService.atualizarGreeting(id, greeting));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteGreeting(@PathVariable("id") int id){
		greetingService.excluirGreeting(id);
		return ResponseEntity.noContent().build();
	}
	     
	
	
	/* Codigo ate 1:57 da aula 4
	@GetMapping
	public ResponseEntity<Greeting> getGreeting(){
		if(greeting == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(this.greeting);
	}
	@PostMapping
	public ResponseEntity<Greeting> postGreeting(@RequestBody Greeting greeting){
		this.greeting =  greeting;
		return ResponseEntity.status(HttpStatus.CREATED).body(this.greeting);
	}
	
	/* AULA 04 1:15:20
	@GetMapping
	public ResponseEntity<Greeting> boringGreting(@RequestParam(value="name", defaultValue="") String name){
		if(name.isEmpty())
			return ResponseEntity.badRequest().build();
   		String alunos = "Elsa Anna Rapunzel Jasmim Pocahontas Ariel Bela";
		if(alunos.contains(name))
				return ResponseEntity.status(HttpStatus.OK).body(new Greeting(0,"Hello, "+ name));
			//return ResponseEntity.ok(new Greeting(0,"Hello, "+ name)); //200 esta okay
		//return ResponseEntity.notFound().build();// 404 Not Found
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   	}
	
	public ResponseEntity<Greeting> postGreeting(@RequestBody Greeting greeting){
		this.greeting =  greeting;
		return ResponseEntity.status(HttpStatus.CREATED).body(this.greeting);
	} 
	 
		
	Resposta OK
	public ResponseEntity<Greeting> getGreeting(@RequestParam(value="name",
			defaultValue = "Aluno do IFAM!") String name){
		Greeting greeting =  new Greeting(0,"Hello, "+ name);
		return ResponseEntity.ok(greeting);
	}*/
		
	
	
	/* CODIGO FEITO ATE A AULA 04
	 * public Greeting greeting(@RequestParam(value="name",
	 *
			defaultValue = "Aluno de Arendelle") String name) {
		return new Greeting(0, "Saudações, "+ name);
	}*/

}