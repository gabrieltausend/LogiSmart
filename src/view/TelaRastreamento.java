package view;

import model.OrdemEntrega;
import service.OrdemEntregaService;

import javax.swing.*;
import java.awt.*;

public class TelaRastreamento
        extends JInternalFrame {

    private JComboBox<OrdemEntrega> cbOrdens;

    private JComboBox<String> cbStatus;

    public TelaRastreamento() {

        super(
                "Rastreamento",
                true,
                true,
                true,
                true
        );

        setSize(500,300);

        JPanel painel =
                new JPanel(
                        new GridLayout(
                                4,
                                2,
                                10,
                                10
                        )
                );

        cbOrdens =
                new JComboBox<>();

        for(OrdemEntrega ordem :
                OrdemEntregaService.listar()){

            cbOrdens.addItem(ordem);
        }

        cbStatus =
                new JComboBox<>(
                        new String[]{
                                "AGUARDANDO ENVIO",
                                "EM SEPARAÇÃO",
                                "EM TRANSPORTE",
                                "SAIU PARA ENTREGA",
                                "ENTREGUE"
                        }
                );

        JButton atualizar =
                new JButton(
                        "Atualizar"
                );

        atualizar.addActionListener(e -> {

            OrdemEntrega ordem =
                    (OrdemEntrega)
                            cbOrdens.getSelectedItem();

            if(ordem != null){

                ordem.setStatus(
                        cbStatus
                                .getSelectedItem()
                                .toString()
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Status atualizado!"
                );
            }

        });

        painel.add(
                new JLabel("Ordem")
        );

        painel.add(cbOrdens);

        painel.add(
                new JLabel("Status")
        );

        painel.add(cbStatus);

        painel.add(
                new JLabel("")
        );

        painel.add(atualizar);

        add(painel);
    }
}