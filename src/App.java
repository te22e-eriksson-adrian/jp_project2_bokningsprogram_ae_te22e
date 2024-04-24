//Importering från java-biblioteket
import java.util.InputMismatchException;
import java.util.Scanner;

/** Författare: Adrian Eriksson, Te22E
 * Programmet låter en anställd på ett bussresebolag sköta bokningar och administrera personuppgifter för
 * passagerare. Detta gör denna genom att navigera systemet utifrån instruktioner som visas i terminalen.
 * För att välja ett visst alternativ använder den anställde, enhetens tangentbord för att genom siffror
 * (exempelvis menysiffra, platsnummer eller personnummer/födelsedatum) eller andra uppgifter göra val i 
 * programmet.
 * @author Adrian Eriksson Te22E
 * @version 1.0
 * @since 2024
 */

public class App {

    /**Globala variabler
    * Scanner som låter programmet ta in inforamtion från tangentbordet.
    * Denna tar in inmatningar från tangentbordet och distribuerar informationen
    * till den variabel som är likställd med scannern.
    * 
    * Den andra globala variabeln lagrar menyvalet för att avgöra vad som händer i menyn.
    *
    * De sista två är fält/arrayer som lagrar, i fallet med "platser" lagrar personnummer för 
    * platsinnehavaren eller en nolla ifall platsen är tom. Den andra lagrar åldern för passageraren på
    * varje ockuperad plats.
    */    
    static Scanner tangentbord = new Scanner(System.in);
    static int menyval;
    static int[] platser = new int[20];
    static int[] ålder = new int[20];
    public static void main(String[] args) throws Exception {
        //Variabeln för menyval nollställs när man startar eller startar om programmet.
        menyval = 0;

        //Programmets fortgång/cirkulation avbryts ifall menyvalet är detsamma som 7.
        while (menyval != 7) {
            //Startmeny
            menyval = start_meny();
            switch (menyval) {
                case 1:
                    //Lägga till en passagerare
                    lägg_till_passagerare();
                    break;
                case 2:
                    //Avboka en passagerare
                    avboka_passagerare();
                    break;
                case 3:
                    //Antal lediga platser
                    tillgängliga_platser();
                    break;
                case 4:
                    //Vinst på antal sålda biljetter
                    biljett_vinst();
                    break;
                case 5:
                    //Lista passagerare
                    lista_passagerare();
                    break;
                case 6:
                    //Hitta bokad plats
                    hitta_bokad_plats();
                    break;
                default:
                    //Om fel inmatad siffra
                    System.out.println("Du inmatade ett felaktigt värde, var god starta om programmet och prova igen.");
                    System.out.println();
                    menyval = 7;
                    break;
            }
        }
        //Informerar att programmet avslutats och att scannern inte längre behövs.
        System.out.println("Programmet avslutat.");
        tangentbord.close();
    }
    //Metoder för programmet:
    /** METOD: start_meny
     * INPARAMETER: INGET.
     * @return val : menyval för att avgöra vilket alternativ som valts i startmenyn.
     */
    static int start_meny() {
        System.out.println("Bokningssystem för bussresor:");
        System.out.println("1. Lägga till en passagerare \n2. Avboka en passagerare \n3. Skriv ut antal lediga platser \n4. Beräkna vinsten av antalet sålda biljetter \n5. Lista passagerare \n6. Hitta kundens bokade plats \n7. Avsluta programmet");
        System.out.println();
        System.out.print("Inmata menyval här: ");
        int val = get_user_input();
        System.out.println();
        return val;
    }

    /** METOD: get_user_input
     * INPARAMETER: INGET.
     * @return input_val RETUR: Returnerar inmatningen som användaren gör med hjälp av scannern/tangentbordet.
     */
    static int get_user_input() {
        int input_val = 0;
        try {
            input_val = tangentbord.nextInt();
            tangentbord.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Felaktig inmatning, var god försök igen med siffror!");
            input_val = 7;
        }
        return input_val;
    }

    /** METOD: lägga_till_passagerare
     * INPARAMETER: INGET.
     * RETUR: INGET.
     */
    static void lägg_till_passagerare() {
        int obokade_platser = 0;

        System.out.println("Lediga platser:");
        for (int i = 0; i < platser.length; i++) {
            if (platser[i]==0 && (i%4==0 || (i+1)%4==0)) {
                System.out.println("Fönsterplats "+(i+1));
                obokade_platser++;
            }
            else if(platser[i]==0) {
                System.out.println("Plats "+(i+1));
                obokade_platser++;
            }
        }
        System.out.println();

        if (obokade_platser==0) {
            System.out.println("Tyvärr finns det inga lediga platser kvar.");
        }else{
            System.out.print("Välj plats att boka: ");
            int plats = get_user_input();
            System.out.print("Inmata personnummer för ny platsinnehavare: ");
            platser[plats-1] = get_user_input();
            System.out.print("Inmata ålder för passageraren: ");
            ålder[plats-1] = get_user_input();
            System.out.println();
            System.out.println("Summering: \nVald plats "+plats+"\nPlatsinnehavare: "+platser[plats]);
        }
        System.out.println();
    }

    /** METOD: tillgängliga_platser
     * INPARAMETER: INGET.
     * RETUR: INGET.
     */
    static void tillgängliga_platser() {
        int lediga_platser = 0;
        for (int i = 0; i < platser.length; i++) {
            if (platser[i]==0) {
                lediga_platser++;
            }
        }
        System.out.println("Antal lediga platser: "+lediga_platser);
        System.out.println();
    }

    /** METOD: biljett_vinst
     * INPARAMETER: INGET.
     * RETUR: INGET.
     */
    static void biljett_vinst() {
        double vinst = 0;
        for (int i = 0; i < ålder.length; i++) {
            if (ålder[i] != 0) {
                if (ålder[i]>=18) {
                    vinst+=299.90;
                }else{
                    vinst+=149.90;
                }
            }
        }
        System.out.println("Vinst för antal sålda biljetter: "+vinst+" SEK");
        System.out.println();
    }

    /** METOD: hitta_bokad_plats
     * INPARAMETER: INGET.
     * RETUR: INGET.
     */
    static void hitta_bokad_plats() {
        int status = 0;
        System.out.print("Välj personnummer att söka efter: ");
        int nummer = get_user_input();
        for (int i = 0; i < platser.length; i++) {
            if (platser[i]==nummer) {
                System.out.println("Personnummer "+nummer+" har plats nummer: "+(i+1));
                status = 1;
            }
        }
        if (status==0) {
            System.out.println("Personnummer "+nummer+" har ingen registrerad plats.");
        }
        System.out.println();
    }

    /** METOD: avboka_passagerare
     * INPARAMETER: INGET.
     * RETUR: INGET.
     */
    static void avboka_passagerare() {
        int status = 0;
        System.out.print("Välj personnummer till passagerare att avboka: ");
        int nummer = get_user_input();
        for (int i = 0; i < platser.length; i++) {
            if (platser[i]==nummer) {
                platser[i] = 0;
                System.out.println("Personnummer "+nummer+" har inte längre en plats");
                status = 1;
            }
        }
        if (status==0) {
            System.out.println("Personnummer "+nummer+" fanns inte registrerat. (Ingen avbokades.)");
        }
        System.out.println();
    }

    /** METOD: lista_passagerare
     * INPARAMETER: INGET.
     * RETUR: INGET.
     */
    static void lista_passagerare() {
        System.out.println("Vuxna passagerare (18 eller mer):");
        for (int i = 0; i < ålder.length; i++) {
            if (ålder[i] != 0 && ålder[i] >= 18) {
                System.out.println(platser[i]+" - Ålder: "+ålder[i]);
            }
        }
        System.out.println();
        System.out.println("Passagerare som är barn (under 18):");
        for (int i = 0; i < ålder.length; i++) {
            if (ålder[i] != 0 && ålder[i] < 18) {
                System.out.println(platser[i]+" - Ålder: "+ålder[i]);
            }
        }
        System.out.println();
    }
}
