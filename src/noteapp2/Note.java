package noteapp2;
import java.util.Date;

public class Note 
{
    private String content = "";
    private int noteId;
    private final Date creatDate;
    private Date lastModified;
    private String notePath;
    private static int count = 0;
    
    //Constructor that initializes the instance variables
    //and keeps track of the number of notes created
    public Note(String defaultContent, Date currentDate, Date lastModified)
    {
        this.noteId = count;
        this.content = defaultContent;
        this.creatDate = currentDate;
        this.lastModified = lastModified;
        count++;
    }

    //Setter and Getter methods
    public void setNotePath(String path) {notePath = path;}
    public String getNotePath() {return notePath;}
    public int getNoteId(){return noteId;}
    public String getContent(){return content;}
    public Date getCreateDate(){return creatDate;}
    public Date getLastModified(){return lastModified;}    
}
