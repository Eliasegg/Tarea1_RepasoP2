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

}
