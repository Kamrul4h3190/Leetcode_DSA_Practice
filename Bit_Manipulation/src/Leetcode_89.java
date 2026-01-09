import java.util.ArrayList;
import java.util.List;

public class Leetcode_89 {
    public static void main(String[] args) {
        Leetcode_89 app = new Leetcode_89();
        int n = 2;
        System.out.println("n bit gray sequence : "+app.grayCode(n));
    }
    public List<Integer> grayCode(int n) {
        n = 1<<n;//2^n
        List<Integer> gray = new ArrayList<>();
        for (int i = 0; i < n; i++)
            gray.add(i^(i>>1));//gray[i] = i^(i/2)
        return gray;
    }
}
