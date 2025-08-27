import Model.Calc;
import java.util.Scanner;
public class Main {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Calc calc = new Calc();
    boolean continueCalculating = true;

    while (continueCalculating) {
        System.out.println("\nMenu de Opções");
        System.out.println("1 - Adicionar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Dividir");
        System.out.println("4 - Multiplicar");
        System.out.println("5 - Módulo");
        System.out.println("6 - Fatorial");
        System.out.println("7 - Decimal para Binário");
        System.out.println("8 - Decimal para Hexadecimal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        double val1, val2, result = 0;
        String operation = "";

        switch (opcao) {
            case 1:
                System.out.print("Digite o primeiro valor: ");
                val1 = scanner.nextDouble();
                System.out.print("Digite o segundo valor: ");
                val2 = scanner.nextDouble();
                result = calc.add(val1, val2);
                System.out.println("Resultado: " + result);
                break;
            case 2:
                System.out.print("Digite o primeiro valor: ");
                val1 = scanner.nextDouble();
                System.out.print("Digite o segundo valor: ");
                val2 = scanner.nextDouble();
                result = calc.subtract(val1, val2);
                System.out.println("Resultado: " + result);
                break;
            case 3:
                System.out.print("Digite o primeiro valor: ");
                val1 = scanner.nextDouble();
                System.out.print("Digite o segundo valor: ");
                val2 = scanner.nextDouble();
                result = calc.divide(val1, val2);
                if (!Double.isNaN(result)) {
                    System.out.println("Resultado: " + result);
                }
                break;
            case 4:
                System.out.print("Digite o primeiro valor: ");
                val1 = scanner.nextDouble();
                System.out.print("Digite o segundo valor: ");
                val2 = scanner.nextDouble();
                result = calc.multiply(val1, val2);
                System.out.println("Resultado: " + result);
                break;
            case 5:
                System.out.print("Digite o primeiro valor: ");
                val1 = scanner.nextDouble();
                System.out.print("Digite o segundo valor: ");
                val2 = scanner.nextDouble();
                result = calc.modulus(val1, val2);
                if (!Double.isNaN(result)) {
                    System.out.println("Resultado: " + result);
                }
                break;
            case 6:
                System.out.print("Digite um valor inteiro não negativo: ");
                val1 = scanner.nextDouble();
                long factorialResult = calc.factorial(val1);
                if (factorialResult != -1) {
                    System.out.println("Resultado: " + factorialResult);
                }
                break;
            case 7:
                System.out.print("Digite um número inteiro: ");
                int numBinario = scanner.nextInt();
                String binaryResult = calc.decimalTobinary(numBinario);
                System.out.println("Resultado: " + binaryResult);
                break;
            case 8:
                System.out.print("Digite um número: ");
                int numHex = scanner.nextInt();
                String hexResult = calc.decimalTohex(numHex);
                System.out.println("Resultado: " + hexResult);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        System.out.print("Deseja realizar outra operação? (Sim / Não): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Não")) {
            continueCalculating = false;
        }
    }

    calc.showLastOperations();
    scanner.close();
}
}