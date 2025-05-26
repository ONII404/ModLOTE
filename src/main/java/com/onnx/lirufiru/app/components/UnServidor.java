package com.onnx.lirufiru.app.components;

public class UnServidor {
    //Variables a utilizar
    double lam, mu, C_W, C_S;
    double rho, P0, L, Lq, W, Wq, Costo_Total;

    //Contructor UnServidor
    public UnServidor(double lam, double mu, double C_W, double C_S) {
        this.lam = lam;
        this.mu = mu;
        this.C_W = C_W;
        this.C_S = C_S;
        
        //Calcular rho, P0, L, Lq, W, Wq, CT
        
        calcularRho();
        calcularP0();
        calcularL();
        calcularLq();
        calcularW();
        calcularWq();
        calcularCostoTotal();

        mostrarResultados();
    }
    //Calcular Rho
    void calcularRho() {
        this.rho = lam / mu;
    }
    //Calcular P0
    void calcularP0() {
        this.P0 = 1 - rho;
    }
    //Calcular L
    void calcularL() {
        this.L = lam / (mu - lam);
    }
    //Calcular Lq
    void calcularLq() {
        this.Lq = (Math.pow(lam, 2)) / (mu * (mu - lam));
    }
    //Calcular W
    void calcularW() {
        this.W = 1 / (mu - lam);
    }
    //Calcular Wq
    void calcularWq() {
        this.Wq = lam / (mu * (mu - lam));
    }
    //Calcular  CT
    void calcularCostoTotal() {
        this.Costo_Total = Lq * C_W + C_S;
    }
    
    //Mostrar Resultados UnServidor
    void mostrarResultados() {
        System.out.println("rho: " + rho);
        System.out.println("P0: " + P0);
        System.out.println("L: " + L);
        System.out.println("Lq: " + Lq);
        System.out.println("W: " + W);
        System.out.println("Wq: " + Wq);
        System.out.println("Costo Total: " + Costo_Total);
    }
}
