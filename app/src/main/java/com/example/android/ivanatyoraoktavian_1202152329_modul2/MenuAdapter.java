package com.example.android.ivanatyoraoktavian_1202152329_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MenuAdapter extends
        RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    private final LinkedList<String> mFoodList; //membuat variabel bernama mFoodList dengan linkedlist yang berbentuk string
    private final LinkedList<Integer> mPriceList;
    private final LinkedList<Integer> mPhotoList;
    private LayoutInflater mInflater; //menampung activity_menu_adapter.xml


    public MenuAdapter(Context context, LinkedList<String> foodList, LinkedList<Integer> priceList, LinkedList<Integer> photoList) {
        mInflater = LayoutInflater.from(context);
        this.mFoodList = foodList;  //memanggil isi dari foodList
        this.mPriceList = priceList;
        this.mPhotoList = photoList;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //memanggil overide MenuViewHolder
        View mItemView = mInflater.inflate(R.layout.activity_menu_adapter, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) { //mengatur posisi
        String mCurrentFood = mFoodList.get(position);
        Integer mCurrentPrice = mPriceList.get(position);
        Integer mCurrentPhoto = mPhotoList.get(position);
        holder.foodItemView.setText(mCurrentFood);
        holder.priceItemView.setText("Rp."+mCurrentPrice.toString());
        holder.photoItemView.setImageResource(mCurrentPhoto);
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{ //disaat item tersebut bisa di klik
        public final TextView foodItemView;
        public final TextView priceItemView;
        public final ImageView photoItemView;

        final MenuAdapter mAdapter;
        public MenuViewHolder(final View itemView, MenuAdapter adapter) {
            super(itemView);
            foodItemView = (TextView)itemView.findViewById(R.id.tv_food); //inisiasi berdasar id
            priceItemView = (TextView)itemView.findViewById(R.id.tv_price);
            photoItemView = (ImageView)itemView.findViewById(R.id.iv_photo);
            photoItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // posisi jika item sudah diklik
                    int mPosition = getLayoutPosition();
                    String food = mFoodList.get(mPosition); //mengatur posisi
                    Integer price = mPriceList.get(mPosition);
                    Integer photo = mPhotoList.get(mPosition);
                    Intent intent = new Intent(itemView.getContext(), com.example.android.ivanatyoraoktavian_1202152329_modul2.DetailMenu.class);
                    intent.putExtra("food",food); //membawa data
                    intent.putExtra("price",price);
                    intent.putExtra("photo",photo);
                    itemView.getContext().startActivity(intent); //mengirim data ke detail menu
                }
            });
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
