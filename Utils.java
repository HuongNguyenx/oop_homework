import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    /**
     * read from file.
     */
    public static String readContentFromFile(String path) {
        StringBuilder fileContent = new StringBuilder();
        try {
            
            Path filePath = Paths.get(path);

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line);
                    fileContent.append("\n");
                }
            } 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return fileContent.toString();
    }

    /**
     * write to file.
     */
    public static void writeContentToFile(String path) {
        String fileContent = "This is my new content";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            writer.write(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * append content to file.
     */
    public static void appendContentToFile(String path) {
        String fileContent = "This is my new content";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

            writer.write(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * find file.
     */
    public static File findFileByName(String folderPath, String fileName) {
        try {
            File folder = new File(folderPath);
            File[] files = folder.listFiles();
        
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        return file;
                    } else if (file.isDirectory()) {
                        File fileChild = findFileByName(file.getAbsolutePath(), fileName);
                        if (fileChild != null) {
                            return fileChild;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * main.
     */
    public static void main(String[] args) {
        String pathFile = "src/test.txt";
        String pathFolder = "/Users/changchang/Documents/inputOutput/src/mytest";
        String fileName = "newtest.txt";

        // read from file.
        String content = Utils.readContentFromFile(pathFile);
        System.out.println(content);

        // write content to a file.
        Utils.writeContentToFile(pathFile);
        String content2 = Utils.readContentFromFile(pathFile);
        System.out.println(content2);
        
        // append content to file.
        Utils.appendContentToFile(pathFile);
        String content3 = Utils.readContentFromFile(pathFile);
        System.out.println(content3);

        // find folder.
        File find = Utils.findFileByName(pathFolder, fileName);
        System.out.println("Find Folder: " + find.getAbsolutePath());
    }
}
