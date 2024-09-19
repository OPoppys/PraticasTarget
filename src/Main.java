import java.util.Scanner;

public static void main(String[] args) {
    Praticas praticas = new Praticas();
    Scanner sc = new Scanner(System.in);
    int escolha;
    do {
        System.out.println("Escolha um item do menu abaixo:");
        System.out.println("\n-=+ MENU +=-");
        System.out.println("1- Soma incremental");
        System.out.println("2- Fibonacci");
        System.out.println("3- Faturamento diario");
        System.out.println("4- Percentual do faturamento mensal");
        System.out.println("5- Inverter string");
        System.out.println("0- Sair");
        escolha = sc.nextInt();

        sc.nextLine();

        switch (escolha) {
            case 1:
                System.out.println("Resultado da soma incremental é " + praticas.somaIncr());
                break;
            case 2:
                System.out.println("Informe um numero positivo e inteiro que deseje encontrar na sequencia de Fibonacci: ");
                int n = sc.nextInt();
                if (praticas.pertenceFibonacci(n)) {
                    System.out.println("O numero " + n + " pertence a sequencia de Fibonacci");
                } else {
                    System.out.println("O numero " + n + " nao pertence a sequencia de Fibonacci");
                }
                break;
            case 3:
                System.out.println("Calculando o faturamento diário...");
                praticas.calcularFaturamento("C:\\Users\\Usuario\\Downloads\\dados.json");
                break;
            case 4:
                System.out.println("Calculando o percentual de faturamento mensal por estado...");
                praticas.calcularPercentualEstados();
                break;
            case 5:
                System.out.println("Informe a string que deseja inverter: ");
                String str = sc.nextLine();
                String stringInvertida = praticas.inverterString(str);
                System.out.println("String invertida: "+ stringInvertida);
            case 0:
                System.out.println("Obrigado pela avaliação");
            default:
                System.out.println("Valor inserido nao e valido tente novamente");
        }
    } while (escolha != 0);

    sc.close();
}
