package com.agileppp.excecao;

public class MaximoPinosUltrapassadoException extends Exception {
    public MaximoPinosUltrapassadoException() {
        super("Quantidade máxima de pinos ultrapassada.");
    }
}
