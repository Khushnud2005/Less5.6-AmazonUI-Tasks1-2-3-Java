package uz.exemple.less56_amazonui_task1_java.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less56_amazonui_task1_java.R;
import uz.exemple.less56_amazonui_task1_java.model.BooksModel;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    private Context context;
    private ArrayList<BooksModel> items;

    public BooksAdapter(Context context, ArrayList<BooksModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BooksModel item = items.get(position);
        holder.image.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        int price = (int) Math.floor(item.getPrice());
        holder.price.setText("$" + price);
        int price2 = (int)(item.getPrice()*100)%100;
        holder.price2.setText(""+price2);
        if (item.getOldPrice() !=null){
            SpannableString oldPrice = new SpannableString("$"+item.getOldPrice());
            oldPrice.setSpan(new StrikethroughSpan(), 0, oldPrice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.oldPrice.setText(oldPrice);
            holder.oldPrice.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView price;
        TextView price2;
        TextView oldPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_image_book);
            title = itemView.findViewById(R.id.tv_titleBook);
            price = itemView.findViewById(R.id.tv_priceBook1);
            price2 = itemView.findViewById(R.id.tv_priceBook2);
            oldPrice = itemView.findViewById(R.id.tv_oldPriceBook);
        }
    }
}
