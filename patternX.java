import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class patternX {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an integer ");
        int n = Integer.parseInt(reader.readLine());

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)
            System.out.print(" ");
            System.out.print("*");
            for(int k=0;k<2*(n-i-1)-1;k++)
            System.out.print(" ");
            if(i!=n-1)
            System.out.println("*");
            else
            System.out.println();
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<i;j++)
            System.out.print(" ");
            System.out.print("*");
            for(int k=0;k<2*(n-i-1)-1;k++)
            System.out.print(" ");
            System.out.println("*");
        }
    }

}