package view;

import service.OrdemEntregaService;
import service.ProdutoService;
import util.MockData;

import javax.swing.*;
import java.awt.*;

public class DashboardMDI
        extends JInternalFrame {

    public DashboardMDI() {

        super(
                "Dashboard",
                true,
                true,
                true,
                true
        );

        setSize(800,500);

        JPanel painel =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                20,
                                20
                        )
                );

        painel.add(
                criarCard(
                        "Produtos",
                        String.valueOf(
                                ProdutoService
                                        .listar()
                                        .size()
                        )
                )
        );

        painel.add(
                criarCard(
                        "Transportadoras",
                        String.valueOf(
                                MockData
                                        .transportadoras
                                        .size()
                        )
                )
        );

        painel.add(
                criarCard(
                        "Ordens",
                        String.valueOf(
                                OrdemEntregaService
                                        .listar()
                                        .size()
                        )
                )
        );

        painel.add(
                criarCard(
                        "Status",
                        "Operacional"
                )
        );

        add(painel);
    }

    private JPanel criarCard(
            String titulo,
            String valor
    ){

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBorder(
                BorderFactory
                        .createTitledBorder(
                                titulo
                        )
        );

        JLabel label =
                new JLabel(
                        valor,
                        SwingConstants.CENTER
                );

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        card.add(label);

        return card;
    }
}