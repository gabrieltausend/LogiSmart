package util;

import model.Produto;
import model.Transportadora;
import service.ProdutoService;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Transportadora> transportadoras =
            new ArrayList<>();

    public static void carregar() {

        ProdutoService.adicionar(
                new Produto(
                        1,
                        "Notebook Gamer",
                        "Notebook RTX 4060",
                        5500.00,
                        "São Paulo",
                        null
                )
        );

        ProdutoService.adicionar(
                new Produto(
                        2,
                        "Mouse RGB",
                        "Mouse Gamer RGB",
                        150.00,
                        "Curitiba",
                        null
                )
        );

        ProdutoService.adicionar(
                new Produto(
                        3,
                        "Monitor 24",
                        "Monitor Full HD",
                        899.90,
                        "Florianópolis",
                        null
                )
        );

        transportadoras.add(
                new Transportadora(
                        "Correios",
                        2.50,
                        false
                )
        );

        transportadoras.add(
                new Transportadora(
                        "Jadlog",
                        3.20,
                        true
                )
        );

        transportadoras.add(
                new Transportadora(
                        "Loggi",
                        4.10,
                        true
                )
        );
    }
}