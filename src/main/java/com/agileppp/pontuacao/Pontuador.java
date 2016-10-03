package com.agileppp.pontuacao;

import com.agileppp.jogo.Jogo;

public class Pontuador {

    private int bola;
    private int[] arremessos = new int[21];
    private int jogadaAtual;

    public void adicionarJogada(int pinosDaJogada) {
        this.arremessos[jogadaAtual++] = pinosDaJogada;
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

    private int pegarProximasDuasBolasParaStrike() {
        return arremessos[bola + 1] + arremessos[bola + 2];
    }

    private int pegarProximoArremessoParaSpare() {
        return arremessos[bola + 2];
    }

    private boolean isStrike() {
        return arremessos[bola] == Jogo.STRIKE;
    }

    private int pegarProximasDuasBolas() {
        return pegarProximoArremesso() + arremessos[bola + 1];
    }

    private int pegarProximoArremesso() {
        return arremessos[bola];
    }

    private boolean isSpare() {
        return pegarProximoArremesso() + arremessos[bola + 1] == 10;
    }
}
