package com.onnx.lirufiru.app;

import com.formdev.flatlaf.FlatDarkLaf;
import com.onnx.lirufiru.app.components.Inventarios;
import com.onnx.lirufiru.app.components.Servidores;

public class main {

    public static void main(String[] args) {

        FlatDarkLaf.setup();
        createAndShowGUI();

    }

    public static void createAndShowGUI() {

        Inventarios inventarios = new Inventarios();
        inventarios.setVisible(true);

        Servidores servidores = new Servidores();
        servidores.setVisible(true);
    }

}
