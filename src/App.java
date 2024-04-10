import java.util.Scanner;

public class App {
    
    static Scanner tangentbord = new Scanner(System.in);
    static int menyval;
    public static void main(String[] args) throws Exception {
        int[] array = new int[20];
        menyval = 0;

        while (menyval != 4) {
            //Meny
            /* System.out.println("Bokningssystem för bussresor:");
            System.out.println("1. Lägga till en passagerare - boka en obokad plats \n2. Skriv ut antal lediga platser \n3. Beräkna vinsten av antalet sålda biljetter \n4. Avsluta programmet");
            System.out.println();
            System.out.print("Inmata menyval här: ");
            val = tangentbord.nextInt();
            tangentbord.nextLine();
            System.out.println(); */
            int menyval = start_meny();

            //Lägga till en passagerare
            if (menyval==1) {
                int obokade_platser = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i]==0) {
                        System.out.println("Plats "+(i+1));
                        obokade_platser++;
                    }
                }
                if (obokade_platser==0) {
                    System.out.println("Tyvärr finns det inga lediga platser kvar.");
                }else{
                    System.out.println();
                    System.out.print("Välj plats att boka: ");
                    int plats = tangentbord.nextInt();
                    tangentbord.nextLine();
                    System.out.print("Inmata personnummer för ny platsinnehavare: ");
                    array[plats] = tangentbord.nextInt();
                    tangentbord.nextLine();
                    System.out.println();
                    System.out.println("Summering: \nVald plats "+plats+"\nPlatsinnehavare: "+array[plats]);
                }
            }

            //Antal lediga platser (val 2)
            if (menyval==2) {
                int lediga_platser = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i]==0) {
                        lediga_platser++;
                    }
                }
                System.out.println("Antal lediga platser: "+lediga_platser);
            }

            //Vinst på antal sålda biljetter
            if (menyval==3) {
                double vinst = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] != 0) {
                        vinst+=299.90;
                    }
                }
                System.out.println("Vinst för antal sålda biljetter: "+vinst+" SEK");
            }
        }
        //Avsluta programmet
        System.out.println("Programmet avslutat.");
        tangentbord.close();
    }
    static int start_meny(){
        System.out.println("Bokningssystem för bussresor:");
        System.out.println("1. Lägga till en passagerare - boka en obokad plats \n2. Skriv ut antal lediga platser \n3. Beräkna vinsten av antalet sålda biljetter \n4. Avsluta programmet");
        System.out.println();
        System.out.print("Inmata menyval här: ");
        int val = tangentbord.nextInt();
        tangentbord.nextLine();
        System.out.println();
        return val;
    }
}
