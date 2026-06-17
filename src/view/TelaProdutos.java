package view;

import model.Produto;
import service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class TelaProdutos extends JInternalFrame {

    private JPanel painelProdutos;

    public TelaProdutos() {

        super(
                "Produtos Diversos",
                true,
                true,
                true,
                true
        );

        setSize(900, 600);

        setLayout(new BorderLayout());

        criarMenuLateral();
        criarGridProdutos();

        carregarProdutos();
    }

    private void criarMenuLateral() {

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(10,1,5,5));

        JButton btnCompra = new JButton("Compra");
        JButton btnCadastro = new JButton("Cadastro");
        JButton btnInfo = new JButton("Info");

        btnCadastro.addActionListener(e -> {

            TelaCadastroProduto tela =
                    new TelaCadastroProduto();

            getDesktopPane().add(tela);
            tela.setVisible(true);

        });

        menu.add(btnCompra);
        menu.add(btnCadastro);
        menu.add(btnInfo);

        add(menu, BorderLayout.WEST);
    }

    private void criarGridProdutos() {

        painelProdutos = new JPanel();

        painelProdutos.setLayout(
                new GridLayout(4,4,15,15)
        );

        JScrollPane scroll =
                new JScrollPane(painelProdutos);

        add(scroll, BorderLayout.CENTER);
    }

    private void carregarProdutos() {

        painelProdutos.removeAll();

        for (Produto produto :
                ProdutoService.listar()) {

            JButton card =
                    new JButton(
                            "<html><center>"
                                    + produto.getNome()
                                    + "<br>R$ "
                                    + produto.getPreco()
                                    + "</center></html>"
                    );

            card.addActionListener(e -> {

                TelaDetalheProduto tela =
                        new TelaDetalheProduto(produto);

                getDesktopPane().add(tela);
                tela.setVisible(true);

            });

            painelProdutos.add(card);
        }

        painelProdutos.revalidate();
        painelProdutos.repaint();
    }
}