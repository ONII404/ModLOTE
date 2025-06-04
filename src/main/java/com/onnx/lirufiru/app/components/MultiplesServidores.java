
package com.onnx.lirufiru.app.components;


public class MultiplesServidores {

    //Variables a usar
    double lam, miu, costoEspera, costoServicio;
    int s;
    double rho, P0, L, Lq, W, Wq, costoEsperaDiario, costoServicioDiario, costoAnual;

    //Constructor Multiples Servidores
    public MultiplesServidores(double lam, double mu, int s, double costoEspera, double costoServicio) {
        this.lam = lam;
        this.miu = mu;
        this.s = s;
        this.costoEspera = costoEspera;
        this.costoServicio = costoServicio;

        //Calcular Rho, P0, Lq, L, Wq, W, CostoEsperaDiario, CostoServicioDiario, CT.
        calcularRho();
        calcularP0();
        calcularLq();
        calcularW();
        calcularWq();
        calcularL();
        calcularCostoEsperaDiario();
        calcularCostoServicioDiario();
        calcularCostoTotal();

    }

    //Calcular Rho
    private void calcularRho() {
        rho = lam / (s * miu);
    }

    //Calcular P0
    private void calcularP0() {
        double sumatoria = 0;
        for (int n = 0; n < s; n++) {
            sumatoria += Math.pow(lam / miu, n) / factorial(n);
        }
        P0 = 1 / (sumatoria + Math.pow(lam / miu, s) / (factorial(s) * (1 - rho)));
    }

    //Calcular Lq
    private void calcularLq() {
        Lq = (Math.pow(lam / miu, s) * rho * P0) / (factorial(s) * Math.pow(1 - rho, 2));
    }

    //Calcular L
    private void calcularL() {
        L = Lq + lam / miu;
    }

    //Calcular Wq
    private void calcularWq() {
        Wq = Lq / lam;
    }

    //Calcular W
    private void calcularW() {
        W = Wq + (miu == 1 ? 0 : 1 / miu);
    }

    //Calcular CostoEsperaDiario
    private void calcularCostoEsperaDiario() {
        costoEsperaDiario = L * costoEspera;
    }

    //CalcularCostoServicioDiario
    private void calcularCostoServicioDiario() {
        costoServicioDiario = s * costoServicio;
    }

    //Calcular CT
    private void calcularCostoTotal() {
        costoAnual = costoEsperaDiario + costoServicioDiario;
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
