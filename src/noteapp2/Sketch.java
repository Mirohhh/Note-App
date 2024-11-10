package noteapp2;

public class Sketch {

    private int sketchId;
    private String sketchPath;
    private static int count = 0;

    public Sketch(String path)
    {
        this.sketchId = count;
        this.sketchPath = path;
        count++;
    }
}
