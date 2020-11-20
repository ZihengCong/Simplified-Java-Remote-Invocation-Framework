package Contract;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;


public class CalculatePi implements Task, Serializable {
    /**
    public static void main(String[] args) {
        CalculatePi pi = new CalculatePi(20);
        System.out.println(pi.getResult());
    }
    **/
    private static final long serialVersionUID = 227L; 
    private static final BigDecimal FOUR = BigDecimal.valueOf(4); 
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;
    private final int digits;

    public CalculatePi(int digits) {
        this.digits = digits;
    }

    @Override
    public void executeTask(){
        computePi(digits);
    }

    @Override
    public Object getResult(){
        return computePi(digits);
    }
    

   
    public static BigDecimal computePi(int digits) { 
        int scale = digits + 5; 
        BigDecimal arctan1_5 = arctan(5, scale); 
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239).multiply(FOUR); 
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP); 
    }
    public static BigDecimal arctan(int inverseX, int scale)
    {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX); 
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);
        numer = BigDecimal.ONE.divide(invX, scale, roundingMode); 
        result = numer; 
        int i = 1;
        do {
            numer = numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale, roundingMode); 
            if ((i % 2) != 0) { 
                result = result.subtract(term);
            } else { 
                result = result.add(term); 
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0); 
        return result;
    }
}
