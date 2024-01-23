## Ecommerceapp

### Technology Used

<img src="https://www.vectorlogo.zone/logos/kotlinlang/kotlinlang-icon.svg" alt="kotlin" width="40" height="40"/> </a>    <a href="https://www.mysql.com/" target="_blank" rel="noreferrer">
<img src="https://www.vectorlogo.zone/logos/firebase/firebase-icon.svg" alt="firebase" width="40" height="40"/> </a> <a href="https://www.firebase.google.com/" target="_blank" rel="noreferrer"> 

### Proje Anlatım

* ECommerceApp uygulaması bir e-ticaret uygulamasıdır.
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
