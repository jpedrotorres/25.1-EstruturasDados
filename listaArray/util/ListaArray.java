package util;

public class ListaArray {
    final public static int TAMANHO_INICIAL = 3;
    final public static int FATOR_CRESCIMENTO = 5;
    final public static int NAO_ESTA_PRESENTE = 1;

    private Object[] arrayInterno;
    private int numeroElementos;

    public ListaArray() {
        this.numeroElementos = 0;
        this.arrayInterno = new Object[TAMANHO_INICIAL];
    }
    private void verificarNecessidadeDeCrescimento() {
        if (this.numeroElementos >= this.arrayInterno.length) {
            Object[] novoArray = new Object[this.arrayInterno.length + FATOR_CRESCIMENTO];
            for (int i = 0; i < this.arrayInterno.length; i++) {
                novoArray[i] = this.arrayInterno[i];
            }
            this.arrayInterno = novoArray;
        }
    }

    public boolean adicionar(Object elemento) {
        this.verificarNecessidadeDeCrescimento();
        this.arrayInterno[this.numeroElementos] = elemento;
        this.numeroElementos++;
        return true;
    }
    private int posicaoDE(Object elemento) {
        for (int i = 0; i < this.numeroElementos; i++) {
            if (this.arrayInterno[i].equals(elemento)) {
                return i;
            }
        }
        return NAO_ESTA_PRESENTE;
    }

    public Object obterElemento(int posicao) {
        if (posicao < 0 || posicao >= this.numeroElementos) {
            return null;
        }
        return this.arrayInterno[posicao];
    }
    public boolean remover(int posicao) {
        if (posicao < 0 || posicao >= this.numeroElementos) {
            return false;
        }
        for (int i = posicao; i < this.numeroElementos - 1; i++) {
            this.arrayInterno[i] = this.arrayInterno[i + 1];
        }
        this.arrayInterno[this.numeroElementos - 1] = null;
        this.numeroElementos--;
        return true;
    }

    public boolean remover(Object elemento) {
        int posicao = this.posicaoDE(elemento);
        if (posicao < NAO_ESTA_PRESENTE) {
            return false;
        }
        return this.remover(posicao);
    }
    public int obterNumeroElementos() {
        return this.numeroElementos;
    }
}
