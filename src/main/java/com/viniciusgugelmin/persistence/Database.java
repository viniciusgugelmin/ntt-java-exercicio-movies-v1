package main.java.com.viniciusgugelmin.persistence;

import java.io.*;

public class Database {
    private static final String FILE_PATH = "database.txt";
    protected static final String MOVIES_KEY = "movies";
    private String jsonData;

    public Database() throws IOException {
        if (!fileExists()) {
            createFile();
            initializeWithMovies();
            return;
        }

        this.jsonData = readData();

        if (jsonData.isEmpty()) {
            initializeWithMovies();
        }
    }

    private boolean fileExists() {
        File file = new File(FILE_PATH);
        return file.exists();
    }

    private void createFile() {
        try {
            File file = new File(FILE_PATH);

            if (file.createNewFile()) {
                System.out.println("File created: " + FILE_PATH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeWithMovies() throws IOException {
        jsonData = "{ \"" + MOVIES_KEY + "\": [] }";
        writeData(jsonData);
    }

    protected String readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

    protected void writeData(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(data);
        }
    }
}
