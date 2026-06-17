package view;

import model.OrdemEntrega;
import service.OrdemEntregaService;

import javax.swing.*;
import java.awt.*;

public class TelaOrdemEntrega extends JInternalFrame {

    private JTextArea area;

    public TelaOrdemEntrega() {

        super(
                "Ordens de Entrega",
                true,
                true,
                true,
                true
        );

        setSize(600, 500);

        area = new JTextArea();

        JButton atualizar =
                new JButton("Atualizar");

        atualizar.addActionListener(e ->
                carregar());

        setLayout(new BorderLayout());

        add(new JScrollPane(area),
                BorderLayout.CENTER);

        add(atualizar,
                BorderLayout.SOUTH);
    }

    private void carregar() {

        area.setText("");

        for (OrdemEntrega o :
                OrdemEntregaService.listar()) {

            area.append(
                    "Cliente: "
                            + o.getPedido()
                            .getCliente()
                            .getNome()
                            + "\n"
            );

            area.append(
                    "Produto: "
                            + o.getPedido()
                            .getProduto()
                            .getNome()
                            + "\n"
            );

            area.append(
                    "Transportadora: "
                            + o.getTransportadora()
                            .getNome()
                            + "\n\n"
            );
        }
    }
}