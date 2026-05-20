package com.padrao.visitor;

public class Sobremesa implements ItemCardapio {

    private String nome;
    private double preco;
    private boolean semGluten;

    public Sobremesa(String nome, double preco, boolean semGluten) {
        this.nome = nome;
        this.preco = preco;
        this.semGluten = semGluten;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    public boolean isSemGluten() { return semGluten; }

    @Override
    public String aceitar(CardapioVisitor visitor) {
        return visitor.visitarSobremesa(this);
    }
}