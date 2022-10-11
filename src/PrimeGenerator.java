import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giovaneaguira
 */
public class PrimeGenerator
{
    public static void main(String[] args)
    {
        int a = 1, b = 10000;

        boolean isPrime;

        List<Integer> primes = new LinkedList<>();

        for(int i = a; i <= b; i++)
        {
            if((i == 1) || (i == 0))
            {
                continue;
            }

            isPrime = true;

            for(int j = 2; j <= (i / 2); ++j)
            {
                if((i % j) == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime)
            {
                primes.add(i);
            }
        }

        try(FileWriter fileWriter = new FileWriter("primes.txt"))
        {
            for(Integer prime : primes)
            {
                fileWriter.write(prime + " ");
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(PrimeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}