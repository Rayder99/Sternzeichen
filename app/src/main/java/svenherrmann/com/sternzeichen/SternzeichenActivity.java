package svenherrmann.com.sternzeichen;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class SternzeichenActivity extends ListActivity implements OnItemClickListener {

    private SternzeichenAdapter adapter;

    //@Override
    public void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new SternzeichenAdapter(this);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Sternzeichen zeichen = (Sternzeichen) adapter.getItem(position);
        String url = getString(R.string.wikipedia_url,zeichen.getName(this));
        Intent viewIntent = new Intent("android.intent.action.view", Uri.parse(url));
        startActivity(viewIntent);
    }
}
