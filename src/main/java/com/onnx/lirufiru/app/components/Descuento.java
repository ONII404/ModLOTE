package com.onnx.lirufiru.app.components;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Descuento {

    // Variables de entrada
    public double S, C1, C2, Qm, Qi, q1, q1_1, q1_2, CTm, CTi1, CTi2;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D;
    int q, q_2, zona;
    ArrayList<Double> CTi = new ArrayList<Double>();

    // Constructor EOQ con descuento 1 limite y 2 costos
    public Descuento(double D, double S, double H, double C1, double C2, int q) {

        this.S = S;
        this.C1 = C1;
        this.C2 = C2;
        this.q = q;
        this.d = D;
        this.D = D * 365;
        this.h = H;
        this.H = H * 365;

        // Calculo de Qm
        getQm();

        // Preparacion de la Ecuacion Cuadratica
        double A = h;
        double B = -(Qm * h) - (2 * (d / Qm) * (S)) - (2 * (C1 - C2) * d);
        double C = 2 * d * S;
        // Calculo de la Ecucacion Cuadratica q1
        getq1(A, B, C);
        // Calculo de CTm Costo sin descuento
        getCTm(C1);
        // Calculo de CTi Costo con descuento
        getCTi1(C2, q);
        // Calculo de la Zona de mi Q*
        getZona(q);
    }

    // Constructor EOQ con descuento 2 limite y 2 costos
    public Descuento(double D, double S, double H, double C1, double C2, int q, int q_2) {

        this.S = S;
        this.C1 = C1;
        this.C2 = C2;
        this.q_2 = q_2;
        this.q = q;
        this.d = D;
        this.D = D * 365;
        this.h = H;
        this.H = H * 365;

        // Calculo de Qm
        getQm();
        // Preparacion de la Ecuacion Cuadratica
        double A = h;
        double B = -(Qm * h) - (2 * (d / Qm) * (S)) - (2 * (C1 - C2) * d);
        double C = 2 * d * S;
        // Calculo de la Ecucacion Cuadratica q1
        getq1(A, B, C);
        // Calculo de CTm Costo sin descuento
        getCTm(C1);
        // Calculo de CTi Costo con descuento
        getCTi1(C2, q);
        getCTi2(C2, q_2);
        getZona(q);

    }

    /**
     *
     *
     * Funciones
     *
     *
     */
    // Calculo de la cantidad optima de pedido
    void getQm() {
        this.Qm = Math.sqrt(((2 * S * D) / H));
    }

    // Calculo de la cantidad optima de pedido sin descuento
    void getCTm(double P) {
        this.CTm = (S * D / Qm) + (H * Qm / 2) + (P * D);
    }

    // Calculo de la cantidad optima de pedido con descuento
    void getCTi1(double P, double Qi) {

        this.CTi1 = ((S * D / Qi) + (H * Qi / 2) + (P * D));
    }

    void getCTi2(double P, double Qi) {

        this.CTi2 = ((S * D / Qi) + (H * Qi / 2) + (P * D));
    }

    // Calculo de q1 o Q*
    public void getq1(double a, double b, double c) {

        double discriminant = (Math.pow(b, 2) - (4 * a * c));

        if (discriminant < 0) {
            System.out.println("No hay soluciones reales para la ecuación cuadrática.");
        } else {
            q1_1 = (-(b) + Math.sqrt(discriminant)) / (2 * a);
            q1_2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            q1 = q1_1 > q1_2 ? q1_1 : q1_2;

        }
    }

    // Calcular Zona de Q
    public void getZona(double Qi) {

        if (Qi < q) {
            zona = 1;
        } else if (Qi >= q && Qi < q1) {
            zona = 2;
        } else {
            zona = 3;
        }

    }

    public void imprimirResultados() {
        DecimalFormat df = new DecimalFormat("#.##");

        // Cuando hay 1 q
        System.out.println("Qm: " + df.format(Qm));
        System.out.println("q1: " + df.format(q1));
        System.out.println("CTm: " + df.format(CTm));
        System.out.println("CTi: ");
        for (double cti : CTi) {
            System.out.print(df.format(cti) + " ");
        }
        System.out.println("Zona: " + df.format(zona));
        System.out.println(q);

        // Cuando hay 2 q
        System.out.println("Qm: " + df.format(Qm));
        System.out.println("q1: " + df.format(q1));
        System.out.println("CTm: " + df.format(CTm));
        System.out.print("CTi: ");
        for (double cti : CTi) {
            System.out.print(df.format(cti) + " ");
        }
        System.out.println("Zona: " + df.format(zona));
        System.out.println(q);
        System.out.println(q_2);
    }

}
