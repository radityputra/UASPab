package com.if3a.Quotable.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.Quotable.R;
import com.if3a.Quotable.model.results;


import java.util.ArrayList;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder>
{

    private ArrayList<results> quoteList = new ArrayList<>();

    public MainViewAdapter(ArrayList<results> quoteList) {
        this.quoteList = quoteList;
    }

    @NonNull
    @Override
    public MainViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_quote, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewAdapter.ViewHolder holder, int position) {

        results QM = quoteList.get(position);
        holder.tvContent.setText(QM.getContent());
        holder.tvAuthor.setText(QM.getAuthor());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Quote : " + QM.getContent() + "Author : "  + QM.getAuthor() , Toast.LENGTH_SHORT).show();

//                String idUser = QM.getId();
//                Toast.makeText(holder.itemView.getContext(), "ID User : " + QM.getId(), Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
//                intent.putExtra("varId", idUser);
//                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent, tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvContent = itemView.findViewById(R.id.tv_content);
            tvAuthor = itemView.findViewById(R.id.tv_author);



        }
    }
}
