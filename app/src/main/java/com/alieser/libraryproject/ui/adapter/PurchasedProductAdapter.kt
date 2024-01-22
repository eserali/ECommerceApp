package com.alieser.libraryproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alieser.libraryproject.data.model.Product
import com.alieser.libraryproject.data.model.PurchasedProduct
import com.alieser.libraryproject.databinding.ProductPurchasedRcvRowBinding
import com.alieser.libraryproject.ui.view.product.PurchasedProductFragmentDirections
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat

class PurchasedProductAdapter(val purchasedList : List<PurchasedProduct>) : RecyclerView.Adapter<PurchasedProductAdapter.ProductPurchasedViewHolder>(){

    class ProductPurchasedViewHolder(val purchasedRowBinding : ProductPurchasedRcvRowBinding) : RecyclerView.ViewHolder(purchasedRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPurchasedViewHolder {
        val binding = ProductPurchasedRcvRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductPurchasedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return purchasedList.size
    }

    override fun onBindViewHolder(holder: ProductPurchasedViewHolder, position: Int) {

        val purchasedProduct = purchasedList[position]

        val imageUrl = purchasedProduct.imageUrl

        Glide.with(holder.itemView.context).load(imageUrl).
        override(120,120).into(holder.purchasedRowBinding.ivPurchasedRow)


        val dateFormat = SimpleDateFormat("dd/MM/yyyy").format(purchasedProduct.purchasedDate!!.toDate())


        holder.purchasedRowBinding.txtDate.text = dateFormat.toString()

        holder.purchasedRowBinding.txtCount.text = "Count : ${purchasedProduct.count}"

        holder.purchasedRowBinding.txtPrice.text = "Total : ${purchasedProduct.count*purchasedProduct.productPrice} ${purchasedProduct.currency}"

        holder.purchasedRowBinding.ivRightArrow.setOnClickListener {

            val product = Product("","",0,"")

            val action = PurchasedProductFragmentDirections.actionPurchasedProductFragmentToProductDetailFragment(product,purchasedProduct)

            Navigation.findNavController(it).navigate(action)
        }

    }


}