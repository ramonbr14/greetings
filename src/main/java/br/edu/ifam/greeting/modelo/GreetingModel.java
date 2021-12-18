package br.edu.ifam.greeting.modelo;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.edu.ifam.greeting.entidade.Greeting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Relation(collectionRelation =  "greetings")
@JsonRootName(value = "greeting")
@JsonInclude(Include.NON_NULL)
public class GreetingModel extends RepresentationModel<GreetingModel> {

}
