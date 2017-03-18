package com.mobilerepair.app.listview41;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Santoshraddi on 21-02-2017.
 */
public class StringAdapter extends ArrayAdapter<String> {

    // Attributes
    private List<String> strModel;
    private Context mContext;

    static class Holder
    {
        private TextView StringNameTextView;
    }

    public StringAdapter(Context context, int textViewResourceId,
                         List<String> strModel) {
        super(context, textViewResourceId, strModel);
        this.strModel = strModel;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;

        if (view == null) {
            view = View.inflate(mContext,
                    R.layout.sort_list_item, null);

            holder = new Holder();
            holder.StringNameTextView = (TextView) view
                    .findViewById(R.id.name_text_view);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        String nameText=strModel.get(position);
        holder.StringNameTextView.setText(nameText);
        return view;
    }
}

