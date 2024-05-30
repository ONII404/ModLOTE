
package com.onnx.lirufiru.app.components;

public class Descuento {

    public double S, C1, C2, q, CT, Q, CT1, CT2;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D;

    // Constructor EOQ con descuento
    public Descuento(double S, double C1, double C2, int q, double H, double D, int tD, int tH) {

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
        //Calculo de CTs
        this.CT1 = CT(C1);
        this.CT2 = CT(C2);
    }
//         Seteo de q
//        if ( == true) {
//        // Funcion de rango
//        
//        } else {
//        }
//
//    }
//    /**
//     * 
//     * Funciones
//     * 
//     */

    double CT(double P) {
        return (S * D / Q) + (H * Q / 2) + (P * D);
    }

    // Calculo de la cantidad optima de pedido
    void getQ() {
        this.Q = Math.sqrt(((2 * S * D) / H));
    }

}
