package com.padrao.visitor;

public class ImpostoVisitor implements CardapioVisitor {

    private double totalImpostos = 0.0;

    @Override
    public String visitarBebida(Bebida bebida) {
        double aliquota = bebida.isAlcolica() ? 0.20 : 0.08;
        double imposto = bebida.getPreco() * aliquota;
        totalImpostos += imposto;
        return String.format("%s → imposto de %.0f%%: R$ %.2f", bebida.getNome(), aliquota * 100, imposto);
    }

    @Override
    public String visitarPrato(Prato prato) {
        double imposto = prato.getPreco() * 0.12;
        totalImpostos += imposto;
        return String.format("%s → imposto de 12%%: R$ %.2f", prato.getNome(), imposto);
    }

    @Override
    public String visitarSobremesa(Sobremesa sobremesa) {
        double imposto = sobremesa.getPreco() * 0.05;
        totalImpostos += imposto;
        return String.format("%s → imposto de 5%%: R$ %.2f", sobremesa.getNome(), imposto);
    }

    public double getTotalImpostos() {
        return totalImpostos;
    }
}