//Approach 1: Iterating in complete matrix.

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        for(int i = 0; i < A.size(); i++) {
            for(int j: A.get(i)) {
                if(j == B) return 1;
            }
        }
        return 0;
    }
}



//Approach 2: Performing binary serach in each row of the matrix.

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        for(int i = 0; i < A.size(); i++) {
            int low = 0, high = A.get(i).size() - 1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(A.get(i).get(mid) == B) return 1;
                if(A.get(i).get(mid) < B) low = mid + 1;
                else high = mid - 1;
            }
        }
        return 0;
    }
}


//Approach 3: Performing a single binary search in whole matrix at once.

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();
        int low = 0, high = N * M - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / M;
            int j = mid % M;
            if(A.get(i).get(j) == B) return 1;
            if(A.get(i).get(j) < B) low = mid + 1;
            else high = mid - 1;
        }
        return 0;
    }
}
