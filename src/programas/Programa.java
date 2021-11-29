package programas;

import datos.DatosDesordenados;
import datos.DatosOrdenados;
import javax.swing.JOptionPane;

public class Programa {
    public static void main(String[] args) {
        
        DatosDesordenados m;
        //DatosOrdenados datosOrd;
        int n, s; 
        long t, t1, t2;
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de datos que desee"));
        s = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de los valores de datos"));
        
        System.out.println("*************************************************************");
        System.out.println("El número de datos es: " + n);
        System.out.println("Valor de los datos: de 0 hasta " + s);
        
        m = new DatosDesordenados(s, n);
        m.generarValores();
        System.out.println("" + m);
        
        //bubbleSort
        t1 = System.nanoTime();   // start
        DatosOrdenados mob = m.bubbleSort();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        System.out.println("n = "+ n + " t = " + t + "ns. Burbuja = " + mob);
        
        System.out.println("*************************************************************");
        
        //insertSort
        t1 = System.nanoTime();   // start
        DatosOrdenados moi = m.insertSort();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        System.out.println("n = "+ n + " t = " + t + "ns. Inserción = " + moi);
        
        System.out.println("*************************************************************");
        
        //quickSort
        
        t1 = System.nanoTime();   // start
        DatosOrdenados moq = m.quickSort();
        t2 = System.nanoTime();   // stop 
        t = t2 - t1;
        System.out.println("n = "+ n + " t = " + t + "ns. Rápido = " + moq);
        
        System.out.println("*************************************************************");
        
        //mergeSort
        
        t1 = System.nanoTime();   // start
        DatosOrdenados mom = m.mergeSort();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        System.out.println("n = "+ n + " t = " + t + "ns. Merge = " + mom);
        
        System.out.println("*************************************************************");
    }
}
