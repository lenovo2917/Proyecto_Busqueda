/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import datos.DatosDesordenados;
import datos.DatosOrdenados;
import javax.swing.JOptionPane;
public class TestBusqueda {

    public static void main(String[] args) {
        DatosDesordenados m;
        //DatosOrdenados datosOrd;
        int n, s, num, x, y, y1,me1,ma1,me2,ma2; 
        
        n = Integer.parseInt(JOptionPane.showInputDialog(
                "ingrese los valores que seran"));
        s = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuál es el valor máximo de sus datos?"));
        
        m = new DatosDesordenados(s, n);
        m.generarValores();
        System.out.println("" + m);
        num = Integer.parseInt(JOptionPane.showInputDialog(
                "Cual es el dato que se va a buscar?"));
        x = m.secuencialDes(num);
        me1 = m.menorDes();
        ma1 = m.mayorDes();
        System.out.println("\nSecuencial \nposicion: "+ x+
                "\n+++++++++++Numero MAYOR:+++++++++++++ "+ma1+"\n++++++++++Numero MENOR++++++: "+me1);
        DatosOrdenados exr = m.radix();
         System.out.println("" + exr);
        num = Integer.parseInt(JOptionPane.showInputDialog(
                "Cual es el dato que se va a buscar?"));
        y = exr.secuencialOr(num);
        me1 = m.menorDes();
        ma1 = m.mayorDes();
        System.out.println("\nSecuencial \nposicion: "+ y);
        y1 = exr.binaria(num);
        System.out.println("\nBinaria \nposicion: "+ y1+
             "\n+++++++++++Numero MAYOR:+++++++++++++ "+ma1+"\n++++++++++Numero MENOR++++++: "+me1);
    }
    
}