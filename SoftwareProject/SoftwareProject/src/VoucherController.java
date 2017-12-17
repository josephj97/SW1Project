import java.util.Vector;

public class VoucherController {
    public Vector<VoucherCard> VoucherCards;
    int ProvidedIndex;
    public VoucherController(){
        VoucherCards=new Vector<VoucherCard>();
        ProvidedIndex=0;
        for(int i=0;i<20;i++){
            VoucherCard newVoucher= new VoucherCard(500.0);
            VoucherCards.add(newVoucher);
        }
    }
    public int SearchVouchers(int id){
        int ind=-1;
        for (int i=0;i<VoucherCards.size();i++){
            if(VoucherCards.get(i).GetID()==id){
                ind=i;
                break;
            }
        }
        return ind;
    }
    public void AddCard(double val){
        VoucherCard newVoucher=new VoucherCard(val);
        VoucherCards.add(newVoucher);
    }
    public boolean RemoveCard(int id){
        int ind=SearchVouchers(id);
        if(ind!=-1){
            VoucherCards.remove(ind);
            return true;
        }
        return false;
    }
    public void ProvideToStore(Store store, int numberOfCards){
        for(int i=0;ProvidedIndex<VoucherCards.size() && i<numberOfCards;ProvidedIndex++, i++){
            store.VoucherCards.add(VoucherCards.get(ProvidedIndex));
        }
    }
    public  void PrintVouchers(){
        for (int i=0;i<VoucherCards.size();i++){
            System.out.println(VoucherCards.get(i).GetID());
        }
    }
}
