import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author giovaneaguiar
 */
public class ThreadExample
{
    private static final Object mutex = new Object();

    public static class Task implements Runnable
    {
        private final int index;

        public Task(int index)
        {
            this.index = index;
        }

        @Override
        public void run()
        {
            synchronized(mutex)
            {
                System.out.print("Hello from thread " + index);
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        int threadCount = 1000000;
        Thread[] threads = new Thread[threadCount];

        for(int i = 0; i < threadCount; i++)
        {
            Task task = new Task(i);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for(int i = 0; i < threadCount; i++)
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(ThreadExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
