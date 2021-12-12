/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orden_Externo;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MezclaD {

    public void mezclaD(File f, int n) {

        File f1 = new File("f1.txt");
        File f2 = new File("f2.txt");
        int particion = 1;
        particiona(f, f1, f2, particion);
        fusiona(f, f1, f2, particion);
        while (particion < ((n + 1) / 2)) {
            particion *= 2;
            particiona(f, f1, f2, particion);
            fusiona(f, f1, f2, particion);
        }
    }// fin de Mezcla directa

    private void particiona(File f, File f1, File f2, int particion) {
        try {
            Scanner F = new Scanner(f);
            PrintStream F1 = new PrintStream(f1);
            PrintStream F2 = new PrintStream(f2);

            while (F.hasNext()) {
                int k = 0;
                while ((k < particion) && F.hasNext()) {
                    String R = F.next();
                    F1.print(R);
                    k++;
                }
                int l = 0;
                while ((1 < particion) && F.hasNext()) {
                    String R = F.next();
                    F1.print(R);
                    k++;
                }
            }
            F1.close();
            F2.close();
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());

        }
    }// fin de particiona

    private void fusiona(File f, File f1, File f2, int particion) {
        try {
            PrintStream F = new PrintStream(f);
            Scanner F1 = new Scanner(f1);
            Scanner F2 = new Scanner(f1);

            String R1 = "";
            String R2 = "";

            boolean B1 = true;
            boolean B2 = true;

            if (F1.hasNext()) {
                R1 = F1.next();
                B1 = false;

            }// fin de if de F1

            if (F2.hasNext()) {
                R1 = F2.next();
                B1 = false;

            }// fin de if de F2

            while ((F1.hasNext() || B1 == false)
                    && F2.hasNext() || B2 == false) {
                int k = 0;
                int l = 0;
                while ((k < particion && B1 == false)
                        && 1 < particion && B2 == false) {
                    int n1 = Integer.parseInt(R1);
                    int n2 = Integer.parseInt(R2);
                    if (n1 <= n2) {
                        F.print(R1);
                        B1 = true;
                        k++;
                        if (F1.hasNext()) {
                            R1 = F1.next();
                            B1 = false;
                        }
                    } else {
                        F.print(R2);
                        B2 = true;
                        l++;
                        if (F2.hasNext()) {
                            R2 = F2.next();
                            B2 = false;
                        }
                    }

                }
                while ((k < particion) && B1 == false) {
                    F.println(R1);
                    B1 = true;
                    k++;
                    if (F1.hasNext()) {
                        R1 = F1.next();
                        B1 = false;
                    }
                }// fin de while

                while ((k < particion) && B2 == false) {
                    F.println(R2);
                    B1 = true;
                    l++;
                    if (F2.hasNext()) {
                        R2 = F2.next();
                        B2 = false;
                    }
                }// fin de while
            }

            if (B1 == false) {
                F.print(R1);
            }
            if (B2 == false) {
                F.print(R2);
            }
            while (F1.hasNext()) {
                R1 = F1.next();
                F.print(R1);
            }
            while (F2.hasNext()) {
                R2 = F2.next();
                F.print(R2);
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        }
    }
}// fin de mezcla

