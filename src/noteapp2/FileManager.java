package noteapp2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
    List<User> users = new ArrayList<>();
    private final String userName;
    private String defaultPath;
    private static String pathToFolder;
    private static String notePath;
    private static int count = 0;
    
    //Constructor that gets the pc user's name and
    //assigns the default path to the desktop
    public FileManager()
    {
        userName = System.getProperty("user.name");
        defaultPath = "C:\\Users\\" + userName + "\\Desktop\\";
    }
    
    //A method that takes a user and adds it to
    //the list of users and makes a folder for that user
    public String addUser(User u)
    {
        users.add(u);
        count++;
        pathToFolder = defaultPath + u.getUsername() + "'s notes";
        File userFolder = new File(pathToFolder);
        userFolder.mkdir();
        System.out.println("Made Dir Successfully!");
        return pathToFolder;
    }
    
    //Setter and Getter methods
    public void setPath(String path) {defaultPath = path; pathToFolder = defaultPath;}
    public String getPath() {return defaultPath;}
    public String getNotePath() {return notePath;}
    public String getFolderPath() {return  pathToFolder;}
    
    //A method that takes a note and
    //write its content to a text file
    //in the selected path
    public void savenote(Note note){
        if (note == null)
        {
            System.out.println("Note is null. Cannot save.");
        }
        else 
        {
            File file = new File(pathToFolder + File.separator + "note_" + note.getNoteId() + ".txt");
            notePath = file.getPath();
            int noteNum = note.getNoteId();
            while (file.exists()) {
                noteNum++;
                file = new File(pathToFolder + File.separator + "note_" + noteNum + ".txt");
                notePath = file.getPath();
            }
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(note.getContent() + "\n\n");
                writer.write("Create Date: " + note.getCreateDate() + "\n");
                writer.write("Last Modified: " + note.getLastModified());
                System.out.println("Note saved successfully.");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error saving note: " + e.getMessage());
            }
        }
    }
    
    //Not used
    public void editNote(Note note){
        if (note == null)
        {
            System.out.println("Note is null. Cannot save.");
        }
        else 
        {
            File file = new File(pathToFolder + File.separator + "note_" + note.getNoteId() + ".txt");
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(note.getContent() + "\n\n");
                writer.write("Create Date: " + note.getCreateDate() + "\n");
                writer.write("Last Modified: " + note.getLastModified() + "\n");
                System.out.println("Note saved successfully.");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error saving note: " + e.getMessage());
            }
        }
    }
}