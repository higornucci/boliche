package com.agileppp.jogo;

public class Jogo {

    private static final int STRIKE = 10;
    private int[] arremessos = new int[21];
    private int jogadaAtual;
    private int quadroAtual = 1;
    private boolean primeiraJogada = true;
    private int bola;

    public void adicionar(int pinosDaJogada) {
        this.arremessos[jogadaAtual++] = pinosDaJogada;
        ajustarQuadroAtual(pinosDaJogada);
    }

    private void ajustarQuadroAtual(int pinosDaJogada) {
        if(primeiraJogada) {
            if(pinosDaJogada == STRIKE) {
                quadroAtual++;
            } else {
                primeiraJogada = false;
            }
        } else {
            primeiraJogada = true;
            quadroAtual++;
        }
        if(quadroAtual > 11) {
            quadroAtual = 11;
        }
    }

    public int getPontuacao() {
        return getPontuacaoDoQuadro(quadroAtual - 1);
    }

    public int getPontuacaoDoQuadro(int quadro) {
        bola = 0;
        int pontuacao = 0;
        for(int quadroAtual = 0; quadroAtual < quadro; quadroAtual++) {
            if(isStrike()) {
                pontuacao += 10 + pegarProximasDuasBolasParaStrike();
                bola++;
            } else if(isSpare()) {
                pontuacao += 10 + pegarProximoArremessoParaSpare();
                bola += 2;
            } else {
                pontuacao += pegarProximasDuasBolas();
                bola += 2;
            }
        }
        return pontuacao;
    }

    private int pegarProximoArremessoParaSpare() {
        return arremessos[bola + 2];
    }

    private int pegarProximasDuasBolasParaStrike() {
        return arremessos[bola + 1] + arremessos[bola + 2];
    }

    private int pegarProximasDuasBolas() {
        return pegarProximoArremesso() + arremessos[bola + 1];
    }

    private boolean isStrike() {
        return arremessos[bola] == STRIKE;
    }

    private int pegarProximoArremesso() {
        return arremessos[bola];
    }

    private boolean isSpare() {
        return pegarProximoArremesso() + arremessos[bola + 1] == 10;
    }

    public int getQuadroAtual() {
        return quadroAtual;
    }
}
