package com.onnx.lirufiru.app.components;

import java.lang.Math;

public class Fun {
    

    /**
     * 
     * @param S 
     * @param D Diario/Anual
     * @param H Costo Mantenimiento Inventario Diario/Anual
     * @return Retorna el valor de Q
     */
    Double getQ(double S, double D, double H) {

        double Q = (2 * S * D) / H;
        return RaizCuadrada(Q);
    }

    /**
     * 
     * @param Q 
     * @param D
     * @return Retorna el tiempo
     */
    Double getT(double Q, double D) {
        return Q/D;
    }

    /**
     * 
     * @param a
     * @return
     */
    Double RaizCuadrada(double a) {
        return Math.sqrt(a);
    }

}
