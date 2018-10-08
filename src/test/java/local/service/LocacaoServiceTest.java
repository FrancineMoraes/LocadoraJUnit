package local.service;

import java.util.ArrayList;
import local.exception.FilmeSemEstoqueException;
import local.exception.LocadoraException;
import local.model.Filme;
import local.model.Cliente;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import local.exception.ClienteException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;
//TODO atualizar testes para trabalhar com os multiplos filmes
public class LocacaoServiceTest {

    private List<Filme> filmes;
    private Cliente cliente;
    public static Double VALOR_FILME = 4.00;

    @Before
    public void setUp(){
        cliente = new Cliente("Angelo Gonçalves da Luz");

        filmes = Arrays.asList(
                new Filme("O Cavaleiro das Trevas", 2, VALOR_FILME),
                new Filme("Brilho Eterno de Uma Mente Sem Lembranças", 2, VALOR_FILME),
                new Filme("O Fabuloso Destino de Amelie Poulain", 3, VALOR_FILME),
                new Filme("Avatar", 4, VALOR_FILME),
                new Filme("Gladiador", 2, VALOR_FILME),
                new Filme("Brokeback Mountain", 4, VALOR_FILME),
                new Filme("O Senhor dos Anéis: A Sociedade do Anel", 5, VALOR_FILME),
                new Filme("Quem Quer Ser um Milionário", 2, VALOR_FILME),
                new Filme("A Lista de Schindler", 5, VALOR_FILME),
                new Filme("Guerra nas Estrelas", 9, VALOR_FILME)
        );
    }


    @Test
    public void naoDeveLocarFilmeSemUsuario() throws Exception {
        //Cenário
        Cliente cliente = null;
        LocacaoService ls = new LocacaoService();
        Filme filme = new Filme();
        
        List<Filme> filmes = new ArrayList();
        filmes.add(filme);

        //Processamento e validação
        try {
            //TODO: Corrigir parâmetro para teste
            ls.alugarFilme(cliente, filmes);
            fail("Locação realizada com usuário null");
        }catch (ClienteException ex){
            assertThat(ex.getMessage(),is(equalTo("Nome é um campo obrigatório")));
        }
    }
    

    @Test
    public void deveRealizarLocacao(){
        //TODO: Deve realizar uma locação caso os argumentos sejam apropriados
        //Cenário
        
        //Processamento

        //Validação
    }

}