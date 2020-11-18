package baitap.ute.demolist_proflie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<baitap.ute.demolist_proflie.ProductModel> productsData;
    LayoutInflater layoutInflater;
    baitap.ute.demolist_proflie.ProductModel productModel;

    public ProductAdapter(Context context, ArrayList<baitap.ute.demolist_proflie.ProductModel> productData) {
        this.context = context;
        this.productsData = productData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return productsData.size();
    }

    @Override
    public Object getItem(int i) {
        return productsData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return productsData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View view1 = view;
        if (view1==null) {
            view1 = layoutInflater.inflate(R.layout.row_data,null, true);
        }
        //getting view in row_data
        TextView name = view1.findViewById(R.id.idTitle);
        ImageView image = view1.findViewById(R.id.imageView);
        productModel = productsData.get(position);

        name.setText(productModel.getNamedh());
        image.setImageResource(productModel.getImages());

        return view1;
    }
}