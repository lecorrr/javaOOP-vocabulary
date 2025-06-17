public class App {
    public static void main(String[] args) throws Exception {
        Vocabulary vocab = new Vocabulary();

        vocab.addWord("привіт", "hello");
        vocab.addWord("світ", "world");

        System.out.println("Translate 'привіт' to English: " + vocab.translateToEnglish("привіт"));
        System.out.println("Translate 'world' to Ukrainian: " + vocab.translateToUkrainian("world"));

        System.out.println("\nFull Vocabulary:");
        vocab.displayAll();
    }
}
