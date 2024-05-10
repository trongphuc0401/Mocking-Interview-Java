package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalofTriangle {
    public List<List<Integer>> generate(int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            for (int j = row.size() - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
            result.add(new ArrayList<>(row));
        }

        return result;
    }
}
