package com.agileppp.quadro;

import com.agileppp.excecao.MaximoPinosUltrapassadoException;

class Quadro {
    private static final int MAXIMO_PINOS = 10;

    private int pontuacao = 0;

    int getPontuacao() {
        return this.pontuacao;
    }

    void adicionar(int pinosDerrubados) throws MaximoPinosUltrapassadoException {
        int novaPontuacao = this.pontuacao + pinosDerrubados;
        if(novaPontuacao > MAXIMO_PINOS) {
            throw new MaximoPinosUltrapassadoException();
        } else {
            this.pontuacao = novaPontuacao;
        }
    }
}
