package br.edu.ifam.greeting.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.edu.ifam.greeting.entidade.Greeting;
import br.edu.ifam.greeting.modelo.GreetingModel;
import br.edu.ifam.greeting.recursos.GreetingController;

@Component
public class GreetingModelAssembler<D> extends 
RepresentationModelAssemblerSupport<Greeting, GreetingModel> {

	public GreetingModelAssembler() {
		super(GreetingController.class,GreetingModel.class);
	}

	@Override
	public GreetingModel toModel(Greeting greeting) {
		GreetingModel greetingModel = instantiateModel(greeting);
		
		greetingModel.add(linkTo(
				methodOn(GreetingController.class)
				.getGreeting(greeting.getId())
				).withSelfRel());
		
		greetingModel.add(linkTo(
				methodOn(GreetingController.class)
				.getGreeting(greeting.getId())
				).withRel("mainpage"));
		return greetingModel;
	}
	
	@Override
	public CollectionModel<GreetingModel> 
		toCollectionModel(Iterable<? extends Greeting> greetings) {
		CollectionModel<GreetingModel> greetingModels = super.toCollectionModel(greetings);
		
		greetingModels.add(linkTo(
				methodOn(GreetingController.class)
				.getGreetings())
				.withSelfRel());
		return super.toCollectionModel(greetings);
	}

}