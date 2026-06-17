package main;

import javax.swing.SwingUtilities;

import util.MockData;
import view.MainMDI;

public class Main {

    public static void main(String[] args) {

        MockData.carregar();

        SwingUtilities.invokeLater(() -> {

            MainMDI tela =
                    new MainMDI();

            tela.setVisible(true);

        });

    }
}