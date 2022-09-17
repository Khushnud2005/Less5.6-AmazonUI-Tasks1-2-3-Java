package uz.exemple.less56_amazonui_task1_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import uz.exemple.less56_amazonui_task1_java.adapter.BooksAdapter;
import uz.exemple.less56_amazonui_task1_java.adapter.CategoryAdapter;
import uz.exemple.less56_amazonui_task1_java.adapter.EssentialAdapter;
import uz.exemple.less56_amazonui_task1_java.adapter.GiftsAdapter;
import uz.exemple.less56_amazonui_task1_java.adapter.SneakersAdapter;
import uz.exemple.less56_amazonui_task1_java.model.BooksModel;
import uz.exemple.less56_amazonui_task1_java.model.CategoryModel;
import uz.exemple.less56_amazonui_task1_java.model.Essential;
import uz.exemple.less56_amazonui_task1_java.model.GiftsModel;
import uz.exemple.less56_amazonui_task1_java.model.SneakersModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_essential;
    RecyclerView rv_sneakers;
    RecyclerView rv_gifts;
    RecyclerView rv_books;
    RecyclerView rv_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews(){

        rv_essential = findViewById(R.id.rv_essential);
        LinearLayoutManager manager = new  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_essential.setLayoutManager(manager);

        rv_sneakers = findViewById(R.id.rv_sneakers);
        GridLayoutManager sneakersManager = new GridLayoutManager(this, 2);
        rv_sneakers.setLayoutManager(sneakersManager);

        rv_gifts = findViewById(R.id.rv_gifts);
        GridLayoutManager giftsManager = new GridLayoutManager(this, 2);
        rv_gifts.setLayoutManager(giftsManager);

        rv_books = findViewById(R.id.rv_books);
        LinearLayoutManager booksManager = new  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_books.setLayoutManager(booksManager);

        rv_category = findViewById(R.id.rv_category);
        GridLayoutManager categoryManager = new GridLayoutManager(this, 2);
        rv_category.setLayoutManager(categoryManager);

        refreshAdapter(getEssentials());
        refreshSneakers(getSneakers());
        refreshGifts(getGifts());
        refreshBooks(getBooks());
        refreshCategories(getCategories());


        //setLinearHeight(ll_popular);
    }

    void setLinearHeight(LinearLayout layout ){
        // Get screen width programmatically
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int widthPixels = displayMetrics.widthPixels;

        // Set layout width programmatically
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = widthPixels;
        layout.setLayoutParams(params);
    }


    void refreshAdapter(ArrayList<Essential> items ) {
        EssentialAdapter adapter = new  EssentialAdapter(this, items);
        rv_essential.setAdapter(adapter);
    }
    void refreshSneakers(ArrayList<SneakersModel> items ) {
        SneakersAdapter adapter = new  SneakersAdapter(this, items);
        rv_sneakers.setAdapter(adapter);
    }
    void refreshGifts(ArrayList<GiftsModel> items ) {
        GiftsAdapter adapter = new  GiftsAdapter(this, items);
        rv_gifts.setAdapter(adapter);
    }
    void refreshBooks(ArrayList<BooksModel> items ) {
        BooksAdapter adapter = new  BooksAdapter(this, items);
        rv_books.setAdapter(adapter);
    }

    void refreshCategories(ArrayList<CategoryModel> items ) {
        CategoryAdapter adapter = new  CategoryAdapter(this, items);
        rv_category.setAdapter(adapter);
    }

    ArrayList<Essential> getEssentials() {
        ArrayList<Essential> items = new ArrayList<Essential>();
        items.add(new Essential("Oculus", R.drawable.oculus));
        items.add(new Essential("Gamer", R.drawable.gamer));
        items.add(new Essential("Mobile", R.drawable.gamer_mob));

        return items;
    }
    ArrayList<SneakersModel> getSneakers() {
        ArrayList<SneakersModel> items = new ArrayList<SneakersModel>();
        items.add(new SneakersModel( R.drawable.sneakers5));
        items.add(new SneakersModel( R.drawable.sneakers6));
        items.add(new SneakersModel( R.drawable.sneakers7));
        items.add(new SneakersModel( R.drawable.sneakers8));

        return items;
    }
    ArrayList<GiftsModel> getGifts() {
        ArrayList<GiftsModel> items = new ArrayList<GiftsModel>();
        items.add(new GiftsModel( R.drawable.camera1));
        items.add(new GiftsModel( R.drawable.camera2));
        items.add(new GiftsModel( R.drawable.camera3));
        items.add(new GiftsModel( R.drawable.camera4));

        return items;
    }

    ArrayList<BooksModel> getBooks() {
        ArrayList<BooksModel> items = new ArrayList<BooksModel>();
        items.add(new BooksModel( R.drawable.book1,"Wedding Bels for the Victory Girls",4.75,7.55));
        items.add(new BooksModel( R.drawable.book2,"The Complete Peas and Carrots Collection",12.30,18.40));
        items.add(new BooksModel( R.drawable.book3,"Apple Tree Cottage",3.22,null));

        return items;
    }
    ArrayList<CategoryModel> getCategories() {
        ArrayList<CategoryModel> items = new ArrayList<CategoryModel>();
        items.add(new CategoryModel( R.drawable.beauty,"Beauty"));
        items.add(new CategoryModel( R.drawable.homeand,"Home and Kitchen"));
        items.add(new CategoryModel( R.drawable.sportsand,"Sports and Outdoors"));
        items.add(new CategoryModel( R.drawable.electronic,"Electronics"));
        items.add(new CategoryModel( R.drawable.outdoor_clothing,"Outdoor Clothing"));
        items.add(new CategoryModel( R.drawable.pet,"Pet Supplies"));

        return items;
    }
}