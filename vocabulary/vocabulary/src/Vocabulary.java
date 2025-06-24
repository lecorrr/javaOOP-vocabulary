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

public void saveToCSV(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : ukToEn.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
            System.out.println("Vocabulary saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving to CSV: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    addWord(parts[0].trim(), parts[1].trim());
                }
            }
            System.out.println("Vocabulary loaded from: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading from CSV: " + e.getMessage());
        }       
    }
}
