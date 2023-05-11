import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tweet tuite = new Tweet("Teste... Funciona! sera? Teste Funciona!realmente");
        System.out.println(Tweet.generateTweetContent());
    }
}

class Tweet {
    private String content;

    public Tweet(String content) {
        setContent(content);
    }

    public static String generateTweetContent() {
        final int MIN_WORDS = 1, MAX_WORDS = 5;
        Random random = new Random();
        StringBuilder tweetContent = new StringBuilder();
        String[] possibleWords = {"Teste", "Funciona", "Tuite", "Realmente"};

        int numberOfWords = random.nextInt(MIN_WORDS, MAX_WORDS);
        for (int i = 0; i < numberOfWords; i++) {
            tweetContent.append(possibleWords[random.nextInt(0, possibleWords.length)]);
            tweetContent.append(" ");
        }

        return tweetContent.toString();
    }

    public int phraseCount() {
        boolean lastWasPunctuation = false;
        int phraseCount = 0, index = 0;
        final char[] charArray = this.content.toCharArray();

        for (char c : charArray) {
            if (c == '.' || c == '?' || c == '!' || c == ';')
                lastWasPunctuation = true;

            if ((lastWasPunctuation && Character.isLetter(c)) || index == charArray.length - 1) {
                phraseCount++;
                lastWasPunctuation = false;
            }

            index++;
        }

        return phraseCount;
    }

    public int wordOccurance(String word) {
        int occurance = 0;
        String searchString = this.content;

        while (true) {
            int searchResult = searchString.indexOf(word);
            if (searchResult == -1)
                break;

            searchString = searchString.substring(searchResult + word.length());
            occurance++;
        }

        return occurance;
    }

    public int wordCount() {
        final String[] words = content.split(" ");
        return words.length;
    }

    // Risos...
    public int characterCount() {
        return content.length();
    }

    public void setContent(String content) {
        this.content = (content.length() > 144) ? content.substring(0, 144).trim() : content.trim();
    }

    public String getContent() {
        return content;
    }
}