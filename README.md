
<h3 align="left">Ecommerceapp</h3>

* ECommerceApp uygulaması bir e-ticaret uygulaması prototipidir.
* ECommerceApp application is an e-commerce application prototype.

### Technology Used

<img src="https://www.vectorlogo.zone/logos/kotlinlang/kotlinlang-icon.svg" alt="kotlin" width="40" height="40"/> </a>  <a href="https://kotlinlang.org" target="_blank" rel="noreferrer">
<img src="https://www.vectorlogo.zone/logos/firebase/firebase-icon.svg" alt="firebase" width="40" height="40"/> </a> <a href="https://www.firebase.google.com/" target="_blank" rel="noreferrer"> 

### Project Explanation(TR)

* Bu uygulama MVVM(Model-View-Viewmodel) ve repository mimarisine sahip olup live data ile desteklenmektedir.
* Veritabanındaki mevcut her değişiklik anında ekranlarda gösterilmektedir.
* Activity ve Fragmentlar arası ekran geçişleri navigasyon grafiği ile yapılmaktadır.
* Uygulama giriş ekranında email ve şifre ile kullanıcı kaydı yapabilen bir yapıya sahip, bu yapı Google Firebase Authentication destekli olup email ve şifre standartları firebase tarafından belirlenmektedir.
* Mevcut kullanıcılar, Authentication paneline kayıt edilmektedir. Kullanıcı kaydının ardından kullanıcıyı ürünlerin bulunduğu ana sayfa karşılamaktadır.
* Ana sayfada yer alan ürünler Recyclerview listeleme aracılığıyla Firebase realtime database üzerinden Livedata kullanılarak kullanıcıya gösterilmekte veritabanındaki anlık değişimler anında kullanıcıya gösterilmektedir.
* Home sayfasında bulunan searcview sayesinde ürün arayabilir bu ürünlerin listesi yine livedata kullanılarak listelenmektedir.
* Kullanıcı anasayfada mevcut ürünün detayına ürünün kartına tıklayarak detay bilgilere ulaşabilmektedir. Ürün detayında özellikler, ürün puanı ve soruların bulunduğu tablayout’ı görebilirsiniz.
* Kullanıcı “Add To Basket” butonuna basarak ürünü sepete ekleyebilir ve bottom navigation sayesinde “Basket” sekmesine tıklayarak sepetteki ürünleri inceleyebilir.
* “Add To Basket” butonuna farklı ürünler için her tıklandığında baskette bulunan badge artmakta böylelikle kullanıcı sepete kaç tane ürün eklemiş olduğunun farkına varmaktadır.
* Hesabım sayfasında aktif olarak adresler gözükmekte,kullanıcı dilediği adresi varsayılan yapıp ödeme ekranında gözükmesini sağlayabilir.
* Kullanıcı “Save” butonuna tıkladıktan sonra mevcut adres firebase database’e kaydedilmekte ve MVVM Repository ve Live data kullanılarak adresler listesinde anında görüntülenmektedir, aynı zamanda adresler listesinde yer alan adresleri silebilir ya da düzenleyebilirsiniz.
* Kullanıcı sepetteki ürünleri görmek için sepet sekmesine tıklayarak ulaşır, burada artı ve eksi buton sayesinde aynı üründen maksimum 10 adete kadar satın alabilir.
* Kullanıcı sepet satırında yer alan çöp kutusuna tıklayarak ürünü sepetten silebilir.
* Satın almak istediği ürünleri sepetinde tutan kullanıcı “Confirm Order” butonuna tıklayarak teslimat adresi sayfasına geçiş yapar. Bu sayfada varsayılan adres gösterilmekte “Add/Change” butonuna tıklandığında Dialog Fragment açılmakta mevcut adresler listelenmektedir. 
* Bu listeden varsayılan adresi değiştirebilir ya da adresiniz yoksa “Add Address” butonuna tıklayarak adres ekleme ekranına gidebilirsiniz.
* Adresin seçilmesinin ardından sayfanın alt kısmında sepete eklediğiniz ürünlerin listesi live data aracılığıyla yer almakta adetleri parantez içinde belirtilmektedir, toplamda ödeyeceğiniz miktar sol altta yer almaktadır.
* Ardından kullanıcı “Confirm Order” butonuna tıklayarak ödeme sayfasına geçiş yapabilir. Burada yer alan bilgileri doldururken edittextlerde verilen kurallara uymalı ve kart bilgilerini girerek “Confirm Order” butonuna tıklayarak alışverişi tamamlayabilir.
* Ödemesi tamamlanan ürünlerin listesi bottom navigationda yer alan “Purchased” sekmesinde gözükmektedir.

### Project Explanation(EN)
* This application has MVVM (Model-View-Viewmodel) and repository architecture and is supported with live data.
* Every available change in the database is instantly displayed on the screens.
* Screen transitions between Activity and Fragments are made with the navigation graph.
* The application has a structure that can register users with email and password on the login screen, this structure is supported by Google Firebase Authentication and email and password standards are determined by firebase.
* Existing users are registered in the Authentication panel. After user registration, the user is welcomed to the main page with products.
* The products on the home page are displayed to the user using Livedata via Firebase realtime database via Recyclerview listing and instant changes in the database are instantly displayed to the user.
* Thanks to the searcview on the Home page, you can search for products and the list of these products is also listed using livedata.
* The user can access detailed information by clicking on the product card of the product on the homepage. In the product detail, you can see the tablayout with features, product rating and questions.
* The user can add the product to the basket by clicking the "Add To Basket" button and can view the products in the basket by clicking on the "Basket" tab through the bottom navigation.
* Each time the "Add To Basket" button is clicked for different products, the badge in the basket increases so that the user realises how many products have been added to the basket.
* Addresses are actively displayed on the My Account page, the user can make the desired address default and make it appear on the payment screen.
* After the user clicks on the "Save" button, the current address is saved in the firebase database and is instantly displayed in the addresses list using MVVM Repository and Live data, you can also delete or edit the addresses in the addresses list.
* The user clicks on the basket tab to see the products in the basket, where they can buy up to 10 of the same product thanks to the plus and minus button.
* The user can delete the product from the basket by clicking the trash can in the basket line.
* The user who keeps the products he/she wants to buy in the basket switches to the delivery address page by clicking the "Confirm Order" button. On this page, the default address is shown and when the "Add/Change" button is clicked, the Dialog Fragment opens and the available addresses are listed.
* You can change the default address from this list or if you do not have an address, you can go to the address addition screen by clicking the "Add Address" button.
* After selecting the address, the list of products you have added to the basket at the bottom of the page is displayed via live data, the quantities are indicated in brackets, and the amount you will pay in total is located at the bottom left.
* Then the user can switch to the payment page by clicking the "Confirm Order" button. While filling in the information here, the user must follow the rules given in the edittext and enter the card information and complete the shopping by clicking the "Confirm Order" button.
* The list of products whose payment is completed is shown in the "Purchased" tab in the bottom navigation.

### İmages
| Login  | SignUp  | Main  | Search  | Purchased  |
|---|---|---|---|---|
| ![login](https://github.com/eserali/ECommerceApp/assets/157403007/2b85a017-db32-4603-ab92-fd8d72cc5104) |![SignUpPage](https://github.com/eserali/ECommerceApp/assets/157403007/15473b22-89f7-4b78-89df-34bb58e867c6)   | ![main](https://github.com/eserali/ECommerceApp/assets/157403007/669f3290-6584-40e3-9d1d-d839b9344acc)  |  ![search](https://github.com/eserali/ECommerceApp/assets/157403007/bb551c77-9547-465c-a4d7-1a8f5e87d348) |  ![Purchased](https://github.com/eserali/ECommerceApp/assets/157403007/605641ac-0dd2-4e6c-a6df-3d6f8ac5a0b0) |

| Basket  | My Account  | Addresses  | Add Address  | Detail  |
|---|---|---|---|---|
| ![basket](https://github.com/eserali/ECommerceApp/assets/157403007/198521e4-856f-4b2c-8db1-aea4c52b9b60) | ![My Account](https://github.com/eserali/ECommerceApp/assets/157403007/2b013a30-38d9-4e07-a590-5182e6fdfda2) |![addressList](https://github.com/eserali/ECommerceApp/assets/157403007/7eded1d1-aab6-49f1-ab61-1f374caab6ec)  |![add address](https://github.com/eserali/ECommerceApp/assets/157403007/10dd64e0-6265-4943-9bb3-fefee7c05d4c) |![Detail](https://github.com/eserali/ECommerceApp/assets/157403007/a4b88af8-c4c1-47bd-b89b-ea37335fa1f9) |

| Confirm Order  | Change Address  | Add Credit Card  |  Credit Card  Show |
|---|---|---|---|
| ![confirmOrder](https://github.com/eserali/ECommerceApp/assets/157403007/2fb67c6e-2aae-4c1d-9548-7ace7bc331ad) |![chengeAddress](https://github.com/eserali/ECommerceApp/assets/157403007/8995e393-794f-4f47-b1c7-1a34bf6a6ed7)|![add credit card](https://github.com/eserali/ECommerceApp/assets/157403007/cd25d75b-14ed-45c2-91ae-f1de7724faf4)| ![credit card show](https://github.com/eserali/ECommerceApp/assets/157403007/28473784-81c8-41ad-9a76-e6b51650c0f4)  |












