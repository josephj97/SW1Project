import javax.swing.*;
import java.util.Scanner;

public class Platform {
    UserController UserCtrl;
    ProductController ProductCtrl;
    BrandController BrandCtrl;
    StoreController StoreCtrl;
    SuggestionController SuggestionCtrl;
    VoucherController VoucherCtrl;
    CartController CartCtrl;
    PaymentController PaymentCtrl;
    public Platform(){
        UserCtrl=new UserController();
        ProductCtrl=new ProductController();
        BrandCtrl=new BrandController();
        StoreCtrl=new StoreController();
        SuggestionCtrl=new SuggestionController();
        VoucherCtrl=new VoucherController();
        CartCtrl=new CartController();
        PaymentCtrl=new PaymentController();
    }
    public void Start(){
        MainPageGUI gui=new MainPageGUI(this);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}















 /*
    public void Register(){
        while (true){
            System.out.print("Enter Name: ");
            String n=StringIn.nextLine();
            System.out.print("Enter Password: ");
            String p=StringIn.nextLine();
            System.out.print("Enter Type (NormalUser, StoreOwner, Administrator): ");
            String t=StringIn.nextLine();
            if(UserCtrl.Register(n,p,t)){
                UserCtrl.PrintUsers();
                break;
            }
        }
    }
    public void AddStore(){
        System.out.print("Enter Name: ");
        String n=StringIn.nextLine();
        System.out.print("Enter Address: ");
        String address=StringIn.nextLine();
        System.out.print("Enter Type (Online, Onsite): ");
        String t=StringIn.nextLine();
        System.out.print("Enter Link: ");
        String l=StringIn.nextLine();
        if(StoreCtrl.AddStore(n,address, t, l, (StoreOwner) UserCtrl.CurrentUser)){
            System.out.println("You've added the store successfully!");
        }
        else {
            System.out.println("This store cannot be added");
        }
        StoreCtrl.PrintStores();
    }
    public void AddProduct(){
        System.out.print("Enter Name: ");
        String n=StringIn.nextLine();
        System.out.print("Enter price: ");
        double p=input.nextDouble();
        System.out.print("Enter Category: ");
        String c=StringIn.nextLine();
        System.out.print("Enter Type (Online, Normal): ");
        String t=StringIn.nextLine();
        System.out.print("Enter Brand name: ");
        String b=StringIn.nextLine();
        int brandIndex=BrandCtrl.SearchBrand(b);
        if(brandIndex==-1){
            System.out.println("This brand is not found in the platform!");
            return;
        }
        if(ProductCtrl.AddProduct(n,p,c,t,BrandCtrl.Brands.get(brandIndex))){
            System.out.println("You've added the Product successfully!");
        }
        else {
            System.out.println("This Product cannot be added");
        }
        ProductCtrl.PrintProducts();
    }
    public void AddStoreProduct(){
        System.out.println("ana: "+ UserCtrl.CurrentUser.getName());
        System.out.println("Enter Product name: ");
        String n=StringIn.nextLine();
        System.out.println("Enter your store name: ");
        String sName=StringIn.nextLine();
        int productIndex=ProductCtrl.SearchProduct(n);
        if(productIndex==-1){
            System.out.println("This product is not found in the platform!");
            return;
        }
        if(StoreCtrl.AddProductToStore(ProductCtrl.Products.get(productIndex),sName,(StoreOwner) UserCtrl.CurrentUser)){

            System.out.println("You've added the Product successfully!");
            StoreCtrl.Stores.get(StoreCtrl.SearchStore(sName)).ShowStoreProducts();
        }
        else {
            System.out.println("This Product cannot be added to your store, it is already exist!");
        }
    }
    public void AddBrand(){
        System.out.print("Enter Name: ");
        String n=StringIn.nextLine();
        System.out.print("Enter company name: ");
        String companyName=StringIn.nextLine();
        if(BrandCtrl.AddBrand(n,companyName)){
            System.out.println("You've added the Brand successfully!");
        }
        else {
            System.out.println("This Brand cannot be added, it is already exists");
        }
        BrandCtrl.PrintBrands();
    }
    public void Suggest(){
        System.out.print("Enter Suggestion Name: ");
        String n=StringIn.nextLine();
        System.out.print("Enter Type: ");
        String t=StringIn.nextLine();
        if (SuggestionCtrl.AddSuggestion(n,t)){
            System.out.println("You've submitted your suggestion successfully!");
        }
        else {
            System.out.println("This suggestion cannot be added, it is already exists!");
        }
        SuggestionCtrl.ShowSuggestions();
    }
    public void BuyCart(){
        CartCtrl.SetCart(UserCtrl.CurrentUser);
        double totalPrice=CartCtrl.BuyCart();
        System.out.println("1) Pay by visa");
        System.out.println("2) Pay by cash");
        System.out.println("3) Pay by Voucher card");
        System.out.println("Enter the number of payment type you want to pay with: ");
        int paymentType=input.nextInt();
        PaymentCtrl.SetPrice(totalPrice);
        switch (paymentType){
            case 1:
                System.out.print("Enter Card Holder Name: ");
                String n=StringIn.nextLine();
                System.out.print("Enter Card Number: ");
                long num=input.nextLong();
                System.out.print("Enter Card Password: ");
                long pass=input.nextLong();
                PaymentCtrl.PayByVisa(n,num,pass);
                break;
            case 2:
                PaymentCtrl.PayByCash();
                break;
            case 3:
                while (true){
                    System.out.print("Enter Voucher's ID: ");
                    int voucherID=input.nextInt();
                    int voucherIndex=VoucherCtrl.SearchVouchers(voucherID);
                    if(voucherIndex==-1){
                        System.out.println("You've entered a wrong ID!");
                    }
                    else{
                        PaymentCtrl.PayByVoucher(VoucherCtrl.VoucherCards.get(voucherIndex));
                         break;
                    }
                }
                break;
            default :
                System.out.println("You've entered a wrong choice!");
                break;
        }
        CartCtrl.ShowCart();
    }
    public void ExploreStoreProducts(){
        System.out.print("Enter the store name you want to explore: ");
        String n=StringIn.nextLine();
        StoreCtrl.explore(n);
    }
    public void SearchStoreProducts(){
        System.out.print("Enter the store name you want to explore: ");
        String n=StringIn.nextLine();
        System.out.print("Enter the product name that you want to search for: ");
        String Pname=StringIn.nextLine();
        int StoreIndex=StoreCtrl.SearchStore(n);
        if(StoreIndex==-1){
            System.out.println("This store doesn't exist!");
            return;
        }
        if(!StoreCtrl.Stores.get(StoreIndex).SearchProductInStore(Pname)){
            System.out.println("No search results!");
        }
    }
    public void ViewProduct(){
        System.out.println("Enter the name of product you want: ");
        String n=StringIn.nextLine();
        int ProductIndex=ProductCtrl.SearchProduct(n);
        if(ProductIndex==-1){
            System.out.println("This product is not found!");
            return;
        }
        ProductCtrl.Products.get(ProductIndex).ShowInfo();
    }
    public void ExploreProductViews(){
        System.out.print("Enter the name of the store: ");
        String n=StringIn.nextLine();
        int StoreIndex=StoreCtrl.SearchStore(n);
        if(StoreIndex!=-1 && ((StoreOwner) UserCtrl.CurrentUser).SearchMyStores(n)==true){
            System.out.print("Enter product name: ");
            String Pname=StringIn.nextLine();
            StoreCtrl.CurrentStore=StoreCtrl.Stores.get(StoreIndex);
            System.out.println("Its number of views is: "+StoreCtrl.ExploreProductViews(Pname));
            return;
        }
        System.out.println("This store doesn't exist");
    }
    public void GetMostViewedProduct(){
        System.out.print("Enter the name of the store: ");
        String n=StringIn.nextLine();
        int StoreIndex=StoreCtrl.SearchStore(n);
        if(StoreIndex!=-1 && ((StoreOwner) UserCtrl.CurrentUser).SearchMyStores(n)==true){
            StoreCtrl.CurrentStore=StoreCtrl.Stores.get(StoreIndex);
            System.out.println("The most viewed product is: "+StoreCtrl.GetMostViewedProduct());
            return;
        }
        System.out.println("This store doesn't exist");
    }
    public void ProvideVoucherCards(){
        VoucherCtrl.PrintVouchers();
        System.out.print("Enter the name of the store you want to provide voucher cards: ");
        String n=StringIn.nextLine();
        int stroreIndex=StoreCtrl.SearchStore(n);
        if(stroreIndex==-1){
            System.out.println("This store is not found");
            return;
        }
        System.out.println("Enter how many cards you want to provide: ");
        int numCards=input.nextInt();
        VoucherCtrl.ProvideToStore(StoreCtrl.Stores.get(stroreIndex),numCards);
        for (int i=0;i<StoreCtrl.Stores.get(stroreIndex).VoucherCards.size();i++){
            StoreCtrl.Stores.get(stroreIndex).VoucherCards.get(i).GetID();
        }
    }
    public void AddToCart(){
        CartCtrl.SetCart(UserCtrl.CurrentUser);
        System.out.println("Enter the name of the product you want to add to the cart: ");
        String n=StringIn.nextLine();
        int ProductIndex=ProductCtrl.SearchProduct(n);
        if(ProductIndex==-1){
            System.out.println("This product doesn't exist!");
        }
        else {
            if(CartCtrl.AddToCart(ProductCtrl.Products.get(ProductIndex))){
                System.out.println("Added successfully!");
            }
            else {
                System.out.println("Cannot be added!");
            }
        }
        CartCtrl.ShowCart();
    }

    public void DeleteBrand(){}
    public void UpdateBrand(){}
    public void RemoveFromCart(){}
    public void ShowCart(){}
    public void PayByCash(){}
    public void PayByVisa(){}
    public void PayByVoucher(){}
    public void DeleteProduct(){}
    public void UpdateProduct(){}
    public void DeleteStore(){}
    public void ShowStatistics(){}
    public void DeleteSuggestion(){}
    public void ShowSuggestions(){}
    public void ProvideVoucherToUser(){}
    */