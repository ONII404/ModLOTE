/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onnx.lirufiru.app.components;

/**
 *
 * @author Admin
 */
public class MultiplesServidores {

    //Variables a usar
    double lam, mu, C_W, C_S;
    int s;
    double rho, P0, L, Lq, W, Wq, Costo_Espera_Diario, Costo_Servicio_Diario, Costo_Total;

    //Constructor Multiples Servidores
    public MultiplesServidores(double lam, double mu, int s, double C_W, double C_S) {
        this.lam = lam;
        this.mu = mu;
        this.s = s;
        this.C_W = C_W;
        this.C_S = C_S;

        //Calcular Rho, P0, Lq, L, Wq, W, CostoEsperaDiario, CostoServicioDiario, CT.
        calcularRho();
        calcularP0();
        calcularLq();
        calcularL();
        calcularWq();
        calcularW();
        calcularCostoEsperaDiario();
        calcularCostoServicioDiario();
        calcularCostoTotal();

        mostrarResultados();
    }

    //Calcular Rho
    void calcularRho() {
        this.rho = lam / (s * mu);
    }

    //Calcular P0
    void calcularP0() {
        double sumatoria = 0;
        for (int n = 0; n < s; n++) {
            sumatoria += Math.pow(lam / mu, n) / factorial(n);
        }
        this.P0 = 1 / (sumatoria + Math.pow(lam / mu, s) / (factorial(s) * (1 - rho)));
    }

    //Calcular Lq
    void calcularLq() {
        this.Lq = (Math.pow(lam / mu, s) * rho * P0) / (factorial(s) * Math.pow(1 - rho, 2));
    }

    //Calcular L
    void calcularL() {
        this.L = Lq + lam / mu;
    }

    //Calcular Wq
    void calcularWq() {
        this.Wq = Lq / lam;
    }

    //Calcular W
    void calcularW() {
        this.W = Wq + (mu == 1 ? 0 : 1 / mu);
    }

    //Calcular CostoEsperaDiario
    void calcularCostoEsperaDiario() {
        this.Costo_Espera_Diario = L * C_W;
    }

    //CalcularCostoServicioDiario
    void calcularCostoServicioDiario() {
        this.Costo_Servicio_Diario = s * C_S;
    }

    //Calcular CT
    void calcularCostoTotal() {
        this.Costo_Total = Costo_Espera_Diario + Costo_Servicio_Diario;
    }
    
    //Mostrar Resultados de MultiplesServidores
    void mostrarResultados() {
        System.out.println("rho: " + rho);
        System.out.println("P0: " + P0);
        System.out.println("L: " + L);
        System.out.println("Lq: " + Lq);
        System.out.println("W: " + W);
        System.out.println("Wq: " + Wq);
        System.out.println("Costo Espera Diario: " + Costo_Espera_Diario);
        System.out.println("Costo Servicio Diario: " + Costo_Servicio_Diario);
        System.out.println("Costo Total: " + Costo_Total);
    }

    int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
