package tp2;


/* Skeleton do trabalho TP2. */

public class TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Leia requestString, número de cilindros e cilindro inicial 
           do arquivo de entrada conforme o formato especificado no trabalho.
           O arquivo de entrada é passado por args. */
        
        int[] requestString = {70, 80, 90, 40, 30};
        int numCilindros = 200;
        int initCilindro = 50;
        
        DiskScheduler scan = new SCAN(initCilindro, numCilindros, requestString);
        System.out.println("Número de cilindros percorridos: " + scan.serviceRequests());
        
        DiskScheduler clook = new LOOK(initCilindro, numCilindros, requestString);
        System.out.println("Número de cilindros percorridos: " + clook.serviceRequests());
        
        DiskScheduler cscan = new CSCAN(requestString, numCilindros, initCilindro);
        System.out.println("Número de cilindros percorridos: " + cscan.serviceRequests());
        
        DiskScheduler fcfs = new FCFS(requestString, numCilindros, initCilindro);
        System.out.println("Número de cilindros percorridos: " + fcfs.serviceRequests());
        fcfs.printGraph("fcfs.jpg");
        
   }
    
}
