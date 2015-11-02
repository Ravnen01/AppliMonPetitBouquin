package com.lpiem.mylittelbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.lpiem.mylittelbook.Model.Criticism;

import java.util.ArrayList;

/**
 * Created by iem2 on 02/11/15.
 */
public class CustomListCritisumActivity extends BaseAdapter {
    ArrayList<Criticism>listCritisum=new ArrayList<>();
    Context context;

    public CustomListCritisumActivity(ArrayList<Criticism> listCritisum, Context context) {
        this.listCritisum = listCritisum;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCritisum.size();
    }

    @Override
    public Object getItem(int position) {
        return listCritisum.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.customlistcritism,parent, false);
        }
        TextView tvUser=(TextView)convertView.findViewById(R.id.tvUser);
        tvUser.setText(listCritisum.get(position).getUser());
        TextView tvBook=(TextView)convertView.findViewById(R.id.tvBook);
        tvBook.setText(listCritisum.get(position).getBook());
        TextView tvComment=(TextView)convertView.findViewById(R.id.tvComment);
        tvComment.setText(listCritisum.get(position).getComment());
        RatingBar rtCritism=(RatingBar)convertView.findViewById(R.id.rtCritism);
        rtCritism.setRating(listCritisum.get(position).getRate());
        rtCritism.setIsIndicator(true);


        return convertView;
    }
}
