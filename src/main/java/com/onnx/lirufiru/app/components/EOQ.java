package com.onnx.lirufiru.app.components;

public class EOQ {

    // Variables a utilizar en el cálculo del EOQ
    public double C, Q, S, R, L, n, Z, B, Sigma, SigmaL;
    // Variables Diarias
    public double d, h;
    // Variables Anuales
    public double H, D, N, t;

    // Constructor EOQ con demanda constante
    public EOQ(double D, int tD, double S, double H, int tH, double L) {
        this.S = S;
        this.L = L;

        // Seteo de D y d
        switch (tD) {
            case 1: // Diario
                this.d = D;
                this.D = D * 365;
                break;
            case 2: // Anual
                this.D = D;
                this.d = D / 365;
                break;
        }

        // Seteo de H y h
        switch (tH) {
            case 1: // Diario
                this.h = H;
                this.H = H * 365;
                break;
            case 2: // Anual
                this.H = H;
                this.h = H / 365;
                break;
        }

        // Calcular Q, t, N, R y C
        calcularQ();
        calcularT();
        calcularN();
        calcularR();
        calcularC();

        System.out.println("valor de L: " + L);
        System.out.println("valor de t: " + t);
        System.out.println("valor de R: " + R);

        mostrarResultados();
    }

    // Constructor EOQ con demanda variable
    public EOQ(double Q, double L, double Z, double Sigma, double t) {

        this.Q = Q;
        this.L = L;
        this.Z = Z;
        this.t = t;
        this.Sigma = Sigma;

        System.out.println("valor de L: " + L);
        System.out.println("valor de t: " + t);

        calcularn();
        calcularSigmaL();
        calcularB();
        calculard();
        calcularR();
        calcularN();
        calcularC();

        this.Q += B;
        mostrarResultadosDemandaVariable();

    }

    // Calcular la cantidad óptima de pedido
    void calcularQ() {
        this.Q = Math.sqrt((2 * S * D) / H);
    }

    // Calcular el número de pedidos al año
    void calcularN() {
        this.N = D / Q;
    }

    // Calcular el tiempo de ciclo
    void calcularT() {
        this.t = Q / d;
    }

    // Calcular el punto de reorden
    void calcularR() {
        if (L > t) {
            calcularn();
            this.R = d * (L - (n * t));
        } else {
            this.R = d * L;
        }
    }

    // Calcular el coste total anual
    void calcularC() {
        this.C = (S * D / Q) + (H * Q / 2);
    }

    // Calcular n
    void calcularn() {
        this.n = Math.floor(L / t);
    }

    // Calcular SigmaL
    void calcularSigmaL() {
        if (L > t) {
            this.SigmaL = Math.sqrt((L - (n * t)) * Math.pow(Sigma, 2));
        } else {
            this.SigmaL = Math.sqrt(L * Math.pow(Sigma, 2));
        }
    }

    // Calcular el stock de seguridad
    void calcularB() {
        this.B = Z * SigmaL;
    }

    // Calcular demanda diaria
    void calculard() {
        this.d = Q / t;
        this.D = d * 365;
    }

    // Mostrar resultados para demanda constante
    void mostrarResultados() {
        System.out.println("Cantidad Optima de Pedido (Q): " + Q);
        System.out.println("Tiempo de Ciclo (t): " + t);
        System.out.println("Número de Pedidos al Año (N): " + N);
        System.out.println("Punto de Reorden (R): " + R);
        System.out.println("Costo Total Anual (C): " + C);
    }

    // Mostrar resultados para demanda variable
    void mostrarResultadosDemandaVariable() {
        System.out.println("Cantidad Optima de Pedido (Q): " + Q);
        System.out.println("Stock de Seguridad (B): " + B);
        System.out.println("Punto de Reorden (R): " + R);
        System.out.println("Tiempo de Ciclo (t): " + t);
        System.out.println("Número de Pedidos al Año (N): " + N);
        System.out.println("Costo Total Anual (C): " + C);
        System.out.println("SigmaL: " + SigmaL);
        System.out.println("n: " + n);

    }
}
