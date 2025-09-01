import java.util.ArrayList;

public class Banca{
    ArrayList<Banca> conti;

    public Banca(){
        conti = new ArrayList<>();
    }

    public void creaConto(String intestatario, int numeroConto){
        conti.add(new Conto(intestatario, numeroConto));
        System.out.println("Conto creato con successo");
    }

    public void eliminaConto(int numeroConto){
        for (Conto conto : conti){
            if (numeroConto == conto.getNumeroConto()){
                conti.remove(conto);
                System.out.println("Conto eliminato con successo");
            } else {
                System.out.println("Il conto associato al numero conto " + numeroConto + " non è stato trovato o non esiste");
            }
        }
    }
}
