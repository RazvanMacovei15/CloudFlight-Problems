import java.util.*;

public class PrimeInceptionCounter {

    private long primeInt;
    private static Map<Long, Long> memo = new HashMap<>();

    public PrimeInceptionCounter(long primeInt){
        this.primeInt = primeInt;
    }

    public long countPrimeInceptions() {
        if (this.primeInt < 10) {
            return 1;
        } else if (memo.containsKey(this.primeInt)) {
            return memo.get(this.primeInt);
        } else {
            long count = 0;
            List<Long> deletions = primesFromPrime();
            for (long deletion : deletions) {
                count += new PrimeInceptionCounter(deletion).countPrimeInceptions();
            }
            memo.put(this.primeInt, count);
            return count;
        }
    }

    public ArrayList<Long> numbersFromANumber() {
        ArrayList<Long> arr = new ArrayList<>();
        String nString = Long.toString(this.primeInt);
        for (int i = 0; i < nString.length(); i++) {
            StringBuilder sb = new StringBuilder(nString);
            sb.deleteCharAt(i);
            long newNumber = Long.parseLong(sb.toString());
            arr.add(newNumber);
        }
        return arr;
    }

    public List<Long> primesFromPrime() {
        ArrayList<Long> list = numbersFromANumber();
        return list.stream().filter(this::isPrime).toList();
    }

    public boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a prime number:");
        long prime = scanner.nextLong();
        PrimeInceptionCounter counter = new PrimeInceptionCounter(prime);
        List<Long> deletions = counter.primesFromPrime();
        System.out.println("List of deletions: " + deletions);
        long count = counter.countPrimeInceptions();
        System.out.println("Number of prime inceptions: " + count);
    }
}
