package com.onnx.lirufiru.app.components;

import com.onnx.lirufiru.app.components.Tiempos.TipoTiempo;

public class ELS {

  /*
   * ESL - Modelo de Produccion
   * Q: Cantidad óptima de producción
   * S: Costo por setup
   * D: Demanda anual o diaria
   * H: Costo de mantener una unidad en inventario por año o día
   * Sm: Stock máximo
   * t: Tiempo de ciclo (en días)
   * t1: Tiempo de producción
   * t2: Tiempo de espera
   * costoAnual: Costo total anual
   * costoUnitario: Costo total unitario
   * 
   */
  private double Q, S, a, Sm, t, t1, t2, costoAnual, costoUnitario;
  private double D, H;
  private double d, h;

  // Constructor ELS con demanda constante
  public ELS(double D, TipoTiempo tipoTiempoD, double S, double H, TipoTiempo tipoTiempoH, double a) {
    this.S = S;
    this.a = a;

    // Seteo de D y d
    switch (tipoTiempoD) {
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
    switch (tipoTiempoH) {
      case DIARIO: // Diario
        this.h = H;
        this.H = H * 365;
        break;
      case ANUAL: // Anual
        this.H = H;
        this.h = H / 365;
        break;
    }

    calcularProduccion();
  }

  private void calcularProduccion() {
    Q = Math.sqrt((2 * S * D) / (H * (1 - (d / a))));
    t = Q / d;
    t1 = Q / a;
    t2 = (Q / d) - t1;
    Sm = Q - (t1 * d);
    costoAnual = ((D / Q) * S) + ((Q / 2) * (1 - (d / a)) * H);
    costoUnitario = costoAnual / 365;
  }

  // getters
  public double getQ() {
    return Q;
  }

  public double getS() {
    return S;
  }

  public double getD() {
    return D;
  }

  public double getH() {
    return H;
  }

  public double getSm() {
    return Sm;
  }

  public double getT() {
    return t;
  }

  public double getT1() {
    return t1;
  }

  public double getT2() {
    return t2;
  }

  public double getCostoAnual() {
    return costoAnual;
  }

  public double getCostoUnitario() {
    return costoUnitario;
  }

  public double getA() {
    return a;
  }

  public double getDdiario() {
    return d;
  }

  public double getHdiario() {
    return h;
  }
}
