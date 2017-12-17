
public class User {
    protected String Name;
    protected String Password;
    protected String Type;
    public User(){}
    public User(String n, String pass, String t){
        Name=n;
        Password=pass;
        Type=t;
    }
    public String getName(){
        return Name;
    }
    public String getPassword(){
        return Password;
    }
    public String getType(){
        return Type;
    }
}
