package com.padrao.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveArmazenarEstados() {
        Pedido pedido = new Pedido(1, "X-Burguer");
        pedido.setEstado(PedidoEstadoAberto.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertEquals(2, pedido.getHistoricoEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Pedido pedido = new Pedido(2, "Frango Grelhado");
        pedido.setEstado(PedidoEstadoAberto.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        pedido.restaurarEstado(0);
        assertEquals(PedidoEstadoAberto.getInstance(), pedido.getEstadoAtual());
    }

    @Test
    void deveRestaurarEstadoAnteriorAposTransicaoErrada() {
        Pedido pedido = new Pedido(3, "Suco de Laranja");
        pedido.setEstado(PedidoEstadoAberto.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        pedido.setEstado(PedidoEstadoCancelado.getInstance()); // transição errada
        pedido.restaurarEstado(1);
        assertEquals(PedidoEstadoEmPreparo.getInstance(), pedido.getEstadoAtual());
    }

    @Test
    void deveManterEstadoAtualAposMultiplasTransicoes() {
        Pedido pedido = new Pedido(4, "Pudim");
        pedido.setEstado(PedidoEstadoAberto.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstadoAtual());
        assertEquals(4, pedido.getHistoricoEstados().size());
    }

    @Test
    void deveLancarExcecaoParaIndiceInvalido() {
        try {
            Pedido pedido = new Pedido(5, "Cerveja");
            pedido.restaurarEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoParaIndiceNegativo() {
        try {
            Pedido pedido = new Pedido(6, "Salada");
            pedido.setEstado(PedidoEstadoAberto.getInstance());
            pedido.restaurarEstado(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}