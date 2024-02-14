package br.com.rodrigojunior.money.utils;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CodeGenerator {


    public static String generateLetterCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder code = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            code.append(characters.charAt(randomIndex));
        }

        return code.toString();
    }

    public static String generateNumberCode() {
        StringBuilder code = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(10);
            code.append(randomNumber);
        }

        return code.toString();
    }

    public static void main(String[] args) {
        // Test the methods
        String letterCode = generateLetterCode();
        String numberCode = generateNumberCode();
        System.out.println("Letter code: " + letterCode);
        System.out.println("Number code: " + numberCode);
    }
}
