package model;

public class Transportadora {

    private String nome;
    private double custoPorKm;
    private boolean entregaRapida;

    public Transportadora(String nome,
                          double custoPorKm,
                          boolean entregaRapida) {

        this.nome = nome;
        this.custoPorKm = custoPorKm;
        this.entregaRapida = entregaRapida;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoPorKm() {
        return custoPorKm;
    }

    public boolean isEntregaRapida() {
        return entregaRapida;
    }

    @Override
    public String toString() {
        return nome;
    }
}