package com.onnx.lirufiru.app.components;

/**
 * Clase que hereda del Metodo LOTE y tiene las operaciones para el calculo del
 * EOQ
 */

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
     * 
     * 
     * 
     * 
     * 
     * 
     * q = Cantidad optima de pedido Diaria
     * s = Costo de pedido
     * h = Costo de mantenimiento/almacenamiento
     * d = Demanda
     * L = Tiempo de pedido/entrega Anual
     * 
     * 
     * T = Tiempo de pedido/entrega Anual
     * t = Tiempo de pedido/entrega
     * 
     * n = Numero de pedidos
     * z = Costo total de pedido
     * l = Costo total de mantenimiento
     * pr = Punto de reorden
     * 
     */

    double C, Q, H, D, S, N;
    double q, h, d, L, T, t, n, z, l, pr, sig, sigL;

    /***
     * 
     * 
     * 
     * 
     * 
     * 
     */


    

    // Calculo del Coste Anual por Mantenimiento
    double getHAnual(double Q, double H) {
        return (H * Q / 2);
    }

    // Calculo del Coste Anual por hacer pedidos
    double getSAnual(double D, double S) {
        return (S * D);
    }

    // Calculo del Coste total
    double getCT(double Q, double D, double S, double H) {
        return (S * D / Q) + (H * Q / 2);
    }

    // Calculo de la cantidad optima de pedido
    double getQ(double S, double D, double H) {
        return Math.sqrt(((2 * S * D) / H));
    }

}
