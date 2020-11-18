package baitap.ute.demolist_proflie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView back;
    ListView listView;
    Context context;
    LinearLayout listviewdata;
    ArrayList<ProductModel> productData;
    ProductAdapter productAdapter;
    ProductModel productModel;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        context = this;
        setContentView ( R.layout.activity_main );

        //getviews
        listView = findViewById ( R.id.listview );
        listviewdata = (LinearLayout) findViewById ( R.id.listviewdata );
        productData = new ArrayList<> ();

        //add Countries Data
        populateProductData ();
        listView.setOnItemLongClickListener ( new ItemLongClickRemove () );
        productAdapter = new ProductAdapter ( context, productData );
        listView.setAdapter ( productAdapter );
        registerForContextMenu ( listView );
        listView = findViewById ( R.id.listview );
        listView.setOnItemLongClickListener ( new ItemLongClickRemove () );
        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText ( context, productData.get ( position ).getNamedh (), Toast.LENGTH_SHORT ).show ();
                Intent intent = new Intent ( getApplicationContext (), ListviewItemActivity.class );
                intent.putExtra ( "name", productData.get ( position ).getNamedh () );
                intent.putExtra ( "image", productData.get ( position ).getImages () );
                startActivity ( intent );
            }
        } );

    }
    private void populateProductData() {
        //product1
        productModel = new ProductModel();
        productModel.setId(1);
        productModel.setNamedh("VinMart");
        productModel.setImages(R.drawable.imga);
        productData.add(productModel);

        //product2
        productModel = new ProductModel();
        productModel.setId(2);
        productModel.setNamedh("Meiji");
        productModel.setImages(R.drawable.img5);
        productData.add(productModel);

        //product3
        productModel = new ProductModel();
        productModel.setId(3);
        productModel.setNamedh("Bác Tôm");
        productModel.setImages(R.drawable.img4);
        productData.add(productModel);

        //product4
        productModel = new ProductModel();
        productModel.setId(4);
        productModel.setNamedh("F5 Fruit");
        productModel.setImages(R.drawable.img2);
        productData.add(productModel);

        //product5
        productModel = new ProductModel();
        productModel.setId(5);
        productModel.setNamedh("Nông sản Dũng Hà");
        productModel.setImages(R.drawable.img3);
        productData.add(productModel);

        //product6
        productModel = new ProductModel();
        productModel.setId(6);
        productModel.setNamedh("Hoàng Đông food");
        productModel.setImages(R.drawable.imgchamthan);
        productData.add(productModel);
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( baitap.ute.demolist_proflie.MainActivity.this);
            alertDialogBuilder.setMessage("Bạn có muốn xóa sản phẩm này?");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    productData.remove(position);
                    //cập nhật lại gridview
                    productAdapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}