package noteapp2;

public class SecureNote
{
    private String pass;
    private int sId;
    private String content; 
    private static int count = 0;

    public SecureNote(String c, String p)
    {
        this.sId = count;
        this.content = c;
        this.pass = p;
        count++;
    }
    public String getContent() {return content;}
    public String getPass() {return pass;}
}
