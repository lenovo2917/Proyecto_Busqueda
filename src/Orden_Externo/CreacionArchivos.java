package Orden_Externo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class CreacionArchivos {
    public static void main(String[] args){
        int n=100,  lim=999;
        
        try{
            PrintStream ps = new PrintStream(new File("Numeros.txt"));
            for (int i=0; i<n; i++){
                ps.println((int) (Math.random()* lim)+ 1);
            }
        }catch (IOException e){
            System.out.println("ERROR");
        }
    }
}
