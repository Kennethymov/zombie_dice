import br.com.ada.zombiedice.dado.Dado;
import br.com.ada.zombiedice.dado.DadoAmarelo;
import br.com.ada.zombiedice.dado.DadoVerde;
import br.com.ada.zombiedice.dado.DadoVermelho;
import br.com.ada.zombiedice.pote.PoteDado;

import java.util.ArrayList;
import java.util.List;

public class ZombieDice {

    public static void main(String[] args) {
        ArrayList<Dado> dados = new ArrayList<>();

        dados.add(new DadoVerde());
        dados.add(new DadoVerde());
        dados.add(new DadoVerde());
        dados.add(new DadoVerde());
        dados.add(new DadoVerde());
        dados.add(new DadoVerde());

        dados.add(new DadoAmarelo());
        dados.add(new DadoAmarelo());
        dados.add(new DadoAmarelo());
        dados.add(new DadoAmarelo());

        dados.add(new DadoVermelho());
        dados.add(new DadoVermelho());
        dados.add(new DadoVermelho());

        PoteDado pote = new PoteDado(dados);

        //Jogada um
        pote.embaralhar();
        List<Dado> dadosDoJogador = pote.entregarDado(3);
        for (Dado dado: dadosDoJogador) {
            dado.jogar();
            System.out.println(dado.getFaceSorteada());
        }
        pote.devolverDado(dadosDoJogador);

        System.out.println("--------");

        pote.embaralhar();
        dadosDoJogador = pote.entregarDado(2);
        for (Dado dado: dadosDoJogador) {
            dado.jogar();
            System.out.println(dado.getFaceSorteada());
        }
        pote.devolverDado(dadosDoJogador);
    }


}
