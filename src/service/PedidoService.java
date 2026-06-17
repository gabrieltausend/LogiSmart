package service;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private static List<Pedido> pedidos = new ArrayList<>();

    public static void adicionar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public static List<Pedido> listar() {
        return pedidos;
    }
}