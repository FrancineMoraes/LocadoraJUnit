package local.model;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.Valid;
import local.exception.ClienteException;
import local.exception.FilmeSemEstoqueException;
import local.service.LocacaoService;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FilmeTest {
    //TODO: Nome deve possuir entre 2 e 99 caracteres (inclusive)
    
     @Test
    public void nomeDevePossuirEntre2e99Carac() throws Exception {
          Cliente user = new Cliente();
               
        try
        {
           user.setNome("hahahahahahah hahahahahahahahhahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahah");
           fail("Nome do usuário deve ser maior que 2 e menor que 99");
           
        }
        catch(ClienteException e)
        {
            assertEquals("O nome do cliente deve possuir entre 2 e 99 caracteres", e.getMessage());
            
        }
        
    }
    
    //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
    
    @Test
    public void estoqueNaoPodeSerNegativoMax99(){
        Filme filme = new Filme();
        
        LocacaoService ls = new LocacaoService();
        
        
        try{
            
            filme.setEstoque(-1);
            fail("Estoque não pode ser negativo e o máximo é 99");
        }
        catch(FilmeSemEstoqueException e)
        {
            assertThat(e.getMessage(),is(equalTo("Estoque não pode ser negativo e o máximo é 99")));
        }
    }
    
    //TODO: O preço de Locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99 (inclusive)

    @Test
    public void locacaoEntre1e9() throws Exception{
        Filme filme = new Filme();
        filme.setEstoque(20);
        
        LocacaoService ls = new LocacaoService();
       
        try{
            filme.setPrecoLocacao(15.00);
            fail("O valor da locação deve ser entre 1,00 e 9,99");
        }
        catch(FilmeSemEstoqueException e)
        {
            assertEquals("O preço da locação deve ser maior que 1,00 e menor que 9,99", e.getMessage());
        }
    }

}
