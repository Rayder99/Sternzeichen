package svenherrmann.com.sternzeichen;

import android.util.SparseArray;

import java.util.Calendar;

final class Starsign {

        private static final Starsign INSTANCE = new Starsign();

        private final SparseArray<Sternzeichen> a;

        private Starsign() {
            a=new SparseArray<>();
            a.put(Calendar.JANUARY, new Sternzeichen(21, Calendar.JANUARY, R.string.aquarius));
            a.put(Calendar.FEBRUARY, new Sternzeichen(20, Calendar.FEBRUARY, R.string.pisces));
            a.put(Calendar.MARCH, new Sternzeichen(21, Calendar.MARCH, R.string.aries));
            a.put(Calendar.APRIL, new Sternzeichen(21, Calendar.APRIL, R.string.taurus));
            a.put(Calendar.MAY, new Sternzeichen(22, Calendar.MAY, R.string.gemini));
            a.put(Calendar.JUNE, new Sternzeichen(22, Calendar.JUNE, R.string.cancer));
            a.put(Calendar.JULY, new Sternzeichen(24, Calendar.JULY, R.string.leo));
            a.put(Calendar.AUGUST, new Sternzeichen(24, Calendar.AUGUST, R.string.virgo));
            a.put(Calendar.SEPTEMBER, new Sternzeichen(24, Calendar.SEPTEMBER, R.string.libra));
            a.put(Calendar.OCTOBER, new Sternzeichen(24, Calendar.OCTOBER, R.string.scorpius));
            a.put(Calendar.NOVEMBER, new Sternzeichen(23, Calendar.NOVEMBER, R.string.sagittarius));
            a.put(Calendar.DECEMBER, new Sternzeichen(22, Calendar.DECEMBER, R.string.capricornus));
        }

        static Sternzeichen getSternzeichenFuerMonat(int monat) {
            return INSTANCE.a.get(monat);
        }
}
