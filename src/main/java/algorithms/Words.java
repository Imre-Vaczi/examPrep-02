package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (!isWithoutSpace(word)) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!isLowerCase(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }

    private boolean isLowerCase(String word) {
        return word.chars().allMatch(c -> Character.isLowerCase(c));
    }

    private boolean isWithoutSpace(String word) {
        //return word.chars().anyMatch(c -> String.valueOf(c).equals(" "));
        return !word.contains(" ");
    }
}
