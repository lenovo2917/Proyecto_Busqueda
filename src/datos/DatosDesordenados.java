package datos;
public class DatosDesordenados {

    // Atributos
    private int[] valores;
    private int limiteSuperior;
    private int size;

    public DatosDesordenados(int limite, int size) {
        this.valores = new int[size];
        this.limiteSuperior = limite;
        this.size = size;
    }

    public void agregarDato(int valor) {
        valores[size] = valor;
        size++;
    }

    public int getDato(int posicion) {
        return valores[posicion];
    }

    public void generarValores() {
        for (int i = 0; i < valores.length; i++) {
            double aleatorio = Math.random() * limiteSuperior;
            valores[i] = (int) aleatorio + 1;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacidad() {
        return valores.length;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public int[] getValores() {
        return valores;
    }

    public int[] getCopiaValores() {
        int[] copia = new int[size];
        System.arraycopy(valores, 0, copia, 0, size);
        return copia;
    }

    public int secuencialDes(int a){
        int i=0;
        System.out.print("\nnumero a buscar:" + a);
        for (i = 0;i<valores.length;i++ ){
            if(a==valores[i]){
                System.out.println("\nNumero de ciclos: "+i);
                return i;
            }
        }
        System.out.println("\nNumero de ciclos: "+i);
        return -1;
    }

    public int mayorDes() {
        int max = valores[0];
        for (int x = 1; x < valores.length; x++) {
            if (valores[x] > max) {
                max = valores[x];
            }
        }
        return max;
    }
    
    public int menorDes() {
        int menor = valores[0];
        for (int x = 1; x < valores.length; x++) {
            if (valores[x]< menor) {
                menor = valores[x];
            }
        }
        return menor;
    }
    
    public DatosOrdenados algoritmoSort() {

        // obtener una copia de los datos desordenados
        int[] arreglo = this.getCopiaValores();

        // agregar algoritmo de ordenaci??n
        // devolver los datos ordenados
        return new DatosOrdenados(arreglo);
    }

    public DatosOrdenados bubbleSort() {
        int[] arreglo = this.getCopiaValores();
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                cont++;
                if (arreglo[j] > arreglo[j + 1]) {
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
        System.out.println("BS-comparaciones = " + cont);
        System.out.println("BS-intercambios = " + ci);
        return new DatosOrdenados(arreglo);
    }

    public DatosOrdenados radix() {
        int[] arreglo = this.getCopiaValores();
        int[][] bucket = new int[10][arreglo.length];
        int[] bucketOfElement = new int[10];
        int max = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        int maxLength = (max + "").length();
        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {

            for (int i = 0; i < arreglo.length; i++) {
                int digit = arreglo[i] / n % 10;

                bucket[digit][bucketOfElement[digit]] = arreglo[i];
                bucketOfElement[digit]++;
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketOfElement[j]; k++) {
                    arreglo[index] = bucket[j][k];
                    index++;
                }
                bucketOfElement[j] = 0;
            }
        }
        return new DatosOrdenados(arreglo);
    }

    public DatosOrdenados insertSort() {
        // obtener una copia de los datos desordenados
        int[] a = this.getCopiaValores();

        int i, j, aux;
        int cont = 0;
        for (i = 1; i < a.length; i++) {
            j = i;
            aux = a[i];
            while (j > 0 && aux < a[j - 1]) {
                cont++;
                a[j] = a[j - 1];
                j--;
            }
            a[j] = aux;
        }
        System.out.println("IS-comparaciones = " + cont);
        // devolver los datos ordenados
        return new DatosOrdenados(a);
    }

    public DatosOrdenados mergeSort() {
        int[] x = this.getCopiaValores();
        // Aqu?? va la llamada al m??todo mergesort( arreglo, l, r)
        this.mergesort(x, 0, x.length - 1);
        System.out.println("MS-comparaciones = " + cm);
        return new DatosOrdenados(x);
    } // fin del m??todo ordenacionMerge

    private void mergesort(int v[], int l, int r) {
        int m = (r + l) / 2;
        if (r > l) {
            cm++;
            mergesort(v, l, m);
            mergesort(v, m + 1, r);
            merge(v, l, m, r);
        }
    }
    static int cm = 0;

    private void merge(int v[], int l, int m, int r) {
        //Encuentra el tama??o de los sub-vectores para unirlos.
        int n1 = m - l + 1;
        int n2 = r - m;

        //Vectores temporales.
        int arrIzq[] = new int[n1];
        int arrDer[] = new int[n2];

        //Copia los datos a los arreglos temporales.
        for (int i = 0; i < n1; i++) {
            cm++;
            arrIzq[i] = v[l + i];
        }
        for (int j = 0; j < n2; j++) {
            cm++;
            arrDer[j] = v[m + j + 1];
        }
        // Combinaci??n (mezcla) de los dos arreglos:
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {//Ordenamiento.
            cm++;
            if (arrIzq[i] <= arrDer[j]) {
                v[k] = arrIzq[i];
                i++;
            } else {
                v[k] = arrDer[j];
                j++;
            }
            k++;
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de arrIzq[].
        while (i < n1) {
            cm++;
            v[k] = arrIzq[i];
            i++;
            k++;
        }
        //Copiar los elementos restantes de arrDer[].
        while (j < n2) {
            cm++;
            v[k] = arrDer[j];
            j++;
            k++;
        }
    }

    @Override
    public String toString() {
        String cad = "Datos desordenados:\n ";
        for (int x : valores) {
            cad += x + ", ";
        }
        return cad;
    }

}