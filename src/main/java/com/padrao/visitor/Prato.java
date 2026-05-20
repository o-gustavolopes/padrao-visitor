package com.padrao.visitor;

public class Prato implements ItemCardapio {

    private String nome;
    private double preco;
    private String categoria; // ex: "Entrada", "Principal", "Vegetariano"

    public Prato(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    public String getCategoria() { return categoria; }

    @Override
    public String aceitar(CardapioVisitor visitor) {
        return visitor.visitarPrato(this);
    }
}
