public class Visa extends Payment {
    private String CardHolderName;
    private long CardNumber;
    private long SecurityCode;
    public Visa(){}
    public Visa(String n, long num, long pass){
        CardHolderName=n;
        CardNumber=num;
        SecurityCode=pass;
    }
    public void Pay(double price){
        System.out.println("You've payed successfully! The products will be delivered to you in two days.");
    }
}
