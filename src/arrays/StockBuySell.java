// ***** problem asked in all the big company. ref :- gfg

package arrays;

import java.util.ArrayList;

public class StockBuySell {

    class Interval {
        int buy;
        int sell;
    }

    private void maxProfit(int price[], int n){
      if(n <= 1)
          return;
      int count = 0;
      int i = 0;
        ArrayList<Interval> arr = new ArrayList<>();
      while(i < n-1){

          while((i < n-1) && (price[i] >= price[i+1]))
              i++;
          if(i ==  n-1)
              break;
          Interval e = new Interval();
          e.buy = i++;

          while ((i < n-1) && (price[i+1] >= price[i]))
              i++;
          e.sell = i-1;
          arr.add(e);
          count++;
      }

      if(count == 0){
          System.out.println(" there is no such day in which buying stock will give profit");
      }
      for(var j : arr){
          System.out.println("buy on this day: " + j.buy  + " And sell on this day: "+ j.sell );
      }

    }

    public static void main(String[] args) {
        StockBuySell s = new StockBuySell();
        int [] price = {100, 180, 260, 310, 40, 535, 695};
        int len = price.length;
        s.maxProfit(price,len);

    }
}
