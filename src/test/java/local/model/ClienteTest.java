package local.model;

import java.util.ArrayList;
import java.util.List;
import local.exception.ClienteException;
import local.service.LocacaoService;
import org.assertj.core.util.Arrays;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;

public class ClienteTest {
    //TODO: O nome não pode ser nulo. Lança RuntimeException -  Nome não é um campo obrigatório
    
    @Test
    public void naoDeveLocarFilmeSemUsuario() throws Exception {
        //Cenário
        Cliente user = null;
        LocacaoService ls = new LocacaoService();
        Filme filme = new Filme();
        filme.setEstoque(4);
        filme.setNome("Angelo Luz");
        filme.setPrecoLocacao(5.00);
        List<Filme> filmes = new ArrayList();
        filmes.add(filme);
        //Processamento e validação
        try {
            ls.alugarFilme(user, filmes);
            fail("Impossível locar sem um usuário");
        }catch (ClienteException e){
            assertThat(e.getMessage(),is(equalTo("Nome é um campo obrigatório")));
        }
    }
    
//    @Test
//    public void nomeDevePossuirEntre4e55Carac() {
//          LocacaoService ls = new LocacaoService();
//          Cliente user = new Cliente("Oxi");
//          Cliente user1 = new Cliente("Ademar Pereira Da Silva");
//          Cliente user2 = new Cliente("Albus Percival Wulfric Brian Godric Rills Dumbledore HEAUIHUEAIUAEHIEAUIHAIUE");
//               
//        try{
//           ls.alugarFilme(user); 
//           fail("Usuario deve conter entre 4 e 55 caracteres");
//        }catch(ClienteException e){
//            assertEquals("Usuario deve conter entre 4 e 55 caracteres", e.getMessage());
//            
//        }
//        try{
//            ls.alugarFilme(user1);
//        }catch (ClienteException e) {
//            assertEquals("Usuario deve conter entre 4 e 55 caracteres", e.getMessage());
//        }
//        try {
//            ls.alugarFilme(user2);
//           fail("Usuario deve conter entre 4 e 55 caracteres");
//        }catch(ClienteException e){
//            assertEquals("Usuario deve conter entre 4 e 55 caracteres", e.getMessage());
//        }
//        
//    }
    //TODO: nome deve possuir entre 4 e 55 caracteres (inclusive). Lança ClienteException - O nome do cliente deve possuir entre 4 e 55 caracteres
@Test
public void nomeDoCadastroDevePossuir2Nomes(){
    LocacaoService ls = new LocacaoService();
    Cliente user = new Cliente();
    
    try{
        user.setNome("Angelo");
        fail("O sistema aceito o nome sem sobrenome");
    }
    catch(ClienteException e)
    {
        assertEquals("Nome do cadastro deve possuir pelo menos dois nomes", e.getMessage());
    }
   
}
  
@Test
public void naoDeveTerCaracteresEspeciais()
{
    Cliente cliente = new Cliente();
    
    try{
        cliente.setNome("$$$ha*%¨#$ ¨&%¨&$%%");
        fail("Nome não deve possuir caracteres ou simbolos especiais");
    }
    catch(ClienteException e)
    {
        assertEquals("Números e símbolos não são permitidos", e.getMessage());
    }
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