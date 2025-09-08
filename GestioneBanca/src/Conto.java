public class Conto implements Transazioni{
    private String intestatario;
    private int numeroConto;
    private String email;
    private String password;
    private double saldo;

    public Conto(String intestatario, int numeroConto, String email, String password){
        this.intestatario = intestatario;
        this.numeroConto = numeroConto;
        this.email = email;
        this.password = password;
        this.saldo = 0.0;
    }

    // Metodo getter dell'intestatario
    public String getIntestatario(){
        return intestatario;
    }

    // Metodo getter del numero conto
    public int getNumeroConto(){
        return numeroConto;
    }

    // Metodo getter dell'email
    public String getEmail(){return  email;}

    // Metodo getter della password
    public String getPassword(){return password;}

    // Metodo getter del saldo
    public double getSaldo(){
        return saldo;
    }

    // Metodo deposita
    @Override
    public void deposita(double importo, boolean mostraMessaggio) {
        // Manda a schermo l'errore se l'importo è negativo
        if (importo < 0){
            if (mostraMessaggio)
                System.out.println("Errore: L'importo deve essere positivo.");
        } else {
            this.saldo += importo; // Aggiungo l'importo al saldo
            // Se mostraMessaggio è uguale true, manda a schermo il messaggio
            if (mostraMessaggio) {
                System.out.println("Deposito avvenuto con successo. Importo: € " + importo);
                System.out.println("Il tuo saldo aggiornato è di: € " + saldo);
            }
        }
    }

    // Metodo preleva
    @Override
    public void preleva(double importo, boolean mostraMessaggio) {
        // Manda a schermo l'errore se l'importo è negativo
        if (importo < 0){
            if (mostraMessaggio)
                System.out.println("Errore: L'importo deve essere positivo.");
        }
        else if (saldo < importo){
            System.out.println("Errore: impossibile prelevare € " + importo + ". Saldo insufficiente.");
        } else {
            this.saldo -= importo; // Sottraggo l'importo al saldo
            // Se mostraMessaggio è uguale true, manda a schermo il messaggio
            if (mostraMessaggio){
                System.out.println("Prelievo avvenuto con successo. Importo: € " + importo);
                System.out.println("Il tuo saldo aggiornato è di: € " + saldo);
            }
        }
    }

    // Sovrascrivo il metodo toString
    public String toString(){
        return "Numero conto: " + numeroConto + "\nIntestatario: " + intestatario + "\nEmail: " + email + "\nSaldo: " + saldo;
    }
}
