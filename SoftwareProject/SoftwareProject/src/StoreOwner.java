import java.util.Vector;

public class StoreOwner extends User{
    public Vector<Store> MyStores;
    public StoreOwner(String n, String pass, String t){
        Name=n;
        Password=pass;
        Type=t;
        MyStores=new Vector<Store>();
    }
    public boolean SearchMyStores(String name){
        int index=-1;
        for(int i=0;i<MyStores.size();i++){
            if(MyStores.get(i).getName().equals(name)){
                index=i;
                break;
            }
        }
        if(index==-1){
            return false;
        }
        return true;
    }
}
