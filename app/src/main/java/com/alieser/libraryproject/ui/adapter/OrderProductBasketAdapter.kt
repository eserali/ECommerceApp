package com.alieser.libraryproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alieser.libraryproject.data.model.ProductBasket
import com.alieser.libraryproject.databinding.OrderRcvRowBinding
import com.bumptech.glide.Glide

class OrderProductBasketAdapter(var context : Context, var basketList : List<ProductBasket>) : RecyclerView.Adapter<OrderProductBasketAdapter.OrderProductBasketViewHolder>() {

    class OrderProductBasketViewHolder(val rowBinding : OrderRcvRowBinding) : RecyclerView.ViewHolder(rowBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderProductBasketViewHolder {
        val binding = OrderRcvRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OrderProductBasketViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return basketList.size
    }

    override fun onBindViewHolder(holder: OrderProductBasketViewHolder, position: Int) {
        var productBasket = basketList[position]
        val binding = holder.rowBinding

        val imageUrl = productBasket.imageUrl
        Glide.with(context).load(imageUrl).override(60,60).into(binding.ivOrderProduct)

        binding.txtOrderProductName.text = "${productBasket.productName } (${productBasket.count})"
        binding.txtOrderPrice.text = "${productBasket.productPrice.toString()} ${productBasket.currency}"



    }
}