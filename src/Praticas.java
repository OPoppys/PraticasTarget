import java.util.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Praticas {
    // Prática 1: Soma incremental de 1 até 13
    public int somaIncr() {
        int indice = 13; // Valor final da soma
        int soma = 0;

        // Calcula a soma incremental
        for (int k = 1; k <= indice; k++) {
            soma += k;
        }

        return soma;
    }

    // Prática 2: Calcula o n-ésimo número da sequência de Fibonacci
    public int fibonacci(int n) {
        // Caso base para 0 e 1
        if (n == 0 || n == 1) {
            return n;
        }
        // Calcula recursivamente o número de Fibonacci
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Verifica se um número pertence à sequência de Fibonacci
    public boolean pertenceFibonacci(int n) {
        int i = 0;
        // Encontra o número de Fibonacci mais próximo que é maior ou igual a n
        while (fibonacci(i) < n) {
            i++;
        }
        // Verifica se o número é igual ao número de Fibonacci encontrado
        return fibonacci(i) == n;
    }

    // Prática 3: Calcula o faturamento diário a partir de um arquivo JSON
    public void calcularFaturamento(String arquivoJson) {
        JSONParser parser = new JSONParser();

        try {
            // Lê e parseia o arquivo JSON
            JSONArray dados = (JSONArray) parser.parse(new FileReader(arquivoJson));

            List<Double> valores = new ArrayList<>();
            double total = 0;
            int diasComFaturamento = 0;

            // Itera sobre os dados para calcular o faturamento
            for (Object obj : dados) {
                JSONObject diaObj = (JSONObject) obj;
                double valor = (double) diaObj.get("valor");

                // Adiciona valores positivos
                if (valor > 0) {
                    valores.add(valor);
                    total += valor;
                    diasComFaturamento++;
                }
            }

            // Calcula o menor e maior valor de faturamento
            double menorValor = Collections.min(valores);
            double maiorValor = Collections.max(valores);

            // Calcula a média mensal
            double mediaMensal = total / diasComFaturamento;

            // Calcula o número de dias com faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (double valor : valores) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibe os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da media: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace(); // Exibe erros se ocorrerem
        }
    }

    // Prática 4: Calcula o percentual de faturamento por estado
    public void calcularPercentualEstados() {
        Map<String, Double> estados = new HashMap<>();
        estados.put("SP", 67836.43);
        estados.put("RJ", 36678.66);
        estados.put("MG", 29229.88);
        estados.put("ES", 27165.48);
        estados.put("Outros", 19849.53);

        // Calcula o total de faturamento
        double total = estados.values().stream().mapToDouble(Double::doubleValue).sum();

        // Calcula e exibe o percentual de faturamento por estado
        estados.forEach((estado, valor) -> {
            double percentual = (valor / total) * 100;
            System.out.println("Percentual de " + estado + ": " + percentual);
        });
    }

    // Prática 5: Inverte uma string
    public String inverterString(String str) {
        String stringInvertida = "";

        // Itera sobre a string de trás para frente
        for (int i = str.length() - 1; i >= 0; i--) {
            stringInvertida += str.charAt(i);
        }

        return stringInvertida;
    }
}