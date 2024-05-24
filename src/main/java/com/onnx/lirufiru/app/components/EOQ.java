package com.onnx.lirufiru.app.components;

public class EOQ {

    /**
     * Variables a utilizar en el calculo del EOQ
     * 
     * -- Posible cambio a una clase Padre --
     * 
     * C = Costo Total Anual
     * Q = Cantidad optima de pedido/lote
     * H = Costo de mantenimiento/alacenamiento Anual por unidad %
     * D = Demanda Anual de unidades
     * S = Costo por hacer pedidos
     * N = Numero de pedidos al año
     * t = Tiempo de ciclo/entrega
     * 
     * L = Tiempo de Espera
     * R = Punto de reorden
     * 
     * 
     */

    public double C, Q, S;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D, N, t;

    //
    double q, L, T, n, z, l, pr, sig, sigL;

    // Constructor EOQ sin Q
    public EOQ(double D, int tD, double S, double H, int tH) {

        this.S = S;

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

        getT();

        // Seteo de N
        getN();

    }

    /***
     * 
     * 
     * 
     * 
     * 
     * 
     */

    // Calculo de la cantidad optima de pedido
    void getQ() {
        this.Q = Math.sqrt(((2 * S * D) / H));
    }

    // Calculo del numero de pedidos al año
    void getN() {
        this.N = D / Q;
    }

    void getT() {
        this.t = Q / d;
    }

    // Calculo del Coste total
    double getCT(double Q, double D, double S, double H) {
        return (S * D / Q) + (H * Q / 2);
    }
}
