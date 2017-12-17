public class NormalUser extends User{
    private Cart MyCart;
    private VoucherCard Card;
    public NormalUser(String n, String pass, String t){
        MyCart=new Cart();
        Card=new VoucherCard();
        Name=n;
        Password=pass;
        Type=t;
    }
    public Cart GetCart(){
        return MyCart;
    }
}
