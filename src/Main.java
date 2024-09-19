import java.util.Scanner;

public static void main(String[] args) {
    // Cria uma instância da classe Praticas
    Praticas praticas = new Praticas();

    // Cria um Scanner para ler a entrada do usuário
    Scanner sc = new Scanner(System.in);

    int escolha;
    do {
        // Exibe o menu de opções para o usuário
        System.out.println("Escolha um item do menu abaixo:");
        System.out.println("\n-=+ MENU +=-");
        System.out.println("1- Soma incremental");
        System.out.println("2- Fibonacci");
        System.out.println("3- Faturamento diário");
        System.out.println("4- Percentual do faturamento mensal");
        System.out.println("5- Inverter string");
        System.out.println("0- Sair");

        // Lê a opção escolhida pelo usuário
        escolha = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner

        // Processa a escolha do usuário
        switch (escolha) {
            case 1:
                // Calcula e exibe a soma incremental
                System.out.println("Resultado da soma incremental é " + praticas.somaIncr());
                break;
            case 2:
                // Solicita um número e verifica se ele pertence à sequência de Fibonacci
                System.out.println("Informe um numero positivo e inteiro que deseje encontrar na sequencia de Fibonacci: ");
                int n = sc.nextInt();
                if (praticas.pertenceFibonacci(n)) {
                    System.out.println("O numero " + n + " pertence a sequencia de Fibonacci");
                } else {
                    System.out.println("O numero " + n + " nao pertence a sequencia de Fibonacci");
                }
                break;
            case 3:
                // Calcula e exibe o faturamento diário
                System.out.println("Calculando o faturamento diário...");
                praticas.calcularFaturamento("C:\\Users\\Usuario\\Downloads\\dados.json");
                break;
            case 4:
                // Calcula e exibe o percentual do faturamento mensal por estado
                System.out.println("Calculando o percentual de faturamento mensal por estado...");
                praticas.calcularPercentualEstados();
                break;
            case 5:
                // Solicita uma string e exibe a string invertida
                System.out.println("Informe a string que deseja inverter: ");
                String str = sc.nextLine();
                String stringInvertida = praticas.inverterString(str);
                System.out.println("String invertida: " + stringInvertida);
                break;
            case 0:
                // Mensagem de saída
                System.out.println("Obrigado pela avaliação");
                break;
            default:
                // Mensagem de erro para opção inválida
                System.out.println("Valor inserido nao e valido tente novamente");
        }
    } while (escolha != 0); // Continua o loop até que o usuário escolha sair

    // Fecha o scanner
    sc.close();
}
