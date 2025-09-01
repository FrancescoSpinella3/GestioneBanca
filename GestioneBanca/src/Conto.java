public class Conto implements Transazioni{
    private String intestatario;
    private int numeroConto;
    private double saldo;

    public Conto(String intestatario, int numeroConto){
        this.intestatario = intestatario;
        this.numeroConto = numeroConto;
        this.saldo = 0.0;
    }

    public String getIntestatario(){
        return intestatario;
    }

    public int getNumeroConto(){
        return numeroConto;
    }

    public double getSaldo(){
        return saldo;
    }

    @Override
    public void deposita(double importo) {
        if (importo < 0){
            throw new IllegalArgumentException("Errore: L'importo deve essere positivo.");
        } else {
            this.saldo += importo;
            System.out.println("Hai depositato € " + importo);
            System.out.println("Il tuo saldo aggiornato è di: € " + saldo);
        }
    }

    @Override
    public void preleva(double importo) {
        if (importo < 0) throw new IllegalArgumentException("Errore: L'importo deve essere positivo.");
        if (saldo < importo){
            System.out.println("Errore: impossibile prelevare € " + importo + ". Saldo insufficiente.");
        } else {
            this.saldo -= importo;
            System.out.println("Hai prelevato € " + importo);
            System.out.println("Il tuo saldo aggiornato è di: € " + saldo);
        }
    }

    public String toString(){
        return "Numero conto: " + numeroConto + "\nIntestatario: " + intestatario + "\nSaldo: " + saldo;
    }
}
