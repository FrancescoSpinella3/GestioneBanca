import java.util.HashMap;
import java.util.Map;

public class Banca{
    private Map<Integer, Conto> conti;
    private int prossimoNumero;
    private Conto contoCorrente;

    public Banca(){
        conti = new HashMap<>();
        prossimoNumero = 1; // Valore di partenza del numero conto

    }

    // Metodo crea conto
    public void creaConto(String intestatario){
        Conto conto = new Conto(intestatario, prossimoNumero);
        conti.put(prossimoNumero, conto); // Aggiungo conto alla lista conti
        System.out.println("Conto creato con successo");
        prossimoNumero++; // Incremento il numero del conto ogni volta che ne viene creato uno nuovo
    }

    // Metodo per il login al conto
    public boolean accedi(int numeroConto){
        Conto conto = conti.get(numeroConto); // Ricevo il numero del conto
        // Se il conto non viene trovato manda a schermo un errore
        if (conto == null){
            System.out.println("Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
            return false;
        }
        contoCorrente = conto; // Assegno alla variabile contoCorrente il conto su cui si vuole operare
        System.out.println("Accesso confermato");
        System.out.println("Benvenuto " + conto.getIntestatario());
        return true;
    }

    // Metodo Deposita
    public void efftuaDeposito(double importo){
        contoCorrente.deposita(importo, true);
    }

    // Metodo Preleva
    public void effettuaPrelievo(double importo){
        contoCorrente.preleva(importo, true);
    }

    // Metodo Visualizza saldo
    public void visualizzaSaldo(){
        System.out.println("Il tuo saldo attuale: € " + contoCorrente.getSaldo());
    }

    // Metodo informazioni conto
    public void informazioniConto(){
        System.out.println("Numero conto: " + contoCorrente.getNumeroConto() +"\nIntestatario: " + contoCorrente.getIntestatario());
    }

    // Metodo elimina conto
    public void eliminaConto(int numeroConto){
        Conto conto = conti.get(numeroConto); // Ricevo il numero del conto
        // Se il conto viene trovato lo elimina, altrimenti manda a schermo un errore
        if (conto != null){
            conti.remove(numeroConto);
            System.out.println("Conto eliminato con successo");
        } else {
            System.out.println("Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
        }
    }

    // Metodo effettua pagamanto
    public void effettuaPagamento(int numeroContoRicevente, double importo){
        Conto contoRicevente = conti.get(numeroContoRicevente); // Ricevo il numero del conto del destinatario
        // Se il conto del destinatario non viene trovato manda a schermo un errore
        if (contoRicevente == null){
            System.out.println("Errore: Il conto (" + contoRicevente + ") non è stato trovato o non esiste");
            return; // Ritorna al menu
        }
        // Se il saldo del mittende è minore dell'importo da pagare manda a schermo un errore
        if (contoCorrente.getSaldo() < importo){
            System.out.println("Errore: impossibile effettuare il pagamento, saldo insufficiente");
            return; // Ritorna al menu
        }

        // Se tutti i controlli vanno a buon fine effettua l'operazione
        contoCorrente.preleva(importo, false); // Prelevo l'importo dal conto del mittente
        contoRicevente.deposita(importo, false); // E lo depostio sul conto del destinatario
        System.out.println("Pagamento di € " + importo + " verso il conto (" + contoRicevente.getNumeroConto() + ") avvenuto con successo");
    }
}
