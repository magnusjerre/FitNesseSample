package jerre.fixture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.InterruptedException;

public class Shell {

    private static String containerId;

    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public int waitUntilDockerIsReady() throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        String[] args = new String[] {
            "/bin/bash", "-c", "curl http://localhost:8081"
        };

        String curlResult = null;
        do {
            Thread.sleep(1000);
            final ProcessBuilder processBuilder = new ProcessBuilder(args);
            final Process start = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(start.getInputStream()))){
                curlResult = reader.readLine();
            }
        }
        while (curlResult == null || curlResult.contains("Empty reply from server"));

        return (int)((System.currentTimeMillis() - startTime) / 1000);
    }

    public String runDockerImage() throws IOException {
        String[] args = new String[] {
            "/bin/bash", "-c", "docker run -p 8081:8081 -d fitnesse-sample-docker"
          };
        final ProcessBuilder processBuilder = new ProcessBuilder(args);
        final Process start = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(start.getInputStream()))){
            containerId = reader.readLine();
        }
          
        return containerId;
    }

    public void stopDockerImage() throws IOException {
        String[] args = new String[] {
            "/bin/bash", "-c", "docker rm -f  " + containerId
        };
        final ProcessBuilder processBuilder = new ProcessBuilder(args);
        final Process start = processBuilder.start();
    }
}