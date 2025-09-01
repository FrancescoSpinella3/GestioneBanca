import java.util.HashMap;
import java.util.Map;

public class Banca{
    private Map<Integer, Conto> conti;
    private int prossimoNumero;

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

    // Metodo Deposita
    public void efftuaDeposito(int numeroConto, double importo){
        Conto conto = conti.get(numeroConto);
        if (conto != null){
            conto.deposita(importo);
        } else {
            System.out.println("⚠️ Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
        }
    }

    // Metodo Preleva
    public void effettuaPrelievo(int numeroConto, double importo){
        Conto conto = conti.get(numeroConto);
        if (conto != null){
            conto.preleva(importo);
        } else {
            System.out.println("⚠️ Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
        }
    }

    // Metodo Visualizza saldo
    public void visualizzaSaldo(int numeroConto){
        Conto conto = conti.get(numeroConto);
        if (conto != null){
            System.out.println("Saldo del conto (" + numeroConto + "): €"  + conto.getSaldo());
        } else {
            System.out.println("⚠️ Errore: Il conto associato al numero conto (" + numeroConto + ") non è stato trovato o non esiste");
        }
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
}
