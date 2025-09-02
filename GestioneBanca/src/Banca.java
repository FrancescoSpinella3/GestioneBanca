import java.util.HashMap;
import java.util.Map;

public class Banca{
    private Map<Integer, Conto> conti;
    private int prossimoNumero;
    private Conto contoCorrente;

    public Banca(){
        conti = new HashMap<>();
        prossimoNumero = 1;

    }

    // Metodo crea conto
    public void creaConto(String intestatario){
        Conto conto = new Conto(intestatario, prossimoNumero);
        conti.put(prossimoNumero, conto);
        System.out.println("✅ Conto creato con successo");
        prossimoNumero++;
    }

    // Metodo per accedere al conto
    public boolean accedi(int numeroConto){
        Conto conto = conti.get(numeroConto);
        if (conto == null){
            System.out.println("⚠️ Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
            return false;
        }
        contoCorrente = conto;
        String intestatario = conto.getIntestatario();
        System.out.println("✅ Accesso confermato");
        System.out.println("Benvenuto " + intestatario);
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
        Conto conto = conti.get(numeroConto);
        if (conto != null){
            conti.remove(numeroConto);
            System.out.println("✅ Conto eliminato con successo");
        } else {
            System.out.println("⚠️ Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
        }
    }

    // Metodo effettua pagamanto
    public void effettuaPagamento(int numeroContoRicevente, double importo){
        Conto contoRicevente = conti.get(numeroContoRicevente);
        if (contoRicevente == null){
            System.out.println("⚠️ Errore: Il conto (" + contoRicevente + ") non è stato trovato o non esiste");
            return;
        }
        if (contoCorrente.getSaldo() < importo){
            System.out.println("⚠️ Errore: impossibile effettuare il pagamento, saldo insufficiente");
            return;
        }

        contoCorrente.preleva(importo, false);
        contoRicevente.deposita(importo, false);
        System.out.println("✅ Pagamento di € " + importo + " verso il conto (" + contoRicevente.getNumeroConto() + ") avvenuto con successo");
    }
}
