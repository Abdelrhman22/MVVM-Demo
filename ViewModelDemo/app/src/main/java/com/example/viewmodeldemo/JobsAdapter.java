package com.example.viewmodeldemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewmodeldemo.model.JobPojo;
import com.squareup.picasso.Picasso;

import java.util.List;


public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder>  implements View.OnClickListener{

    private List<JobPojo> jobsList;
    private  Context context;

    JobPojo pojo=new JobPojo();

    public JobsAdapter(List<JobPojo> jobsList, Context context)
    {
        this.jobsList=jobsList;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        pojo=jobsList.get(position);
        viewHolder.bindItem(pojo);
    }

    @Override
    public int getItemCount()
    {
        return jobsList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        ImageView imagviewJob;
        TextView txtJobTitle,txtCompanyName,txtDate;
        Button btnFavourite;


        public ViewHolder(View itemView) {
            super(itemView);
            imagviewJob=itemView.findViewById(R.id.imagviewJob);
            txtJobTitle=itemView.findViewById(R.id.txtJobTitle);
            txtCompanyName=itemView.findViewById(R.id.txtCompanyName);
            txtDate=itemView.findViewById(R.id.txtDate);
        }
        public void bindItem(JobPojo item)
        {
            Picasso.get().load(item.companyLogo).placeholder(R.drawable.load).into(imagviewJob);
            txtJobTitle.setText(item.title);
            txtCompanyName.setText(item.company);
            txtDate.setText(item.createdAt);
        }
        @Override
        public void onClick(View v) {

        }
    }
}
