class Solution {
    public boolean isValid(String w)
     {
        if(w.length()<3)
        return false;
        int vc=0;
        int cc=0;
        for(int i=0;i<w.length();i++)
      {
        int a=(int)(w.charAt(i));
        char g=w.charAt(i);
        if((a>=97 && a<=122)||(a>=65 && a<=90)||(a>=48 && a<=57))
        {
            if((a>=97 && a<=122)||(a>=65 && a<=90))
            {
                if(g=='a'||g=='e'||g=='i'||g=='o'||g=='u'||g=='A'||g=='E'||g=='I'||g=='O'||g=='U')
                {
                    vc++;

                }
                else
                {
                    cc++;
                }
                 

            }

        }
        else
        return false;



        }

        if(vc==0 || cc==0)
        return false;

        return true;

        
  }
}
