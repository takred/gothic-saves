import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

public class CopySave {
    private final String savePath;
    private final String copyPath;

    public CopySave(String savePath, String copyPath) {
        this.savePath = savePath;
        this.copyPath = copyPath;
    }

    public void copy() throws IOException {
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
                File endSavePath = new File(fileNew.getPath() + "/" + savesName[i]);
                endSavePath.mkdirs();
                Files.copy(currentFile.toPath(), Path.of(endSavePath.toPath() + "/" + directName[j]));
            }
        }
    }
}
