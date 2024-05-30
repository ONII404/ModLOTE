package com.onnx.lirufiru.app.components;

import java.util.ArrayList;

public class Descuento {

    // Variables de entrada
    public double S, C1, C2, Qm, Qi, q, q1_1, q1_2, CTm;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D;
    ArrayList<Double> CTi = new ArrayList<Double>();

    // Constructor EOQ con descuento
    public Descuento(double D, double S, double H, double C1, double C2, int q, int tD, int tH) {

        this.S = S;
        this.C1 = C1;
        this.C2 = C2;

        // Seteo de D y d
        switch (tD) {
            case 1: // Diario
                this.d = D;
                this.D = D * 365;
                break;

            case 2: // Anual
                this.D = D;
                this.d = D / 365;
                break;
        }

        // Seteo de H y h
        switch (tH) {
            case 1: // Diario
                this.h = H;
                this.H = H * 365;
                break;

            case 2: // Anual
                this.H = H;
                this.h = H / 365;
                break;

        }
        // Calculo de Q
        getQ();

        // Preparacion de la Ecuacion Cuadratica
        double A = h;
        double B = -(Qm * h) - (2 * (d / Qm) * (S)) - (2 * (C1 - C2) * d);
        double C = 2 * d * S;
        // Calculo de la Ecucacion Cuadratica Q*
        getQi(A, B, C);

        // Calculo de CTm Costo sin descuento
        getCTm(C1);

        // Calculo de CTi Costo con descuento
        getCTi(C2, Qi);

    }

    /**
     *
     * Funciones
     * 
     *
     */

    // Calculo de la cantidad optima de pedido
    void getQ() {
        this.Qm = Math.sqrt(((2 * S * D) / H));
    }

    // Calculo de la cantidad optima de pedido sin descuento
    void getCTm(double P) {
        this.CTm = (S * D / Qm) + (H * Qm / 2) + (P * D);
    }

    // Calculo de la cantidad optima de pedido con descuento
    void getCTi(double P, double Qi) {

        // Añadir Costo con descuento al arrayList CTi[]
        CTi.add((S * D / Qi) + (H * Qi / 2) + (P * D));
    }

    // Calculo de q1 o Q*
    public void getQi(double a, double b, double c) {

        double discriminant = (Math.pow(b, 2) - (4 * a * c));

        if (discriminant < 0) {
            System.out.println("No hay soluciones reales para la ecuación cuadrática.");
        } else {
            q1_1 = (-(b) + Math.sqrt(discriminant)) / (2 * a);
            q1_2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            
            Qi = q1_1 > q1_2 ? q1_1 : q1_2;

        }
    }

}