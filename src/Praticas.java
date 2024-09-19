import java.util.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Praticas {
    //Prática 1
    public int somaIncr() {
        int indice = 13;
        int soma = 0;

        for (int k = 1; k <= indice; k++) {
            soma += k;
        }

        return soma;
    }
    //Prática 2
    public int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public boolean pertenceFibonacci(int n) {
        int i = 0;
        while (fibonacci(i) < n) {
            i++;
        }
        return fibonacci(i) == n;
    }
    //Prática 3
    public void calcularFaturamento(String arquivoJson) {

        JSONParser parser = new JSONParser();

        try {
            JSONArray dados = (JSONArray) parser.parse(new FileReader(arquivoJson));

            List<Double> valores = new ArrayList<>();
            double total = 0;
            int diasComFaturamento = 0;

            for (Object obj : dados) {
                JSONObject diaObj = (JSONObject) obj;
                double valor = (double) diaObj.get("valor");

                if (valor > 0) {
                    valores.add(valor);
                    total += valor;
                    diasComFaturamento++;
                }
            }

            double menorValor = Collections.min(valores);
            double maiorValor = Collections.max(valores);

            double mediaMensal = total / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (double valor : valores) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da media: " + diasAcimaDaMedia);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Prática 4
    public void calcularPercentualEstados(){
        Map<String, Double> estados = new HashMap<>();
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = estados.values().stream().mapToDouble(Double::doubleValue).sum();

        estados.forEach((estado, valor) -> {
            double percentual = (valor / total) * 100;
            System.out.println("Percentual de "+ estado +": "+ percentual);
        });
    }
    //Prática 5
    public String inverterString(String str) {
        String stringInvertida = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            stringInvertida += str.charAt(i);
        }

        return stringInvertida;
    }
}
