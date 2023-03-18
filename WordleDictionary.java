import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
/**
 * Manages a dictionary of words for use in Wordle.
 *
 * @author (vyclu20)
 */
public class WordleDictionary
{
    // Contains all the words in the dictionary.
    private ArrayList<String> words;

    /**
     * Constructs a WordleDictionary from a single parameter which gives a String
     * containing the path to the file of words to use.
     * 
     * YOU DO NOT NEED TO MODIFY THIS METHOD'S CODE!
     */
    public WordleDictionary(String wordsFilePath)
    {
        // !!! DO NOT MODIFY !!!
        words = new ArrayList<>();
        File wordsFile = new File(wordsFilePath);
        try {
            Scanner fileScanner = new Scanner(wordsFile);
            while (fileScanner.hasNext()) {
                words.add(fileScanner.next());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the word file: " + wordsFilePath);
            e.printStackTrace();
        }
        // !!! DO NOT MODIFY !!!
    }
    
    /**
     * Default constructor for use in BlueJ that uses the default path to "words.txt".
     * 
     * YOU DO NOT NEED TO MODIFY THIS METHOD'S CODE!
     * DO NOT MODIFY words.txt!
     */
    public WordleDictionary()
    {
        // !!! DO NOT MODIFY !!!
        this("words.txt");
        // !!! DO NOT MODIFY !!!
    }
    
    /**
     * Returns an ArrayList containg all the words in the dictionary with a specified length (in number of letters).
     * For example, if we called getWordsWithLength(3) it might return an ArrayList containing the word "cat" (along with all other 3 letter words)
     * because "cat" has 3 letters, but the array list will not contain "test" because "test" has 4 letters.
     * 
     * Hint 1: You will need to create a new ArrayList<String>, put the words in it, and return it.
     * Hint 2: See above that this class has a field "words" containing all the words. You will need to use this field.
     */
    public ArrayList<String> getWordsWithLength(int length)
    {
        // TODO
        ArrayList<String> wordsWithLength = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() == length) {
                wordsWithLength.add(word);
            }
        }
        return wordsWithLength;
    }
    
    /**
     * Returns a randomly selected word from the dictionary with a specified length.
     * 
     * Hint 1: Use getWordsWithLength
     * Hint 2: Recall java.util.Random from the lectures
     */
    public String getRandomWord(int length)
    {
        // TODO
        ArrayList<String> wordsWithLength = getWordsWithLength(length);
        Random random = new Random();
        int index = random.nextInt(wordsWithLength.size());
        return wordsWithLength.get(index);
    }
}
