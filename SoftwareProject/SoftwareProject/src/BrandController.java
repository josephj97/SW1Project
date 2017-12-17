import java.util.Vector;

public class BrandController {
    public Vector<Brand> Brands;
    public BrandController(){
        Brands= new Vector<Brand>();
    }
    public int SearchBrand(String name){
        int index=-1;
        for(int i=0;i<Brands.size();i++){
            if(Brands.get(i).getName().equals(name)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean AddBrand(String n, String c){
        Brand NewBrand=new Brand(n, c);
        if(SearchBrand(n)==-1){
            Brands.add(NewBrand);
            return true;
        }
        return false;
    }
    public boolean DeleteBrand(String name){
        int ind=SearchBrand(name);
        if(ind!=-1){
            Brands.remove(ind);
            return true;
        }
        return false;
    }
    public boolean UpdateBrand(String n, String c){
        int ind=SearchBrand(n);
        if(ind!=-1){
            Brands.get(ind).UpdateBrand(c);
            return true;
        }
        return false;
    }
    public  void PrintBrands(){
        for (int i=0;i<Brands.size();i++){
            System.out.println(Brands.get(i).getName());
        }
    }
}
