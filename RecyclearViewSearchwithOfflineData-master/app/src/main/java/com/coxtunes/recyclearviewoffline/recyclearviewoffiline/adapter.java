package com.coxtunes.recyclearviewoffline.recyclearviewoffiline;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//------Step 2-----///
public class adapter extends RecyclerView.Adapter<adapter.Holder>{


    //------Step 3----//
    private List<model> flaglist;
    private Context context;

    //----Step 4-----/
    public adapter(List<model> flaglist, Context context) {
        this.flaglist = flaglist;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        //-----Step 5---//
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        //---------Step 6----//
        holder.f_name.setText(flaglist.get(position).getName());
        holder.f_image.setImageResource(flaglist.get(position).getPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "CLICKED ON "+ flaglist.get(position).getName(), Toast.LENGTH_SHORT).show();

                //-------For show data in Details Activity-------///
                int md = flaglist.get(position).getPhoto();
                String tt = flaglist.get(position).getName();
                Intent a = new Intent(context,Details.class);
                a.putExtra("image", md);
                a.putExtra("text", tt);
                context.startActivity(a);


            }
        });


    }

    @Override
    public int getItemCount() {
        return flaglist.size();
    }

    //-----Serach filter class-----//
    //---Step 7---//
    public void setfilter(List<model> litem)
    {
        flaglist = new ArrayList<>();
        flaglist.addAll(litem);
        notifyDataSetChanged();

    }

    //-------Step 1------///
    class Holder extends RecyclerView.ViewHolder
    {
        ImageView f_image;
        TextView f_name;

        Holder(View flagview)
        {
            super(flagview);

            f_image = flagview.findViewById(R.id.flag_image);
            f_name = flagview.findViewById(R.id.flag_name);


        }



    }


}
