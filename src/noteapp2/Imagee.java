package noteapp2;
import java.awt.image.BufferedImage;

public class Imagee {
    private int imageId;
    private String path;
    private BufferedImage img;
    private static int count = 0;
    
    //Constructor that initializes the instance variables
    //and keeps track of the number of images added
    public Imagee(BufferedImage im, String p) 
    {
        imageId = count;
        this.img = im;
        this.path = p;
        count++;
    }
    
    //Returns the path to the image
    public String getImagePath() {return path;}
}
