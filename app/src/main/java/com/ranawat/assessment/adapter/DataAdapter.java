package com.ranawat.assessment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.ranawat.assessment.R;
import com.ranawat.assessment.databinding.NameModelBinding;
import com.ranawat.assessment.model.Model;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.HolderName>{


    public ArrayList<Model> modelArrayList;
    private Context context;

    public DataAdapter(Context context, ArrayList<Model> modelArrayList) {

        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    private NameModelBinding binding;

    @NonNull
    @Override
    public HolderName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=NameModelBinding.inflate(LayoutInflater.from(context),parent,false);
        return new HolderName(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderName holder, int position) {

        Model model=modelArrayList.get(position);
        String name=model.getName();
        /*String realname=model.getRealname();
        String team=model.getTeam();
        String firstappearance=model.getFirstappearance();
        String createdby=model.getCreatedby();
        String publisher=model.getPublisher();
        String imageurl=model.getImageurl();
        String bio=model.getBio();*/

        holder.name.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getRootView().getContext());
                View dialogView=LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.pop_up,null);
                TextView realname,team,firstappearance,createdby,publisher,bio,name;
                de.hdodenhof.circleimageview.CircleImageView img;
                img=dialogView.findViewById(R.id.img);
                realname=dialogView.findViewById(R.id.realname);
                name=dialogView.findViewById(R.id.name);
                createdby=dialogView.findViewById(R.id.createdby);
                publisher=dialogView.findViewById(R.id.publisher);
                bio=dialogView.findViewById(R.id.bio);
                team=dialogView.findViewById(R.id.team);
                firstappearance=dialogView.findViewById(R.id.firstappearance);
                //img.setImageResource(model.getImageurl());
               name.setText(model.getName());
               realname.setText(model.getRealname());
               team.setText(model.getTeam());
               firstappearance.setText(model.getFirstappearance());
               createdby.setText(model.getCreatedby());
               publisher.setText(model.getPublisher());
               bio.setText(model.getBio());
               builder.setView(dialogView);
               builder.setCancelable(true);
               builder.show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class HolderName extends RecyclerView.ViewHolder {
        TextView name;

        public HolderName(@NonNull View itemView) {
            super(itemView);
            name=binding.name;
        }
    }
}
