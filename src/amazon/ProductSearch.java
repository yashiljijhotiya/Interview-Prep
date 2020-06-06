package amazon;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch {

    private static List<List<String>> suggestedProducts(String [] products, String searchKeyword){
        List<List<String>> result = new ArrayList<>();
        if(searchKeyword == null || products == null || products.length == 0 || searchKeyword.length() == 0){
            return result;
        }

        for(int i = 0; i < searchKeyword.length(); i++){
            result.add(new ArrayList<>());
            if(i == 0){

            }
        }
        return result;
    }
    public static void main(String[] args) {
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};

    }
}
