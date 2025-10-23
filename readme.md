```markdown
# Flashcard Learning Application

## Short Description
Welcome to the Flashcard Learning Application! This Java-based project is designed to help you learn and review information through the use of flashcards. Whether you're studying for exams, learning a new language, or just want to memorize some facts, this application provides a simple and effective way to organize and study your flashcards.

## Features
- **Create New Decks:** Easily create new flashcard decks with unique names.
- **Load Existing Decks:** Load previously saved flashcard decks from files.
- **Add Cards to Decks:** Add new flashcards to your existing decks.
- **Study Decks:** Review your flashcards and test your knowledge with a simple interface.
- **Shuffle Cards:** Randomize the order of cards for a more dynamic learning experience.
- **List All Decks:** View all available decks.
- **Save Decks:** Automatically save your decks to files for future use.

## Usage Instructions
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/DDurgeshmahajan/Flashcard-Learning-Application.git
   cd Flashcard-Learning-Application
   ```

2. **Compile the Java Program:**
   Make sure you have JDK (Java Development Kit) installed on your computer. Then, compile the `Main.java` file:
   ```bash
   javac Main.java
   ```

3. **Run the Application:**
   Run the compiled Java program:
   ```bash
   java Main
   ```

4. **Use the Application:**
   - **Create a New Deck:**
     - Enter `1` to create a new deck.
     - Follow the prompts to name your deck and add cards.

   - **Load an Existing Deck:**
     - Enter `2` to load a previously saved deck.
     - Select the deck you want to load from the list of available decks.

   - **Add Cards to a Deck:**
     - Enter `3` to add cards to an existing deck.
     - Select the deck and enter the term and definition for the new card.

   - **Study a Deck:**
     - Enter `4` to study a deck.
     - Select the deck you want to study.
     - Follow the prompts to review the cards and test your knowledge.

   - **List All Decks:**
     - Enter `5` to view all available decks.

   - **Exit the Application:**
     - Enter `6` to exit the application.

## Dependencies
- Java Development Kit (JDK) - Ensure you have JDK installed to compile and run the Java program.

## Example/Preview
Here's a sample interaction with the application:

- **Creating a New Deck:**
  ```
  Enter a unique name for the new deck: Math
  Deck created successfully.
  ```

- **Adding a Card:**
  ```
  Select a deck to add a card:
  Math
  Enter the name of the deck: Math
  Enter the term: Pythagorean Theorem
  Enter the definition: a^2 + b^2 = c^2
  Card added successfully.
  ```

- **Studying a Deck:**
  ```
  Select a deck to study:
  Math
  Enter the name of the deck: Math
  Term: Pythagorean Theorem
  Press Enter to reveal the definition:
  Definition: a^2 + b^2 = c^2
  Did you know this card? (y/n): y
  You knew 1 out of 1 cards.
  ```

## Contact / Author
- **Name:** Durgesh Mahajan
- **Email:** ashamahajan955@gmail.com

If you have any questions, suggestions, or issues, feel free to reach out!

Happy studying!
```