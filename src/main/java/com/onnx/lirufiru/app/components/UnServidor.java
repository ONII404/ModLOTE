package com.onnx.lirufiru.app.components;

/**
 * UnServidor.java
 * Clase que representa un sistema de colas M/M/1.
 * Calcula métricas como la tasa de utilización, probabilidad de vacío,
 * número promedio de clientes en el sistema y en la cola, tiempos de espera,
 * y costos asociados.
 */

public class UnServidor {
    // Variables a utilizar
    private final double lam, miu, costoEspera, costoServicio;
    private double rho, P0, L, Lq, W, Wq, costoAnual, costoDiario;

    /**
     * Modela un sistema de colas M/M/1 con un único servidor.
     * 
     * @param lam       Tasa de llegada (clientes/tiempo).
     * @param miu       Tasa de servicio (clientes/tiempo).
     * @param cEspera   Costo de espera por cliente/tiempo.
     * @param cServicio Costo de servicio por servidor/tiempo.
     */
    public UnServidor(double lam, double miu, double cEspera, double cServicio) {
        this.lam = lam;
        this.miu = miu;
        this.costoEspera = cEspera; // Costo de espera
        this.costoServicio = cServicio; // Costo del servicio

        calcularMetricas();
    }

    private void calcularMetricas() {
        rho = lam / miu;
        P0 = 1 - rho;
        L = lam / (miu - lam);
        Lq = rho * L;
        W = 1 / (miu - lam);
        Wq = rho * W;
        costoAnual = Lq * costoEspera + costoServicio;
        costoDiario = costoAnual / 365;
    }

    // Getters para acceder a las métricas calculadas
    public double getRho() {
        return rho;
    }

    public double getP0() {
        return P0;
    }

    public double getL() {
        return L;
    }

    public double getLq() {
        return Lq;
    }

    public double getW() {
        return W;
    }

    public double getWq() {
        return Wq;
    }

    public double getCostoAnual() {
        return costoAnual;
    }

    public double getCostoDiario() {
        return costoDiario;
    }

}
