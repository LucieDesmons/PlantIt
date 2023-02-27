package utility;

import java.util.Calendar;
import java.util.Date;

public class Utility {

    public static final Date END_DATE;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(3000, Calendar.JANUARY, 1, 23, 59, 59);
        END_DATE = calendar.getTime();
    }
}
