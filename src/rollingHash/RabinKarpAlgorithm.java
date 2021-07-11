package rollingHash;

//It is also known as rolling hash technique
public class RabinKarpAlgorithm {

    private static final int prime = 101;

    private static int searchPattern(char [] str, char [] pattern){
        int n = str.length;
        int m = pattern.length;
        long patternHash = createHash(pattern, m-1);
        long strHash = createHash(str, m-1);
        for (int i =1; i <= n-m+1; i++){
            if(patternHash == strHash && isEqualHash(str, i-1, i+m-2, pattern, 0, m-1)){
                return i-1;
            }
            if(i < n-m+1){
                strHash = recalculateHash(str,i-1, i +m-1, strHash, m);
            }
        }
        return -99;
    }

    private static long createHash(char [] str, int end){
        long hash = 0;
        for(int i = 0; i <= end; i++){
            hash += str[i]*Math.pow(prime, i);
        }
        return hash;
    }

    private static boolean isEqualHash(char[] str1, int start1, int end1, char[] str2, int start2, int end2){
        if(end1 - start1 != end2-start2){
            return false;
        }
        return true;
    }

    private static long recalculateHash(char [] str, int oldIndex, int newIndex, long oldHash, int patternLen){
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/prime;
        newHash += str[newIndex]*Math.pow(prime, patternLen -1);
        return  newHash;
    }

    public static void main(String[] args) {
        String s = "abrleabcrla";
        String pattern = "ac";
        System.out.println(searchPattern(s.toCharArray(), pattern.toCharArray()));

    }
}
