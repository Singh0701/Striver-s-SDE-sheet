public class Solution {
	public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if(n == 1) return (long) valueInHouse[0];
        int[] arr1 = new int[n - 1], arr2 = new int[n - 1];
        int index1 = 0, index2 = 0;
        for(int i = 0; i < n; i++) {
            if(i != 0)
                arr1[index1++] = valueInHouse[i];
            if(i != n - 1)
                arr2[index2++] = valueInHouse[i];
        }
//         System.out.println(arr1.length);
		long ans1 = max(arr1);
        long ans2 = max(arr2);
        return Math.max(ans1,ans2);
	}	
    
    
   public static long max(int[] money) {
       long prev = money[0];
       long prev2 = 0;
       int n = money.length;
       for(int index = 1; index < n; index++) {
           long take = money[index];
           if(index > 1) take += prev2;
           long notTake = prev;
           long max = Math.max(take, notTake);
           prev2 = prev;
           prev = max;
       }
       return prev;
   }
}
