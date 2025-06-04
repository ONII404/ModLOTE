package com.onnx.lirufiru.app.components;

public class Descuento {

    // Variables de entrada
    public double S, C1, C2, Qm, Qi, q1, q1_1, q1_2;

    // Variables
    public double costoAnual, costoDiario, costoAnualDescuento1, costoAnualDescuento2, costoDiarioDescuento1,
            costoDiarioDescuento2;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D;
    int q, q_2, zona;

    /**
     * Constructor EOQ con descuento 1 limite y 2 costos
     * 
     * @param D  Demanda anual
     * @param S  Costo de pedido
     * @param H  Costo de mantenimiento
     * @param C1 Costo del producto sin descuento
     * @param C2 Costo del producto con descuento
     * @param q  Cantidad de pedido con descuento
     */
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
        calQm();

        // Preparacion de la Ecuacion Cuadratica
        double A = h;
        double B = -(Qm * h) - (2 * (d / Qm) * (S)) - (2 * (C1 - C2) * d);
        double C = 2 * d * S;
        // Calculo de la Ecucacion Cuadratica q1
        calq1(A, B, C);
        // Calculo de CTm Costo sin descuento
        calCostoTotal(C1);
        // Calculo de CTi Costo con descuento
        calCostoTotalDescuento1(C2, q);
        // Calculo de la Zona de mi Q*
        calZona(q);
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
        calQm();
        // Preparacion de la Ecuacion Cuadratica
        double A = h;
        double B = -(Qm * h) - (2 * (d / Qm) * (S)) - (2 * (C1 - C2) * d);
        double C = 2 * d * S;
        // Calculo de la Ecucacion Cuadratica q1
        calq1(A, B, C);
        // Calculo de CTm Costo sin descuento
        calCostoTotal(C1);
        // Calculo de CTi Costo con descuento
        calCostoTotalDescuento1(C2, q);
        calCostoTotalDescuento2(C2, q_2);
        calZona(q);

    }

    private void ecuacion(double A, double B, double C) {
        double discriminant = (Math.pow(B, 2) - (4 * A * C));

        if (discriminant < 0) {
            System.out.println("No hay soluciones reales para la ecuación cuadrática.");
        } else {
            q1_1 = (-(B) + Math.sqrt(discriminant)) / (2 * A);
            q1_2 = (-B - Math.sqrt(discriminant)) / (2 * A);

            q1 = q1_1 > q1_2 ? q1_1 : q1_2;
        }

    }

    /**
     *
     *
     * Funciones
     *
     *
     */

    // Calculo de la cantidad optima de pedido
    void calQm() {
        Qm = Math.sqrt(((2 * S * D) / H));
    }

    /*
     * Calcualar costos
     * 
     * Costo sin descuento: Anual y diario
     * Costo con descuento: Anual y diario
     * Costo 2 con descuento: Anual y diario
     * 
     */

    // Calculo de la cantidad optima de pedido sin descuento
    void calCostoTotal(double P) {
        costoAnual = (S * D / Qm) + (H * Qm / 2) + (P * D);
        costoDiario = (S * d / Qm) + (h * Qm / 2) + (P * d);
    }

    // Calculo de la cantidad optima de pedido con descuento
    void calCostoTotalDescuento1(double P, double Qi) {
        costoAnualDescuento1 = ((S * D / Qi) + (H * Qi / 2) + (P * D));
        costoDiarioDescuento1 = ((S * d / Qi) + (h * Qi / 2) + (P * d));
    }

    void calCostoTotalDescuento2(double P, double Qi) {
        costoAnualDescuento2 = ((S * D / Qi) + (H * Qi / 2) + (P * D));
        costoDiarioDescuento2 = ((S * d / Qi) + (h * Qi / 2) + (P * d));
    }

    // Calculo de q1 o Q*
    public void calq1(double a, double b, double c) {

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
    public void calZona(double Qi) {

        if (Qi < q) {
            zona = 1;
        } else if (Qi >= q && Qi < q1) {
            zona = 2;
        } else {
            zona = 3;
        }

    }

}
