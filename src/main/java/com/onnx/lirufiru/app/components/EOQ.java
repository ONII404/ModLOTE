package com.onnx.lirufiru.app.components;

public class EOQ extends LOTE {

    double n, z, l, pr, sig, sigL;

    public EOQ() {
    }

    @Override
    public void getQ() {

        q = RaizC((2 * s * d) / h);
    }

    Double getN() {
        return l / t;
    }

    double getPR(double D, double L, double N, double T) {

        return d * (l - (n * t));
    }


}
