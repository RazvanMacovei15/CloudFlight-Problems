

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bowling {

    private int[] rolls;
    private int currentRoll;
    private int nrOfRounds;
    private int nrOfFrames;

    public Bowling(int nrOfRounds) {
        this.nrOfRounds = nrOfRounds;
        this.nrOfFrames = nrOfRounds * 2;
        this.rolls = new int[nrOfFrames + 2];
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int sumOfRolls(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    public String score() {
        int score = 0;
        int frame = 0;
        List<Integer> roundScore = new  ArrayList<Integer>();
        for (int i = 0; i < nrOfRounds; i++) {
            if (isStrike(frame)) {
                score += 10 + strikeBonus(frame);
                int score1 = score;
                roundScore.add(score1);
//                System.out.println("Score after round " + (i + 1) + ": " + score);
                frame++;
            } else if (isSpare(frame)) {
                score += 10 + spareBonus(frame);
                int score1 = score;
                roundScore.add(score1);
//                System.out.println("Score after round " + (i + 1) + ": " + score);
                frame += 2;
            } else {
                score += sumOfRolls(frame);
                int score1 = score;
                roundScore.add(score1);
//                System.out.println("Score after round " + (i + 1) + ": " + score);
                frame += 2;
            }
        }
        return String.join(",", roundScore.toString().replaceAll("[\\[\\]\\s]", "").split(","));

//        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integers separated by spaces: ");
        String[] tokens = scanner.nextLine().split(",");

        int nrOfRounds = Integer.parseInt(tokens[0]);
        Bowling bowling = new Bowling(nrOfRounds);

        for (int i = 1; i < tokens.length; i++) {
            int pins = Integer.parseInt(tokens[i]);
            bowling.roll(pins);
        }

        String score = bowling.score();
        System.out.println("Score: " + score);

        scanner.close();
    }
}
