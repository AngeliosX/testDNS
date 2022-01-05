package testDNS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ZoomFinder {
    public void run(String cmd) {
        String s;
        System.out.println("\n=========== Текущий запрос: " + cmd + " ===========");

        try {
            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));

            while ((s = input.readLine()) != null) {
                if (s.contains("ZOOM")) {
                    System.out.println("Имеется запись: " + s);
                    System.out.println("================ Конец запроса ==================");
                }
                if (!s.contains("ZOOM")) {
                    System.out.println("Другие записи, кроме Zoom");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
