import java.util.Vector;

public class Brand {
    private String Name;
    private Vector<String> CompanyName;
    public int NoOfPurchases;
    public Brand(){}
    public Brand(String n, String c){
        Name=n;
        CompanyName=new Vector<String>();
        CompanyName.add(c);
    }
    public void ShowInfo(){
        System.out.println("Brand name: "+Name);
        System.out.println("Brand company name: "+CompanyName);
    }
    public String getName(){
        return Name;
    }
    public void UpdateBrand(String c){
        if(CompanyName.contains(c)==false){
            CompanyName.add(c);
        }
    }
}
