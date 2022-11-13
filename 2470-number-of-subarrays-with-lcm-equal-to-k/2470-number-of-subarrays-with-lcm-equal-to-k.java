class Solution {
   public int subarrayLCM(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int ans = nums[i];
            for(int j = i; j < nums.length; j++){
                ans = lcm(ans, nums[j]);
                
                if(ans == k){
                    count++;
                }
            }
        }
        return count;
    }
    
    public int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
    
    public int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
}