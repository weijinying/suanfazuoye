#include 
int main()
{
int a[50];
int i,j,maxCount=0,index=0,nCount=0;
int n;
scanf("%d",&n);
for(i=0;imaxCount)
      {
       maxCount=nCount;
       index=i;
      }
   nCount=0;
   }
printf("%d\n%d",a[index],maxCount);
}
