package br.com.ada.zombiedice.jogo;

import br.com.ada.zombiedice.dado.Dado;
import br.com.ada.zombiedice.dado.Face;
import br.com.ada.zombiedice.pote.PoteDado;
import br.com.ada.zombiedice.zumbi.Zumbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turno {

    private List<Dado> dadosUtilizadosNoTurno;
    private int qtdeCerebros;
    private int qtdeTiros;
    private Zumbi jogador;
    private PoteDado pote;

    public Turno(Zumbi jogador, PoteDado pote) {
        this.jogador = jogador;
        this.pote = pote;
        this.qtdeCerebros = 0;
        this.qtdeTiros = 0;
        this.dadosUtilizadosNoTurno = new ArrayList<>();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        String continuarJogando = "n";
        ArrayList<Dado> dadosASeremRelancados = new ArrayList<>();
        do {
            System.out.println("Jogador " + jogador.getNome() +
                    " é sua vez, realize uma jogada.");
            List<Dado> dadosLancados = jogador.lancarDados(pote, dadosASeremRelancados);
            dadosASeremRelancados.clear();
            for (Dado dado : dadosLancados) {
                System.out.println("Você lançou o dado " + dado.getTipoDado() +
                        " e obteve o resultado " + dado.getFaceSorteada());
                boolean dadoContabilizado = contabilizarDadoJogado(dado);
                if (!dadoContabilizado) {
                    dadosASeremRelancados.add(dado);
                }
            }
            boolean forcarEncerramento = forcarEncerramentoTurno();
            if (forcarEncerramento) {
                break;
            }
            System.out.println("Pontuação atual no turno: " + qtdeCerebros +
                    " cerebros consumidos, " + qtdeTiros + " tiros levados");
            System.out.println(jogador.getNome() + " deseja jogar novamente?(s/n)");
            continuarJogando = scanner.nextLine();
        } while (continuarJogando.equalsIgnoreCase("s"));
        contabilizarTurno();
        pote.devolverDado(dadosUtilizadosNoTurno);
        pote.devolverDado(dadosASeremRelancados);
    }

    private boolean forcarEncerramentoTurno() {
        return qtdeTiros >= 3 || qtdeCerebros >= 13;
    }

    private boolean contabilizarDadoJogado(Dado dado) {
        boolean contabilizado = dado.getFaceSorteada() != Face.PASSOS;
        if (contabilizado) {
            dadosUtilizadosNoTurno.add(dado);
            if (dado.getFaceSorteada() == Face.CEREBRO) {
                System.out.println("Yeah, você consumiu mais um cerebro");
                qtdeCerebros++;
            } else {
                System.out.println("Mal dia, levou um tiro");
                qtdeTiros++;
            }
        } else {
            System.out.println("Vai precisar correr mais, sua presa fugiu");
        }
        return contabilizado;
    }

    private void contabilizarTurno() {
        if (qtdeTiros < 3) {
            int qtdeCerebrosAtual = jogador.getQtdeCerebros();
            int novaQtdeCerebrosConsumidos = qtdeCerebrosAtual + qtdeCerebros;
            jogador.setQtdeCerebros(novaQtdeCerebrosConsumidos);
            System.out.println("Contabilizado turno do jogador: " + jogador.getNome() +
                    ", encerrado com um total de " + novaQtdeCerebrosConsumidos +
                    " cerebros consumidos");
        }
    }

}
