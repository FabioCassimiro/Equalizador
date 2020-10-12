
import java.util.ArrayList;

public class Equalizador {


    /*
    * @author Fabio Cassimiro
    */

    public int encontraMaiorValor(int valoresLinha[]) {
        int maiorValor = 0;
        for (int i = 0; i < valoresLinha.length; i++) {
            if (maiorValor < valoresLinha[i]) {
                maiorValor = valoresLinha[i];
            }
        }
        return maiorValor;
    }

    public ArrayList<Integer> quantidadeRepetida(int maiorNumero, int valoresLinha[]) {
        int quantRepetida = 0;
        ArrayList<Integer> quantidadeRepetidas = new ArrayList<>();

        for (int i = 0; i < maiorNumero; i++) {
            for (int j = 0; j < valoresLinha.length; j++) {
                if (i == valoresLinha[j]) {
                    quantRepetida++;

                }

            }
            quantidadeRepetidas.add(quantRepetida);
            quantRepetida = 0;
        }

        return quantidadeRepetidas;

    }

    public ArrayList<Double> calculaAcumulativa(ArrayList<Integer> quantidadeRepetidas) {
        ArrayList<Double> acumulativas = new ArrayList<>();
        double acumulativa = 0;
        for (int i = 0; i < quantidadeRepetidas.size(); i++) {
            acumulativa += quantidadeRepetidas.get(i);
            acumulativas.add(acumulativa);
        }

        return acumulativas;
    }

    public ArrayList<Double> calculaPorcentagem(ArrayList<Double> acumulativas, int quantidadePixels) {
        ArrayList<Double> porcentagens = new ArrayList<>();
        double porcentagem = 0;
        for (int i = 0; i < acumulativas.size(); i++) {
            porcentagem = acumulativas.get(i) / quantidadePixels;
            porcentagens.add(porcentagem);
            porcentagem = 0;
        }

        return porcentagens;

    }

    public ArrayList<Integer> calculaEqualizacao(ArrayList<Double> porcentagens, int maiorNumero) {
        ArrayList<Integer> equalizacao = new ArrayList<>();
        int equaliza = 0;

        for (int i = 0; i < porcentagens.size(); i++) {
            equaliza = (int) Math.round(porcentagens.get(i) * maiorNumero);
            equalizacao.add(equaliza);
            equaliza = 0;
        }

        return equalizacao;
    }

    public int[] equalizaLinha(int valoresLinha[], ArrayList<Integer> calculoEqualizacao) {
        Integer[] vetor = calculoEqualizacao.toArray(new Integer[calculoEqualizacao.size()]);

        for (int j = 0; j < valoresLinha.length; j++) {
            valoresLinha[j] = (int) vetor[valoresLinha[j]];
        }

        return valoresLinha;
    }

    public static void main(String[] args) {
        Equalizador equalizador = new Equalizador();

        //Altere os valores do vetor abaixo para executar o processo com novos valores.

        int valoresLinha[] = {0, 0, 4, 6, 8, 8, 4, 7, 8, 9, 9, 4, 3, 2, 3, 8, 2, 2, 1, 0};

        int maiorValor = equalizador.encontraMaiorValor(valoresLinha);

        ArrayList<Integer> quantidadeRepetidas = equalizador.quantidadeRepetida(maiorValor + 1, valoresLinha);

        ArrayList<Double> acumulativas = equalizador.calculaAcumulativa(quantidadeRepetidas);

        ArrayList<Double> porcentagens = equalizador.calculaPorcentagem(acumulativas, valoresLinha.length);

        ArrayList<Integer> equalizado = equalizador.calculaEqualizacao(porcentagens, maiorValor);;

        int[] valores = equalizador.equalizaLinha(valoresLinha, equalizado);

        System.out.println("O resultado da linha equalizada e: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.print(" " + valores[i] + " ");
        }

        
    }

}
