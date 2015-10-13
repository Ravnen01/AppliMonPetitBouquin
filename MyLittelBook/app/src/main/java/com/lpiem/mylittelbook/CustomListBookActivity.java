package com.lpiem.mylittelbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iem2 on 13/10/15.
 */
public class CustomListBookActivity extends BaseAdapter {
    ArrayList<String> listBook;
    Context context;

    public CustomListBookActivity(ArrayList<String> listBook, Context context) {
        this.listBook = listBook;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.customlistbook,parent, false);
        }
        TextView tvTitle=(TextView)convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(listBook.get(position));
        TextView tvAuthor=(TextView)convertView.findViewById(R.id.tvAuthor);
        tvAuthor.setText(listBook.get(position));
        TextView tvISBN=(TextView)convertView.findViewById(R.id.tvISBN);
        tvISBN.setText(listBook.get(position));



        return convertView;
    }
}
