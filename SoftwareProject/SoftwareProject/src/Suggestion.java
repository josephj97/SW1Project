public class Suggestion {
    private String Name;
    private String Type;
    public Suggestion(){}
    public Suggestion(String n, String t){
        Name=n;
        Type=t;
    }
    public void setName(String n){
        Name=n;
    }
    public void setType(String t){
        Type=t;
    }
    public String getName(){
        return Name;
    }
    public void ShowInfo(){
        System.out.println("Suggestion name: "+Name);
        System.out.println("Suggestion Type: "+Type);
    }
}
