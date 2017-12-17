public class VoucherCard {
    private int ID;
    public static int VouchersNum=0;
    private double Value;
    public VoucherCard(){}
    public VoucherCard(double val){
        VouchersNum++;
        ID=VouchersNum;
        Value=val;
    }
    public double GetValue(){
        return Value;
    }
    public int GetID(){
        return ID;
    }
    public void ShowInfo(){
        System.out.println("Voucher Card ID: "+ID);
        System.out.println("Voucher Card Value: "+Value);
    }
    public void AddToCardValue(double val){
        Value+=val;
    }
    public void MinusFromCardValue(double val){
        Value-=val;
    }
}

