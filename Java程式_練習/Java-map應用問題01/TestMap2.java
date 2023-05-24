import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

// 題目：請在『/* insert code here */』這個地方寫程式讓 groupMap 能夠統計 list 裡面的數字。
// groupMap 的 key值 是 list 裡包含的數字。
// groupMap 的 value值 是 key 在 list 裡面出現多少次。
public class TestMap2 {
    public static void main(String[] args) {
        int n = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        TreeMap<Integer, Integer> groupMap = new TreeMap<>();
        for (int i = 1; i <= 200; ++i) {
            n = random.nextInt(40) + 1;
            list.add(n);
        }

        /* insert code here */

        System.out.println(groupMap);
    }
}
