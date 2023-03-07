package br.com.sicredi.simulacao.teste;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sicredi.model.Simulacao;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestricaoControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	@Test
	public void consultarRestricaoCpf() {
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8080/api/v1/restricoes" + "/" + "97093236014", String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void criarUmaSimulacao() {
		Simulacao simulacao = new Simulacao("Fulano de tal","60094146012","email@email.com",1200,3,true);
		ResponseEntity<Simulacao> response = restTemplate.postForEntity("http://localhost:8080/api/v1/simulacoes", simulacao, Simulacao.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(201);
	}

}
