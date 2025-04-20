class Solution {
    public int numRabbits(int[] a)
     {
        int tr=0;

        Arrays.sort(a);
        int c=0;
       for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
            tr++;
        
            else if( i==0 || a[i]!=a[i-1] || c==0)
                {
                    tr=tr+a[i]+1;
                    c=a[i];
                }
                else
                c--;

            }

     
        return tr;

        
    }
}