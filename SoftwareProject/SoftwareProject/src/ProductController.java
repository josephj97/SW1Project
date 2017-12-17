import java.util.Vector;

public class ProductController {
    public Vector<Product> Products;
    public ProductController(){
        Products=new Vector<Product>();
    }
    public int SearchProduct(String name){
        int index=-1;
        for(int i=0;i<Products.size();i++){
            if(Products.get(i).getName().equals(name)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean AddProduct(String n, double p, String ctgry, String type, Brand brand){
        Product NewProduct=new Product(n, p, ctgry, type, brand);
        if(SearchProduct(n)==-1){
            Products.add(NewProduct);
            return true;
        }
        return false;
    }
    public boolean DeleteProduct(String name){
        int ind=SearchProduct(name);
        if(ind!=-1){
            Products.remove(ind);
            return true;
        }
        return false;
    }
    public boolean UpdateProduct(String n, double p, int orders, Brand brand, Store store){
        int ind=SearchProduct(n);
        if(ind!=-1){
            Products.get(ind).UpdateProduct(p, orders, brand, store);
            return true;
        }
        return false;
    }
    public  void PrintProducts(){
        for (int i=0;i<Products.size();i++){
            System.out.println(Products.get(i).getName());
        }
    }
}
