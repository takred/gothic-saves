import java.io.*;

public class FileGothic implements Gothic{
    String filePath;

    public FileGothic(String filePath) {
        this.filePath = filePath;
    }

    public boolean gothicIsRunning() throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        boolean result = reader.readLine().equals("true");
        reader.close();

        return result;
    }

}
