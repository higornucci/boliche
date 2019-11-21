package com.agileppp.quadro;

import com.agileppp.excecao.MaximoPinosUltrapassadoException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuadroTeste {

    @Test
    public void nao_deve_conter_pontuacao_caso_nao_haja_jogada() {
        int pontuacaoEsperada = 0;
        Quadro quadro = new Quadro();
        assertThat(quadro.getPontuacao(), is(equalTo(pontuacaoEsperada)));
    }

    @Test
    public void deve_adicionar_os_pinos_de_uma_jogada() throws MaximoPinosUltrapassadoException {
        // arrange
        int pinosDaJogada = 5;
        int pontuacaoEsperada = 5;
        Quadro quadro = new Quadro();

        // action
        quadro.adicionar(pinosDaJogada);

        // assert
        assertThat(quadro.getPontuacao(), is(equalTo(pontuacaoEsperada)));
    }

    @Test(expected = MaximoPinosUltrapassadoException.class)
    public void nao_deve_ultrapassar_o_maximo_de_pinos_por_quadro() throws MaximoPinosUltrapassadoException {
        int pinosDaJogada1 = 5;
        int pinosDaJogada2 = 6;

        Quadro quadro = new Quadro();
        quadro.adicionar(pinosDaJogada1);
        quadro.adicionar(pinosDaJogada2);
    }
}
