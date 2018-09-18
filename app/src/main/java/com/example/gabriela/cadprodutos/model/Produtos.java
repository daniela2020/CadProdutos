package com.example.gabriela.cadprodutos.model;
//criamos o model e criamos uma classe java chamada produtos e
//definimos os metodos get e setrs
public class Produtos {
    private Long id;
    private String nomeProduto;
    private String descricao;
    private  int quantidade;

    //alt+insert para construir abaixo os métodos get e setrs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
