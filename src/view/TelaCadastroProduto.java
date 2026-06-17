package view;

import model.Produto;
import service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroProduto extends JInternalFrame {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtEndereco;

    private JTextArea txtDescricao;

    private JLabel lblFoto;

    private String caminhoImagem;

    public TelaCadastroProduto() {

        super(
                "Cadastro de Produtos",
                true,
                true,
                true,
                true
        );

        setSize(750, 550);

        JPanel painel = new JPanel(null);

        lblFoto = new JLabel(
                "Foto Produto",
                SwingConstants.CENTER
        );

        lblFoto.setBounds(
                30,
                30,
                180,
                120
        );

        lblFoto.setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK
                )
        );

        JButton btnImagem =
                new JButton("Selecionar Imagem");

        btnImagem.setBounds(
                30,
                170,
                180,
                30
        );

        btnImagem.addActionListener(
                e -> selecionarImagem()
        );

        JLabel lblNome =
                new JLabel("Nome Produto");

        lblNome.setBounds(
                260,
                30,
                120,
                25
        );

        txtNome =
                new JTextField();

        txtNome.setBounds(
                260,
                60,
                300,
                30
        );

        JLabel lblPreco =
                new JLabel("Preço");

        lblPreco.setBounds(
                260,
                100,
                120,
                25
        );

        txtPreco =
                new JTextField();

        txtPreco.setBounds(
                260,
                130,
                120,
                30
        );

        JLabel lblDescricao =
                new JLabel("Descrição");

        lblDescricao.setBounds(
                30,
                230,
                120,
                25
        );

        txtDescricao =
                new JTextArea();

        JScrollPane scroll =
                new JScrollPane(
                        txtDescricao
                );

        scroll.setBounds(
                30,
                260,
                530,
                120
        );

        JLabel lblEndereco =
                new JLabel("Endereço Entrega");

        lblEndereco.setBounds(
                30,
                400,
                150,
                25
        );

        txtEndereco =
                new JTextField();

        txtEndereco.setBounds(
                30,
                430,
                530,
                30
        );

        JButton btnSalvar =
                new JButton("Salvar");

        btnSalvar.setBounds(
                600,
                430,
                100,
                30
        );

        btnSalvar.addActionListener(
                e -> salvarProduto()
        );

        painel.add(lblFoto);
        painel.add(btnImagem);
        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblPreco);
        painel.add(txtPreco);
        painel.add(lblDescricao);
        painel.add(scroll);
        painel.add(lblEndereco);
        painel.add(txtEndereco);
        painel.add(btnSalvar);

        add(painel);
    }

    private void selecionarImagem() {

        JFileChooser chooser =
                new JFileChooser();

        int retorno =
                chooser.showOpenDialog(this);

        if(retorno ==
                JFileChooser.APPROVE_OPTION){

            caminhoImagem =
                    chooser.getSelectedFile()
                            .getAbsolutePath();

            ImageIcon icon =
                    new ImageIcon(
                            caminhoImagem
                    );

            Image img =
                    icon.getImage()
                            .getScaledInstance(
                                    180,
                                    120,
                                    Image.SCALE_SMOOTH
                            );

            lblFoto.setIcon(
                    new ImageIcon(img)
            );

            lblFoto.setText("");
        }
    }

    private void salvarProduto() {

        try {

            Produto produto =
                    new Produto(
                            ProdutoService.listar().size() + 1,
                            txtNome.getText(),
                            txtDescricao.getText(),
                            Double.parseDouble(
                                    txtPreco.getText()
                            ),
                            txtEndereco.getText(),
                            caminhoImagem
                    );

            ProdutoService.adicionar(produto);

            JOptionPane.showMessageDialog(
                    this,
                    "Produto cadastrado com sucesso!"
            );

            limparCampos();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao salvar produto."
            );

        }
    }

    private void limparCampos() {

        txtNome.setText("");
        txtPreco.setText("");
        txtDescricao.setText("");
        txtEndereco.setText("");

        lblFoto.setIcon(null);
        lblFoto.setText("Foto Produto");

        caminhoImagem = null;
    }
}