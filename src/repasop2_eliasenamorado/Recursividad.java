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
    

}
