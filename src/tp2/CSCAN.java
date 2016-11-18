package tp2;

public class CSCAN implements DiskScheduler {

    private int[] requestString;
    private int numCilindros;
    private int initCilindro;

    public CSCAN(int[] requestString, int numCilindros, int initCilindro) {

        this.numCilindros = requestString.length;
        this.initCilindro = initCilindro;
        this.requestString = new int[requestString.length + 2];
        this.requestString[0] = 0;
        int i = 1;
        for (int request : requestString) {
            this.requestString[i] = request;
            i++;
        }
        this.requestString[i++] = initCilindro;

    }

    @Override
    public int serviceRequests() {

        int x = 0;
        int requisicao = 0;
        int total = 0;

        this.requestString[0] = 0;
        this.requestString[requisicao] = 199;
        this.requestString[requisicao++] = initCilindro;

        // Para cada requisiçao
        for (requisicao = 0; requisicao < numCilindros + 2; requisicao++) {

            // para cada uma das proximas requisicoes 
            for (int index = 0; index < numCilindros + 2 - requisicao; index++) {

                // Se o cilindro for maior que o proximo cilindro               
                if (index + 1 < this.requestString.length) {

                    if (this.requestString[index] > this.requestString[index + 1]) {

                        // troca as posicoes
                        int aux = this.requestString[index];
                        this.requestString[index] = this.requestString[index + 1];
                        this.requestString[index + 1] = aux;

                    }

                }

            }
        }

        // Para cada uma das requiscoes 
        for (requisicao = 0; requisicao < numCilindros + 2; requisicao++) {

            // Calcula a diferenca entre os cilindros
            if (requisicao + 1 < this.requestString.length) {
                x = this.requestString[requisicao] - this.requestString[requisicao + 1];

                if (x < 0) {
                    x = x * (-1);
                }
                total = total + x;

                // Se o cilindro atual for o cilindro inicial 
                if (this.requestString[requisicao] == initCilindro) {
                    total = total - x;
                }
            }

        }

        if (requisicao < this.requestString.length) {
            total = total + this.requestString[requisicao];
        }
        

        return total;

    }

    @Override
    public void printGraph(String filename) {
    }
}
