import java.util.*;

public class Bakery {

    public static List<List<String>> getListsOf3(List<String> list){
        List<List<String>> listsOf3 = new ArrayList<>();
        for(int i = 0; i< list.size(); i+=3){
            List<String> listOf3 = new ArrayList<>();
            listOf3.add(list.get(i));
            listOf3.add(list.get(i+1));
            listOf3.add(list.get(i+2));
            listsOf3.add(listOf3);
        }
        return listsOf3;
    }

    public static Map<Integer, Integer> sumOfElements(Map<Integer, List<Integer>> B){

        Map<Integer, Integer> mapOfSumOfElements = new HashMap<>();

        for(int key : B.keySet()){
            int sum = 0;
            List<Integer> values = B.get(key);
            for(int value : values){
                sum += value;
            }
            mapOfSumOfElements.put(key, sum);
        }
        return mapOfSumOfElements;
    }

//    public static List<Integer> method(Map<Integer,Integer> F, Map<Integer, Integer> B){
//        int min = Math.min(F.size(),B.size());
//        int rest=0;
//        List<Integer> listOfDays = new ArrayList<>();
//        for(int i = 1; i <= min+1; i++){
//            if(F.get(i) > B.get(i)){
//                rest = F.get(i) - B.get(i);
//            }
//
//            int paymentForNextDay = B.get(i+1) - rest;
//            if(paymentForNextDay != F.get(i+1)){
//                listOfDays.add(F.get(i+1));
//                B.put(i+1, paymentForNextDay);
//            }
//        }
//        return listOfDays;
//    }

    public static List<Integer> method(Map<Integer, Integer> F, Map<Integer, List<Integer>> B) {
        int min = Math.min(F.size(), B.size());
        int rest = 0;
        List<Integer> listOfDays = new ArrayList<>();
        for (int i = 1; i <= min + 1; i++) {
            if (F.get(i) > sumList(B.getOrDefault(i, Collections.emptyList()))) {
                rest = F.get(i) - sumList(B.getOrDefault(i, Collections.emptyList()));
            }

            int paymentForNextDay = sumList(B.getOrDefault(i + 1, Collections.emptyList())) - rest;
            if (paymentForNextDay != F.getOrDefault(i + 1, 0)) {
                listOfDays.add(F.get(i + 1));
                B.put(i + 1, Collections.singletonList(paymentForNextDay));
            }
        }
        return listOfDays;
    }

    private static int sumList(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input: ");
        List<String> list = new ArrayList<>();
        List<Integer> listOfDays = new ArrayList<>();
        Map<Integer, Integer> F = new HashMap<>();
        Map<Integer, List<Integer>> B = new HashMap<>();

        list = List.of(scan.nextLine().split(" "));
        List<List<String>> newList = getListsOf3(list);
        Map<Integer, List<Integer>> outputMap = new HashMap<>();

        for(int i = 0 ; i < newList.size(); i++){
            List<String> listOfThree = newList.get(i);
            if(listOfThree.get(0).equals("F")){
                F.put(Integer.parseInt(listOfThree.get(1)), Integer.parseInt(listOfThree.get(2)));
            } else {
                int key = Integer.parseInt(listOfThree.get(1));
                if (!B.containsKey(key)) {
                    B.put(key, new ArrayList<>());
                }
                B.get(key).add(Integer.parseInt(listOfThree.get(2)));
            }
        }
        Map<Integer,Integer> ceva = sumOfElements(B);
        listOfDays = method(F,B);
        System.out.println("Output: ");

        List<String> listOfDaysAsStrings = new ArrayList<>();
        for ( int i = 0; i < listOfDays.size(); i++){
            listOfDaysAsStrings.add(String.valueOf(listOfDays.get(i)));
        }
        String result = String.join(" ", listOfDaysAsStrings);
        System.out.println(result);
    }
}
