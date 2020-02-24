import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Prime {
    public static void main(final String args[]) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=1;
        try {
            System.out.print("Enter number : ");
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean flag = true;
        if(n%2 == 0)
        flag = false;
        for(int i=3;i<Math.sqrt(n);i+=2){
            if(n%i==0){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
    }
}