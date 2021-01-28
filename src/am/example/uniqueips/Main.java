package am.example.uniqueips;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<IPv4> ipSet = new HashSet<>();

        while (true) {
            String line = null;
            try {
                if (((line = reader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(line.trim().equals("")) continue;

            String[] numbersStr = line.split("\\.");
            if(numbersStr.length != 4) continue;

            byte[] numbersByte = new byte[4];
            for(int i = 0; i < numbersStr.length; i++) {
                short value;
                try {
                    value = Short.parseShort(numbersStr[i]);
                } catch (NumberFormatException e) {
                    continue;
                }

                if(value < 0 || value > 255) {
                    continue;
                }

                numbersByte[i] = (byte) (value - 128);
            }
            IPv4 ip = new IPv4(numbersByte);
            ipSet.add(ip);
        }

        long numberOfIP = ipSet.size();
        System.out.println(numberOfIP);
    }
}
