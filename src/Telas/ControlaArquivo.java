/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ControlaArquivo {

    BufferedWriter bw;
    BufferedReader br;
    FileReader fr;
    File arquivo;
    String operacaoAtual;

    ControlaArquivo() throws IOException {
        arquivo = new File("Arquivo/gasto.txt");
    }

    public void abrirGastoParaLeitura() throws IOException {
        fr = new FileReader(arquivo);
        br = new BufferedReader(fr);
    }

    public Gastos leGasto() throws IOException {
        String linha = br.readLine();
        if (linha != null) {
            String[] campos = linha.split("\t");
            Gastos gasto = new Gastos("", "", "");
            gasto.local = campos[0];
            gasto.data = campos[1];
            gasto.valorCompra = campos[2];
            return gasto;
        }
        return null;
    }

    public void fecharGastoLeitura() throws IOException {
        br.close();
        fr.close();
    }

    public void excluiGasto(String local) throws IOException {
        StringBuffer memoria;
        memoria = new StringBuffer();
        String registro;
        while ((registro = br.readLine()) != null) {
            memoria.append(registro);
            memoria.append("\r\n");
        }

        int inicioCampoLocal = memoria.indexOf(local);
        int finalCampoLocal = memoria.indexOf("\r\n", inicioCampoLocal) + 2;
        System.out.println(inicioCampoLocal + "  " + finalCampoLocal);
        if (inicioCampoLocal != -1) {
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro?");
            if (confirma == 0) {
                System.out.println(confirma);
                memoria.delete(inicioCampoLocal, finalCampoLocal);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                System.out.println(memoria);
            }
            escreverArquivo(memoria);
        } else {
            JOptionPane.showMessageDialog(null, "Nome não encontrado!");
        }
    }

    public void escreverArquivo(StringBuffer memoria) throws IOException {
        bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(memoria.toString());
        bw.flush();
        bw.close();
    }

}
