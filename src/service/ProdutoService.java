package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private static final List<Produto> lista = new ArrayList<>();

    public static void adicionar(Produto produto) {
        lista.add(produto);
    }

    public static List<Produto> listar() {
        return lista;
    }

    public static Produto buscar(int id) {

        for (Produto p : lista) {

            if (p.getId() == id) {
                return p;
            }

        }

        return null;
    }

    public static void remover(int id) {

        lista.removeIf(
                p -> p.getId() == id
        );

    }

    public static void atualizar(
            Produto produtoAtualizado) {

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId()
                    == produtoAtualizado.getId()) {

                lista.set(i, produtoAtualizado);
                return;
            }

        }

    }

}