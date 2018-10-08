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
        if(estoque < 0 || estoque > 99){
            throw new FilmeSemEstoqueException("Estoque não pode ser negativo e o máximo é 99");
        }
        this.estoque = estoque;
    }

    public Double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(Double precoLocacao) {
        if(precoLocacao < 1 || precoLocacao > 9.99){
            throw new FilmeSemEstoqueException("O preço da locação deve ser maior que 1,00 e menor que 9,99");
        }
        this.precoLocacao = precoLocacao;
    }
}
