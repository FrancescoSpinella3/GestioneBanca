import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioneBanca {
    public static void main(String[] args) {
        Banca banca = new Banca();

        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("\n-------- BANCA --------");
            System.out.println("1. Crea conto");
            System.out.println("2. Desposita");
            System.out.println("3. Preleva");
            System.out.println("4. Visualizza saldo");
            System.out.println("5. Elimina conto");
            System.out.println("6. Chiudi applicazione");
            System.out.println("------------------------");

            int comando = 0;
            while (true){
                try {
                    System.out.print("Inserisci comando: ");
                    comando = s.nextInt();
                    s.nextLine();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                    System.out.println("⚠️ Scelta utente non valida");
                    System.out.println("------------------------\n");
                    s.nextLine();
                }
            }

            switch (comando){
                case 1: // Crea conto
                    System.out.println("\n---- CREA CONTO ----");
                    System.out.print("Intestatario conto: ");
                    String intestatario = s.nextLine();
                    banca.creaConto(intestatario);
                    break;

                case 2: // Deposita
                    System.out.println("\n---- DEPOSITA ----");
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
                        } catch (InputMismatchException e){
                            System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                            System.out.println("⚠️ Input utente non valido");
                            System.out.println("------------------------\n");
                            s.nextLine();
                        }
                    }
                    banca.efftuaDeposito(numeroConto, importo);
                    break;

                case 3: // Preleva
                    System.out.println("\n---- DEPOSITA ----");
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
                        } catch (InputMismatchException e){
                            System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                            System.out.println("⚠️ Input utente non valido");
                            System.out.println("------------------------\n");
                            s.nextLine();
                        }
                    }
                    banca.effettuaPrelievo(numeroConto, importo);
                    break;

                case 4: // Visualizza saldo
                    System.out.println("\n---- VISUALIZZA SALDO ----");
                    numeroConto = 0;
                    while (true){
                        try {
                            System.out.print("Inserisci numero conto: ");
                            numeroConto = s.nextInt();
                            s.nextLine();
                            break;
                        }catch (InputMismatchException e){
                            System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                            System.out.println("⚠️ Input utente non valido");
                            System.out.println("------------------------\n");
                            s.nextLine();
                        }
                    }
                    banca.visualizzaSaldo(numeroConto);
                    break;

                case 5: // Elimina conto
                    System.out.println("\n---- ELIMINA CONTO ----");
                    numeroConto = 0;
                    while (true){
                        try {
                            System.out.print("Numero conto: ");
                            numeroConto = s.nextInt();
                            s.nextLine();
                            break;
                        }catch (InputMismatchException e){
                            System.out.println("\uD83D\uDD34 Errore: " + e.getMessage());
                            System.out.println("⚠️ Input utente non valido");
                            System.out.println("------------------------\n");
                            s.nextLine();
                        }
                    }
                    banca.eliminaConto(numeroConto);
                    break;

                case 6: // Chiudi applicazione
                    System.out.println("Chiusura dell'applicazione...");
                    return;

                default:
                    System.out.println("Scelta utente non valida");
            }
        }
    }
}
