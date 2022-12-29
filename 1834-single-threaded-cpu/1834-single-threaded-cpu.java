class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
       
        PriorityQueue<Tasks> task_list = new PriorityQueue<>(new Comparator<Tasks>(){
             public int compare(Tasks a,Tasks b)
             {
                  return a.enqueue_time - b.enqueue_time;
             }
         });
          PriorityQueue<Tasks> available_list = new PriorityQueue<>(new Comparator<Tasks>(){
             public int compare(Tasks a,Tasks b)
             {
                return a.process_time!=b.process_time ? a.process_time - b.process_time:a.index-b.index;
             
             }
         });
     
        
         for(int i = 0;i<tasks.length;i++)
         {
             task_list.add(new Tasks(i,tasks[i][0],tasks[i][1]));

         }
     

        int current_time = task_list.peek().enqueue_time;
        int idx  = 0;

        while(task_list.size()!=0 || available_list.size()!=0)
        {
           while(task_list.size()!=0&&task_list.peek().enqueue_time<=current_time)
           {
               available_list.add(task_list.remove());
           }
           if(available_list.size()!=0)
           {
               ans[idx++] = available_list.peek().index;
               current_time+=available_list.remove().process_time;

           }
           else
           {
               current_time = task_list.peek().enqueue_time;
           }
        }
        return ans;

    }

}
class Tasks{
    int index,enqueue_time,process_time;
     public Tasks(int idx,int e_t,int p_t)
     {
         this.index = idx;
         this.enqueue_time = e_t;
         this.process_time = p_t;
     }
}