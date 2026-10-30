package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Testes unitários das operações e validações da calculadora.
 *
 * @author Nicolas Godoy
 * @version 1.0
 */
class TesteCalculadora {

    private final Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("Soma: 8 + 5 deve resultar em 13")
    void deveSomarDoisNumeros() {
        assertEquals(13, calculadora.calc(8, 5, "+"));
    }

    @Test
    @DisplayName("Subtração: 8 - 5 deve resultar em 3")
    void deveSubtrairDoisNumeros() {
        assertEquals(3, calculadora.calc(8, 5, "-"));
    }

    @Test
    @DisplayName("Multiplicação: 8 * 5 deve resultar em 40")
    void deveMultiplicarDoisNumeros() {
        assertEquals(40, calculadora.calc(8, 5, "*"));
    }

    @Test
    @DisplayName("Divisão inteira: 9 / 2 deve resultar em 4")
    void deveDividirDoisNumerosComResultadoInteiro() {
        assertEquals(4, calculadora.calc(9, 2, "/"));
    }

    @Test
    @DisplayName("Divisão por zero deve lançar exceção com mensagem compreensível")
    void deveImpedirDivisaoPorZero() {
        ArithmeticException excecao = assertThrows(
                ArithmeticException.class,
                () -> calculadora.calc(8, 0, "/"));

        assertEquals("Não é possível dividir por zero.", excecao.getMessage());
    }

    @Test
    @DisplayName("Operador não suportado deve lançar exceção")
    void deveRejeitarOperadorInvalido() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calc(8, 5, "%"));

        assertEquals("Operador inválido: %", excecao.getMessage());
    }

    @Test
    @DisplayName("Operador nulo deve ser tratado como inválido")
    void deveRejeitarOperadorNulo() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calc(8, 5, null));

        assertEquals("Operador inválido: null", excecao.getMessage());
    }
}
