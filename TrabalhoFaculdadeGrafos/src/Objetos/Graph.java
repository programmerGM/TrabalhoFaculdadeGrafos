package Objetos;

import Objetos.Armazenamento.AdjacencyElement;
import Objetos.Armazenamento.IncidencyElement;
import Objetos.Armazenamento.IncidenceMatrix;
import Objetos.Armazenamento.AdjacencyMatrix;
import Objetos.Armazenamento.Matrix;
import java.util.LinkedList;

/**
 * Classe para armazenar a Matriz e lista de Adjacência e Incidência. O
 * armazenamento direcionado ou não direcionado é feito de acordo com a opção
 * que o usuário seleciona na criação do grafo. Se selecionar direcionado a
 * matriz será criada com caracteristicas de direcionada, e assim por diante
 * para todos os demais casos.
 *
 * Estudantes de Ciência da Computação - 4 fase.
 *
 * @author Gustavo Souza
 * @author Luan Darabas
 * @author Luiz Alexandre da Luz
 * @author Maurício Generoso
 *
 * @since 15/10/2016
 * @version 1.7
 */
public class Graph implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    // Matrizes
    private Matrix matrizAdj;
    private Matrix matrizInc;

    // Listas
    private LinkedList<AdjacencyElement>[] listaAdj;
    private LinkedList<IncidencyElement>[] listaInc;

    // Nós e arestas
    private String[] nos;
    private String[] arestas;

    /**
     * Construtor.
     */
    public Graph() {
        matrizAdj = null;
        matrizInc = null;

        listaAdj = null;
        listaInc = null;

        nos = null;
        arestas = null;
    }

    /**
     * Retorna mariz de adjacencia.
     *
     * @return Matriz de adjacencia
     */
    public Matrix getMatrizAdj() {
        return matrizAdj;
    }

    /**
     * Retorna mariz de incidência.
     *
     * @return Matriz de incidência
     */
    public Matrix getMatrizInc() {
        return matrizInc;
    }

    /**
     * Lista de adjacencia.
     *
     * @return Lista de elementos da lista de adjacencia
     */
    public LinkedList<AdjacencyElement>[] getListaAdj() {
        return listaAdj;
    }

    /**
     * Lista de incidência.
     *
     * @return Lista de elementos da lista de incidência
     */
    public LinkedList<IncidencyElement>[] getListaInc() {
        return listaInc;
    }

    /**
     * Retorna Nós.
     *
     * @return String[] de nós
     */
    public String[] getNos() {
        return nos;
    }

    /**
     * Atribui Nós.
     *
     * @param nos String[] - Array de strings para setar nós
     */
    public void setNos(String[] nos) {
        this.nos = nos;
    }

    /**
     * Retorna arestas.
     *
     * @return String[] de arestas
     */
    public String[] getArestas() {
        return arestas;
    }

    /**
     * Atrubui arestas.
     *
     * @param arestas String[] - Array de strings para setar arestas
     */
    public void setArestas(String[] arestas) {
        this.arestas = arestas;
    }

    /**
     * Retorna nó da posição.
     *
     * @param posicao int - Posição do nó solicitado
     * @return String - Nome do nó na posição
     */
    public String getNoPosicao(int posicao) {
        return nos[posicao];
    }

    /**
     * Retorna aresta da posição.
     *
     * @param posicao int - Posição da aresta solicitado
     * @return String - Nome da aresta na posição
     */
    public String getArestaPosicao(int posicao) {
        return arestas[posicao];
    }

    /**
     * Retorna a quantidade de nós.
     *
     * @return int - Quantidade de nó
     */
    public int quantidadeNos() {
        return nos.length;
    }

    /**
     * Nó é vazio.
     *
     * @return boolean - Verdadeiro se estiver vazio, caso contrário falso
     */
    public boolean noIsEmpty() {
        return nos == null;
    }

    /**
     * Retorna a quantidade de arestas.
     *
     * @return int - Quantidade de arestas
     */
    public int quantidadeArestas() {
        return arestas.length;
    }

    /**
     * Inicia a matriz.
     *
     * @param mt Matriz - A matriz que será iniciada
     * @param qntLinhas int - Quantidade de linhas
     * @param qntColunas int - Quantidade de colunas
     */
    public void iniciarMatriz(Matrix mt, int qntLinhas, int qntColunas) {
        if (mt instanceof AdjacencyMatrix) {
            mt = new AdjacencyMatrix();
            mt.iniciarMatriz(qntLinhas, qntColunas);
            matrizAdj = mt;
        } else if (mt instanceof IncidenceMatrix) {
            mt = new IncidenceMatrix();
            mt.iniciarMatriz(qntLinhas, qntColunas);
            matrizInc = mt;
        }
    }

    /**
     * Inicia as listas.
     */
    public void iniciarListas() {
        listaAdj = new LinkedList[quantidadeNos()];
        for (int i = 0; i < quantidadeNos(); i++) {
            listaAdj[i] = new LinkedList<>();
        }

        listaInc = new LinkedList[quantidadeNos()];
        for (int i = 0; i < quantidadeNos(); i++) {
            listaInc[i] = new LinkedList<>();
        }
    }

    /**
     * Destroi o grafo.
     */
    public void destruirGrafo() {
        nos = null;
        arestas = null;
        matrizAdj = null;
        matrizInc = null;
        listaAdj = null;
        listaInc = null;
    }

    /**
     * Altera a matriz do grafo não direcionado.
     *
     * @param mt Matriz - Matriz a ser alterada
     * @param noInicial int - Nó inicial
     * @param noFinal int - Nó final
     * @param aresta int - Aresta
     */
    public void alterarMatrizGrafoNaoDirecionado(Matrix mt, int noInicial, int noFinal, int aresta) {
        if (mt instanceof AdjacencyMatrix) {
            ((AdjacencyMatrix) mt).alterarMatrizGrafoNaoDirecionado(noInicial, noFinal);
        } else if (mt instanceof IncidenceMatrix) {
            ((IncidenceMatrix) mt).alterarMatrizGrafoNaoDirecionado(noInicial, noFinal, aresta);
        }
    }

    /**
     * Imprimi a lista Este método iŕá chamar o toString() da classe "Lista"
     * para cada posição do array(listaInc[i]). O toString() da classe Lista irá
     * imprimir cada elemento presente em tal posição do vetor, ou seja, a outra
     * lista(chamando o toString de cada elemento);
     *
     * @param lt Lista - Lista a ser impressa
     */
    public void imprimirLista(LinkedList[] lt) {
        for (int i = 0; i < quantidadeNos(); i++) {
            System.out.println(nos[i] + " -> " + lt[i]);
        }
    }

    /**
     * Captura posição de um nó em uma lista
     *
     * @param no String - nó a ser pesquisado
     * @return posição do nó solicitado
     */
    private int posicaoLista(String no) {
        for (int i = 0; i < quantidadeNos(); i++) {
            if (nos[i].equals(no)) {
                return i;
            }
        }
        System.out.println("OCORREU UM ERRO");
        return -1;
    }

    /**
     * Altera a lista do grafo não direcionado.
     *
     * @param noInicial int - Nó inicial
     * @param noFinal int - Nó final
     * @param aresta int - Aresta
     */
    public void alterarListaGrafoNaoDirecionado(String noInicial, String noFinal, String aresta) {
        if (noInicial.equals(noFinal)) {
            listaAdj[posicaoLista(noInicial)].add(new AdjacencyElement(noFinal));

            listaInc[posicaoLista(noInicial)].add(new IncidencyElement(noFinal, aresta)); //uni os dois para não ter 2 ifs com mesmo resultado, desnecessário
        } else {
            listaAdj[posicaoLista(noInicial)].add(new AdjacencyElement(noFinal));
            listaAdj[posicaoLista(noFinal)].add(new AdjacencyElement(noInicial));

            listaInc[posicaoLista(noInicial)].add(new IncidencyElement(noFinal, aresta));
            listaInc[posicaoLista(noFinal)].add(new IncidencyElement(noInicial, aresta));
        }
        System.out.println("Lista de Adjacência não direcionada: ");
        imprimirLista(listaAdj);

        System.out.println("Lista de Incidência não direcionada: ");
        imprimirLista(listaInc);
    }

}