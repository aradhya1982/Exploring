package cisco.playground;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneParsing {

    public static String getClientTimeConversion(String utcdate, String clientTime){
		/*DateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy, h:mm:ss a zzzzz");
		String[] splittedZone = clientTime.trim().split(" ") ;
		formatter.setTimeZone(TimeZone.getTimeZone(splittedZone[2]));
		DateFormat formatterDTO = null;
		String strDateConversion ="";
		try{
			if(utcdate != null && utcdate.toString().trim() != ""){
				formatterDTO = new SimpleDateFormat("MMMMM dd, yyyy h:mm:ss a zzzz");
				strDateConversion=formatter.format(formatterDTO.parse(utcdate));
			}
		}
		catch(ParseException e){
			formatterDTO = new SimpleDateFormat("dd MMMMM, yyyy h:mm:ss a zzzz");
			try {
				strDateConversion=formatter.format(formatterDTO.parse(utcdate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				logger.error("getClientTimeConversion"+e1.getStackTrace());
			}
		}
		return strDateConversion;*/
        String convertedClientTime = "";
        TimeZone tz = TimeZone.getDefault();
        Date parsedDate = null;
        try {
            DateFormat formatterDTO = new SimpleDateFormat("MMMMM dd, yyyy h:mm:ss a zzzz");
            parsedDate = formatterDTO.parse(utcdate);
        } catch (ParseException e1) {
//            logger.error("getClientTimeConversion ", e1);
        }
        if (parsedDate != null) {
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss a XXX");
            try {
                int zoffset = Integer.parseInt(clientTime);
                int offset = zoffset * 60 * 1000;
                tz.setRawOffset(offset);
                formatter.setTimeZone(tz);

            } catch (NumberFormatException e) {
//                logger.error("getClientTimeConversion", e);
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            }
            convertedClientTime = formatter.format(parsedDate);

        }

        return convertedClientTime;
    }


    public static void main(String[] args) {
//        String clientStr = "2019-07-03 15:14:34 Eastern Standard Time";

        String clientStr = "2019-07-03 08:01:20 Arabia Standard Time";
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss zzzz");
        try {
//            Date now = new Date();
//            String nowStr = formatter.format(now);
//            System.out.println(nowStr);
//            Date parsed = formatter.parse(nowStr);
//            System.out.println(parsed);

//            Date parsedDate = formatter.parse(clientStr);
//            System.out.println(formatter.getTimeZone());
//            System.out.println(parsedDate);
//
//            String zoneOffsetSrt = "-331";
//            int zoffset = Integer.parseInt(zoneOffsetSrt);
//            int offset = zoffset * 60 * 1000;
//            TimeZone tz = TimeZone.getDefault();
//            tz.setRawOffset(offset);
//            System.out.println(tz);
//
//            DateFormat formatter2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss XXX");
//            formatter2.setTimeZone(tz);
//            System.out.println(formatter2.format(new Date()));

            DateFormat formatterDTO = new SimpleDateFormat("MMMMM dd, yyyy h:mm:ss a zzzz");
            System.out.println(formatterDTO.format(new Date()));

            String date1 = "July 08, 2019 3:09:13 PM India Standard Time";
            String offset = "1a40";

            System.out.println(getClientTimeConversion(date1, offset));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
