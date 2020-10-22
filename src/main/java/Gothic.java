import java.io.*;
import java.nio.file.Files;
import java.util.Calendar;

public class Gothic {
    String filePath;
    String savePath;
    String copyPath;

    public Gothic(String filePath, String savePath, String copyPath) {
        this.filePath = filePath;
        this.savePath = savePath;
        this.copyPath = copyPath;
    }

    public boolean gothicIsRunning() throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        boolean result = reader.readLine().equals("true");
        reader.close();

        return result;
    }

    public void gothicCopySaves() throws IOException {
        Calendar calendar = Calendar.getInstance();
        String fullCopyPath = copyPath + "/" + calendar.getTimeInMillis();
        File file = new File(savePath);
        File fileNew = new File(fullCopyPath);
        fileNew.mkdirs();
        File saves[] = file.listFiles();
        String savesName[] = file.list();

        for (int i = 0; i < saves.length; i++) {
            String directName[] = saves[i].list();

            for (int j = 0; j < directName.length; j++) {
                File currentFile = new File(file.getPath() + "/" + savesName[i] + "/" + directName[j]);
                File endSavePath = new File(fileNew.getPath() + "/" + savesName[i] + "/" + directName[j]);
                endSavePath.mkdirs();
                Files.copy(currentFile.toPath(), endSavePath.toPath());
            }
        }

    }

}
