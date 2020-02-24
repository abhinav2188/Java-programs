class Pattern{
    public static void main(final String args[]){
        int n = Integer.parseInt(args[0]);
        System.out.println("n="+n);
        for(int i=1;i<=n;i++){
            for(int j=1; j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}