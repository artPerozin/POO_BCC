package Semana8.Exercicio2;

import java.util.ArrayList;
import java.util.List;

enum Quadrante {
    PRIMEIRO,
    SEGUNDO,
    TERCEIRO,
    QUARTO
}

public class Matriz<T> {
    private int n;
    private int m;
    private T[][] elementos;

    @SuppressWarnings("unchecked")
    public Matriz(int n, int m) {
        this.n = n;
        this.m = m;
        this.elementos = (T[][]) new Object[n][m];
    }

    public boolean set(T objeto, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        elementos[i][j] = objeto;
        return true;
    }

    public T get(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return null;
        }
        return elementos[i][j];
    }

    public List<T> getLinha(int linha) {
        List<T> lista = new ArrayList<>();
        if (linha < 0 || linha >= n) return lista;

        for (int j = 0; j < m; j++) {
            lista.add(elementos[linha][j]);
        }
        return lista;
    }

    public List<T> getColuna(int coluna) {
        List<T> lista = new ArrayList<>();
        if (coluna < 0 || coluna >= m) return lista;

        for (int i = 0; i < n; i++) {
            lista.add(elementos[i][coluna]);
        }
        return lista;
    }

    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> lista = new ArrayList<>();

        int meioLinha = n / 2;
        int meioColuna = m / 2;

        int linhaInicio = 0, linhaFim = 0;
        int colunaInicio = 0, colunaFim = 0;

        switch (quadrante) {
            case PRIMEIRO:
                linhaInicio = 0;
                linhaFim = meioLinha;
                colunaInicio = 0;
                colunaFim = meioColuna;
                break;
            case SEGUNDO:
                linhaInicio = 0;
                linhaFim = meioLinha;
                colunaInicio = meioColuna;
                colunaFim = m;
                break;
            case TERCEIRO:
                linhaInicio = meioLinha;
                linhaFim = n;
                colunaInicio = 0;
                colunaFim = meioColuna;
                break;
            case QUARTO:
                linhaInicio = meioLinha;
                linhaFim = n;
                colunaInicio = meioColuna;
                colunaFim = m;
                break;
        }

        for (int i = linhaInicio; i < linhaFim; i++) {
            for (int j = colunaInicio; j < colunaFim; j++) {
                lista.add(elementos[i][j]);
            }
        }

        return lista;
    }
}
