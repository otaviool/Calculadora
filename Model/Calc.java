package Model;
import java.util.ArrayList;
import java.util.List;

public class Calc {
    private List<String> lastOperations;

    public Calc() {
        lastOperations = new ArrayList<>();
    }

    private void saveOperation(String operation, double val1, double val2, double result) {
        String operationStr = String.format("%.2f %s %.2f = %.2f", val1, operation, val2, result);
        lastOperations.add(operationStr);
    }

    private void saveSingleValueOperation(String operation, double val, double result) {
        String operationStr = String.format("%s(%.0f) = %.0f", operation, val, result);
        lastOperations.add(operationStr);
    }

    public double add(double val1, double val2) {
        double result = val1 + val2;
        saveOperation("+", val1, val2, result);
        return result;
    }

    public double subtract(double val1, double val2) {
        double result = val1 - val2;
        saveOperation("-", val1, val2, result);
        return result;
    }

    public double divide(double val1, double val2) {
        if (val2 == 0) {
            System.out.println("Não é possível dividir por zero.");
            return Double.NaN; // Retorna um valor "Not a Number" para um resultado inválido
        }
        double result = val1 / val2;
        saveOperation("/", val1, val2, result);
        return result;
    }

    public double multiply(double val1, double val2) {
        double result = val1 * val2;
        saveOperation("*", val1, val2, result);
        return result;
    }

    public double modulus(double val1, double val2) {
        if (val2 == 0) {
            System.out.println("Não é possível calcular o módulo por zero.");
            return Double.NaN;
        }
        double result = val1 % val2;
        saveOperation("%", val1, val2, result);
        return result;
    }

    public long factorial(double val1) {
        if (val1 < 0) {
            System.out.println("O fatorial de um número negativo não é válido.");
            return -1;
        }
        if (val1 != Math.floor(val1)) {
            System.out.println("O fatorial é definido apenas para números inteiros.");
            return -1;
        }
        long result = 1;
        for (int i = 1; i <= val1; i++) {
            result *= i;
        }
        saveSingleValueOperation("Fatorial", val1, result);
        return result;
    }

    public String decimalTobinary(int num) {
        String result = Integer.toBinaryString(num);
        lastOperations.add(String.format("DecimalToBinary(%d) = %s", num, result));
        return result;
    }

    public String decimalTohex(int num) {
        String result = Integer.toHexString(num).toUpperCase();
        lastOperations.add(String.format("DecimalToHex(%d) = %s", num, result));
        return result;
    }

    public void showLastOperations() {
        System.out.println("\nHistórico de Operações:");
        if (lastOperations.isEmpty()) {
            System.out.println("Nenhuma operação foi realizada.");
        } else {
            for (String operation : lastOperations) {
                System.out.println(operation);
            }
        }
    }
}