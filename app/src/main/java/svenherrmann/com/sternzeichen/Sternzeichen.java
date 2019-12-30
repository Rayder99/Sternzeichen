package svenherrmann.com.sternzeichen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;

//public class MainActivity extends AppCompatActivity {


final class Sternzeichen {
    private final int sternzeichen;

    private final int tag, monat;

    Sternzeichen(int tag, int monat, int sternzeichen){
        this.tag= tag;
        this.monat=monat;
        this.sternzeichen=sternzeichen;
    }

    int getTag(){
        return tag;
    }

    int getMonat(){
        return monat;
    }

    String getName(Context context) {
        return context.getString(sternzeichen);
    }

    int getIdForDrawable() {
        switch (sternzeichen) {
            case R.string.aquarius:
                return R.drawable.aquarius;
            case R.string.aries:
                return R.drawable.aries;
            case R.string.cancer:
                return R.drawable.cancer;
            case R.string.capricornus:
                return R.drawable.capricornus;
            case R.string.gemini:
                return R.drawable.gemini;
            case R.string.leo:
                return R.drawable.leo;
            case R.string.libra:
                return R.drawable.libra;
            case R.string.pisces:
                return R.drawable.pisces;
            case R.string.sagittarius:
                return R.drawable.sagittarius;
            case R.string.scorpius:
                return R.drawable.scorpius;
            case R.string.taurus:
                return R.drawable.taurus;
            case R.string.virgo:
                return R.drawable.virgo;
            default:
                return R.drawable.ic_launcher;
        }
    }

/*}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } */
}
