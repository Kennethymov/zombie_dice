package br.com.ada.zombiedice.dado;

public class DadoAmarelo extends Dado {

    public DadoAmarelo() {
        super(new Face[]{
                Face.CEREBRO,
                Face.TIRO,
                Face.PASSOS,
                Face.CEREBRO,
                Face.TIRO,
                Face.PASSOS
        });
    }

    @Override
    public TipoDado getTipoDado() {
        return TipoDado.AMARELO;
    }
}
