import java.util.Vector;

public class Statistics {
    public Vector<Product> MostOrderedProducts;
    public Vector<Brand> MostOrderedBrands;
    public Statistics(){
        MostOrderedBrands=new Vector<Brand>();
        MostOrderedProducts=new Vector<Product>();
    }
    public boolean SearchOrderedProducts(Product p){
        int index=-1;
        for (int i=0;i<MostOrderedProducts.size();i++){
            if(MostOrderedProducts.get(i)==p){
                index=i;
            }
        }
        if(index==-1){
            return false;
        }
        return true;
    }
    public boolean SearchOrderedBrands(Brand b){
        int index=-1;
        for (int i=0;i<MostOrderedBrands.size();i++){
            if(MostOrderedBrands.get(i)==b){
                index=i;
            }
        }
        if(index==-1){
            return false;
        }
        return true;
    }
    public void GetMostOrderedProducts(Vector<Product> storeProducts){
        int tmp=-1; // save the largest no of orders of a product
        int index=0;
        int counter=0; // count no. of Products that should be in the vector
        for(int j=0;j<10 && j<storeProducts.size();j++){
            for(int i=0;i<storeProducts.size();i++){
                if(storeProducts.get(i).NoOfPurchases>tmp && SearchOrderedProducts(storeProducts.get(i))==false){
                    tmp=storeProducts.get(i).NoOfPurchases;
                    index=i;
                }
            }
            MostOrderedProducts.add(storeProducts.get(index));
        }
    }
    public void GetMostOrderedBrands(Vector<Brand> brandProducts){
        int tmp=-1; // save the largest no of orders of a product
        int index=0;
        int counter=0; // count no. of Products that should be in the vector
        for(int j=0;j<10 && j<brandProducts.size();j++){
            for(int i=0;i<brandProducts.size();i++){
                if(brandProducts.get(i).NoOfPurchases>tmp && SearchOrderedBrands(brandProducts.get(i))==false){
                    tmp=brandProducts.get(i).NoOfPurchases;
                    index=i;
                }
            }
            MostOrderedBrands.add(brandProducts.get(index));
        }
    }
    public void ShowStatistics(){
        System.out.print("Most Ordered Products: ");
        for (int i=0;i<MostOrderedProducts.size();i++){
            System.out.println(i+") "+MostOrderedProducts.get(i).getName());
        }
        System.out.print("Most Ordered Brands: ");
        for (int i=0;i<MostOrderedBrands.size();i++){
            System.out.println(i+") "+MostOrderedBrands.get(i).getName());
        }
    }
}
