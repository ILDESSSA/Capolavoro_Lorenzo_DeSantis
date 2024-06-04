/*In questo programma, dovrai scrivere 3 numeri e il programma ti dirà se il numero da te detto è uguale, 
quasi uguale o completamente sbagliato al numero generato in maniera random, scrivendoti anche se un numero inserito sia in posizione corretta*/
package indovina.il.numero.a.pkg3.cifre;

import java.util.Random;
import java.util.Scanner;

public class IndovinaIlNumeroA3Cifre {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random Rand = new Random();

        int[] vrandom = new int[3];
        int[] vscelto = new int[3];
        boolean V = true;
        int Nindizio;
        int contatoreNgiusti = 0;
        int contatoreN = 0;
        int contatoreInserimenti = 0;
        boolean Indizio = false;
        int tasto = 0;
        String nome = "";
        int contacifre = 0;
        String risposta = "s";
        int num = 0;

        while (risposta.contains("s") || risposta.contains("S")) {

            for (int i = 0; i < 3; i++) {
                vrandom[i] = Rand.nextInt(10);
            }

            Nindizio = Rand.nextInt(2);

            System.out.println("");
            System.out.println("INDOVINA IL NUMERO!");
            System.out.println("");
            System.out.println("BENVENUTO A UNO DEI GIOCHI DI LOGICA PIU' DIVERTENTI CHE ESISTA");
            System.out.println(" ");
            System.out.println("Il gioco consiste nell'indovinare il numero composto da 3 cifre generato in maniera casuale dal programma.");
            System.out.println("N.B. se inserisci un numeri a 2 cifre, la prima posizione del numero verra' considerata 0 (11 -> 011).");
            System.out.println("Puoi utilizzare un indizio che ti aiutera' a risolvere il gioco. ");
            System.out.println("");
            System.out.println("Scrivere '1' -> per inserire il numero.");
            System.out.println("Scrivere '2' -> per avere un indizio.");
            System.out.println("Scrivere '3' -> per visualizzare il numero");
            System.out.println("");
            System.out.println("METTITI ALLA PROVA E BUON DIVERTIMENTO!!!");
            System.out.println("");

            System.out.println("Per inziare scrivi il tuo nome: ");
            nome = in.nextLine();
            System.out.println("");
            V = true;

            while (V) {

                System.out.println("1. INSERISCI IL NUMERO: ");
                System.out.println("2. INDIZIO: ");
                System.out.println("3. TI ARRENDI? VISUALIZZA IL NUMERO: ");
                tasto = in.nextInt();

                switch (tasto) {

                    case 1:
                        num = in.nextInt();

                        System.out.println("");

                        contatoreInserimenti++;

                        vscelto[0] = num / 100;
                        vscelto[1] = ((num / 10) - ((num / 100) * 10));
                        vscelto[2] = (num - ((num / 10) * 10));

                        contatoreNgiusti = 0;

                        for (int k = 0; k < 3; k++) {
                            if (vrandom[k] == vscelto[k]) {
                                contatoreNgiusti++;
                            }
                        }

                        if (contatoreNgiusti == 3) {
                            System.out.println(nome + " COMPLIMENTI HAI INDOVINATO IL NUMERO!");
                            System.out.println("Numero tentativi: " + contatoreInserimenti);
                            if (Indizio) {
                                System.out.println("Hai usato l'indizio.");
                            }
                            V = false;
                        }

                        contatoreNgiusti = 0;
                        contatoreN = 0;

                        if (V) {
                            for (int i = 0; i < 3; i++) {
                                if (vrandom[i] == vscelto[i]) {
                                    System.out.println("cifra esatta in posizione corretta");
                                    System.out.println("");
                                    contatoreNgiusti++;
                                    contatoreN++;
                                }
                                if (contatoreNgiusti < 1) {
                                    if (vrandom[i] == vscelto[0] || vrandom[i] == vscelto[1] || vrandom[i] == vscelto[2]) {
                                        System.out.println("Una di queste cifre e' corretta ma non in posizione corretta");
                                        System.out.println("");
                                        contatoreN++;
                                    }
                                }

                            }
                            if (contatoreN == 0) {
                                System.out.println("Nessuna cifra corretta.");
                                System.out.println("");
                            }

                        }
                        break;

                    case 2:
                        System.out.println(nome + " il numero nella " + (Nindizio + 1) + "^ posizione e': " + vrandom[Nindizio]);
                        System.out.println("");
                        Indizio = true;
                        break;

                    case 3:
                        System.out.print(nome + " il numero era: " + vrandom[0] + vrandom[1] + vrandom[2]);
                        System.out.println("");
                        V = false;
                        break;

                    default:
                        System.out.println("Comando non riconosciuto, scrivi un numero tra '1', '2', '3'.");
                        System.out.println("");
                        break;
                }
            }

            System.out.println("Vuoi fare un altra partita? (SI/NO)");
            risposta = in.nextLine();
            risposta = in.nextLine();

        }
    }
}
