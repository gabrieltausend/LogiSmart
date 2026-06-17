package view;

import model.*;
import service.*;
import util.MockData;

import javax.swing.*;
import java.awt.*;

public class TelaPedido extends JInternalFrame {

    public TelaPedido() {

        super(
                "Novo Pedido",
                true,
                true,
                true,
                true
        );

        setSize(600,450);

        JPanel painel =
                new JPanel(
                        new GridLayout(
                                7,
                                2,
                                10,
                                10
                        )
                );

        JTextField txtCliente =
                new JTextField();

        JTextField txtTelefone =
                new JTextField();

        JTextField txtEndereco =
                new JTextField();

        JTextField txtDistancia =
                new JTextField();

        JComboBox<Produto> cbProdutos =
                new JComboBox<>();

        for(Produto p :
                ProdutoService.listar()){

            cbProdutos.addItem(p);
        }

        JCheckBox chkUrgente =
                new JCheckBox(
                        "Entrega Urgente"
                );

        JButton btnGerar =
                new JButton(
                        "Gerar Ordem"
                );

        btnGerar.addActionListener(e -> {

            try {

                Cliente cliente =
                        new Cliente(
                                txtCliente.getText(),
                                txtTelefone.getText(),
                                txtEndereco.getText()
                        );

                Produto produto =
                        (Produto)
                                cbProdutos.getSelectedItem();

                double distancia =
                        Double.parseDouble(
                                txtDistancia.getText()
                        );

                Pedido pedido =
                        new Pedido(
                                cliente,
                                produto,
                                chkUrgente.isSelected(),
                                distancia
                        );

                LogisticaService service =
                        new LogisticaService();

                Transportadora transportadora =
                        service.escolherTransportadora(
                                distancia,
                                chkUrgente.isSelected(),
                                MockData.transportadoras
                        );

                OrdemEntrega ordem =
                        new OrdemEntrega(
                                pedido,
                                transportadora
                        );

                OrdemEntregaService.adicionar(
                        ordem
                );

                JOptionPane.showMessageDialog(
                        this,
                        """
                        Ordem Gerada!

                        Código: %s

                        Transportadora:
                        %s
                        """
                                .formatted(
                                        ordem.getCodigo(),
                                        transportadora.getNome()
                                )
                );

            } catch (Exception ex){

                JOptionPane.showMessageDialog(
                        this,
                        "Verifique os dados informados."
                );

            }

        });

        painel.add(
                new JLabel("Cliente")
        );

        painel.add(txtCliente);

        painel.add(
                new JLabel("Telefone")
        );

        painel.add(txtTelefone);

        painel.add(
                new JLabel("Endereço")
        );

        painel.add(txtEndereco);

        painel.add(
                new JLabel("Produto")
        );

        painel.add(cbProdutos);

        painel.add(
                new JLabel("Distância (KM)")
        );

        painel.add(txtDistancia);

        painel.add(
                new JLabel("Urgente")
        );

        painel.add(chkUrgente);

        painel.add(
                new JLabel("")
        );

        painel.add(btnGerar);

        add(painel);
    }
}