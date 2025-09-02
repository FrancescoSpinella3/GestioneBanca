import java.io.StringReader;
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
                    while (true){
                        try {
                            System.out.print("Il tuo numero conto: ");
                            numeroConto = s.nextInt();
                            s.nextLine();
                            banca.accedi(numeroConto);
                            break;

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

/*        while (true){
            System.out.println("\n------------------ MENU ------------------");
            System.out.println("1. Crea conto\t\t\t5. Visualizza saldo");
            System.out.println("2. Deposita\t\t\t\t6. Elimina conto");
            System.out.println("3. Preleva\t\t\t\t7. Chiudi applicazione");
            System.out.println("4. Effettua pagamento");
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
                case 1: // Crea conto
                    System.out.println("\n--------------- CREA CONTO ----------------");
                    System.out.print("Intestatario conto: ");
                    String intestatario = s.nextLine();
                    banca.creaConto(intestatario);
                    break;

                case 2: // Deposita
                    System.out.println("\n---------------- DEPOSITA -----------------");
                    int numeroConto = 0;
                    double importo = 0.0;
                    while (true){
                        try {
                            System.out.print("Numero conto: ");
                            numeroConto = s.nextInt();
                            s.nextLine();
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
                    banca.efftuaDeposito(numeroConto, importo);
                    break;

                case 3: // Preleva
                    System.out.println("\n----------------- PRELEVA -----------------");
                    numeroConto = 0;
                    while (true){
                        try {
                            System.out.print("Numero conto: ");
                            numeroConto = s.nextInt();
                            s.nextLine();
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
                    banca.effettuaPrelievo(numeroConto, importo);
                    break;

                case 4: // Effettua pagamento
                    System.out.println("\n---------- EFFETTUA UN PAGAMENTO ----------");
                    int numeroContoPagante = 0;
                    int numeroContoRicevente = 0;
                    importo = 0.0;
                    while (true){
                        try {
                            System.out.println("Numero conto mittente: ");
                            numeroContoPagante = s.nextInt();
                            s.nextLine();
                            System.out.println("Numero conto destinatario: ");
                            numeroContoRicevente = s.nextInt();
                            s.nextLine();
                            System.out.println("Importo da pagare: €");
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
                    banca.effettuaPagamento(numeroContoPagante, numeroContoRicevente, importo);
                    break;

                case 5: // Visualizza saldo
                    System.out.println("\n------------ VISUALIZZA SALDO -------------");
                    numeroConto = 0;
                    while (true){
                        try {
                            System.out.print("Inserisci numero conto: ");
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
                    banca.visualizzaSaldo(numeroConto);
                    break;

                case 6: // Elimina conto
                    System.out.println("\n-------------- ELIMINA CONTO --------------");
                    numeroConto = 0;
                    while (true){
                        try {
                            System.out.print("Numero conto: ");
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
                    break;

                case 7: // Chiudi applicazione
                    System.out.println("Chiusura dell'applicazione...");
                    return;

                default:
                    System.out.println("⚠️ Comando utente non valido");
            }
        } */
    }
}
