package com.padrao.visitor;

public class Bebida implements ItemCardapio {

    private String nome;
    private double preco;
    private boolean alcolica;

    public Bebida(String nome, double preco, boolean alcolica) {
        this.nome = nome;
        this.preco = preco;
        this.alcolica = alcolica;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    public boolean isAlcolica() { return alcolica; }

    @Override
    public String aceitar(CardapioVisitor visitor) {
        return visitor.visitarBebida(this);
    }
}
