package com.features.growharvest.Sementara

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.features.growharvest.DataProduct.DataProduct
import com.features.growharvest.DataProduct.DataProductAdapter
import com.features.growharvest.R
import org.json.JSONException

class DataProductActivity : AppCompatActivity() {

    private val productList = ArrayList<DataProduct>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataProductAdapter: DataProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_data_produk)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        dataProductAdapter = DataProductAdapter(this, productList)
        recyclerView.adapter = dataProductAdapter

        val apiUrl = "https://growharvest.my.id/API/produk.php"

        // Menggunakan Volley untuk mengambil data JSON
        val requestQueue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, apiUrl, null,
            Response.Listener { response ->
                // Mengambil data produk dari JSON response
                try {
                    for (i in 0 until response.length()) {
                        val productJson = response.getJSONObject(i)
                        val product = DataProduct(
                            productJson.getString("id_produk"),
                            productJson.getString("nama_produk"),
                            productJson.getInt("harga_produk"),
                            productJson.getInt("stok_produk"),
                            productJson.getString("deskripsi"),
                            productJson.getString("gambar_produk")
                        )
                        productList.add(product)
                    }
                    // Memberitahu adapter bahwa dataset telah berubah
                    dataProductAdapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                // Menangani kesalahan
                error.printStackTrace()
                if (error is VolleyError) {
                    val errorMessage = error.message
                    Log.e("VolleyError", errorMessage ?: "Unknown VolleyError")
                }
            }
        )
        // Menambahkan request ke queue
        requestQueue.add(jsonArrayRequest)
    }



}
