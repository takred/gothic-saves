import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gothic gothic = new Gothic("value.txt","D:/Games/Gothic II - Rebalance/Saves", "D:/Distr/gothic-copy-saves");
        boolean gothicRun = false;

        while (true) {
            if (!gothicRun && gothic.gothicIsRunning()) {
                gothicRun = true;

            } else if (gothicRun && !gothic.gothicIsRunning()) {
                gothicRun = false;
                gothic.gothicCopySaves();
            }
            Thread.sleep(1000);
        }
    }
}
