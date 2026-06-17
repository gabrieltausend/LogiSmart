package service;

import model.Transportadora;

import java.util.List;

public class LogisticaService {

    public Transportadora escolherTransportadora(
            double distancia,
            boolean urgente,
            List<Transportadora> lista) {

        Transportadora melhor = null;

        for (Transportadora t : lista) {

            if (urgente && t.isEntregaRapida()) {
                return t;
            }

            if (melhor == null ||
                    t.getCustoPorKm() < melhor.getCustoPorKm()) {

                melhor = t;
            }
        }

        return melhor;
    }
}