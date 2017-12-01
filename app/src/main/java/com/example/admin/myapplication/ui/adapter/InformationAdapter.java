package com.example.admin.myapplication.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.Information;
import com.example.admin.myapplication.util.DateUtils;
import com.example.admin.myapplication.util.UtilityMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 05/11/17.
 */

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {
    private List<Information> personList = new ArrayList<>();
    private Context context;
    private Date tempDate;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);

    public InformationAdapter(Context context, List<Information> personList) {
        this.context = context;
        if(null != personList) {
            this.personList.addAll(personList);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_person_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Information information = personList.get(position);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(information.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if((null == tempDate && null != date) || tempDate.after(date)) {
            tempDate = date;
            holder.cardView.setVisibility(View.GONE);
            holder.dateHeader.setVisibility(View.VISIBLE);
            holder.dateHeader.setText(information.getDate());
            personList.add(position, information);
        } else {
            holder.personName.setText(information.getName());
        }
    }

    @Override
    public int getItemCount() {
        return UtilityMethods.listNotNull(personList) ? personList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView personName;
        private TextView dateHeader;
        private CardView cardView;

        public ViewHolder(View view) {
            super(view);
            personName = view.findViewById(R.id.person_list_item_name);
            cardView = view.findViewById(R.id.card_view);
            dateHeader = view.findViewById(R.id.date_header);
        }
    }
}
