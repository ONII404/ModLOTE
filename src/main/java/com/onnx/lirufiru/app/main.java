package com.onnx.lirufiru.app;

import com.formdev.flatlaf.FlatDarkLaf;
import com.onnx.lirufiru.app.components.EOQ;
import com.onnx.lirufiru.app.components.GUI;


public class main {

    public static void main(String[] args) {
        
        FlatDarkLaf.setup();
        createAndShowGUI();
        test();

    }

    public static void createAndShowGUI() {

        GUI gui = new GUI();
        gui.setVisible(true);

        System.out.println("GUI Creada");

    }




    /**
     * tests
     */

    public static void test() {
        EOQ eoq = new EOQ(30.0, 1, 100.0, 0.02, 1);

        System.out.println("Demanda Anual: " + eoq.D);
        System.out.println("Demanda Diaria: " + eoq.d);

        System.out.println("Costo de Mantenimiento Anual: " + eoq.H);
        System.out.println("Costo de Mantenimiento Diario: " + eoq.h);

        System.out.println("Costo de Hacer Pedidos: " + eoq.S);

        System.out.println("Cantidad Optima de Pedido: " + eoq.Q);

        System.out.println("Numero de Pedidos Anual: " + eoq.N);

        System.out.println("Tiempo de Ciclo: " + eoq.t);

    }

}
