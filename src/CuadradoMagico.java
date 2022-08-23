import java.util.ArrayList;
import java.util.Arrays;

public class CuadradoMagico {
    public static void main(String[] args) {
        jugarCuadradoMagico();

    }

    private static void jugarCuadradoMagico() {
        int[][] cuadrado = crearCuadrado();
        llenarCuadrado(cuadrado);
        mostrarCuadrado(cuadrado);
        boolean esCuadradoMagico = verificarCuadradoMagico(cuadrado);
    }

    private static boolean verificarCuadradoMagico(int[][] cuadrado) {
        int[] sumaFilas = sumarFilas(cuadrado);
        int[] sumaColumnas = sumarColumnas(cuadrado);
        int[] sumaDiagonales = sumarDiagonales(cuadrado);

        System.out.println(Arrays.toString(sumaFilas));
        System.out.println(Arrays.toString(sumaColumnas));
        System.out.println(Arrays.toString(sumaDiagonales));
        return false;
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
