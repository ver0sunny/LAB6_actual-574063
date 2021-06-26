package Server;

import Common.collectionInfo.StudyGroup;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileManager {
    private static final Gson gson = new Gson();
    private String uploadedFile;

    public FileManager(String uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void writeToFile(LinkedList<StudyGroup> collection) {
        if (uploadedFile != null) {
            try {
                FileOutputStream fos = new FileOutputStream(uploadedFile);
                PrintWriter pw = new PrintWriter(fos);
                pw.write(gson.toJson(collection));
                pw.close();
            } catch (IOException e) {
                ServerConsole.printerror("File cannot be opened");
            }
        } else {
            ServerConsole.printerror("): No file found to write to :(");
        }
    }


    public LinkedList<StudyGroup> readFile() {
        if (uploadedFile != null) {
            try {
                File filename = new File(uploadedFile);
                Scanner sc = new Scanner(filename);
                LinkedList<StudyGroup> collection;
                collection = gson.fromJson(sc.nextLine().trim(), new TypeToken<LinkedList<StudyGroup>>(){}.getType());
                ServerConsole.println(" (: File upload was SUCCESSFUL :)");
                return collection;
            } catch (FileNotFoundException e) {
                ServerConsole.printerror("File not found");
            } catch (NoSuchElementException e) {
                ServerConsole.printerror("File is empty");
            } catch (JsonParseException e) {
                ServerConsole.printerror("File does not provide a collection");
                ServerConsole.println("ADVICE: check file/text format");
            }
        } else {
            ServerConsole.println(" ): No file chosen for upload :( ");
        }
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        return "FileManager (class for managing files)";
    }
}

