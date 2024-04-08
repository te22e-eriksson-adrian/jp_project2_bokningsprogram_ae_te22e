import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        int[] array = new int[20];

        //Meny
        System.out.println("Bokningssystem för bussresor:");
        System.out.println("1. Lägga till en passagerare - boka en obokad plats \n2. Skriv ut antal lediga platser \n3. Beräkna vinsten av antalet sålda biljetter \n4. Avsluta programmet");
        System.out.print("Inmata menyval här: ");
        int val = tangentbord.nextInt();
        tangentbord.nextLine();

        tangentbord.close();
    }
}
