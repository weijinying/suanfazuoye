package wjy;

//4-4磁盘文件最有存储问题
import java.util.Arrays;
import java.util.Scanner;

public class  four{

  private static int n;
  private static int[] p;
  private static int[] x;

  public static void main(String[] args){
      Scanner input = new Scanner(System.in);

      while (true){
          n = input.nextInt();

          p = new int[n];
          x = new int[n];

          for(int i=0; i<n; i++)
              p[i] = input.nextInt();

          double result = greedy();

          System.out.println(String.format("%.6f", result));
      }
  }

  private static double greedy(){
      Arrays.sort(p);
      int k = (n-1)/2;
      x[k] = p[n-1];
      for(int i=k+1; i<n; i++)
          x[i] = p[n-2*(i-k)];
      for(int i=k-1; i>=0; i--)
          x[i] = p[n-2*(k-i)-1];
      double m=0,t=0;
      for(int i=0; i<n; i++){
          m += p[i];
          for(int j=i+1; j<n; j++)
              t += x[i]*x[j]*(j-i);
      }
      t = t/m/m;

      return t;
  }
}

