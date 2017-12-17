import java.util.Vector;

public class Product {
    private String Name;
    private double Price;
    private String Category;
    private String Type;
    public int NoOfPurchases;
    public int NoOfExplores;
    private Brand ProductBrand;
    private Vector<Store> ProductStores;
    public Product(){
        NoOfPurchases=0;
        NoOfExplores=0;
        ProductStores=new Vector<Store>();
        ProductBrand=new Brand();
    }
    public Product(String n, double p, String ctgry, String type, Brand brand){
        ProductStores=new Vector<Store>();
        Name=n;
        Price=p;
        Category=ctgry;
        Type=type;
        NoOfPurchases=0;
        NoOfExplores=0;
        ProductBrand=brand;
    }
    public boolean AddStore(Store s){
        for(int i=0;i<ProductStores.size();i++){
            if(ProductStores.get(i).equals(s)){
                return false;
            }
        }
        ProductStores.add(s);
        return true;
    }
    public String getName(){
        return Name;
    }
    public double getPrice(){
        return Price;
    }
    public Brand getBrand(){return ProductBrand;}
    public void ShowInfo(){
        NoOfExplores++;
        System.out.println("Product Name: "+Name);
        System.out.println("Product Price: "+Price);
        System.out.println("Product Category: "+Category);
        System.out.println("Product Type: "+Type);
        System.out.println("Product Brand: "+ ProductBrand.getName());
        System.out.println("Product Stores: ");
        for (int i=0;i<ProductStores.size();i++){
            System.out.println((i+1)+") "+ProductStores.get(i).getName());
        }
    }
    public void UpdateProduct(double p, int orders, Brand brand, Store store){
        Price=p;
        NoOfPurchases=orders;
        ProductBrand=brand;
        if(ProductStores.contains(store)==false){
            ProductStores.add(store);
        }
    }
}
