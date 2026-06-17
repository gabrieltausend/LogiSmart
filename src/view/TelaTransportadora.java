package view;

import model.Transportadora;
import util.MockData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaTransportadora
        extends JInternalFrame {

    private JTable tabela;
    private DefaultTableModel model;

    public TelaTransportadora() {

        super(
                "Transportadoras",
                true,
                true,
                true,
                true
        );

        setSize(700,400);

        model =
                new DefaultTableModel();

        model.addColumn("Nome");
        model.addColumn("Custo/KM");
        model.addColumn("Entrega Rápida");

        tabela =
                new JTable(model);

        carregar();

        add(
                new JScrollPane(tabela),
                BorderLayout.CENTER
        );
    }

    private void carregar() {

        model.setRowCount(0);

        for(Transportadora t :
                MockData.transportadoras){

            model.addRow(
                    new Object[]{
                            t.getNome(),
                            t.getCustoPorKm(),
                            t.isEntregaRapida()
                    }
            );
        }
    }
}