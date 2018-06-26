package com.example.a12.arisewindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ButtonAdapter extends BaseAdapter {

    private String[] titleList;
    private LayoutInflater lInflater;
    private ButtonClickListener buttonClickListener;

    public ButtonAdapter(Context context, String[] titleList, ButtonClickListener buttonClickListener ) {
        this.titleList = titleList;
        this.buttonClickListener = buttonClickListener;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ButtonAdapter(Context context, String[] titleList ) {
        this.titleList = titleList;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public String[] getTitleList() {
        return titleList;
    }

    @Override
    public int getCount() {
        return titleList.length;
    }

    @Override
    public Object getItem(int position) {
        return titleList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {

            holder = new ViewHolder();
            view = lInflater.inflate(R.layout.item, null);
            holder.button = (TextView) view.findViewById(R.id.button);
            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();
        }

        holder.ref = i;

        holder.button.setText(titleList[i]);

//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                char symbol = String.valueOf(holder.button.getText()).toCharArray()[0];
//                buttonClickListener.ButtonOnClick(symbol);
//            }
//        });
        return view;
    }


    private class ViewHolder {
        TextView button;
        int ref;
    }
}
//
