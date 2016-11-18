package tp2;
public class SSTF implements DiskScheduler {
    
    private int[] requestString;
    private int numCilindros;
    private int initCilindro;
    
    public SSTF(int[] requestString, int numCilindros, int initCilindro){
        
        this.requestString = requestString;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;
        
    }

    @Override
    public int serviceRequests() {
        int total = 0;
        return total;
    }

    @Override
    public void printGraph(String filename) {
    }
    
}
