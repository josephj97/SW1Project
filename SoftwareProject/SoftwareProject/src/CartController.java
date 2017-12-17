public class CartController {
    private Cart CurrentCart;
    private NormalUser CurrUser;
    public CartController(){
        CurrUser=null;
        CurrentCart=null;
    }
    public void SetCart(User x){
        CurrUser=(NormalUser) x;
        CurrentCart=CurrUser.GetCart();
    }
    public double BuyCart(){
        double totalPrice=CurrentCart.Buy();
        return totalPrice;
    }
    public boolean AddToCart(Product p){
        if(CurrentCart.AddProduct(p)){
            return true;
        }
        return false;
    }
    public boolean RemoveFromCart(String name){
        if (CurrentCart.RemoveProduct(name)){
            return true;
        }
        return false;
    }
    public boolean ShowCart(){
        if(CurrentCart.ShowCart()==false){
            return false;
        }
        else{
            return true;
        }
    }
}
