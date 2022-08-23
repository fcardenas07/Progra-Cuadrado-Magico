import java.util.ArrayList;
import java.util.Arrays;

public class CuadradoMagico {
    public static void main(String[] args) {
        jugarCuadradoMagico();

    }

    private static void jugarCuadradoMagico() {
        int[][] cuadrado = crearCuadrado();
        int contador = 0;
        boolean esCuadradoMagico;

        do {
            llenarCuadrado(cuadrado);
            mostrarCuadrado(cuadrado);
            System.out.println();
            esCuadradoMagico = verificarCuadradoMagico(cuadrado);
            contador++;
        } while (!esCuadradoMagico);

        mostrarResultado(esCuadradoMagico);
        System.out.println("Cuadrado numero: " + contador);
    }

    private static boolean verificarCuadradoMagico(int[][] cuadrado) {
        int[] sumaFilas = sumarFilas(cuadrado);
        int[] sumaColumnas = sumarColumnas(cuadrado);
        int[] sumaDiagonales = sumarDiagonales(cuadrado);

        ArrayList<int[]> sumasCuadrado = crearArrayList(sumaFilas, sumaColumnas, sumaDiagonales);

        return comprobarSumasCuadrado(sumasCuadrado);
    }

    private static void mostrarResultado(boolean esMagico) {
        if (esMagico) {
            System.out.println("Es un cuadrado Magico");
        } else {
            System.out.println("NO es un cuadrado Magico");
        }
    }

    private static boolean comprobarSumasCuadrado(ArrayList<int[]> sumasCuadrado) {
        for (int[] suma : sumasCuadrado) {
            for (int k : suma) {
                if (k != 15) {
                    return false;
                }
            }
        }
        return true;
    }

    private static ArrayList<int[]> crearArrayList(int[] sumaFilas, int[] sumaColumnas, int[] sumaDiagonales) {
        ArrayList<int[]> sumas = new ArrayList<>();
        sumas.add(sumaFilas);
        sumas.add(sumaColumnas);
        sumas.add(sumaDiagonales);
        return sumas;
    }

    private static int[] sumarDiagonales(int[][] cuadrado) {
        int[] sumaDiagonales = new int[2];
        sumarDiagonal1(cuadrado, sumaDiagonales);
        sumarDiagonal2(cuadrado, sumaDiagonales);
        return sumaDiagonales;
    }

    private static void sumarDiagonal2(int[][] cuadrado, int[] sumaDiagonales) {
        for (int i = 0; i < cuadrado.length; i++) {
            sumaDiagonales[1] += cuadrado[i][(cuadrado.length - 1) - i];
        }
    }

    private static void sumarDiagonal1(int[][] cuadrado, int[] sumaDiagonales) {
        for (int i = 0; i < cuadrado.length; i++) {
            sumaDiagonales[0] += cuadrado[i][i];
        }
    }

    private static int[] sumarColumnas(int[][] cuadrado) {
        int[] sumaColumnas = new int[3];

        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                sumaColumnas[i] += cuadrado[j][i];
            }
        }
        return sumaColumnas;
    }

    private static int[] sumarFilas(int[][] cuadrado) {
        int[] sumaFilas = new int[3];
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                sumaFilas[i] += cuadrado[i][j];
            }
        }
        return sumaFilas;
    }

    private static void mostrarCuadrado(int[][] cuadrado) {
        for (int[] fila : cuadrado) {
            System.out.println(Arrays.toString(fila));
        }
    }

    private static void llenarCuadrado(int[][] cuadrado) {
        ArrayList<Integer> numerosUnicos = new ArrayList<>();
        int numeroAleatorio;

        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                do {
                    numeroAleatorio = (int) ((Math.random() * 9) + 1);
                } while (numerosUnicos.contains(numeroAleatorio));
                cuadrado[i][j] = numeroAleatorio;
                numerosUnicos.add(numeroAleatorio);
            }
        }
    }

    private static int[][] crearCuadrado() {
        return new int[3][3];
    }
}
