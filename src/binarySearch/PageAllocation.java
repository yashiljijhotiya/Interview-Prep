package binarySearch;

import java.util.Arrays;
/*TC: O (log(n))
*
*  Book Allocation Problem
* ● Aggressive Cow Problem
* ● PRATA - Roti Prata Problem
* ● EKO Problem
* ● Painter Partition Problem
* ● Minimum number of days to make m Bouquets
* ● Find the Smallest Divisor Given a threshold
* ● Divide Chocolate
* ● Capacity To Ship Packages Within D Days
* ● Koko Eating Bananas
* ● Minimize max distance to Gas station
* ● Split Array Largest Sum
* */
public class PageAllocation {

    private static int findMinPages(int books[], int students) {
        if (students > books.length || books == null || books.length == 0) {
            return -1;
        }
        int startIndex = books[0];
        int endIndex = Arrays.stream(books).sum();
        int result = -1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (isValidAllocation(books, students, midIndex)) {
                result = midIndex;
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return result;
    }

    private static boolean isValidAllocation(int books[], int totalStudent, int maxPages) {
        int student = 1, allocatedPageCount = 0;
        for (int bookPages : books) {
            if (bookPages > maxPages) {
                return false;
            }
            if (bookPages + allocatedPageCount > maxPages) {
                student++;
                allocatedPageCount = bookPages;
                if (student > totalStudent) {
                    return false;
                }
            } else {
                allocatedPageCount += bookPages;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] books = {10,20,30,40};
        int students = 2;
        System.out.println("Min no. pages allocated are : "+ findMinPages(books,students));

    }
}
