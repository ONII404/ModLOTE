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
     * t = Tiempo de ciclo en dias
     * L = Tiempo de Entrega en Dias
     * 
     * R = Punto de reorden
     * 
     * Sigma = Desviacion estandar de la demanda
     * Z = Nivel de servicio
     * B = Factor de seguridad
     * SigmaL = Desviacion estandar del tiempo de entrega
     * 
     * 
     */

    public double C, Q, S, R, L, n, Z, B, Sigma, SigmaL;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D, N, t;

    // Constructor EOQ con demanda constante
    public EOQ(double D, int tD, double S, double H, int tH, double L) {

        this.S = S;
        this.L = L;

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

        // Seteo de R
        getR();

        getCT();

    }

    // Constructor EOQ con demanda Variable
    public EOQ(double Q, double L, double Z, double Sigma, double t) {

        this.Q = Q;
        this.L = L;
        this.Z = Z;
        this.t = t;
        this.Sigma = Sigma;


        getn();
        getSigmaL();
        getSS();

        this.Q =+ B;

        // // Seteo de N
        // getN();
        // // Seteo de R
        // getR();

        // getCT();




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

    // Calculo del tiempo de ciclo
    void getT() {
        this.t = Q / d;
    }

    // Calculo de n
    void getn() {
        this.n = L / t;
    }

    // Calculo del punto de reorden
    void getR() {
        this.R = d * L;
    }

    // Calculo del Coste total
    void getCT() {
        this.C = (S * D / Q) + (H * Q / 2);
    }

    // Calculo de SigmaL
    void getSigmaL() {

        if (L > t) {
            this.SigmaL = Math.sqrt((L - (n * t)) * Math.pow(Sigma, B));
        } else {
            this.SigmaL = Math.sqrt(L * Math.pow(Sigma, 2));
        }
    }

    // Calculo del Stock de Seguridad
    void getSS() {

        this.B = Z * SigmaL;

    }

}
