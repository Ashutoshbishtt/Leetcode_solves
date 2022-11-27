class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer>[] hmap=new HashMap[nums.length];
        for(int i=0;i<hmap.length;i++)
        {
            hmap[i]=new HashMap<>();
        }
        for(int i=1;i<hmap.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                long cd=(long)nums[i]-(long)nums[j];
                if(cd<=Integer.MIN_VALUE || cd>=Integer.MAX_VALUE)
                {
                    continue;
                }
                int apEndingAti=hmap[i].getOrDefault((int)cd,0);
                int apEndingAtj=hmap[j].getOrDefault((int)cd,0);
                
                ans+=apEndingAtj;
                hmap[i].put((int)cd,apEndingAti+apEndingAtj+1);
            }
        }
        return ans;
    }
}