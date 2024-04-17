import java.util.Scanner;

public class App {
    
    static Scanner tangentbord = new Scanner(System.in);
    static int menyval;
    static int[] platser = new int[20];
    static int[] ålder = new int[20];
    public static void main(String[] args) throws Exception {
        menyval = 0;

        while (menyval != 7) {
            //Meny
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
        //Avsluta programmet
        System.out.println("Programmet avslutat.");
        tangentbord.close();
    }
    static int start_meny() {
        System.out.println("Bokningssystem för bussresor:");
        System.out.println("1. Lägga till en passagerare \n2. Avboka en passagerare \n3. Skriv ut antal lediga platser \n4. Beräkna vinsten av antalet sålda biljetter \n5. Lista passagerare \n6. Hitta kundens bokade plats \n7. Avsluta programmet");
        System.out.println();
        System.out.print("Inmata menyval här: ");
        int val = get_user_input();
        System.out.println();
        return val;
    }
    static int get_user_input() {
        int input_val = tangentbord.nextInt();
        tangentbord.nextLine();
        return input_val;
    }
    static void lägg_till_passagerare() {
        int obokade_platser = 0;
        for (int i = 0; i < platser.length; i++) {
            if (platser[i]==0) {
                System.out.println("Plats "+(i+1));
                obokade_platser++;
            }
        }
        if (obokade_platser==0) {
            System.out.println("Tyvärr finns det inga lediga platser kvar.");
        }else{
            System.out.println();
            System.out.print("Välj plats att boka: ");
            int plats = get_user_input();
            System.out.print("Inmata personnummer för ny platsinnehavare: ");
            platser[plats-1] = get_user_input();
            System.out.print("Inmata ålder för passageraren: ");
            ålder[plats-1] = get_user_input();
            System.out.println();
            System.out.println("Summering: \nVald plats "+plats+"\nPlatsinnehavare: "+platser[plats]);
            System.out.println();
        }
    }
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
