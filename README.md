
<h3 align="left">Ecommerceapp</h3>

* ECommerceApp uygulaması bir e-ticaret uygulaması protipidir.
* ECommerceApp application is an e-commerce application prototype.

### Technology Used

<img src="https://www.vectorlogo.zone/logos/kotlinlang/kotlinlang-icon.svg" alt="kotlin" width="40" height="40"/> </a>    <a href="https://www.mysql.com/" target="_blank" rel="noreferrer">
<img src="https://www.vectorlogo.zone/logos/firebase/firebase-icon.svg" alt="firebase" width="40" height="40"/> </a> <a href="https://www.firebase.google.com/" target="_blank" rel="noreferrer"> 

### Proje Anlatım

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

### Project Presentation


### İmages
| Login  | SignUp  | Main  | Search  | Purchased  |
|---|---|---|---|---|
| ![login](https://github.com/eserali/ECommerceApp/assets/157403007/2b85a017-db32-4603-ab92-fd8d72cc5104) |![SignUpPage](https://github.com/eserali/ECommerceApp/assets/157403007/15473b22-89f7-4b78-89df-34bb58e867c6)   | ![main](https://github.com/eserali/ECommerceApp/assets/157403007/669f3290-6584-40e3-9d1d-d839b9344acc)  |  ![search](https://github.com/eserali/ECommerceApp/assets/157403007/bb551c77-9547-465c-a4d7-1a8f5e87d348) |  ![Purchased](https://github.com/eserali/ECommerceApp/assets/157403007/605641ac-0dd2-4e6c-a6df-3d6f8ac5a0b0) |

| Basket  | My Account  | Addresses  | Add Address  | Detail  |
|---|---|---|---|---|
| ![basket](https://github.com/eserali/ECommerceApp/assets/157403007/198521e4-856f-4b2c-8db1-aea4c52b9b60) | ![My Account](https://github.com/eserali/ECommerceApp/assets/157403007/2b013a30-38d9-4e07-a590-5182e6fdfda2) |![addressList](https://github.com/eserali/ECommerceApp/assets/157403007/7eded1d1-aab6-49f1-ab61-1f374caab6ec)  |![add address](https://github.com/eserali/ECommerceApp/assets/157403007/10dd64e0-6265-4943-9bb3-fefee7c05d4c) |![Detail](https://github.com/eserali/ECommerceApp/assets/157403007/a4b88af8-c4c1-47bd-b89b-ea37335fa1f9) |

| Confirm Order  | Change Address  | Add Credit Card  |
|---|---|---|
| ![confirmOrder](https://github.com/eserali/ECommerceApp/assets/157403007/2fb67c6e-2aae-4c1d-9548-7ace7bc331ad) |![chengeAddress](https://github.com/eserali/ECommerceApp/assets/157403007/8995e393-794f-4f47-b1c7-1a34bf6a6ed7)|![add credit card](https://github.com/eserali/ECommerceApp/assets/157403007/cd25d75b-14ed-45c2-91ae-f1de7724faf4)|











