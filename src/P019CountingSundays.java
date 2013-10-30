import java.util.Calendar;
import java.util.GregorianCalendar;

public class P019CountingSundays
{
    public static void main(String[] args)
    {
        Calendar calendar = new GregorianCalendar(1901, Calendar.JANUARY, 1);
        Calendar stopDate = new GregorianCalendar(2000, Calendar.DECEMBER, 30);
        System.out.println(calendar.getTime());
        System.out.println(stopDate.getTime());
        int count = 0;
        while (calendar.getTime().before(stopDate.getTime()))
        {
            System.out.println("pass");
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                count++;
            }
            calendar.add(Calendar.MONTH, 1);
        }
        System.out.println(count);
    }
}
