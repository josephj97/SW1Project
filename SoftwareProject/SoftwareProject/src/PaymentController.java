public class PaymentController {
    private double Price;
    private Payment PaymentMethod;
    public PaymentController(){}
    public void SetPrice(double p){
        Price=p;
    }
    public void PayByCash(){
        PaymentMethod= new Cash();
        PaymentMethod.Pay(Price);
    }
    public void PayByVisa(String n, long num, long pass){
        PaymentMethod= new Visa(n, num, pass);
        PaymentMethod.Pay(Price);
    }
    public void PayByVoucher(VoucherCard x){
        PaymentMethod= new Voucher(x);
        PaymentMethod.Pay(Price);
    }
}
