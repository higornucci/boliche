package com.agileppp.jogo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JogoTeste {

    private static final int ZERO_PINO = 0;
    private static final int UM_PINO = 1;
    private static final int DOIS_PINOS = 2;
    private static final int TRES_PINOS = 3;
    private static final int QUATRO_PINOS = 4;
    private static final int CINCO_PINOS = 5;
    private static final int SEIS_PINOS = 6;
    private static final int SETE_PINOS = 7;
    private static final int OITO_PINOS = 8;
    private static final int NOVE_PINOS = 9;
    private static final int DEZ_PINOS = 10;
    private Jogo jogo;

    @Before
    public void init() {
        jogo = new Jogo();
    }

    @Test
    public void deve_calcular_pontuacao_de_duas_jogadas_sem_spare() {
        int pontuacaoEsperada = 9;
        int quadroAtualEsperado = 2;

        jogo.adicionar(CINCO_PINOS);
        jogo.adicionar(QUATRO_PINOS);

        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
        assertThat(jogo.getQuadroAtual(), is(equalTo(quadroAtualEsperado)));
    }

    @Test
    public void deve_calcular_pontuacao_de_quatro_jogadas_sem_spare() {
        int pontuacaoEsperadaJogo = 18;
        int pontuacaoEsperadaQuadro1 = 9;
        int pontuacaoEsperadaQuadro2 = 18;
        int quadroAtualEsperado = 3;

        jogo.adicionar(CINCO_PINOS);
        jogo.adicionar(QUATRO_PINOS);
        jogo.adicionar(SETE_PINOS);
        jogo.adicionar(DOIS_PINOS);

        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperadaJogo)));
        assertThat(jogo.getPontuacaoDoQuadro(1), is(equalTo(pontuacaoEsperadaQuadro1)));
        assertThat(jogo.getPontuacaoDoQuadro(2), is(equalTo(pontuacaoEsperadaQuadro2)));
        assertThat(jogo.getQuadroAtual(), is(equalTo(quadroAtualEsperado)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_spare_simples() {
        int pontuacaoEsperadaQuadro1 = 13;
        int quadroAtualEsperado = 2;

        jogo.adicionar(TRES_PINOS);
        jogo.adicionar(SETE_PINOS);
        jogo.adicionar(TRES_PINOS);

        assertThat(jogo.getPontuacaoDoQuadro(1), is(equalTo(pontuacaoEsperadaQuadro1)));
        assertThat(jogo.getQuadroAtual(), is(equalTo(quadroAtualEsperado)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_quadro_depois_de_um_spare() {
        int pontuacaoEsperadaQuadro1 = 13;
        int pontuacaoEsperadaQuadro2 = 18;
        int pontuacaoEsperada = 18;
        int quadroAtualEsperado = 3;

        jogo.adicionar(TRES_PINOS);
        jogo.adicionar(SETE_PINOS);
        jogo.adicionar(TRES_PINOS);
        jogo.adicionar(DOIS_PINOS);

        assertThat(jogo.getPontuacaoDoQuadro(1), is(equalTo(pontuacaoEsperadaQuadro1)));
        assertThat(jogo.getPontuacaoDoQuadro(2), is(equalTo(pontuacaoEsperadaQuadro2)));
        assertThat(jogo.getQuadroAtual(), is(equalTo(quadroAtualEsperado)));
        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_strike() throws Exception {
        int pontuacaoEsperadaQuadro1 = 19;
        int pontuacaoEsperada = 28;
        int quadroAtualEsperado = 3;

        jogo.adicionar(DEZ_PINOS);
        jogo.adicionar(TRES_PINOS);
        jogo.adicionar(SEIS_PINOS);

        assertThat(jogo.getPontuacaoDoQuadro(1), is(equalTo(pontuacaoEsperadaQuadro1)));
        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
        assertThat(jogo.getQuadroAtual(), is(equalTo(quadroAtualEsperado)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_jogo_perfeito() throws Exception {
        int pontuacaoEsperada = 300;
        int quadroAtualEsperado = 11;

        for(int i = 0; i < 12; i++)
            jogo.adicionar(DEZ_PINOS);

        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
        assertThat(jogo.getQuadroAtual(), is(equalTo(quadroAtualEsperado)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_jogo_completo() throws Exception {
        int pontuacaoEsperada = 133;

        jogo.adicionar(UM_PINO);
        jogo.adicionar(QUATRO_PINOS);
        jogo.adicionar(QUATRO_PINOS);
        jogo.adicionar(CINCO_PINOS);
        jogo.adicionar(SEIS_PINOS);
        jogo.adicionar(QUATRO_PINOS);
        jogo.adicionar(CINCO_PINOS);
        jogo.adicionar(CINCO_PINOS);
        jogo.adicionar(DEZ_PINOS);
        jogo.adicionar(ZERO_PINO);
        jogo.adicionar(UM_PINO);
        jogo.adicionar(SETE_PINOS);
        jogo.adicionar(TRES_PINOS);
        jogo.adicionar(SEIS_PINOS);
        jogo.adicionar(QUATRO_PINOS);
        jogo.adicionar(DEZ_PINOS);
        jogo.adicionar(DOIS_PINOS);
        jogo.adicionar(OITO_PINOS);
        jogo.adicionar(SEIS_PINOS);

        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_ataque_de_coracao() throws Exception {
        int pontuacaoEsperada = 299;

        for(int i = 0; i < 11; i++)
            jogo.adicionar(DEZ_PINOS);
        jogo.adicionar(NOVE_PINOS);

        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
    }

    @Test
    public void deve_calcular_pontuacao_de_um_spare_no_decimo_quadro() throws Exception {
        int pontuacaoEsperada = 270;

        for(int i = 0; i < 9; i++)
            jogo.adicionar(DEZ_PINOS);
        jogo.adicionar(NOVE_PINOS);
        jogo.adicionar(UM_PINO);
        jogo.adicionar(UM_PINO);

        assertThat(jogo.getPontuacao(), is(equalTo(pontuacaoEsperada)));
    }
}
