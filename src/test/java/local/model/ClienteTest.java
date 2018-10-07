package local.model;

import java.util.Arrays;
import java.util.List;
import local.exception.ClienteException;
import local.exception.FilmeSemEstoqueException;
import local.exception.LocadoraException;
import local.model.Filme;
import local.model.Cliente;
import local.service.LocacaoService;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
public class ClienteTest {
    //TODO: O nome não pode ser nulo. Lança RuntimeException -  Nome não é um campo obrigatório
      @Test
    public void naoDeveLocarFilmeSemUsuario() {
        //Cenário
        Cliente user = null;
        LocacaoService ls = new LocacaoService();

        //Processamento e validação
        try {
            //TODO: Corrigir parâmetro para teste
            ls.alugarFilme(user);
            fail("Locação realizada com usuário null");
        }catch (RuntimeException e){
            assertEquals("Impossível locar com um usuer null",e.getMessage());
            assertThat(e.getMessage(),is(equalTo("Impossível locar com um usuario null")));
        }
    }
    @Test
    public void nomeDevePossuirEntre4e55Carac() {
          LocacaoService ls = new LocacaoService();
          Cliente user = new Cliente("Oxi");
          Cliente user1 = new Cliente("Ademar Pereira Da Silva");
          Cliente user2 = new Cliente("Albus Percival Wulfric Brian Godric Rills Dumbledore HEAUIHUEAIUAEHIEAUIHAIUE");
          
/*
        List<Object> clientes = Arrays.asList();
           
    clientes = Arrays.asList(
                new Cliente("Oxi"),
                new Cliente("Ademar Pereira Dos Santos"),
                new Cliente("Albus Percival Wulfric Brian Godric Rills Dumbledore HEAUIHUEAIUAEHIEAUIHAIUE")
        );  */

            
        try{
           ls.alugarFilme(user); 
           fail("Usuario deve conter entre 4 e 55 caracteres");
        }catch(ClienteException e){
            assertEquals("Usuario deve conter entre 4 e 55 caracteres", e.getMessage());
            
        }
        try{
            ls.alugarFilme(user1);
        }catch (ClienteException e) {
            assertEquals("Usuario deve conter entre 4 e 55 caracteres", e.getMessage());
        }
        try {
            ls.alugarFilme(user2);
           fail("Usuario deve conter entre 4 e 55 caracteres");
        }catch(ClienteException e){
            assertEquals("Usuario deve conter entre 4 e 55 caracteres", e.getMessage());
        }
        
    }
    //TODO: nome deve possuir entre 4 e 55 caracteres (inclusive). Lança ClienteException - O nome do cliente deve possuir entre 4 e 55 caracteres
@Test
public void nomeDoCadastroDevePossuir2Nomes(){
    LocacaoService ls = new LocacaoService();
    Cliente user = new Cliente("Angelo Luz");
    Cliente user1 = new Cliente("Pedrinho");
    
    
}
    


//TODO: O nome do cadastro deve possuir pelo menos 2 nomes (ex.: Angelo Luz)
    //TODO: O nome deverá ser salvo sem espaços no início e fim
    //TODO: O nome não deverá possuir símbolo ou número.Lança ClienteException - Números e símbolos não são permitidos

}
/*








@Test
    public void naoDeveLocarFilmeSemUsuario() {
        //Cenário
        Cliente cliente = null;
        LocacaoService ls = new LocacaoService();

        //Processamento e validação
        try {
            //TODO: Corrigir parâmetro para teste
            ls.alugarFilme(cliente);
            fail("Locação realizada com usuário null");
        }catch (LocadoraException | FilmeSemEstoqueException ex){
            assertEquals("Impossível locar sem um usuário",ex.getMessage());
            assertThat(ex.getMessage(),is(equalTo("Impossível locar sem um usuário")));
        }
    }
*/