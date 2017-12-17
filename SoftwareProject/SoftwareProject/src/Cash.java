public class Cash extends Payment{
    public Cash(){}
    public void Pay(double price){
        System.out.println("The products you've bought will be delivered to you, and you'll have to pay "+ price);
    }
}
