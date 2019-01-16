package leetcode.misc;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

    public String nextClosestTime(String time) {

        String[] tokens = time.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int mins = Integer.parseInt(tokens[1]);

        if (hour == 0 && mins == 0)
            return time;

        Set<Character> seen = new HashSet();

        for (int i = 0; i < time.length(); i++)
            seen.add(time.charAt(i));

        boolean done = false;
        String result = "";
        while (!done) {

            mins++;
            if (mins == 60) {
                mins = 0;
                hour++;
            }

            if (hour == 24 && mins > 0) {
                hour = 0;
            }

            String hr = String.valueOf(hour);
            String mi = String.valueOf(mins);
            result = (hour < 10 ? "0" + hr : hr) + ":" + (mins < 10 ? "0" + mi : mi);

            boolean zero = hour < 10 || mins < 10;
            boolean next = true;
            for (int i = 0; i < hr.length(); i++)
                next = next && seen.contains(hr.charAt(i));

            for (int i = 0; i < mi.length(); i++)
                next = next && seen.contains(mi.charAt(i));

            if (zero) {
                next = next && seen.contains('0');
            }

            if (next)
                break;
        }

        return result;
    }

}
