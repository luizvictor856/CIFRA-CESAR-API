package com.luiz.cifravernamapi.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
public class CesarService {

    private final Set<String> palavras = new HashSet<>();

    public CesarService() {
        carregarDicionario();
    }

    private void carregarDicionario() {

        InputStream arquivo = getClass().getClassLoader()
                .getResourceAsStream("palavras.txt");

        if (arquivo == null) {
            throw new IllegalStateException(
                    "Arquivo palavras.txt não encontrado em resources."
            );
        }

        try (BufferedReader leitor = new BufferedReader(
                new InputStreamReader(arquivo, StandardCharsets.UTF_8))) {

            String palavra;

            while ((palavra = leitor.readLine()) != null) {

                String palavraNormalizada = normalizar(palavra.trim());

                if (!palavraNormalizada.isEmpty()) {
                    palavras.add(palavraNormalizada);
                }
            }

        } catch (Exception e) {
            throw new IllegalStateException(
                    "Erro ao carregar o dicionário de palavras.", e
            );
        }
    }

    private String normalizar(String texto) {

        String textoNormalizado = Normalizer.normalize(
                texto.toLowerCase(Locale.ROOT),
                Normalizer.Form.NFD
        );

        return textoNormalizado.replaceAll("\\p{M}", "");
    }

    public String cifrar(String textoClaro, int deslocamento) {

        return rotacionar(textoClaro, deslocamento);
    }

    public String decifrar(String textoCifrado, int deslocamento) {

        int deslocamentoNormalizado = Math.floorMod(deslocamento, 26);
        int deslocamentoInverso = (26 - deslocamentoNormalizado) % 26;

        return rotacionar(textoCifrado, deslocamentoInverso);
    }

    private String rotacionar(String texto, int deslocamento) {

        int deslocamentoNormalizado = Math.floorMod(deslocamento, 26);

        StringBuilder resultado = new StringBuilder();

        for (char caractere : texto.toCharArray()) {

            if (caractere >= 'A' && caractere <= 'Z') {

                char novaLetra = (char) ('A' +
                        (caractere - 'A' + deslocamentoNormalizado) % 26);

                resultado.append(novaLetra);

            } else if (caractere >= 'a' && caractere <= 'z') {

                char novaLetra = (char) ('a' +
                        (caractere - 'a' + deslocamentoNormalizado) % 26);

                resultado.append(novaLetra);

            } else {

                resultado.append(caractere);
            }
        }

        return resultado.toString();
    }

    public String decifrarForcaBruta(String textoCifrado) {

        String melhorResultado = null;
        int maiorPontuacao = -1;

        for (int deslocamento = 0; deslocamento < 26; deslocamento++) {

            String candidato = decifrar(textoCifrado, deslocamento);
            String textoNormalizado = normalizar(candidato);

            String[] palavrasCandidatas = textoNormalizado.split("[^a-z]+");

            int pontuacao = 0;

            for (String palavra : palavrasCandidatas) {

                if (palavras.contains(palavra)) {
                    pontuacao += palavra.length();
                }
            }

            if (pontuacao > maiorPontuacao) {
                maiorPontuacao = pontuacao;
                melhorResultado = candidato;
            }
        }

        if (maiorPontuacao <= 0) {
            throw new IllegalArgumentException(
                    "Não foi possível identificar palavras em português na mensagem."
            );
        }

        return melhorResultado;
    }
}