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

public class TagsViewAdapter extends RecyclerView.Adapter<TagsViewAdapter.ViewHolder>
{

    private ArrayList<results> quoteList = new ArrayList<>();

    public TagsViewAdapter(ArrayList<results> quoteList) {
        this.quoteList = quoteList;
    }

    @NonNull
    @Override
    public TagsViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_tags, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagsViewAdapter.ViewHolder holder, int position) {

        results QM = quoteList.get(position);
        holder.tvName.setText(QM.getName());
        holder.tvQuoteCount.setText(QM.getQuoteCount());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Name : " + QM.getName() + "QuoteCount : " + QM.getQuoteCount(), Toast.LENGTH_SHORT).show();

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
        private TextView tvName, tvQuoteCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvQuoteCount = itemView.findViewById(R.id.tv_quoteCount);



        }
    }
}
