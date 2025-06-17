import java.util.*;

public class Vocabulary {
    private Map<String, String> ukToEn = new HashMap<>();
    private Map<String, String> enToUk = new HashMap<>();

    public void addWord(String ukrainian, String english) {
        ukToEn.put(ukrainian.toLowerCase(), english.toLowerCase());
        enToUk.put(english.toLowerCase(), ukrainian.toLowerCase());
    }
    
    public String translateToEnglish(String ukrainian) {
        return ukToEn.getOrDefault(ukrainian.toLowerCase(), "Not found");
    }

    public String translateToUkrainian(String english) {
        return enToUk.getOrDefault(english.toLowerCase(), "Not found");
    }

    public void displayAll() {
        System.out.println("Ukrainian -> English:");
        for (Map.Entry<String, String> entry : ukToEn.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}