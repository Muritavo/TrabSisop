package tp2;

public class LOOK implements DiskScheduler {

    private int[] requestString;
    private int numCilindros;
    private int initCilindro;

    public LOOK(int[] requestString, int numCilindros, int initCilindro) {

        this.requestString = requestString;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;

    }

    @Override
    public int serviceRequests() {
        return 0;
    }

    @Override
    public void printGraph(String filename) {
    }
}
