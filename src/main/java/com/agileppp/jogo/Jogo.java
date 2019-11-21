package com.agileppp.jogo;

import com.agileppp.pontuacao.Pontuador;

public class Jogo {

    public static final int STRIKE = 10;
    private static final int TOTAL_DE_QUADROS = 10;
    private int quadroAtual = 1;
    private boolean primeiraJogada = true;
    private Pontuador pontuador = new Pontuador();

    int getPontuacao() {
        return getPontuacaoDoQuadro(quadroAtual);
    }

    void adicionar(int pinosDaJogada) {
        pontuador.adicionarJogada(pinosDaJogada);
        ajustarQuadroAtual(pinosDaJogada);
    }

    private void ajustarQuadroAtual(int pinosDaJogada) {
        if(primeiraJogada) {
            ajustarQuadroParaStrike(pinosDaJogada);
        } else {
            primeiraJogada = true;
            incrementarQuadro();
        }
    }

    private void ajustarQuadroParaStrike(int pinosDaJogada) {
        if(isUltimaBolaNoQuadro(pinosDaJogada)) {
            incrementarQuadro();
        } else {
            primeiraJogada = false;
        }
    }

    private boolean isUltimaBolaNoQuadro(int pinosDaJogada) {
        return !primeiraJogada || isStrike(pinosDaJogada);
    }

    private boolean isStrike(int pinosDaJogada) {
        return primeiraJogada && pinosDaJogada == STRIKE;
    }

    private void incrementarQuadro() {
        quadroAtual++;
        if(quadroAtual > TOTAL_DE_QUADROS) {
            quadroAtual = TOTAL_DE_QUADROS;
        }
    }

    int getPontuacaoDoQuadro(int quadro) {
       return pontuador.getPontuacaoDoQuadro(quadro);
    }
}
