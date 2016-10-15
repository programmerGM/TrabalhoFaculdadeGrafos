package Objetos;

/**
 * Estudantes de Ciência da Computação - 4 fase.
 *
 * @author Luan Darabas
 * @author Luiz Alexandre da Luz
 * @author Maurício Generoso
 */
public class MatrizAdj extends Matriz {

    
    public void alterarMatrizGrafoDirecionado(int noInicial, int noFinal) {
        matriz[noInicial][noFinal] += 1;
        System.out.println("Matriz de adjacência - Grafo direcionado: ");
        this.imprimirMatriz();
    }
    
    public void alterarMatrizGrafoNaoDirecionado(int noInicial, int noFinal) {
        if (noInicial == noFinal){
            // Se houver laço só irá armazenar uma vez
            matriz[noInicial][noFinal] += 1;
        } else {
            matriz[noInicial][noFinal] += 1;
            matriz[noFinal][noInicial] += 1;
        }
        System.out.println("Matriz de adjacência - Grafo não direcionado: ");
        this.imprimirMatriz();
    }
    
}
