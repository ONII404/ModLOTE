package com.onnx.lirufiru.app.components;

/**
 * Clase abstracta que define los metodos a implementar en las clases que
 * heredan de ella
 */
public abstract class LOTE {

    double d, s, h, q, t;
    // double a, Sm, t1, t2, Ct;

    /**
     * Funcion para obtener la cantidad optima de pedido
     */
    abstract void getQ();

    /**
     * Funcion para obtener el tiempo de pedido
     */
    void getT() {
        t = q / d;
    }

    double RaizC(double a) {

        return Math.sqrt(a);
    }
}
