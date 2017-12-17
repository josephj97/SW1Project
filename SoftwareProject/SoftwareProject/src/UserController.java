
import java.util.Vector;

public class UserController {
    public Vector<User> Users;
    public User CurrentUser;
    public UserController(){
        Users=new Vector<User>();
        User admin=new Administrator("Dalia","123","Administrator");
        Users.add(admin);
    }
    public int SearchUser(String name, String pass){
        int index=-1;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getName().equals(name) && Users.get(i).Password.equals(pass)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean Register(String username, String password, String type){
        int ind=SearchUser(username, password);
        if(ind==-1){
            if(type.equals("Normal")){
                CurrentUser=new NormalUser(username, password, type);
            }
            else if(type.equals("StoreOwner")){
                CurrentUser=new StoreOwner(username, password, type);
            }
            else{
                return false;
            }
            Users.add(CurrentUser);
            return true;
        }
        return false;

    }
    public boolean Login(String name, String pass){
        int ind=SearchUser(name,pass);
        if(ind!=-1){
            CurrentUser = Users.get(ind);
            return true;
        }
        return false;
    }
    public  void PrintUsers(){
        for (int i=0;i<Users.size();i++){
            System.out.println(Users.get(i).getName());
        }
    }
}
