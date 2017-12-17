import java.util.Vector;

public class SuggestionController {
    public Vector<Suggestion> Suggestions;
    public SuggestionController(){
        Suggestions=new Vector<Suggestion>();
    }
    public int SearchSuggestion(String name){
        int index=-1;
        for(int i=0;i<Suggestions.size();i++){
            if(Suggestions.get(i).getName().equals(name)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean AddSuggestion(String n, String t){
        Suggestion NewSuggestion=new Suggestion(n,t);
        if(SearchSuggestion(n)==-1){
            Suggestions.add(NewSuggestion);
            return true;
        }
        return false;
    }
    public boolean DeleteSuggestion(String name){
        int ind=SearchSuggestion(name);
        if(ind!=-1){
            Suggestions.remove(ind);
            return true;
        }
        return false;
    }
    public void ShowSuggestions(){
        System.out.println("Suggestions: ");
        for (int i=0;i<Suggestions.size();i++){
            System.out.print((i+1)+") ");
            Suggestions.get(i).ShowInfo();
        }
    }
}
