package com.onnx.lirufiru.app.components;

public class ELS {

  // Variables a utilizar en el cálculo del ELS
  double Q, S, a, Sm, t, t1, t2, CT;
  double D, H;
  double d, h;

  // Constructor ELS con demanda constante
  public ELS(double D, int tD, double S, double H, int tH, double a) {
    this.S = S;
    this.a = a;

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

    // Realizar cálculos
    calcularQ();
    calcularT();
    calcularT1();
    calcularT2();
    calcularSm();
    calcularCT();
    
    // Mostrar resultados
    mostrarResultados();
  }

  // Métodos de cálculo
  void calcularQ() {
    this.Q = Math.sqrt((2 * S * D) / (H * (1 - (d / a))));
  }

  void calcularCT() {
    this.CT = ((D / Q) * S) + ((Q / 2) * (1 - (d / a)) * H);
  }

  void calcularSm() {
    this.Sm = Q - (t1 * d);
  }

  void calcularT() {
    this.t = Q / d;
  }

  void calcularT1() {
    this.t1 = Q / a;
  }

  void calcularT2() {
    this.t2 = (Q / d) - t1;
  }

  // Método para mostrar resultados
  void mostrarResultados() {
    System.out.println("Cantidad Optima de Pedido: " + Q);
    System.out.println("Tiempo de Produccion: " + t);
    System.out.println("Tiempo de Produccion y Demanda: " + t1);
    System.out.println("Tiempo de Demanda: " + t2);
    System.out.println("Stock Maximo: " + Sm);
    System.out.println("Costo Total Anual: " + CT);
  }
}
