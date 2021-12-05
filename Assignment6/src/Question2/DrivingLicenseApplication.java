package Question2;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


class DrivingLicenseApplication {
    private Date dateOfBirth;
    Calendar calendar = Calendar.getInstance();
    Date current = calendar.getTime();
    public DrivingLicenseApplication(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.add(Calendar.YEAR, -15);
            Date past = calendar2.getTime();
            this.dateOfBirth = fmt.parse(date);
            if (current.getTime() - this.dateOfBirth.getTime() < (current.getTime() - past.getTime()) ) {
                throw new RuntimeException();
            }
        } catch (RuntimeException | ParseException e) {

            System.out.println("The age of the applicant is "+ (current.getYear() - dateOfBirth.getYear()) +" which is too early to apply for a driving license！");
            e.printStackTrace();
        }
    }
}
