/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Vinicius
 */
public class teste {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        File arquivo = new File("F:/Sistemas de Informação/Programação de Computadores/Flavio/SistemasGastos/src/Arquivo/gasto.txt");
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String registro = "";
        while(br.ready()){
            registro += br.readLine() + "\n";
            
        }
        System.out.println(registro);
        /*if (registro != null) {
            String[] campos = registro.split("\t");
            Gastos gasto = new Gastos(campos[0], campos[1], campos[2]);
            System.out.println(gasto);
        }*/
        
        
    }   
}
