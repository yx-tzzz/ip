package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import task.*;

/**
 * The Storage class handles file operations.
 * It ensures that tasks are loaded and saved to a text file.
 */
public class Storage {
    private static final String FILE_PATH = "data/SleepyVoid.txt";

    /**
     * Constructs a new Storage instance, ensuring the storage file exists and reading tasks from it.
     * Creates the data directory if it does not already exist.
     */
    public Storage() {
        File dataDir = new File("./data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
    }

    /**
     * Loads tasks from the specified text file.
     * If the file does not exist, an empty list is returned.
     * The file is expected to contain tasks in a specific format, and each task is parsed accordingly.
     *
     * @return An {@link ArrayList} of {@link Task} objects loaded from the file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> savedTasks = new ArrayList<>();
        File textFile = new File(FILE_PATH);

        if (!textFile.exists()) {
            return savedTasks;
        }

        try (Scanner scanner = new Scanner(textFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| | ~ ");
                if (parts.length < 3) {
                    throw new IOException();
                }
                String taskType = parts[0];
                String completionStatus = parts[1];
                String content = parts[2];

                Task task;
                switch (taskType) {
                    case "Todo":
                        task = new Todos(content);
                        break;

                    case "Deadline":
                        if (parts.length < 4) {
                            throw new IOException();
                        }
                        task = new Deadlines(content, parts[3]);
                        break;

                    case "Event":
                        if (parts.length < 5) {
                            throw new IOException();
                        }
                        task = new Events(content, parts[3], parts[4]);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + taskType);
                }
                if (task != null) {
                    savedTasks.add(task);
                    if (completionStatus.equals("Completed ^* *^")) {
                        savedTasks.get(savedTasks.size()-1).markAsDone();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("            /ᐠ˵x x˵マ File not found: " + FILE_PATH);
        } catch (IOException e){
            System.out.println("            /ᐠ˵x x˵マ :");
        }
        return savedTasks;
    }

    /**
     * Saves the current list of tasks to the specified text file.
     * Each task is written to the file in a specific format.
     *
     * @param tasks The {@link TaskList} containing the tasks to be saved
     */
    public void saveTasks(TaskList tasks) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println(Strings.ERROR_VOID + " Error saving tasks to file: " + FILE_PATH);
        }
    }
}