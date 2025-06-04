package com.onnx.lirufiru.app.components;

public class Escases {
    Double D, S, H, I, C, P, t, t1, t2, W, sm, Q;
    Double d;
    Double costoAunal, costoDiario;

    public Escases(Double D, Double S, Double H, Double I, Double C, Double P) {
        this.D = D;
        this.S = S;
        this.H = H;
        this.I = I;
        this.C = C;
        this.P = P;

        // Calcular Q
        calcularQ();

        // Calcular W
        calcularW();

        // Calcular sm
        calcularSm();

        calcualrT1();
        calcualrT2();
        calcularT();

        // Calcular costo anual
        calcularCostoAnual();

        // Calcular costo diario
        calcularCostoDiario();
    }

    private void calcularQ() {
        Q = Math.sqrt((2 * D * S * (H + P)) / (H * P));
    }

    private void calcularW() {
        W = Q * (H / (H + P));
    }

    private void calcularSm() {
        sm = Q - W;
    }

    private void calcualrT1() {
        d = D / 365; // Demanda diaria
        t1 = (sm / d);
    }

    private void calcualrT2() {
        t2 = (W / d);
    }

    private void calcularT() {
        t = t1 + t2;
    }

    private void calcularCostoAnual() {
        costoAunal = (D / Q) * S
                + (Math.pow(sm, 2) * H) / (2 * Q)
                + (Math.pow(W, 2) * P) / (2 * Q);
    }

    private void calcularCostoDiario() {
        costoDiario = costoAunal / 365;
    }

}
