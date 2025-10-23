/*
 * Author: Durgesh Mahajan
 * Date: <current date>
 * Project: Flashcard Learning Application
 */

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, FlashcardDeck> decks = new HashMap<>();
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createNewDeck(scanner, decks);
                    break;
                case "2":
                    loadExistingDeck(scanner, decks);
                    break;
                case "3":
                    addCardToDeck(scanner, decks);
                    break;
                case "4":
                    studyDeck(scanner, decks);
                    break;
                case "5":
                    listAllDecks(decks);
                    break;
                case "6":
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\
Flashcard Learning Application Menu");
        System.out.println("1. Create New Deck");
        System.out.println("2. Load Existing Deck");
        System.out.println("3. Add Card to Deck");
        System.out.println("4. Study Deck");
        System.out.println("5. List All Decks");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createNewDeck(Scanner scanner, Map<String, FlashcardDeck> decks) {
        System.out.print("Enter a unique name for the new deck: ");
        String name = scanner.nextLine();
        if (decks.containsKey(name)) {
            System.out.println("A deck with this name already exists. Please choose a different name.");
            return;
        }
        FlashcardDeck deck = new FlashcardDeck(name);
        decks.put(name, deck);
        saveDeckToFile(deck);
        System.out.println("Deck created successfully.");
    }

    private static void loadExistingDeck(Scanner scanner, Map<String, FlashcardDeck> decks) {
        File[] files = new File(".").listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("No existing decks found.");
            return;
        }
        System.out.println("Available decks:");
        for (File file : files) {
            System.out.println(file.getName().replace(".txt", ""));
        }
        System.out.print("Enter the name of the deck you want to load: ");
        String name = scanner.nextLine();
        File deckFile = new File(name + ".txt");
        if (!deckFile.exists()) {
            System.out.println("Deck not found.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(deckFile))) {
            String line;
            FlashcardDeck deck = new FlashcardDeck(name);
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String term = parts[0].trim();
                    String definition = parts[1].trim();
                    Flashcard card = new Flashcard(term, definition);
                    deck.addCard(card);
                }
            }
            decks.put(name, deck);
            System.out.println("Deck loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading deck: " + e.getMessage());
        }
    }

    private static void addCardToDeck(Scanner scanner, Map<String, FlashcardDeck> decks) {
        if (decks.isEmpty()) {
            System.out.println("No decks available. Please create or load a deck first.");
            return;
        }
        System.out.println("Select a deck to add a card:");
        for (String name : decks.keySet()) {
            System.out.println(name);
        }
        System.out.print("Enter the name of the deck: ");
        String name = scanner.nextLine();
        FlashcardDeck deck = decks.get(name);
        if (deck == null) {
            System.out.println("Deck not found.");
            return;
        }
        System.out.print("Enter the term: ");
        String term = scanner.nextLine();
        System.out.print("Enter the definition: ");
        String definition = scanner.nextLine();
        Flashcard card = new Flashcard(term, definition);
        deck.addCard(card);
        saveDeckToFile(deck);
        System.out.println("Card added successfully.");
    }

    private static void studyDeck(Scanner scanner, Map<String, FlashcardDeck> decks) {
        if (decks.isEmpty()) {
            System.out.println("No decks available. Please create or load a deck first.");
            return;
        }
        System.out.println("Select a deck to study:");
        for (String name : decks.keySet()) {
            System.out.println(name);
        }
        System.out.print("Enter the name of the deck: ");
        String name = scanner.nextLine();
        FlashcardDeck deck = decks.get(name);
        if (deck == null) {
            System.out.println("Deck not found.");
            return;
        }
        System.out.print("Shuffle cards before starting? (y/n): ");
        String shuffleChoice = scanner.nextLine().trim().toLowerCase();
        if (shuffleChoice.equals("y")) {
            deck.shuffleCards();
        }
        int knownCount = 0;
        List<Flashcard> cards = deck.getCards();
        for (Flashcard card : cards) {
            System.out.println("\
Term: " + card.getTerm());
            System.out.print("Press Enter to reveal the definition: ");
            scanner.nextLine();
            System.out.println("Definition: " + card.getDefinition());
            System.out.print("Did you know this card? (y/n): ");
            String knewChoice = scanner.nextLine().trim().toLowerCase();
            if (knewChoice.equals("y")) {
                knownCount++;
            }
        }
        System.out.println("\
You knew " + knownCount + " out of " + cards.size() + " cards.");
    }

    private static void listAllDecks(Map<String, FlashcardDeck> decks) {
        if (decks.isEmpty()) {
            System.out.println("No decks available.");
            return;
        }
        System.out.println("Available decks:");
        for (String name : decks.keySet()) {
            System.out.println(name);
        }
    }

    private static void saveDeckToFile(FlashcardDeck deck) {
        try (FileWriter writer = new FileWriter(deck.getName() + ".txt")) {
            for (Flashcard card : deck.getCards()) {
                writer.write(card.getTerm() + "," + card.getDefinition() + "\
");
            }
        } catch (IOException e) {
            System.out.println("Error saving deck: " + e.getMessage());
        }
    }
}
