import java.util.ArrayList;
import java.util.List;

public class Leetcode_1352 {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);

        System.out.println(productOfNumbers.getProduct(2));
    }
    static class ProductOfNumbers {
        int product = 1;
        List<Integer> prefixProds;
        public ProductOfNumbers() {
            prefixProds = new ArrayList<>();
        }

        public void add(int num) {
            if (num==0){
                prefixProds.clear();
                product = 1;//reset
            }else{
                product *= num;//keep calculating prefix product for the new elements
                prefixProds.add(product);
            }
        }

        public int getProduct(int k) {
            if (k>prefixProds.size()) return 0; //less than k elements
            if (k == prefixProds.size()) return prefixProds.getLast();
            return prefixProds.getLast()/prefixProds.get(prefixProds.size()-k-1);
        }
    }
}