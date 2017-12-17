import java.util.Vector;

public class StoreController {
    Store CurrentStore;
    public Vector<Store> Stores;
    public StoreController(){
        Stores=new Vector<Store>();
    }
    public int SearchStore(String name){
        int index=-1;
        for(int i=0;i<Stores.size();i++){
            if(Stores.get(i).getName().equals(name)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean AddStore(String n, String add, String type, String link, StoreOwner user){
        Store NewStore=new Store(n, add, type, link);
        if(SearchStore(n)==-1){
            NewStore.TheStoreOwner=user;
            NewStore.TheStoreOwner.MyStores.add(NewStore);
            Stores.add(NewStore);
            return true;
        }
        return false;
    }
    public boolean DeleteStore(String name, StoreOwner user){
        int ind=SearchStore(name);
        if(ind!=-1){
            Stores.get(ind).TheStoreOwner.MyStores.remove(Stores.get(ind));
            Stores.remove(ind);
            return true;
        }
        return false;
    }
    public boolean AddProductToStore(Product p, String storeName, StoreOwner user){
        int ind=SearchStore(storeName);
        if(ind!=-1 && user.SearchMyStores(storeName)==true){
            if(Stores.get(ind).AddProductToStore(p)){
                return true;
            }
        }
        return false;
    }
    public boolean ShowStatistics(String name, StoreOwner user){
        int ind=SearchStore(name);
        if(ind!=-1 && user.SearchMyStores(name)==true){
            Stores.get(ind).ShowStatistics();
            return true;
        }
        return false;
    }
    public boolean explore(String storeName) {
        int ind=SearchStore(storeName);
        if(ind!=-1){
            Stores.get(ind).ShowStoreProducts();
            return true;
        }
        return false;
    }
    public String GetMostViewedProduct(){
        Product tmp= CurrentStore.GetMostViewedProduct();
        return tmp.getName();
    }
    public int ExploreProductViews(String name){
        int ExploreNo=CurrentStore.ExploreProductViews(name);
        return ExploreNo;
    }
    public  void PrintStores(){
        for (int i=0;i<Stores.size();i++){
            System.out.println(Stores.get(i).getName());
        }
    }
}
