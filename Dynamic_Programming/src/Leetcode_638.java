import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_638 {
    public static void main(String[] args) {
        Leetcode_638 app = new Leetcode_638();
//        List<Integer> price = List.of(new Integer[]{2,5}); List<Integer> needs = List.of(new Integer[]{3,2});
//        Integer[][] specialOffers = {{3,0,5},{1,2,10}}; List<List<Integer>> special = new ArrayList<>();
        List<Integer> price = List.of(new Integer[]{2,3}); List<Integer> needs = List.of(new Integer[]{1,1});
        Integer[][] specialOffers = {{1,0,1},{0,1,2}}; List<List<Integer>> special = new ArrayList<>();
        for (Integer[] sp: specialOffers) special.add(new ArrayList<>(List.of(sp)));

        System.out.println("min cost shopping : "+app.shoppingOffers(price,special,needs));
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        memOffers = new HashMap<>();
        return exploreOffers(0,price,special,needs);
    }
    Map<String,Integer> memOffers;
    private int exploreOffers(int index,List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if (index>= special.size()) return calculatePrice(needs,price);

        String key = "";  key+=index; for (int need : needs) key+=need;
        if(memOffers.containsKey(key)) return memOffers.get(key);

        if (takeOffer(needs,special.get(index))){ //if offer is take worthy we will explore. Else pass to the next offer
            List<Integer> updatedNeeds = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                updatedNeeds.add(needs.get(i) - special.get(index).get(i));
            }

            int takeOffer = special.get(index).getLast() + exploreOffers(index, price, special, updatedNeeds);
            int skipOffer = exploreOffers(index+1, price, special, needs);

            int cheapest =  Math.min(takeOffer,skipOffer);
            memOffers.put(key,cheapest);    return cheapest;


        }
        else{
            int nextOffer = exploreOffers(index+1, price, special, needs);
            memOffers.put(key,nextOffer);   return nextOffer;
        }
    }
    private boolean takeOffer(List<Integer> needs,List<Integer> offer){//we can not take more than we need, even if exists in offer
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) return false;
        }
        return true;
    }
    private int calculatePrice(List<Integer> needs,List<Integer> price){
        int totalPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
            totalPrice += needs.get(i) * price.get(i);
        }
        return totalPrice;
    }
}
