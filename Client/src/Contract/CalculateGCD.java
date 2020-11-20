package Contract;

import java.io.Serializable;
import java.rmi.RemoteException;


public class CalculateGCD implements Task, Serializable{
    /**
    public static void main(String[] args) {
        CalculateGCD gcd = new CalculateGCD(10,2);
        System.out.println(gcd.getResult());
    }
    **/
    private long a;
    private long b;

    public CalculateGCD(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void executeTask(){
        CalculateGCD(a, b);
    }

    @Override
    public Object getResult(){
        return CalculateGCD(a,b);
    }
    
    public long CalculateGCD(long a, long b){
        if (a ==0) return b;
        else {
            while (b != 0) {
                if (a > b) a = a - b;
                else b = b - a;
            }
            return a;
        }
    }
}
