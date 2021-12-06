package br.edu.ifam.greetings.recursos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifam.greetings.model.Greeting;

@RestController
@RequestMapping(value="greeting")
public class GreetingsController {
   
	private Greeting greeting;
	
	@GetMapping
	public ResponseEntity<Greeting> getGreeting(){
		if(greeting == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(this.greeting);
	}
	
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
	 */
	
	
	
	/*Resposta OK
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
