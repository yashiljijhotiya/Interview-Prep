package amazon;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    private static List<String>  restoreIP(String s){
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12){
            return res;
        }
        dfs(s,res,"",0);
        return res;
    }

    private static void dfs(String s, List<String> res, String subStr, int index ){
        //base case check
        if(index == 4 || s.length() == 0){
            if(index == 4 && s.length() == 0){
                res.add(subStr.substring(0,subStr.length()-1));
            }
            return;
        }
        //case 1 : choose 1 digit
        dfs(s.substring(1), res,subStr + s.substring(0,1) + ".", index+1);
        //case 2 : choose 2 digits
        if(s.length() >1 && s.charAt(0) != '0'){
            dfs(s.substring(2), res,subStr + s.substring(0,2) + ".", index+1);
            //case 3 : choose 3 digits
            if(s.length() >2 && Integer.valueOf(s.substring(0,3)) <= 255){
                dfs(s.substring(3), res,subStr + s.substring(0,3) + ".", index+1);
            }
        }
    }

    private static boolean isValid(String ip){
        if(ip == null || ip.length() > 15){
            return false;
        }
        String s[] = ip.split("\\.");
        if(s.length != 4){
            return false;
        }
        for(String i : s){
            if(i.isEmpty() || i.length() > 3 || i.length() > 1 ||i.charAt(0) == '0'){
                return false;
            }
            for(char c : i.toCharArray()){
                if(!Character.isDigit(c)){
                    return false;
                }
            }
            int val = Integer.parseInt(i);
            if(val > 255 || val < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIP(s));

    }
}
