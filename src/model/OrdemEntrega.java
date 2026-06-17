package model;

import java.time.LocalDate;
import java.util.UUID;

public class OrdemEntrega {
    private String codigo;
    private Pedido pedido;
    private Transportadora transportadora;
    private String status;
    private LocalDate dataCriacao;
    public OrdemEntrega(
            Pedido pedido,
            Transportadora transportadora) {
        this.codigo =
                UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();
        this.pedido = pedido;
        this.transportadora = transportadora;
        this.status =
                "AGUARDANDO ENVIO";
        this.dataCriacao =
                LocalDate.now();
    }
    public String getCodigo() {
        return codigo;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public Transportadora getTransportadora() {
        return transportadora;
    }
    public String getStatus() {
        return status;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
public String toString() {

    return codigo;

}
}