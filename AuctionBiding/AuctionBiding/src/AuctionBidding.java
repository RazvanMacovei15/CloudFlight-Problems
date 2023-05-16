import java.util.*;

public class AuctionBidding {

    private String[] gameInput;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> biddingHistory = new ArrayList<>();

        List<String> biddingHistoryBuyNow = new ArrayList<>();

        System.out.print("Enter integers and strings separated by commas: ");

        String input = scanner.nextLine();

        List<String> bids = Arrays.asList(input.split(","));

        int highestBid = 0;
        String highestBidder = "";

        int startingPrice = Integer.parseInt(bids.get(0));
        int buyNowPrice = Integer.parseInt(bids.get(1));

        int newPrice = startingPrice;

        biddingHistory.add("-");
        biddingHistory.add(String.valueOf(startingPrice));

        String firstBidder = bids.get(2);
        int firstBid = Integer.parseInt(bids.get(3));

        biddingHistory.add(firstBidder);
        biddingHistory.add(String.valueOf(newPrice));
        boolean exit = false;

        if(buyNowPrice == 0){
            do{
                if(bids.size() == 4 ){
                    highestBidder = firstBidder;
                    highestBid = firstBid;
                }else{
                    highestBidder = firstBidder;
                    highestBid = firstBid;
                    for(int i = 4; i<bids.size(); i+=2){
                        String currentBidder = bids.get(i);
                        int currentBid = Integer.parseInt(bids.get(i+1));
                        if(currentBidder.equals(highestBidder)){
                            if(currentBid < highestBid){
                                newPrice = currentBid + 1;
                                biddingHistory.add(currentBidder);
                                biddingHistory.add(String.valueOf(newPrice));

                            }else if(currentBid == highestBid){
                                biddingHistory.add(currentBidder);
                                biddingHistory.add(String.valueOf(newPrice));

                            }else{
                                highestBid = currentBid;
//                                biddingHistory.add(currentBidder);
//
//                                biddingHistory.add(String.valueOf(newPrice));


                            }
                        }else {
                            if(currentBid > highestBid){
                                newPrice = highestBid + 1;
                                highestBidder = currentBidder;
                                highestBid = currentBid;
                                biddingHistory.add(currentBidder);
                                biddingHistory.add(String.valueOf(newPrice));

                            } else if(currentBid == highestBid){
                                newPrice = highestBid;
                                biddingHistory.add(highestBidder);

                                biddingHistory.add(String.valueOf(newPrice));

                            } else {
                                newPrice = currentBid + 1;
                                biddingHistory.add(highestBidder);
                                biddingHistory.add(String.valueOf(newPrice));

                            }
                        }
                    }
                }

//            System.out.println(highestBidder + "," + newPrice);
                String result = String.join(",", biddingHistory);
                System.out.println(result);

                if(newPrice <= buyNowPrice){
                    exit = true;
                }

            }while(!exit && newPrice < buyNowPrice);
        }else{
            do{
                if(bids.size() == 4 ){
                    highestBidder = firstBidder;
                    highestBid = firstBid;
                }else{
                    highestBidder = firstBidder;
                    highestBid = firstBid;
                    for(int i = 4; i<bids.size(); i+=2){
                        String currentBidder = bids.get(i);
                        int currentBid = Integer.parseInt(bids.get(i+1));
                        if(currentBidder.equals(highestBidder)){
                            if(currentBid < highestBid){
                                newPrice = currentBid + 1;
                                biddingHistory.add(currentBidder);
                                if(newPrice > buyNowPrice){
                                    biddingHistory.add(String.valueOf(buyNowPrice));
                                }else{
                                    biddingHistory.add(String.valueOf(newPrice));
                                }
                            }else if(currentBid == highestBid){
                                biddingHistory.add(currentBidder);
                                if(newPrice > buyNowPrice){
                                    biddingHistory.add(String.valueOf(buyNowPrice));
                                }else{
                                    biddingHistory.add(String.valueOf(newPrice));
                                }
                            }else{
                                highestBid = currentBid;
//                                biddingHistory.add(currentBidder);
//                                if(newPrice > buyNowPrice){
//                                    biddingHistory.add(String.valueOf(buyNowPrice));
//                                }else{
//                                    biddingHistory.add(String.valueOf(newPrice));
//                                }

                            }
                        }else {
                            if(currentBid > highestBid){
                                newPrice = highestBid + 1;
                                highestBidder = currentBidder;
                                highestBid = currentBid;
                                biddingHistory.add(currentBidder);
                                if(newPrice > buyNowPrice){
                                    biddingHistory.add(String.valueOf(buyNowPrice));
                                }else{
                                    biddingHistory.add(String.valueOf(newPrice));
                                }
                            } else if(currentBid == highestBid){
                                newPrice = highestBid;
                                biddingHistory.add(highestBidder);
                                if(newPrice > buyNowPrice){
                                    biddingHistory.add(String.valueOf(buyNowPrice));
                                }else{
                                    biddingHistory.add(String.valueOf(newPrice));
                                }
                            } else {
                                newPrice = currentBid + 1;
                                biddingHistory.add(highestBidder);
                                if(newPrice > buyNowPrice){
                                    biddingHistory.add(String.valueOf(buyNowPrice));
                                }else{
                                    biddingHistory.add(String.valueOf(newPrice));
                                }
                            }
                        }
                    }
                }

//            System.out.println(highestBidder + "," + newPrice);
                String result = String.join(",", biddingHistory);
                System.out.println(result);

                if(newPrice <= buyNowPrice){
                    exit = true;
                }

            }while(!exit && newPrice < buyNowPrice);
        }



//        if (newPrice < buyNowPrice) {
//            System.out.println("Auction ended without reaching the buy now price.");
//        }
    }
}
