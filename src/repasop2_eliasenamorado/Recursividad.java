package repasop2_eliasenamorado;

/**
 *
 * @author Elias
 */
public class Recursividad {
    
    // La idea es ir dividiendo el número entre 2 y seguir con el restante
    // El caso base es cuando el número es 0 o 1
    public static String decimalABinario(int numero) {
        if (numero < 2) {
            return String.valueOf(numero);
        }
        return decimalABinario(numero / 2) + (numero % 2);
    }
    
    // Idea principal es ir dividiendo el número mayor entre el menor y quedarse con el resto (Algoritmo de Euclides)
    // El caso base es cuando el segundo número es 0
    public static int mcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return mcd(num2, num1 % num2);
    }
    
    // Según la definición, cada término es la suma de los dos anteriores
    // Por lo que busqué, el 6to término debe ser 8. Sin embargo esto sucede si no se considera el 0 como primer término.
    // Por lo tanto, los casos base son los dos primeros términos (0 y 1)
    public static int fibonacci(int numero) {
        if (numero <= 1) {
           return numero;
        }
        return fibonacci(numero - 1) + fibonacci(numero - 2);
    }

    // Se divide el array a la mitad en cada llamada y buscar en la mitad correspondiente
    public static int busquedaBinaria(int[] arreglo, int izquierda, int derecha, int objetivo) {
        if (izquierda > derecha) {
            return -1;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;

        if (arreglo[medio] == objetivo) {
            return medio;
        }
        
        // Buscar a la derecha
        if (arreglo[medio] > objetivo) {
            return busquedaBinaria(arreglo, izquierda, medio - 1, objetivo);
        }

        // Buscar a la izquierda
        return busquedaBinaria(arreglo, medio + 1, derecha, objetivo);
    }
    
}
