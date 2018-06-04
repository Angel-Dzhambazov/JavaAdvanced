
package homeWorks.hw04_Sets_Maps;

//public class P10_Population {
//
//    private static HashMap<String, HashMap<String, Integer>> countries;
//    private static TreeMap<String, TreeMap<Integer, String>> output;
//    private static TreeMap<Integer, String> outputDarjavi;
//
//    public static void main(String[] args) {
//        countries = new HashMap<>();
//        output = new TreeMap<>();
//        outputDarjavi = new TreeMap<>();
//        Scanner scanner = new Scanner(System.in);
//
//        String[] command = scanner.nextLine().split("\\|");
//        while (!"report".equals(command[0])) {
//            String town = command[0];
//            String country = command[1];
//            Integer population = Integer.parseInt(command[2]);
//            addTown(town, country, population);
//            command = scanner.nextLine().split("\\|");
//        }
//
//
//        for (String darjava : countries.keySet()) {
//            Integer currentPopulation = 0;
//            HashMap<String, Integer> tempTownMap = new HashMap<>(countries.get(darjava));
//            TreeMap<Integer, String> townMapToPut = new TreeMap<>();
//            for (String town : tempTownMap.keySet()) {
//                currentPopulation += tempTownMap.get(town);
//                townMapToPut.put(tempTownMap.get(town), town);
//            }
//            outputDarjavi.put(currentPopulation, darjava);
//            output.put(darjava, townMapToPut);
//        }
//
//
//        String debug = " ";
//    }
//
//    public static void LinkedHashMap
//
//    <Integer, String> sortHashMapByValues(HashMap<Integer, String> passedMap) {
//        List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
//        List<String> mapValues = new ArrayList<>(passedMap.values());
//        Collections.sort(mapValues);
//        Collections.sort(mapKeys);
//
//        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
//
//        Iterator<String> valueIt = mapValues.iterator();
//        while (valueIt.hasNext()) {
//            String val = valueIt.next();
//            Iterator<Integer> keyIt = mapKeys.iterator();
//
//            while (keyIt.hasNext()) {
//                Integer key = keyIt.next();
//                String comp1 = passedMap.get(key);
//                String comp2 = val;
//
//                if (comp1.equals(comp2)) {
//                    keyIt.remove();
//                    sortedMap.put(key, val);
//                    break;
//                }
//            }
//        }
//        return sortedMap;
//    }
//
//    private static void addTown(String town, String country, Integer population) {
//
//        if (!countries.containsKey(country)) {
//            HashMap<String, Integer> tempTown = new HashMap<>();
//            tempTown.put(town, population);
//            countries.put(country, tempTown);
//        } else {
//            HashMap<String, Integer> tempTown = countries.get(country);
//            tempTown.put(town, population);
//            countries.put(country, tempTown);
//        }
//    }
//}
