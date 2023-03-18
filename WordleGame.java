/**
 * Manages a single game of Wordle.
 * 
 * You can play Wordle here https://www.nytimes.com/games/wordle/index.html
 * Note that the above game checks each guess is a valid word.
 * We DO NOT do this here! We let the user guess any sequence of 5 characters.
 *
 * @author (your name AND student number)
 */
public class WordleGame {
    private String secretWord;
    
    /**
     * Constructs a WordleGame with a specified secret word.
     * 
     * Note that we assume the secretWord contains only lowercase letters ('a'-'z').
     * YOU ARE NOT REQUIRED TO CHECK THIS, JUST ASSUME IT IS TRUE.
     * 
     * Hint: See the secretWord field above.
     */
    public WordleGame(String secretWord)
    {
        // TODO
        this.secretWord = secretWord;
    }
    
    /**
     * Returns the secret word.
     * 
     * Hint: See the secretWord field above.
     */
    public String getSecretWord()
    {
        // TODO
        return secretWord;
    }
    
    /**
     * Returns true if the given letter is in the secret word.
     * For example, if secretWord was "haste" and we called isInSecretWord('e'),
     * then the output would be true because 'e' is in "haste".
     * However, if we called isInSecretWord('z'), then the output would be false.
     * 
     * Hint: Strings have a method called charAt and a method called length.
     *       See https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
     */
    public boolean isInSecretWord(char letter)
    {
        // TODO
    
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                return true;
            }
        }
        return false;

    }
    
    
    /**
     * Takes a word being guessed and outputs a string describing the result of the guess.
     * 
     * If the word to guess has a length different to the secret word, returns an empty string ("")
     * For example, if the secret word is "cat" and we call guessWord("test"), it should return ""
     * because test has a different length than cat.
     * 
     * If the word to guess has the same length as the secret word, returns a string description with that length such that:
     * Each character in the returned string corresponds to a letter in the guess.
     * It should be '*' if the guessed letter at that location is correct.
     * It should be '.' if the guessed letter at that location is not correct, but does appear in the secret word.
     * It should be '_' if the guessed letter at that location is not correct and does not appear in the secret word.
     * 
     * For example, if the secretWord was "diary"
     * guessWord("dandy")
     * would return: "*._.*"
     * 
     * Aliging the strings will help us see which locations match
     * "diary"
     * "dandy"
     * "*._.*"
     * 
     * The first character is '*' because both strings start with a 'd'
     * The second is '.' because 'a' is not the right letter, but is in the secret string.
     * The third is '_' because 'n' does not appear in the secret string.
     * The fourth is '.' because 'd' is not correct, but does appear in the secret string.
     * The fifth is '*' because both strings end with 'y'
     * 
     * Note that we assume the input, wordToGuess, contains only lowercase letters ('a'-'z').
     * YOU ARE NOT REQUIRED TO CHECK THIS, JUST ASSUME IT IS TRUE.
     * 
     * Hint: Use the isInSecretWord method above.
     */
    public String guessWord(String wordToGuess)
    {
        // TODO
        if (wordToGuess.length() != secretWord.length()) {
            return "";
        }
    
        char[] word = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            char guess = wordToGuess.charAt(i);
            if (guess == secretWord.charAt(i)) {
                word[i] = '*';
            } else if (isInSecretWord(guess)) {
                word[i] = '.';
            } else{
                word[i] = '_';
            }
        }
        return new String(word);
    }
}