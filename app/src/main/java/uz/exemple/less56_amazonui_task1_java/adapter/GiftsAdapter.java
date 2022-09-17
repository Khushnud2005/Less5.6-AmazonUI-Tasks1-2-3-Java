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
import uz.exemple.less56_amazonui_task1_java.model.GiftsModel;
import uz.exemple.less56_amazonui_task1_java.model.SneakersModel;

public class GiftsAdapter extends RecyclerView.Adapter<GiftsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<GiftsModel> items;

    public GiftsAdapter(Context context, ArrayList<GiftsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public GiftsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gifts,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftsAdapter.ViewHolder holder, int position) {
        GiftsModel item = items.get(position);
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
            image = itemView.findViewById(R.id.iv_image_gift);
        }
    }
}
