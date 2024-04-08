import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        int[] array = new int[20];

        //Meny
        System.out.println("Bokningssystem för bussresor:");
        System.out.println("1. Lägga till en passagerare - boka en obokad plats \n2. Skriv ut antal lediga platser \n3. Beräkna vinsten av antalet sålda biljetter \n4. Avsluta programmet");
        System.out.println();
        System.out.print("Inmata menyval här: ");
        int val = tangentbord.nextInt();
        tangentbord.nextLine();
        System.out.println();

        //Antal lediga platser (val 2)
        if (val==2) {
            int lediga_platser = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i]==0) {
                    lediga_platser++;
                }
            }
            System.out.println("Antal lediga platser: "+lediga_platser);
        }

        //Vinst på antal sålda biljetter
        if (val==3) {
            double vinst = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    vinst+=299.90;
                }
            }
            System.out.println("Vinst för antal sålda biljetter: "+vinst+" SEK");
        }
        tangentbord.close();
    }
}
