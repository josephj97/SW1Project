import java.util.Vector;

public class Cart {
    private Vector<Product> Products;
    public Cart(){
        Products= new Vector<Product>();
    }
    public int SearchCart(String name){
        int ind=-1;
        for(int i=0;i<Products.size();i++){
            if(Products.get(i).getName().equals(name)){
                ind=i;
                break;
            }
        }
        return ind;
    }
    public double Buy(){
        double total=0;
        for(int i=0;i<Products.size();i++){
            Products.get(i).NoOfPurchases++;
            Products.get(i).getBrand().NoOfPurchases++;
            total+=Products.get(i).getPrice();
        }
        for(int i=0;i<Products.size();){
            Products.remove(i);
        }
        return total;
    }
    public boolean AddProduct(Product x){
        int ind=SearchCart(x.getName());
        if(ind==-1){
            Products.add(x);
            return true;
        }
        return false;
    }
    public boolean RemoveProduct(String name){
        int ind=SearchCart(name);
        if(ind!=-1){
            Products.remove(ind);
            return true;
        }
        return false;
    }
    public boolean ShowCart(){
        if(Products.size()==0){
            return false;
        }
        for(int i=0;i<Products.size();i++){
            System.out.println(Products.get(i).getName());
        }
        return true;
    }
}
