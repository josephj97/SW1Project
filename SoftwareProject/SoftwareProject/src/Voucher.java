public class Voucher extends Payment{
    private VoucherCard Card;
    public Voucher(){
        Card=new VoucherCard();
    }
    public Voucher(VoucherCard x){
        Card=x;
    }
    public void Pay(double price){
        if(price>Card.GetValue()){
            price-=Card.GetValue();

            System.out.println("You've payed "+ Card.GetValue()+", the rest will be payed on delivery which is "+price+" .");
            Card.MinusFromCardValue(Card.GetValue());
            System.out.println("Now your card balance = "+Card.GetValue());
        }
        else {
            System.out.println("You've payed successfully! The products will be delivered to you in two days.");
            Card.MinusFromCardValue(price);
            System.out.println("Now your card balance = "+Card.GetValue());
        }
    }
}
