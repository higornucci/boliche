package com.agileppp.quadro;

public class Quadro {

    private int pontuacao = 0;

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void adicionar(int pinosDerrubados) {
        this.pontuacao += pinosDerrubados;
    }
}
