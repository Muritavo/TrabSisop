/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;
public class SCAN implements DiskScheduler{

    private int numberOfProcess;
    private int initialMovement;
    private int[] requests;

    public SCAN(int initialMovement, int numeroCilindros, int[] requests) {
        this.numberOfProcess = requests.length;
        this.initialMovement = initialMovement;
        this.requests = new int[requests.length + 2];
        this.requests[0] = 0;
        int i = 1;
        for (int request : requests) {
            this.requests[i] = request;
            i++;
        }
        this.requests[i++] = initialMovement;
    }
 

    @Override
    public int serviceRequests() {
        
        int x = 0;
        int requisicao = 0;
        int total = 0;

        this.requests[0] = 0;

        this.requests[requisicao] = initialMovement;

        // Para cada requisiçao
        for (requisicao = 0; requisicao < numberOfProcess + 1; requisicao++) {

            // para cada uma das proximas requisicoes 
            for (int index = 0; index < numberOfProcess - requisicao + 1; index++) {

                // Se o cilindro for maior que o proximo cilindro
                if (this.requests[index] > this.requests[index + 1]) {

                    // troca as posicoes
                    int aux = this.requests[index];
                    this.requests[index] = this.requests[index + 1];
                    this.requests[index + 1] = aux;

                }
            }
        }

        // Para cada uma das requiscoes 
        for (requisicao = 0; requisicao < numberOfProcess + 1; requisicao++) {

            // Calcula a diferenca entre os cilindros
            x = this.requests[requisicao + 1] - this.requests[requisicao];
            total = total + x;

            // Se o cilindro atual for o cilindro inicial 
            if (this.requests[requisicao] == initialMovement) {
                total = total - x;
                total = total + this.requests[requisicao + 1];
            }
        }
        
        return total;
        
    }

    @Override
    public void printGraph(String filename) {
        
    }

}
