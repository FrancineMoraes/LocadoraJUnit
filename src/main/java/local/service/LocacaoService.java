package local.service;

import static local.util.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;
import local.exception.ClienteException;

import local.model.Filme;
import local.model.Locacao;
import local.model.Cliente;
import local.exception.FilmeSemEstoqueException;
import local.exception.LocadoraException;
import local.util.DataUtils;

public class LocacaoService {
//TODO atualizar para muitos filmes
    public Locacao alugarFilme(Cliente cliente, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException, Exception {

        if(cliente == null)
        {
            throw new ClienteException("Nome é um campo obrigatório");
        }
       
        if (filmes == null || filmes.isEmpty()) {
            throw new LocadoraException("Nenhum filme foi selecionado");
        }
        
        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);

        for(Filme filme: filmes) {
            
            locacao.addFilme(filme);
            locacao.setDataLocacao(new Date());
            locacao.setValor(filme.getPrecoLocacao());

            //Entrega no dia seguinte
            Date dataEntrega = new Date();
            dataEntrega = adicionarDias(dataEntrega, 1);
            locacao.setDataRetorno(dataEntrega);
        }
        //Salvando a locacao...	
        //TODO adicionar método para salvar
        
                
        return locacao;
    }

//    public String alugarFilme(Cliente cliente, Filme filme) throws LocadoraException, Exception {
//        Locacao l = new Locacao();
//      
//           l.setCliente(cliente);
//           l.setDataLocacao(DataUtils.obterData(8, 10, 2018));
//           l.setDataRetorno(DataUtils.adicionarDias(DataUtils.obterData(8, 10, 2018), 1));
//           l.setValor(filme.getPrecoLocacao());
//           
//           return "Filme Locado com Sucesso!!";
//
//    }
}
