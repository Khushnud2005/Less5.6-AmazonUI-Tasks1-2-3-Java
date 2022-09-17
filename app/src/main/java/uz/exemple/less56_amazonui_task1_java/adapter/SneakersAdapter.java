package uz.exemple.less56_amazonui_task1_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less56_amazonui_task1_java.R;
import uz.exemple.less56_amazonui_task1_java.model.SneakersModel;

public class SneakersAdapter extends RecyclerView.Adapter<SneakersAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SneakersModel> items;

    public SneakersAdapter(Context context, ArrayList<SneakersModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sneaker,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SneakersModel item = items.get(position);
        holder.image.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_image_sneaker);
        }
    }
}
