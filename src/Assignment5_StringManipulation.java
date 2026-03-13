import java.util.Scanner;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String lower = input.toLowerCase();
        String reversed = "";
        for (int i = lower.length() - 1; i >= 0; i--) {
            reversed = reversed + lower.charAt(i);
        }
        boolean isPalindrome = lower.equals(reversed);

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        int wordCount = 0;
        if (!sentence.trim().isEmpty()) {
            String[] words = sentence.trim().split("\\s+");
            wordCount = words.length;
        }

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String noSpaces = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                noSpaces = noSpaces + input.charAt(i);
            }
        }

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            }
            if (i == 0) {
                result = words[i];
            } else {
                result = result + " " + words[i];
            }
        }

        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char mostFrequent = input.charAt(0);
        int maxCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int currentCount = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == current) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequent = current;
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        str1 = str1.toLowerCase().replace(" ", "");
        str2 = str2.toLowerCase().replace(" ", "");

        if (str1.length() != str2.length()) {
            System.out.println("No");
            return;
        }

        int[] counts = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            counts[str2.charAt(i)]--;
        }

        boolean areAnagrams = true;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                areAnagrams = false;
                break;
            }
        }

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}