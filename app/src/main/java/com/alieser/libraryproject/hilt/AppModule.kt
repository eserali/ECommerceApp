package com.alieser.libraryproject.hilt

import com.alieser.libraryproject.data.datasource.AddressDataSource
import com.alieser.libraryproject.data.datasource.ProductBasketDataSource
import com.alieser.libraryproject.data.datasource.ProductDataSource
import com.alieser.libraryproject.data.datasource.PurchasedProductDataSoruce
import com.alieser.libraryproject.data.repository.AddressRepository
import com.alieser.libraryproject.data.repository.ProductBasketRepository
import com.alieser.libraryproject.data.repository.ProductRepository
import com.alieser.libraryproject.data.repository.PurchasedProductRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    // Products
    @Provides
    @Singleton
    @Named("Products")
    fun provideCollectionReference() : CollectionReference {
        return Firebase.firestore.collection("Products")

    }

    @Provides
    @Singleton
    fun provideProductDataSource(@Named("Products")collectionReference: CollectionReference) : ProductDataSource {
        return ProductDataSource(collectionReference)
    }

    @Provides
    @Singleton
    fun provideProductRepository(productDataSource: ProductDataSource) : ProductRepository {
        return ProductRepository(productDataSource)
    }
    // Product Basket
    @Provides
    @Singleton
    @Named("Product Basket")
    fun provideCollectionBasketReference() : CollectionReference {
        return Firebase.firestore.collection("Product Basket")
    }

    @Provides
    @Singleton
    fun provideProductBasketDataSource(@Named("Product Basket")collectionBasketReference: CollectionReference) : ProductBasketDataSource {
        return ProductBasketDataSource(collectionBasketReference)
    }
    @Provides
    @Singleton
    fun provideProductBasketRepository(productBasketDataSource: ProductBasketDataSource) : ProductBasketRepository {
        return ProductBasketRepository(productBasketDataSource)
    }
    // Purchased Product
    @Provides
    @Singleton
    @Named("Purchased Product")
    fun providePurchasedProductCollectionReference() : CollectionReference {
        return Firebase.firestore.collection("Purchased Product")
    }
    @Provides
    @Singleton
    fun providePurchasedProductDataSource(@Named("Purchased Product")collectionPurhcasedProductReference: CollectionReference) : PurchasedProductDataSoruce {
        return PurchasedProductDataSoruce(collectionPurhcasedProductReference)
    }

    @Provides
    @Singleton
    fun providePurchasedProductRepository(purchasedProductDataSource: PurchasedProductDataSoruce) : PurchasedProductRepository {
        return PurchasedProductRepository(purchasedProductDataSource)
    }
    // Address List
    @Provides
    @Singleton
    @Named("Address List")
    fun provideAddressCollectionReference() : CollectionReference {
        return Firebase.firestore.collection("Address List")
    }

    @Provides
    @Singleton
    fun provideAddressDataSource(@Named("Address List")collectionAddressReference: CollectionReference) : AddressDataSource {
        return AddressDataSource(collectionAddressReference)
    }

    @Provides
    @Singleton
    fun provideAddressRepository(addressDatasource: AddressDataSource) : AddressRepository {
        return AddressRepository(addressDatasource)
    }
}