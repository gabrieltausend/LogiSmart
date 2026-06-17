package model;

public class Pedido {
    private Cliente cliente;
    private Produto produto;
    private boolean urgente;
    private double distancia;
    public Pedido(
            Cliente cliente,
            Produto produto,
            boolean urgente,
            double distancia) {
        this.cliente = cliente;
        this.produto = produto;
        this.urgente = urgente;
        this.distancia = distancia;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Produto getProduto() {
        return produto;
    }
    public boolean isUrgente() {
        return urgente;
    }
    public double getDistancia() {
        return distancia;
    }
}