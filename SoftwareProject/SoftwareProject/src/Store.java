import java.util.Vector;

public class Store {
    private String Name;
    private String Address;
    private String Type;
    private String Link;
    public StoreOwner TheStoreOwner;
    private Statistics StoreStatistics;
    public Vector<Product> StoreProducts;
    public Vector<VoucherCard> VoucherCards;
    public Store(){
        StoreProducts=new Vector<Product>();
        VoucherCards=new Vector<VoucherCard>();
        StoreStatistics=new Statistics();
    }
    public Store(String n, String add, String type, String link){
        Name=n;
        Address=add;
        Type=type;
        Link=link;
        StoreProducts=new Vector<Product>();
        VoucherCards=new Vector<VoucherCard>();
        StoreStatistics=new Statistics();
    }
    public String getName(){
        return Name;
    }
    public boolean AddProductToStore(Product p){
        if(StoreProducts.contains(p)==true){
            return false;
        }
        else {
            StoreProducts.add(p);
            p.AddStore(this);
            return true;
        }
    }
    public void ShowInfo(){
        System.out.println("Store name: "+Name);
        System.out.println("Store address: "+Address);
        System.out.println("Store type: "+Type);
        System.out.println("Store link: "+Link);
        System.out.print("Store products: ");
        for (int i=0;i<StoreProducts.size();i++){
            System.out.println((i+1)+") "+StoreProducts.get(i).getName());
        }
    }
    public void ShowStatistics(){
        StoreStatistics.ShowStatistics();
    }
    public void ShowStoreProducts() {
        for(int i=0;i<StoreProducts.size();i++) {
            System.out.println(StoreProducts.get(i).getName());
        }
    }
    public boolean SearchProductInStore(String name){
        int index=-1;
        for (int i=0;i<StoreProducts.size();i++){
            if(StoreProducts.get(i).getName().contains(name)){
                StoreProducts.get(i).getName();
                index=i;
            }
        }
        if(index==-1){
            return false;
        }
        return true;
    }
    public Product GetMostViewedProduct(){
        int index=-1;
        int mostViewed=-1;
        for(int i=0;i<StoreProducts.size();i++) {
           if(StoreProducts.get(i).NoOfExplores>mostViewed){
               index=i;
               mostViewed=StoreProducts.get(i).NoOfExplores;
           }
        }
        if(index==-1){
            return null;
        }
        return StoreProducts.get(index);
    }
    public int ExploreProductViews(String name){
        int index=-1;
        int ExploresNo=0;
        for (int i=0;i<StoreProducts.size();i++){
            if(StoreProducts.get(i).getName().equals(name)){
                ExploresNo=StoreProducts.get(i).NoOfExplores;
                index=i;
            }
        }
        if (index==-1){
            return index;
        }
        return ExploresNo;
    }
}
