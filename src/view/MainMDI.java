package view;

import javax.swing.*;

public class MainMDI extends JFrame {

    private JDesktopPane desktop;

    public MainMDI() {

        setTitle(
                "LogiSmart - Sistema de Gestão Logística"
        );

        setSize(
                1200,
                800
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        desktop =
                new JDesktopPane();

        setContentPane(
                desktop
        );

        criarMenu();

        abrirTela(
                new DashboardMDI()
        );
    }

    private void criarMenu() {

        JMenuBar barra =
                new JMenuBar();

        JMenu menuSistema =
                new JMenu("Sistema");

        JMenu menuCadastros =
                new JMenu("Cadastros");

        JMenu menuOperacoes =
                new JMenu("Operações");

        JMenu menuLogistica =
                new JMenu("Logística");

        /*
         * Dashboard
         */

        JMenuItem dashboard =
                new JMenuItem(
                        "Dashboard"
                );

        dashboard.addActionListener(e ->
                abrirTela(
                        new DashboardMDI()
                )
        );

        /*
         * Produtos
         */

        JMenuItem produtos =
                new JMenuItem(
                        "Produtos"
                );

        produtos.addActionListener(e ->
                abrirTela(
                        new TelaProdutos()
                )
        );

        /*
         * Cadastro Produto
         */

        JMenuItem cadastroProduto =
                new JMenuItem(
                        "Cadastrar Produto"
                );

        cadastroProduto.addActionListener(e ->
                abrirTela(
                        new TelaCadastroProduto()
                )
        );

        /*
         * Pedido
         */

        JMenuItem pedido =
                new JMenuItem(
                        "Novo Pedido"
                );

        pedido.addActionListener(e ->
                abrirTela(
                        new TelaPedido()
                )
        );

        /*
         * Transportadoras
         */

        JMenuItem transportadoras =
                new JMenuItem(
                        "Transportadoras"
                );

        transportadoras.addActionListener(e ->
                abrirTela(
                        new TelaTransportadora()
                )
        );

        /*
         * Rastreamento
         */

        JMenuItem rastreamento =
                new JMenuItem(
                        "Rastreamento"
                );

        rastreamento.addActionListener(e ->
                abrirTela(
                        new TelaRastreamento()
                )
        );

        /*
         * Sair
         */

        JMenuItem sair =
                new JMenuItem(
                        "Sair"
                );

        sair.addActionListener(e ->
                System.exit(0)
        );

        menuSistema.add(dashboard);
        menuSistema.addSeparator();
        menuSistema.add(sair);

        menuCadastros.add(produtos);
        menuCadastros.add(cadastroProduto);
        menuCadastros.add(transportadoras);

        menuOperacoes.add(pedido);

        menuLogistica.add(rastreamento);

        barra.add(menuSistema);
        barra.add(menuCadastros);
        barra.add(menuOperacoes);
        barra.add(menuLogistica);

        setJMenuBar(barra);
    }

    private void abrirTela(
            JInternalFrame tela
    ) {

        desktop.add(tela);

        tela.setVisible(true);

        try {

            tela.setSelected(true);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}