package com.padrao.visitor;

public interface CardapioVisitor {
    String visitarBebida(Bebida bebida);
    String visitarPrato(Prato prato);
    String visitarSobremesa(Sobremesa sobremesa);
}
