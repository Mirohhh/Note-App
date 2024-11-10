package noteapp2;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User 
{
    private String username;
    private String password;
    private boolean isLoggedIn;
    private List<Note> notes = new ArrayList<>();
    private List<Imagee> images = new ArrayList<>();
    private List<Sketch> sketches = new ArrayList<>();
    private List<SecureNote> sNotes = new ArrayList<>();
    
    //Constructor that initializes the instance variables
    public User(String name, String pass)
    {
        this.username = name;
        this.password = pass;
        isLoggedIn = false;
    }
    
    //Method that checks if the user is currently logged-in
    public boolean logIn(String name, String pass)
    {
        if (this.username.equals(name) && this.password.equals(pass))
        {
            isLoggedIn = true;
            System.out.println("Login successful");
            return true;
        }
        else
        {
            System.out.println("Login failed");
            return false;
        }
    }
    
    //Method that resets the current user
    public void logout() 
    {
        if(isLoggedIn=true)
        {
            isLoggedIn = false;
            username = null;
            System.out.println("Logout successful");  
        }
    }
    
    //Method that makes a note object with the String attribute
    //and current date and adds it to the list of notes then uses
    //the savenote method from the FileManager class to save the
    //note to the hard drive in the selected path
    public void addNote(String content)
    {
        if (!isLoggedIn) 
        {
            System.out.println("User not logged in. Cannot create a note.");
        }
        else
        {
        Date currentDate = new Date();
        Note newNote = new Note(content, currentDate, currentDate);
        FileManager fm = new FileManager();
        notes.add(newNote);
        fm.savenote(newNote);
        }
    }

    //Method that returns the content of a text file
    public String openNote(File file) throws Exception
    {
        String pt = file.getPath();
        String data = new String(Files.readAllBytes(Paths.get(pt)));
        return data;
    }
    
    //Method that adds an image and adds it
    //to the list of images
    public void addImage(BufferedImage img, String pth) {
        if (!isLoggedIn) {
            System.out.println("User not logged in. Cannot create an image.");
        }
        else
        {
            Imagee imm = new Imagee(img, pth);
            images.add(imm);
            System.out.println("Image created successfully!");
        }
    }
    
    //Method that iterates through the list of images
    //and copies them to the user's folder in the
    //selected path
    public void saveImages(String path)
    {
        File file;
        for (Iterator<Imagee> iterator = images.iterator(); iterator.hasNext();) {
            file = new File(iterator.next().getImagePath());
            try
            {
                Files.copy(file.toPath(),            
                        (new File(path + File.separator + file.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addSketch(String path) {
        if (!isLoggedIn) {
            System.out.println("User not logged in. Cannot add a sketch.");
        }
        else
        {
        Sketch newSketch = new Sketch(path);
        sketches.add(newSketch);
        System.out.println("Sketch created successfully!");
        }
    }
    
    public void addSecureNote(String c, String p)
    {
        if (!isLoggedIn) {
            System.out.println("User not logged in. Cannot add a secure note.");
        }
        else
        {
            SecureNote sNote = new SecureNote(c, p);
            sNotes.add(sNote);
            System.out.println("Secure note added successfully!");
        }
    }
    
    public String openSecureNote(int i)
    {
        return sNotes.get(i).getContent();
    }
    
    public boolean checkMatch(int i, String p)
    {
        return sNotes.get(i).getPass().equals(p);
    }
    
    public boolean checkSize(int i) {return i < sNotes.size();}
    
    public void deleteSecureNote(int i) 
    {
        sNotes.remove(i);
        System.out.println("Removed the note successfully!");
    }
    
    //Getter methods
    public String getUsername() {return username;}
    public int getSListSize() {return sketches.size();}
    public int getSecureListSize() {return sNotes.size();}
}