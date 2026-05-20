package com.padrao.visitor;

/**
 * Interface Element: todo item do cardápio aceita um Visitor.
 */
public interface ItemCardapio {
    String getNome();
    double getPreco();
    String aceitar(CardapioVisitor visitor);
}
