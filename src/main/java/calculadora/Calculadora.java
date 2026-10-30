package calculadora;

/**
 * Executa operações matemáticas básicas com números inteiros.
 *
 * @author Nicolas Godoy
 * @version 1.0
 */
public class Calculadora {

    /**
     * Calcula uma operação matemática entre dois números inteiros.
     * A divisão utiliza divisão inteira e descarta a parte fracionária,
     * seguindo a regra de truncamento do Java em direção a zero.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param op operador: +, -, * ou /
     * @return resultado inteiro da operação
     * @throws IllegalArgumentException se o operador for nulo ou não suportado
     * @throws ArithmeticException se houver tentativa de divisão por zero
     */
    public int calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Operador inválido: null");
        }

        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        if (op.equals("*")) {
            return a * b;
        }
        if (op.equals("/")) {
            if (b == 0) {
                throw new ArithmeticException("Não é possível dividir por zero.");
            }
            return a / b;
        }

        throw new IllegalArgumentException("Operador inválido: " + op);
    }
}
