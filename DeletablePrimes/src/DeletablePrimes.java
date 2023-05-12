import java.util.*;

public class DeletablePrimes {

    private long primeInt;

    public DeletablePrimes(long primeInt){
        this.primeInt =primeInt;
    }

    public long countNrOfPrimeInceptionMemo(DeletablePrimes deletablePrimes, Map<Long, Long> memo){
        System.out.println("countNrOfPrimeInceptionMemo called with " + deletablePrimes.primeInt);
        if(deletablePrimes.primeInt<10){
            return 1;
        }else if(memo.containsKey(deletablePrimes.primeInt)){
            System.out.println("countNrOfPrimeInceptionMemo returning memoized result " + memo.get(deletablePrimes.primeInt) + " for " + deletablePrimes.primeInt);
            return memo.get(deletablePrimes.primeInt);
        }else{
            long count = 0;
            ArrayList<Long> deletions = deletablePrimes.primesFromPrime(deletablePrimes);
            for (long deletion : deletions) {
                count += countNrOfPrimeInceptionMemo(new DeletablePrimes(deletion), memo);
            }
            memo.put(deletablePrimes.primeInt, count);
            System.out.println("countNrOfPrimeInceptionMemo returning " + count + " for " + deletablePrimes.primeInt);
            return count;
        }
    }


//
//    public long countNrOfPrimeInception(DeletablePrimes deletablePrimes){
//        System.out.println("countNrOfPrimeInception called with " + deletablePrimes.primeInt);
//        if(deletablePrimes.primeInt<10){
//            return 1;
//        }else{
//            long count = 0;
//            ArrayList<Long> deletions = deletablePrimes.primesFromPrime(deletablePrimes);
//            for (long deletion : deletions) {
//                count += countNrOfPrimeInception(new DeletablePrimes(deletion));
//            }
//            System.out.println("countNrOfPrimeInception returning " + count + " for " + deletablePrimes.primeInt);
//            return count;
//        }
//    }


    public ArrayList<Long> numbersFromANumber(DeletablePrimes deletablePrimes){
        ArrayList<Long> arr = new ArrayList<>();
        String nString = Long.toString(primeInt);
        for(int i = 0; i<nString.length();i++){
            String newNString = nString.substring(0, i) + nString.substring(i+1);
            long newNumber = Long.parseLong(newNString);
            arr.add(newNumber);
        }
        return arr;
    }

    public ArrayList<Long> primeNrsInAList(ArrayList<Long> arr){
        ArrayList<Long> arr2 = new ArrayList<>();
        for(int i=0; i<arr.size();i++){
            if(isPrime(arr.get(i))) {
                arr2.add(arr.get(i));
            }
        }
        return arr2;
    }

    public ArrayList<Long> primesFromPrime(DeletablePrimes deletablePrimes){
        ArrayList<Long> list = numbersFromANumber(deletablePrimes);
        return  primeNrsInAList(list);
    }

    public boolean isPrime(long n){
        if(n<=1)
            return false;
        for(int i=2;i<n;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Long, Long> memo = new HashMap<Long, Long>();

        System.out.println("Enter a prime number:");
        long prime = scanner.nextLong();

        DeletablePrimes deletablePrimes = new DeletablePrimes(prime);

        ArrayList<Long> list = deletablePrimes.primesFromPrime(deletablePrimes);
        System.out.println("List of deletions: " + list);

        long count = deletablePrimes.countNrOfPrimeInceptionMemo(deletablePrimes, memo);
        System.out.println("Number of prime inceptions: " + count);
    }
}
