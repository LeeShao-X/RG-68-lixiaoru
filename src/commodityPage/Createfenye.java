package commodityPage;

import java.util.ArrayList;

public class Createfenye{

    public static void  Create(ArrayList arry, int sum)
    {
        int[] p=new int[6];
        sum=sum/4+(sum%4==0?0:1);
        for(int Page=1;Page<=sum;Page++)
        {
            for(int i=0;i<6;i++)
                p[i]=-2;
            if(sum<=6)
                for(int i=0;i<6&&i<sum;i++)
                {
                    p[i]=i+1;
                }
            else if(Page<5)
            {
                for(int i=0;i<6&&i<sum;i++)
                {
                    p[i]=i+1;
                    if(i==5)
                        p[i]=0;
                }
            }
            else
            {
                p[0]=1;
                p[1]=p[5]=0;
                p[2]=Page-1;
                p[3]=Page;
                p[4]=Page+1;
                if(sum-Page<=3)
                {
                    int sum1=sum;
                    for(int i=5;i>=0;i--)
                    {
                        p[i]=sum1--;
                    }
                }

            }
            int k=0;
            String[] str=new String[6];
            for(int i=0;i<6;i++)
            {
                if(p[i]==-2)
                    break;
                if(p[i]==0)
                    str[k++]="...";
                else
                    str[k++]=String.valueOf(p[i]);
            }
            fenyes fen=new fenyes();
            fen.setSum(sum);
            fen.setAns(k);
            fen.setPages(Page);
            fen.setStr(str);
            arry.add(fen);
        }
    }
}

