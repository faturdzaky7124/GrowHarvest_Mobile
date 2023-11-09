package com.features.growharvest;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BerandaActivity extends AppCompatActivity {
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        mProductList = KeranjangBelanjaData.getCatalog(getResources());
        Log.d("PPPPPPPP", mProductList.toString());
        ListView listViewCatalog = (ListView) findViewById(R.id.ListView1);
        listViewCatalog.setAdapter(new ProductAdapter(mProductList,
                getLayoutInflater(), false));
        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),
                        DetailProduk.class);
                productDetailsIntent.putExtra(
                        KeranjangBelanjaData.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });
        Button viewShoppingCart = (Button) findViewById(R.id.Button1);
        viewShoppingCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(),
                        ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });
    }
}