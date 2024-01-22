package com.alieser.libraryproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alieser.libraryproject.data.model.ProductBasket
import com.alieser.libraryproject.databinding.ProductBasketRcvRowBinding
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ProductBasketAdapter(var context: Context,val myBasketList : List<ProductBasket>) : RecyclerView.Adapter<ProductBasketAdapter.ProductBasketViewHolder>(){

    class ProductBasketViewHolder(val basketRowBinding : ProductBasketRcvRowBinding) : RecyclerView.ViewHolder(basketRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductBasketViewHolder {
        val binding = ProductBasketRcvRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductBasketViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return myBasketList.size
    }

    override fun onBindViewHolder(holder: ProductBasketViewHolder, position: Int) {

        val product = myBasketList[position]
        val imageUrl = product.imageUrl

        Glide.with(context).load(imageUrl).override(130, 100)
            .into(holder.basketRowBinding.ivProductBasketRow)


        var productCount = product.count
        holder.basketRowBinding.txtAmount.text = productCount.toString()

        val productBasket = Firebase.firestore.collection("Product Basket")

        holder.basketRowBinding.txtProductNameBasketRow.text = product.productName
        holder.basketRowBinding.txtTotalBasketRow.text = "${productCount*product.productPrice} ${product.currency}"

        if(productCount == 1) {
            holder.basketRowBinding.ivMinus.alpha = 0.5f
            holder.basketRowBinding.ivMinus.isEnabled = false
        }
        if(productCount == 10) {
            holder.basketRowBinding.ivPlus.alpha = 0.5f
            holder.basketRowBinding.ivPlus.isEnabled = false
        }

        fun setPlusOrMinusState(isPlus : Boolean) {

            if (isPlus) {
                productCount++
                holder.basketRowBinding.ivMinus.alpha = 1f
                holder.basketRowBinding.ivMinus.isEnabled = true
                if (productCount == 10) {
                    holder.basketRowBinding.ivPlus.alpha = 0.5f

                    holder.basketRowBinding.ivPlus.isEnabled = false
                }
            } else {
                productCount--
                holder.basketRowBinding.ivPlus.alpha = 1f
                holder.basketRowBinding.ivPlus.isEnabled = true
                if (productCount == 1) {
                    holder.basketRowBinding.ivMinus.alpha = 0.5f
                    holder.basketRowBinding.ivMinus.isEnabled = false
                }
            }
            productBasket.document("${product.productId}").update("count",productCount)
            holder.basketRowBinding.txtAmount.text = productCount.toString()
            holder.basketRowBinding.txtTotalBasketRow.text = "${productCount*product.productPrice} ${product.currency}"

        }
        
        holder.basketRowBinding.ivPlus.setOnClickListener {
            setPlusOrMinusState(true)

        }
        holder.basketRowBinding.ivMinus.setOnClickListener {

            setPlusOrMinusState(false)
        }

        holder.basketRowBinding.ivDelete.setOnClickListener {

            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Delete Product")
                .setMessage("Are you sure you want to remove the product from the basket?")
                .setPositiveButton("Yes") {d,i ->

                    productBasket.document("${product.productId}").delete()
                }
                .setNegativeButton("No") {d,i ->

                    d.cancel()
                }.show()

        }



    }


}