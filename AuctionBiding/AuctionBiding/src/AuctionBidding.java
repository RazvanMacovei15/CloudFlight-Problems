import java.util.*;

public class AuctionBidding {

    private String[] gameInput;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> biddersList = new HashSet<>();



        System.out.print("Enter integers and strings separated by commas: ");
//        String[] tokens = scanner.nextLine().split(",");
        String input = scanner.nextLine();
        List<String> bids = Arrays.asList(input.split(","));

        int highestBid = 0;
        String highestBidder = "";
        int start1 = Integer.parseInt(bids.get(0));
        int startingPrice = Integer.parseInt(bids.get(0));
        int newPrice = startingPrice;
        for(int i = 1; i<bids.size();i+=2){
            String currentBidder = bids.get(i);
            biddersList.add(currentBidder);
            int currentBid = Integer.parseInt(bids.get(i+1));

            if(currentBid == startingPrice){
                highestBidder = currentBidder;
                newPrice = startingPrice;
            }
            else if (currentBid > highestBid){
                highestBidder = currentBidder;
                highestBid = currentBid;
                newPrice = Integer.parseInt(bids.get(i-1)) + 1;
            } else if (currentBid < highestBid) {
                newPrice = currentBid + 1;
            } else if(currentBid == highestBid){
                newPrice = currentBid;
            }
            if(biddersList.size()==1){
                highestBidder = currentBidder;
                newPrice = start1;
            }


        }
        System.out.println(highestBidder + ","+newPrice);
    }
}
