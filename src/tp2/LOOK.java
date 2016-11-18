package tp2;

public class LOOK implements DiskScheduler {

    private int[] requestString;
    private int numCilindros;
    private int initCilindro;

    public LOOK(int initCilindro, int numCilindros, int[] requestString) {
        this.requestString = new int[requestString.length + 1];
        int i = 0;
        for (int request : requestString) {
            this.requestString[i] = request;
            i++;
        }
        this.requestString[i++] = initCilindro;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;
    }

    @Override
    public int serviceRequests() {
        int temp;
        int aux = 0;
        int movimentos = 0;
        
        for (int i = 0; i < this.requestString.length - 2; i++) {
            for (int i2 = 0; i < this.requestString.length - 2 - i; i++) {
                if (this.requestString[i] > this.requestString[i + 1]) {
                    temp = this.requestString[i];
                    this.requestString[i] = this.requestString[i + 1];
                    this.requestString[i + 1] = temp;
                }
            }
        }
        
        for (int i = 0; i < this.requestString.length - 1; i++) {
            if (this.requestString[i] == initCilindro) {
                aux = i;
            }
        }
        int i;
        for (i = aux; i < this.requestString.length - 1; i++) {
            int head = this.requestString[i] - this.requestString[i + 1];
            if (head < 0) {
                head = head * (-1);
            }
            movimentos = movimentos + head;
        }
        int head = this.requestString[i] - this.requestString[0];
        movimentos = movimentos + head;
        
        for (int index = 0; index < aux - 1; index++) {
            head = this.requestString[index] - this.requestString[index + 1];
            if (head < 0)
                head = head * (-1);
            movimentos = movimentos + head;
        }
        return movimentos;

    }

    @Override
    public void printGraph(String filename) {
    }
}
