package com.onnx.lirufiru.app.components;

public class FuenteFinita {

    //Variables a Usar
    double lam, mu, C_W, C_S;
    int N;
    double sumatoria, P0, rho, L, Lq, W, Wq, Costo_Espera_Diario, Costo_Servicio_Diario, Costo_Total;

    //Constructor de Fuente Finita
    public FuenteFinita(double lam, double mu, int N, double C_W, double C_S) {
        this.lam = lam;
        this.mu = mu;
        this.N = N;
        this.C_W = C_W;
        this.C_S = C_S;

        //Calcular Sumatoria, P0, Rho, L, Lq, W, Wq, CostoEsperaDiario, CostoServicioDiario, CostoTotal
        calcularSumatoria();
        calcularP0();
        calcularRho();
        calcularL();
        calcularLq();
        calcularW();
        calcularWq();
        calcularCostoEsperaDiario();
        calcularCostoServicioDiario();
        calcularCostoTotal();

        mostrarResultados();
    }

    //Calcular Sumatoria
    void calcularSumatoria() {
        this.sumatoria = 0;
        for (int n = 0; n <= N; n++) {
            this.sumatoria += factorial(N) / factorial(N - n) * Math.pow(lam / mu, n);
        }
    }

    //Calcular P0
    void calcularP0() {
        this.P0 = 1 / sumatoria;
    }

    //Calcular Rho
    void calcularRho() {
        this.rho = 1 - P0;
    }

    //Calcular L
    void calcularL() {
        this.L = N - (mu / lam) * (1 - P0);
    }

    //Calcular Lq
    void calcularLq() {
        this.Lq = N - ((lam + mu) / lam) * (1 - P0);
    }

    //Calcular W
    void calcularW() {
        this.W = L / (lam * (N - L));
    }

    //Calcular Wq
    void calcularWq() {
        this.Wq = Lq / (lam * (N - L));
    }

    //Calcular CostoEsperaDiario
    void calcularCostoEsperaDiario() {
        this.Costo_Espera_Diario = L * C_S * 8;
    }

    //Calcular CostoServicioDiario
    void calcularCostoServicioDiario() {
        this.Costo_Servicio_Diario = rho * C_W * 8;
    }

    //Calcular CT
    void calcularCostoTotal() {
        this.Costo_Total = Costo_Espera_Diario + Costo_Servicio_Diario;
    }

    //Mostrar Resultados FuenteFinita
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
