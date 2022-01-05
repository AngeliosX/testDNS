package testDNS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String NS = "nslookup -q=TXT";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Укажите адрес (например nba.com), " + "для выхода укажите End");
            String request = NS + " " + sc.nextLine();
            ZoomFinder nslookup = new ZoomFinder();
            nslookup.run(request);
        } while (!sc.nextLine().equalsIgnoreCase("End"));
    }
}
