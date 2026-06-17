package service;

import model.OrdemEntrega;

import java.util.ArrayList;
import java.util.List;

public class OrdemEntregaService {

    private static List<OrdemEntrega> ordens = new ArrayList<>();

    public static void adicionar(OrdemEntrega ordem) {
        ordens.add(ordem);
    }

    public static List<OrdemEntrega> listar() {
        return ordens;
    }
}