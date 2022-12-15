package br.com.ada.zombiedice.zumbi;

import br.com.ada.zombiedice.dado.Dado;
import br.com.ada.zombiedice.pote.PoteDado;

import java.util.List;

public class Zumbi {

    private String nome;
    private int qtdeCerebros;
    private int qtdeTiros;

    public Zumbi(String nome) {
        this.nome = nome;
        this.qtdeCerebros = 0;
        this.qtdeTiros = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setQtdeCerebros(int qtdeCerebros) {
        this.qtdeCerebros = qtdeCerebros;
    }

    public int getQtdeCerebros() {
        return qtdeCerebros;
    }

    public void setQtdeTiros(int qtdeTiros) {
        this.qtdeTiros = qtdeTiros;
    }

    public int getQtdeTiros() {
        return qtdeTiros;
    }

    public List<Dado> lancarDados(PoteDado pote, List<Dado> dadosSortearamPassosNaJogadaAnterior) {
        return null;
    }

}
