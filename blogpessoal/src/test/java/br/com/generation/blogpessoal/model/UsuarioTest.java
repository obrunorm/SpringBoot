package br.com.generation.blogpessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //Ele acha outra posta para rodar o teste
public class UsuarioTest {
    
    public Usuario usuario; //Novo objeto
    public Usuario usuarioErro = new Usuario(); //Usuario sendo criado com nenhum dado (nulo)

	@Autowired
	private  ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); //Objeto da classe validatorFactory, pega todas as anotações das validações dentro da model
	
	Validator validator = factory.getValidator(); //Novo objeto da classe validator, recebe o resultado das validações 

	@BeforeEach //Vai ser executado antes dos outros 2 metodos
	public void start() {

		LocalDate data = LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")); //Cria esse objeto e usa ele nos testes
		usuario = new Usuario(0L, "João da Silva", "joao@email.com.br", "13465278", data);

	}

	@Test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario); //Set não aceita duplicidade, list aceita
		
		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty()); //Verifica se é verdade que a lista está vazia, se estiver é porque não deu erro 
	}
    
    @Test
	@DisplayName("✖ Não Valida Atributos Nulos")
	void  testNaoValidaAtributos() {

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
		System.out.println(violacao.toString());

		assertFalse(violacao.isEmpty()); //Verifica se tem algo na lista, se tiver tem erro
	}

}