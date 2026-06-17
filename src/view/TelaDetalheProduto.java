package view;

import model.Produto;

import javax.swing.*;
import java.awt.*;

public class TelaDetalheProduto extends JInternalFrame {

    private Produto produto;

    public TelaDetalheProduto(
            Produto produto) {

        super(
                "Detalhes do Produto",
                true,
                true,
                true,
                true
        );

        this.produto = produto;

        setSize(700,500);

        JPanel painel =
                new JPanel(null);

        JLabel foto =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        foto.setBounds(
                220,
                20,
                250,
                150
        );

        foto.setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK
                )
        );

        if(produto.getCaminhoImagem() != null){

            ImageIcon icon =
                    new ImageIcon(
                            produto.getCaminhoImagem()
                    );

            Image img =
                    icon.getImage()
                            .getScaledInstance(
                                    250,
                                    150,
                                    Image.SCALE_SMOOTH
                            );

            foto.setIcon(
                    new ImageIcon(img)
            );
        }

        JLabel lblNome =
                new JLabel("Nome");

        lblNome.setBounds(
                50,
                220,
                120,
                25
        );

        JTextField txtNome =
                new JTextField(
                        produto.getNome()
                );

        txtNome.setEditable(false);

        txtNome.setBounds(
                180,
                220,
                300,
                30
        );

        JLabel lblPreco =
                new JLabel("Preço");

        lblPreco.setBounds(
                50,
                270,
                120,
                25
        );

        JTextField txtPreco =
                new JTextField(
                        String.valueOf(
                                produto.getPreco()
                        )
                );

        txtPreco.setEditable(false);

        txtPreco.setBounds(
                180,
                270,
                150,
                30
        );

        JLabel lblDescricao =
                new JLabel("Descrição");

        lblDescricao.setBounds(
                50,
                320,
                120,
                25
        );

        JTextArea descricao =
                new JTextArea(
                        produto.getDescricao()
                );

        descricao.setEditable(false);

        JScrollPane scroll =
                new JScrollPane(
                        descricao
                );

        scroll.setBounds(
                180,
                320,
                350,
                100
        );

        JButton voltar =
                new JButton(
                        "Fechar"
                );

        voltar.setBounds(
                280,
                440,
                100,
                30
        );

        voltar.addActionListener(
                e -> dispose()
        );

        painel.add(foto);
        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblPreco);
        painel.add(txtPreco);
        painel.add(lblDescricao);
        painel.add(scroll);
        painel.add(voltar);

        add(painel);
    }
}