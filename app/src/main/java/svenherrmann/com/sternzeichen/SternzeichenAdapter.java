package svenherrmann.com.sternzeichen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

class SternzeichenAdapter extends BaseAdapter {

    private final List<Sternzeichen>starsign;
    private final LayoutInflater inflater;
    private final DateFormat df;
    private final Calendar cal;

    SternzeichenAdapter(Context context)

    {
        inflater = LayoutInflater.from(context);
        starsign = new ArrayList<>();
        for (int monat = Calendar.JANUARY; monat <= Calendar.DECEMBER; monat++) {
            Sternzeichen zeichen = Starsign.getSternzeichenFuerMonat(monat);
            starsign.add(zeichen);

        }

        df = new SimpleDateFormat(context.getString(R.string.format_string), Locale.US);
        cal = Calendar.getInstance();
    }

    @Override
    public int getCount(){
        return starsign.size();
    }

    @Override
    public Object getItem(int position){
        return starsign.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //falls notwendig, convertView bauen
        if (convertView == null) {
            //layoutdatei entfalten
            convertView = inflater.inflate(R.layout.icon_text_text, parent, false);
            //holder erzeugen
            holder = new ViewHolder();
            holder.name = convertView.findViewById((R.id.text1));
            holder.datumsbereich = convertView.findViewById(R.id.text2);
            holder.icon = convertView.findViewById(R.layout.icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Context context = context = parent.getContext();
        Sternzeichen zeichen = (Sternzeichen) getItem(position);
        holder.name.setText(zeichen.getName(context));
        holder.icon.setImageResource(zeichen.getIdForDrawable());
        cal.set(Calendar.DAY_OF_MONTH, zeichen.getTag());
        cal.set(Calendar.MONTH, zeichen.getMonat());
        String datum1 = df.format(cal.getTime());
        if (++position >= getCount()) {
            position = 0;
        }
        zeichen = (Sternzeichen) getItem(position);
        cal.set(Calendar.DAY_OF_MONTH, zeichen.getTag() - 1);
        cal.set(Calendar.MONTH, zeichen.getMonat());
        String datum2 = df.format(cal.getTime());
        holder.datumsbereich.setText(context.getString(R.string.interval, datum1, datum2));
        return convertView;
        }

        static class ViewHolder {
            TextView name, datumsbereich;
            ImageView icon;
    }
}