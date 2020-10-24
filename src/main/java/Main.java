import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileGothic fileGothic = new FileGothic("value.txt");
        CopySave copySave = new CopySave("D:/Games/Gothic II - Rebalance/Saves", "D:/Distr/gothic-copy-saves");
        boolean gothicRun = false;

        while (true) {
            if (!gothicRun && fileGothic.gothicIsRunning()) {
                System.out.println("зашло");
                gothicRun = true;

            } else if (gothicRun && !fileGothic.gothicIsRunning()) {
                System.out.println("должен быть сейв");
                gothicRun = false;
                copySave.copy();
            }
            Thread.sleep(1000);
        }
    }
}
