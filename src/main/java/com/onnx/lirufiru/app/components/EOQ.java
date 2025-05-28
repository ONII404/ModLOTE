package com.onnx.lirufiru.app.components;

import com.onnx.lirufiru.app.components.Tiempos.TipoDemanda;
import com.onnx.lirufiru.app.components.Tiempos.TipoTiempo;

public class EOQ {

    private double costeAnual, costeUnitario, Q, S, puntoReorden, L, n, Z, B, Sigma, SigmaL;
    private double d, h;
    private double H, D, N, t;


    // Constructor EOQ con demanda constante
    /**
     * Constructor para calcular el EOQ con demanda constante.
     *
     * @param D  Demanda anual o diaria.
     * @param tD Tipo de demanda: 1 para diaria, 2 para anual.
     * @param S  Costo por pedido.
     * @param H  Costo de mantener una unidad en inventario por año o día.
     * @param tH Tipo de costo de mantenimiento: 1 para diario, 2 para anual.
     * @param L  Tiempo de entrega en días.
     */
    public EOQ(double D, TipoTiempo tipoCostoD, double S, double H, TipoTiempo tipoCostoH, double L) {
        this.S = S;
        this.L = L;

        // Seteo de D y d
        switch (tipoCostoD) {
            case DIARIO: // Diario
                this.d = D;
                this.D = D * 365;
                break;
            case ANUAL: // Anual
                this.D = D;
                this.d = D / 365;
                break;
        }

        // Seteo de H y h
        switch (tipoCostoH) {
            case DIARIO: // Diario
                this.h = H;
                this.H = H * 365;
                break;
            case ANUAL: // Anual
                this.H = H;
                this.h = H / 365;
                break;
        }

        calcularDemandaConstante();
    }

    /**
     * Constructor para calcular el EOQ con demanda variable.
     *
     * @param Q     Cantidad óptima de pedido.
     * @param L     Tiempo de entrega en días.
     * @param Z     Nivel de servicio (número de desviaciones estándar).
     * @param Sigma Desviación estándar de la demanda diaria.
     * @param t     Tiempo de ciclo (en días).
     */
    public EOQ(double Q, double L, double Z, double Sigma, double t) {

        this.Q = Q;
        this.L = L;
        this.Z = Z;
        this.t = t;
        this.Sigma = Sigma;

        calcularDemandaVariable();
    }

    private void calcularDemandaConstante() {
        Q = Math.sqrt((2 * S * D) / H);
        t = Q / d;
        N = D / Q;
        n = Math.floor(L / t);
        calcularPuntoReorden(TipoDemanda.CONSTANTE);
        costeAnual = (D / Q) * S + (Q / 2) * H;
        costeUnitario = (d / Q) * S + (Q / 2) * h;
    }

    private void calcularDemandaVariable() {
        n = Math.floor(L / t);
        calcularSigmaL();
        B = Z * SigmaL;
        calcularPuntoReorden(TipoDemanda.VARIABLE);
        N = D / Q;
        costeAnual = (D / Q) * S + (Q / 2) * H;
        costeUnitario = (d / Q) * S + (Q / 2) * h;
        Q += B;
    }

    // Calcular el punto de reorden
    private void calcularPuntoReorden(TipoDemanda caso) {
        switch (caso) {
            case CONSTANTE:
                if (L > t) {
                    puntoReorden = d * (L - (n * t));
                } else {
                    puntoReorden = d * L;
                }
                break;
            case VARIABLE:
                if (L > t) {    
                    puntoReorden = d * (L - n * t) + B;
                } else {
                    puntoReorden = d * L + B;
                }
                break;
        }
    }

    // Calcular SigmaL
    private void calcularSigmaL() {
        if (L > t) {
            this.SigmaL = Math.sqrt((L - (n * t)) * Math.pow(Sigma, 2));
        } else {
            this.SigmaL = Math.sqrt(L * Math.pow(Sigma, 2));
        }
    }

    // Getters
    public double getCosteAnual() {
        return costeAnual;
    }
    public double getCosteUnitario() {
        return costeUnitario;
    }
    public double getQ() {
        return Q;
    }
    public double getS() {
        return S;
    }
    public double getPuntoReorden() {
        return puntoReorden;
    }
    public double getL() {
        return L;
    }
    public double getN() {
        return N;
    }
    public double getn() {
        return n;
    }
    public double getZ() {
        return Z;
    }
    public double getB() {
        return B;
    }
    public double getSigma() {
        return Sigma;
    }
    public double getSigmaL() {
        return SigmaL;
    }
    public double getD() {
        return D;
    }
    public double getH() {
        return H;
    }
    public double getd() {
        return d;
    }
    public double geth() {
        return h;
    }
    public double getT() {
        return t;
    }

}
