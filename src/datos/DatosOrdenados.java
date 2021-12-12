
package datos;


public class DatosOrdenados {

    private int[] valores;

    public DatosOrdenados(int[] valores) {
        this.valores = valores;
    }

    public int getSize() {
        return valores.length;
    }

    public int secuencialOr(int a) {
        int i = 0;
        System.out.print("\nnumero a buscar:" + a);
        for (i = 0; i < valores.length && valores[i] <= a; i++) {
            if (a == valores[i]) {
                System.out.println("\nNumero de ciclos: "+i);
                return i;
            }
        }
        System.out.println("\nNumero de ciclos: " + i);
        return -1;
    }

    public int binaria(int a) {
        int down = 0;
        int up = valores.length - 1;
        int central = (down + up) / 2;
        int x = 0;
        System.out.print("\nnumero a buscar:" + a);
        while (down < up && a != valores[central]) {
            if (a < valores[central]) {
                up = central - 1;
            } else {
                down = central + 1;
            }
            central = (down + up) / 2;
            x++;
        }
        if (a == valores[central]) {
            System.out.println("\nNumero de ciclos: "+x);
            return central;
        }
        System.out.println("\nNumero de ciclos: "+x);
        return -1;
    }

    public int mayorOr() {
        int max = valores[0];
        for (int x = 1; x < valores.length; x++) {
            if (valores[x] > max) {
                max = valores[x];
            }
        }
        return max;
    }

    public int menorOr() {
        int menor = valores[0];
        for (int x = 1; x < valores.length; x++) {
            if (valores[x] < menor) {
                menor = valores[x];
            }
        }
        return menor;
    }

    @Override
    public String toString() {
        String cad = "Datos ordenados: \n";
        for (int x : valores) {
            cad += x + ", ";
        }
        return cad;
    }

}

