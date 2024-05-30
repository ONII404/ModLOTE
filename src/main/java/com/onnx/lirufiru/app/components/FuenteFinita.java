/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onnx.lirufiru.app.components;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Admin
 */
public class FuenteFinita {
    public Map<String, Double> calcular(double lam, double mu, int N, double C_W, double C_S) {
        double sumatoria = 0;
        for (int n = 0; n <= N; n++) {
            sumatoria += factorial(N) / factorial(N - n) * Math.pow(lam / mu, n);
        }
        //Calculo de P0
        double P0 = 1 / sumatoria;
        //Calculo de rho
        double rho = 1 - P0;
        //Calculo de L
        double L = N - (mu / lam) * (1 - P0);
        //Calculo de Lq
        double Lq = N - ((lam + mu) / lam) * (1 - P0);
        //Calculo de W
        double W = L / (lam * (N - L));
        //Calculo de Wq
        double Wq = Lq / (lam * (N - L));
        //Calculo de Costo de Espera
        double Costo_Espera_Diario = L * C_S * 8;
        //Calculo CostodeServicio
        double Costo_Servicio_Diario = rho * C_W * 8;
        //Calculo de Costo Total
        double Costo_Total = Costo_Espera_Diario + Costo_Servicio_Diario;

        Map<String, Double> resultados = new HashMap<>();
        resultados.put("rho", rho);
        resultados.put("P0", P0);
        resultados.put("L", L);
        resultados.put("Lq", Lq);
        resultados.put("W", W);
        resultados.put("Wq", Wq);
        resultados.put("Costo_Espera_Diario", Costo_Espera_Diario);
        resultados.put("Costo_Servicio_Diario", Costo_Servicio_Diario);
        resultados.put("Costo_Total", Costo_Total);

        return resultados;
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

