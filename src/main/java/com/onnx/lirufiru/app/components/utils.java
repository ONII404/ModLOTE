package com.onnx.lirufiru.app.components;

import java.lang.Math;

public class utils {

    Double getQ(double S, double D, double H) {

        double Q = (2 * S * D) / H;
        return RaizC(Q);
    }

    Double getT(double Q, double D) {

        return Q / D;
    }

    Double getN(double L, double T) {

        return L / T;
    }

    double getPR(double D, double L, double N, double T) {

        return D * (L - (N * T));
    }

    /*
     * 
     * 
     * 
     * 
     * 
     */

    /**
     * 
     * @param B
     * @param Z
     * @param L
     * @return
     */
    Double getSigL(double L, double sig) {

        Double sigL = L * Math.pow(sig, L);
        return RaizC(sigL);
    }

    Double getSig(double L, double N, double T, double sig) {

        sig = (L - (N * T)) * Math.pow(sig, 2);
        return RaizC(sig);
    }

    /**
     * 
     * @param Z Valor de Z
     * @param sig_L Sigma o SigmaL
     * @return
     */
    Double getB(double Z, double sig_L) {

        return Z * sig_L;
    }

    /*
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */

    double getZ(double B, double sigL) {

        return B / sigL;
    }

    Double RaizC(double a) {

        return Math.sqrt(a);
    }

}
