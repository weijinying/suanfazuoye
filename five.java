package wjy;

//5-2 最小长度电路板排列问题

import java.util.Scanner;

public class five {

  private static int n,m;
  private static int[] bestx;
  private static int[][] B;

  private static int[] x,low,high;
  private static int bestd;

  public static void main(String[] args){
      Scanner input = new Scanner(System.in);

      while (true){
          n = input.nextInt();
          m = input.nextInt();

          bestx = new int[n+1];
          B = new int[n+1][m+1];

          for(int i=1; i<=n; i++)
              for(int j=1; j<=m; j++)
                  B[i][j] = input.nextInt();

          int minLen = arrangeBoards();

          System.out.println(minLen);

          for(int i=1; i<=n; i++)
              System.out.print(bestx[i]+" ");
      }
  }

  private static int arrangeBoards(){
      x = new int[n+1];
      low = new int[m+1];
      high = new int[m+1];

      bestd = n+1;

      for(int i=1; i<=n; i++)
          x[i] = i;

      backtrack(1);

      return bestd;
  }

  private static void backtrack(int i){
      if(i == n){
          int tmp = len(i);
          if(tmp < bestd){
              bestd = tmp;
              for(int j=1; j<=n; j++)
                  bestx[j] = x[j];
          }
      }else{
          for(int j=i; j<=n; j++){
              swap(x,i,j);
              int ld = len(i);
              if(ld < bestd)
                  backtrack(i+1);
              swap(x,i,j);
          }
      }
  }

  private static int len(int ii){
      for(int i=1; i<=m; i++){
          high[i] = 0;
          low[i] = n+1;
      }
      for(int i=1; i<=ii; i++)
          for(int k=1; k<=m; k++)
              if(B[x[i]][k] > 0){
                  if(i < low[k]) low[k] = i;
                  if(i > high[k]) high[k] = i;
              }
      int tmp = 0;
      for(int k=1; k<=m; k++)
          if(low[k]<=n && high[k]>0 && tmp<high[k]-low[k])
              tmp = high[k] - low[k];

      return tmp;
  }

  private static void swap(int[] x, int i, int j){
      int tmp;
      tmp = x[i];
      x[i] = x[j];
      x[j] = tmp;
  }
}

