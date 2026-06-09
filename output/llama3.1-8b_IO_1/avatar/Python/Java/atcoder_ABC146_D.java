import java.util.*;

public class atcoder_ABC146_D {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add((int) (Math.random() * 100));
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer integer : list) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                int count = map.get(integer);
                map.put(integer, count + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
