package Contract;

import java.io.Serializable;
import java.rmi.RemoteException;


public class CalculatePrime implements Task, Serializable{
    /**
    public static void main(String[] args) {
        CalculatePrime c = new CalculatePrime(2);
        System.out.println(c.getResult());
    }
    **/
    private final int number;

    public CalculatePrime(int number) {
        this.number = number;
    }
    

    @Override
    public void executeTask(){
        primeAll(number);
    }

    @Override
    public Object getResult(){
        return(primeAll(number));
    }
    
   
    public boolean isPrime(int number) {
        for(int i=2; i<number; i++){
            if(number%i ==0){
                return false;
            }
        }
        return true;
    }
    
    public String primeAll(int number){
        String prime = new String();
        int count = 0;
        for(int i=2; i<=number; i++){
            if(isPrime(i))
            {
                prime = prime + String.valueOf(i) + ":";
                count += 1;
            }
        }
        String sum = String.valueOf(count) + ":" + prime;
        return sum;
    }
}
