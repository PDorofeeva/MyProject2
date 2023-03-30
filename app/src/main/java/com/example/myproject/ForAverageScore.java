package com.example.myproject;

public class ForAverageScore {
    public double CurrentAverageScore;
    public double NewAverageScore;
    public int quantity;
    public double result;

    public ForAverageScore(double CurrentAverageScore, double NewAverageScore, int quantity) {
        this.CurrentAverageScore = CurrentAverageScore;
        this.NewAverageScore = NewAverageScore;
        this.quantity = quantity;
        result = Sum(quantity, CurrentAverageScore); // Sum of marks
        Answer(quantity, NewAverageScore, result);
    }

    public double Sum(int quantity, double CurrentAverageScore){
        return quantity*CurrentAverageScore;
    }
    public int Answer(int quantity, double NewAverageScore, double result){
        int five = 0;
        double current = result/quantity; // CurrentAverageScore
        if (current>=NewAverageScore){

        } else {
            while (current < NewAverageScore) {
                result += 5;
                five++;
                quantity++;
                current = result / quantity;
            }
        }
        return five;

    }
}
