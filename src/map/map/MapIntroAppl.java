package map.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapIntroAppl {
    public static void main(String[] args) {
        Map<String, Integer> cities = new HashMap<>();
        System.out.println(cities.isEmpty());
        System.out.println(cities.size());
        cities.put("Denver", 600_000);
        cities.put("Boston", 670_000);
        cities.put("Chicago", 2_700_000);
        cities.put("Atlanta", 470_000);
        cities.put("New York", 8_500_000);
        cities.put("Dallas", 1_300_000);
        System.out.println(cities.size());
        Integer population = cities.get("Chicago");
        System.out.println(population);

        System.out.println(cities.containsKey("Boston"));
        System.out.println(cities.containsKey("Detroit"));
        System.out.println(cities.containsValue(600_000));
        System.out.println(cities.containsValue(700_000));
//        --- method 1
        Set<String> keys = cities.keySet();
//        keys.forEach(c -> System.out.print(c));
//        --- method 2
        Set<Map.Entry<String, Integer>> entries = cities.entrySet();
//        entries.forEach(e -> System.out.println(e));
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println("key: " + e.getKey());
            System.out.println("value: " + e.getValue());
        }

    }
}
