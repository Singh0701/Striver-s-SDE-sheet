// Problem Statement: Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// A palindrome string is a string that reads the same backward as forward.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        doPartition(0, s, result, new ArrayList<>());
        return result;
    }
    
    public void doPartition(int index, String s, List<List<String>> result, List<String> ds) {
        //Check for the base case. If got one of the partition then save it into the result list.
        if(index >= s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }
        //Try for all positions from index to s.length - 1 and see if the partition can be done or not.
        for(int i = index; i < s.length(); i++) {
            //A partition at index i can be done if the substring (index, i) is a Palindrome.
            if(isPalindrome(s, index, i)) {
                //if the substring is palindrome then add it to the ds.
                ds.add(s.substring(index, i + 1));
                //Move to next index that is (i + 1) as we have partitioned and taken the substring from index till i.
                doPartition(i + 1, s, result, ds);
                //Removet the previously added substring while backtracking.
                ds.remove(ds.size() - 1);
            }
        }
    }
    
    //Utility function to check if the given string is a palindrome or not.
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

//Time Complexity = O(2^n * k * (n/2))
//2^n is for generating all the substrings, O(k) is for making a deep copy of ds everytime we put it into the result list where k is the avg length of palindrome list ds, and last n/2 is for checking if the substring is plaindrome or not.
//Space Complexity = O(k * x)
//Where x is the total no. of palindromic lists.
