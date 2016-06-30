package com.agileppp.jogo;

public class Jogo {

    private static final int STRIKE = 10;
    private int[] arremessos = new int[21];
    private int jogadaAtual;
    private int quadroAtual = 1;
    private boolean primeiraJogada = true;

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
        int pontuacao = 0;
        int bola = 0;
        for(int quadroAtual = 0; quadroAtual < quadro; quadroAtual++) {
            int primeiroArremesso = arremessos[bola++];
            if(primeiroArremesso == STRIKE) {
                pontuacao += 10 + arremessos[bola] + arremessos[bola+1];
            } else {
                int segundoArremesso = arremessos[bola++];

                int pontuacaoDoQuadro = primeiroArremesso + segundoArremesso;

                if (pontuacaoDoQuadro == 10) {
                    pontuacao += pontuacaoDoQuadro + arremessos[bola];
                } else {
                    pontuacao += pontuacaoDoQuadro;
                }
            }
        }
        return pontuacao;
    }

    public int getQuadroAtual() {
        return quadroAtual;
    }
}
