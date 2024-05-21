package com.onnx.lirufiru.app;

import com.formdev.flatlaf.FlatDarkLaf;
import com.onnx.lirufiru.app.components.GUI;


public class main {

    public static void main(String[] args) {
        
        FlatDarkLaf.setup();
        createAndShowGUI();

    }

    public static void createAndShowGUI() {

        GUI gui = new GUI();
        gui.setVisible(true);

    }
}
