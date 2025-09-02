import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioneBanca {
    public static void main(String[] args) {
        Banca banca = new Banca();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("\n------------------ BANCA ------------------");
            System.out.println("1. Accedi al tuo conto");
            System.out.println("2. Apri conto");
            System.out.println("3. Chiudi applicazione");
            System.out.println("-------------------------------------------");

            int comando = 0;
            while (true){
                try {
                    System.out.print("Inserisci comando: ");
                    comando = s.nextInt();
                    s.nextLine();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                    System.out.println("⚠️ Scelta utente non valida");
                    System.out.println("------------------------\n");
                    s.nextLine();
                }
            }

            switch (comando){
                case 1: // Accedi
                    System.out.println("\n--------------- ACCEDI AL TUO CONTO ----------------");
                    int numeroConto = 0;
                    accountMenu:
                    while (true){
                        try {
                            System.out.print("Il tuo numero conto: ");
                            numeroConto = s.nextInt();
                            s.nextLine();
                            if (!banca.accedi(numeroConto)){
                                break;
                            }
                            while (true){
                                System.out.println("\n------------------ MENU ------------------");
                                System.out.println("1. Deposita\t\t\t\t\t5. Informazioni conto");
                                System.out.println("2. Preleva\t\t\t\t\t6. Elimina conto");
                                System.out.println("3. Effettua pagamento\t\t7. Torna al menu di accesso");
                                System.out.println("4. Visualizza saldo");
                                System.out.println("-------------------------------------------");

                                comando = 0;
                                while (true){
                                    try {
                                        System.out.print("Inserisci comando: ");
                                        comando = s.nextInt();
                                        s.nextLine();
                                        break;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                                        System.out.println("⚠️ Scelta utente non valida");
                                        System.out.println("------------------------\n");
                                        s.nextLine();
                                    }
                                }

                                switch (comando){
                                    case 1: // Deposita
                                        System.out.println("\n---------------- DEPOSITA -----------------");
                                        numeroConto = 0;
                                        double importo = 0.0;
                                        while (true){
                                            try {
                                                System.out.print("Importo: € ");
                                                importo = s.nextDouble();
                                                s.nextLine();
                                                break;
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                                                System.out.println("⚠️ Input utente non valido");
                                                System.out.println("------------------------\n");
                                                s.nextLine();
                                            }
                                        }
                                        banca.efftuaDeposito(importo);
                                        break;

                                    case 2: // Preleva
                                        System.out.println("\n----------------- PRELEVA -----------------");
                                        numeroConto = 0;
                                        while (true){
                                            try {
                                                System.out.print("Importo: € ");
                                                importo = s.nextDouble();
                                                s.nextLine();
                                                break;
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                                                System.out.println("⚠️ Input utente non valido");
                                                System.out.println("------------------------\n");
                                                s.nextLine();
                                            }
                                        }
                                        banca.effettuaPrelievo(importo);
                                        break;

                                    case 3: // Effettua pagamento
                                        System.out.println("\n---------- EFFETTUA UN PAGAMENTO ----------");
                                        int numeroContoPagante = 0;
                                        int numeroContoRicevente = 0;
                                        importo = 0.0;
                                        while (true){
                                            try {
                                                System.out.print("Numero conto destinatario: ");
                                                numeroContoRicevente = s.nextInt();
                                                s.nextLine();
                                                System.out.print("Importo da pagare: € ");
                                                importo = s.nextDouble();
                                                s.nextLine();
                                                break;
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                                                System.out.println("⚠️ Input utente non valido");
                                                System.out.println("------------------------\n");
                                                s.nextLine();
                                            }
                                        }
                                        banca.effettuaPagamento(numeroContoRicevente, importo);
                                        break;

                                    case 4: // Visualizza saldo
                                        System.out.println("\n------------ VISUALIZZA SALDO -------------");
                                        banca.visualizzaSaldo();
                                        break;

                                    case 5: // Informazioni conto
                                        banca.informazioniConto();
                                        break;

                                    case 6: // Elimina conto
                                        System.out.println("\n-------------- ELIMINA CONTO --------------");
                                        numeroConto = 0;
                                        while (true){
                                            try {
                                                System.out.print("Inserisci il tuo numero conto per le eliminare il conto: ");
                                                numeroConto = s.nextInt();
                                                s.nextLine();
                                                break;
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                                                System.out.println("⚠️ Input utente non valido");
                                                System.out.println("------------------------\n");
                                                s.nextLine();
                                            }
                                        }
                                        banca.eliminaConto(numeroConto);
                                        break accountMenu;

                                    case 7: // Torna al menu di accesso
                                        break accountMenu;

                                    default:
                                        System.out.println("⚠️ Comando utente non valido");
                                }
                            }
                        }
                        catch (InputMismatchException e){
                            System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                            System.out.println("⚠️ Errore: Input utente non valido");
                            System.out.println("------------------------\n");
                            s.nextLine();
                        }
                    }
                    break;

                case 2: // Apri conto
                    System.out.println("\n--------------- APRI CONTO ----------------");
                    System.out.print("Nome: ");
                    String intestatario = s.nextLine();
                    banca.creaConto(intestatario);
                    break;

                case 3: // Chiudi applicazione
                    System.out.println("Chiusura dell'applicazione...");
                    return;

                default:
                    System.out.println("⚠️ Comando utente non valido");
            }
        }
    }
}