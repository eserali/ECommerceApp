package com.alieser.libraryproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alieser.libraryproject.data.model.Product
import com.alieser.libraryproject.data.model.PurchasedProduct
import com.alieser.libraryproject.data.util.ProductManager

import com.alieser.libraryproject.databinding.ProductRcvRowBinding
import com.alieser.libraryproject.ui.view.product.ProductFragmentDirections

import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class ProductAdapter(var context : Context, val productList : List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    private lateinit var auth : FirebaseAuth
    var productManager = ProductManager()

    class ProductViewHolder(val productRowBinding : ProductRcvRowBinding) : RecyclerView.ViewHolder(productRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductRcvRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        val imageUrl = product.imageUrl

        if(imageUrl != null) {
            Glide.with(context).load(imageUrl).override(120, 120)
                .into(holder.productRowBinding.ivProductRow)
        }

        holder.productRowBinding.txtProductName.text = product.productName
        holder.productRowBinding.txtPriceProductRow.text = "${product.productPrice.toString()}  ${product.currency}"


        holder.productRowBinding.cvProductRow.setOnClickListener {
            val purchasedProduct = PurchasedProduct("",0,null,"","",0,0,"","","")
            val action = ProductFragmentDirections.actionProductFragmentToProductDetailFragment(product,purchasedProduct)
            Navigation.findNavController(it).navigate(action)
        }

        holder.productRowBinding.btnAddToBasketProductRow.setOnClickListener {
            try {
                productManager.findProductBasketDocument(product)
            }
            catch (exception : Exception) {
                Toast.makeText(holder.itemView.context,exception.message!!,Toast.LENGTH_LONG).show()
            }



        }
    }

}