//Approach 1: Brute Force.

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int n = A.size();
        for(int i = 0; i < n; i++) {
            int xor = A.get(i);
            for(int j = i + 1; j < n; j++) {
                if(xor == B) count++;
                xor = xor ^ A.get(j);
            }
            if(xor == B) count++;
        }
        return count;
    }
}

//Approach 2: Using Prefix XOR with help of HashMap.

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;
        int n = A.size();
        for(int i = 0; i < n; i++) {
            xor = xor ^ A.get(i);
            
            if(xor == B) count++;
            
            if(map.containsKey(xor ^ B)) 
                count += map.get(xor ^ B);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
