package com.padrao.visitor;

import java.util.Locale;

public class RelatorioVisitor implements CardapioVisitor {

    @Override
    public String visitarBebida(Bebida bebida) {
        String tipo = bebida.isAlcolica() ? "Alcoólica" : "Não alcoólica";
        return String.format(Locale.US, "[BEBIDA]    %-25s R$ %6.2f  (%s)", bebida.getNome(), bebida.getPreco(), tipo);
    }

    @Override
    public String visitarPrato(Prato prato) {
        return String.format(Locale.US, "[PRATO]     %-25s R$ %6.2f  Categoria: %s", prato.getNome(), prato.getPreco(), prato.getCategoria());
    }

    @Override
    public String visitarSobremesa(Sobremesa sobremesa) {
        String gluten = sobremesa.isSemGluten() ? "Sem glúten" : "Com glúten";
        return String.format(Locale.US, "[SOBREMESA] %-25s R$ %6.2f  (%s)", sobremesa.getNome(), sobremesa.getPreco(), gluten);
    }
}
