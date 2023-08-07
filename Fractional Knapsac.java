/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        Bag[] bag = new Bag[n];
        for(int i = 0; i < n; i++){
            double temp = (1.0 * arr[i].value) / arr[i].weight;
            bag[i] = new Bag(arr[i].value, arr[i].weight, temp);
        }
        Arrays.sort(bag, (a, b) -> Double.compare(b.perUnit, a.perUnit));
        int i = 0;
        double totalValue = 0;
        while(w > 0 && i < n){
            if(bag[i].weight > w){
                double fraction = bag[i].perUnit * w;
                totalValue += fraction;
                w = 0;
            } else {
                totalValue += bag[i].value;
                w -= bag[i].weight;
            }
            i++;
        }
        return totalValue;
    }
    class Bag{
        int value, weight;
        double perUnit;
        
        public Bag(int value, int weight, double perUnit){
            this.value = value;
            this.weight = weight;
            this.perUnit = perUnit;
        }
    }
}
