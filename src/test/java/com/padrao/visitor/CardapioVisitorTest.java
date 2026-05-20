package com.padrao.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioVisitorTest {

    @Test
    void deveExibirBebidaNaoAlcolica() {
        Bebida bebida = new Bebida("Agua Mineral", 5.00, false);
        RelatorioVisitor visitor = new RelatorioVisitor();
        assertEquals("[BEBIDA]    Agua Mineral              R$   5.00  (Não alcoólica)", visitor.visitarBebida(bebida));
    }

    @Test
    void deveExibirBebidaAlcolica() {
        Bebida bebida = new Bebida("Cerveja Artesanal", 18.00, true);
        RelatorioVisitor visitor = new RelatorioVisitor();
        assertEquals("[BEBIDA]    Cerveja Artesanal         R$  18.00  (Alcoólica)", visitor.visitarBebida(bebida));
    }

    @Test
    void deveExibirPrato() {
        Prato prato = new Prato("Frango Grelhado", 38.90, "Principal");
        RelatorioVisitor visitor = new RelatorioVisitor();
        assertEquals("[PRATO]     Frango Grelhado           R$  38.90  Categoria: Principal", visitor.visitarPrato(prato));
    }

    @Test
    void deveExibirSobremesaSemGluten() {
        Sobremesa sobremesa = new Sobremesa("Brownie Fit", 16.00, true);
        RelatorioVisitor visitor = new RelatorioVisitor();
        assertEquals("[SOBREMESA] Brownie Fit               R$  16.00  (Sem glúten)", visitor.visitarSobremesa(sobremesa));
    }

    @Test
    void deveExibirSobremesaComGluten() {
        Sobremesa sobremesa = new Sobremesa("Pudim", 14.00, false);
        RelatorioVisitor visitor = new RelatorioVisitor();
        assertEquals("[SOBREMESA] Pudim                     R$  14.00  (Com glúten)", visitor.visitarSobremesa(sobremesa));
    }

    // ---- ImpostoVisitor ----

    @Test
    void deveCalcularImpostoBebidaNaoAlcolica() {
        Bebida bebida = new Bebida("Suco de Laranja", 12.00, false);
        ImpostoVisitor visitor = new ImpostoVisitor();
        visitor.visitarBebida(bebida);
        assertEquals(0.96, visitor.getTotalImpostos(), 0.001);
    }

    @Test
    void deveCalcularImpostoBebidaAlcolica() {
        Bebida bebida = new Bebida("Cerveja Artesanal", 18.00, true);
        ImpostoVisitor visitor = new ImpostoVisitor();
        visitor.visitarBebida(bebida);
        assertEquals(3.60, visitor.getTotalImpostos(), 0.001);
    }

    @Test
    void deveCalcularImpostoPrato() {
        Prato prato = new Prato("Risoto de Cogumelos", 45.00, "Vegetariano");
        ImpostoVisitor visitor = new ImpostoVisitor();
        visitor.visitarPrato(prato);
        assertEquals(5.40, visitor.getTotalImpostos(), 0.001);
    }

    @Test
    void deveCalcularImpostoSobremesa() {
        Sobremesa sobremesa = new Sobremesa("Pudim", 14.00, false);
        ImpostoVisitor visitor = new ImpostoVisitor();
        visitor.visitarSobremesa(sobremesa);
        assertEquals(0.70, visitor.getTotalImpostos(), 0.001);
    }

    @Test
    void deveAcumularImpostosDeVariosItens() {
        ImpostoVisitor visitor = new ImpostoVisitor();
        visitor.visitarBebida(new Bebida("Suco", 12.00, false));        // 0.96
        visitor.visitarPrato(new Prato("Frango", 38.90, "Principal"));  // 4.668
        visitor.visitarSobremesa(new Sobremesa("Pudim", 14.00, false)); // 0.70
        assertEquals(6.328, visitor.getTotalImpostos(), 0.001);
    }
}