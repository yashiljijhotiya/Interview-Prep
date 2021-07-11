package bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//We have to find n bit grey code
public class GreyCode {

    private static List<String> findNBitGreyCode(int n){
        if(n == 1){
            return Arrays.asList("0", "1");
        }
        List<String> resultSet = findNBitGreyCode(n-1);
        List<String> result = new ArrayList<>();
        for(int i = 0; i < resultSet.size(); i++){
            String val = resultSet.get(i);
            result.add("0" +val);
        }
        for(int i = resultSet.size()-1; i >= 0; i--){
            String val = resultSet.get(i);
            result.add("1" +val);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = findNBitGreyCode(2);
        System.out.println(result.toString());
    }
}
