package local.model;

import local.exception.FilmeSemEstoqueException;

public class Filme {


    private String nome;
    private Integer estoque;
    private Double precoLocacao;

    public Filme() {
    }

    public Filme(String nome, Integer estoque, Double precoLocacao) {
        this.nome = nome;
        this.estoque = estoque;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) throws FilmeSemEstoqueException{
        if(estoque < 0){
            throw new FilmeSemEstoqueException("Estoque não pode ficar negativo");
        }else if(estoque > 99){
            throw new FilmeSemEstoqueException("Estoque não pode ser maior que 99");
        }
        this.estoque = estoque;
    }

    public Double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(Double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }
}
