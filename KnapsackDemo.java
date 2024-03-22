import java.util.*;

class DataObject{
    int profit;
    int wt;
    double pw;
}

public class KnapsackDemo{
    DataObject d[];
    int n,max;
    Scanner sc;

    public KnapsackDemo(){
        sc = new Scanner(System.in);
        System.out.print("Enter number of objects: ");
        n = sc.nextInt();
        System.out.print("Enter limit: ");
        max = sc.nextInt();
        d = new DataObject[n];
        for(int i=0; i<n; i++){
            System.out.println("Object "+(i+1)+" details");
            d[i] = new DataObject();
            System.out.print("Enter profit: ");
            d[i].profit = sc.nextInt();
            System.out.print("Enter weight: ");
            d[i].wt = sc.nextInt();
        }
    }

    public void Calculate(){
        for(int i=0; i<n; i++){
            d[i].pw = d[i].profit /(double)d[i].wt;
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(d[i].pw < d[j].pw){
                    DataObject temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        int k=0,s=0;
        while(max>0){
            System.out.println("s is "+s);
            if(max>=d[k].wt){
                
                max -= d[k].wt;
                s += d[k].profit;
            }
            else{
                s += (max*d[k].pw);
                max = 0;
            }
            k++;
        }
        System.out.println("Profit is "+s);
    }
    public static void main(String[] args){
        KnapsackDemo k = new KnapsackDemo();
        k.Calculate();
    }
}