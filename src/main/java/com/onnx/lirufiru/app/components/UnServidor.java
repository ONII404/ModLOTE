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
public class UnServidor {
    public static Map<String, Double> modeloUnServidor(double lam, double mu, double C_W, double C_S) {
        //Calculo de rho
        double rho = lam / mu;
        //Calculo de P0
        double P0 = 1 - rho;
        //Calculo de L
        double L = lam / (mu - lam);
        //Calculo de Lq
        double Lq = (Math.pow(lam, 2)) / (mu * (mu - lam));
        //Calculo de W
        double W = 1 / (mu - lam);
        //Calculo de Wq
        double Wq = lam / (mu * (mu - lam));
        //Calculo de Costo Total
        double Costo_Total = Lq * C_W + C_S;

        Map<String, Double> resultados = new HashMap<>();
        resultados.put("rho", rho);
        resultados.put("P0", P0);
        resultados.put("L", L);
        resultados.put("Lq", Lq);
        resultados.put("W", W);
        resultados.put("Wq", Wq);
        resultados.put("Costo_Total", Costo_Total);

        return resultados;
    }
}

