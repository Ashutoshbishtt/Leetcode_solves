class Solution {
    public long taskSchedulerII(int[] tasks, int gap) {
        HashMap<Integer,Long> map = new HashMap<>();
        long curDay = 0L;
        int n = tasks.length;
        
        for(int i = 0 ; i < n ; i++){
            int task = tasks[i];
            if(!map.containsKey(task))
                map.put(tasks[i],curDay);
            else{
                long lastDay = map.get(task);
                long taskGap = curDay-lastDay;
                if(taskGap<=gap)
                    curDay+=gap-taskGap+1;
                map.put(task,curDay);
            }
            curDay++;
        }
        return curDay;
    }
}