# YazLab
- Yazılım Laboratuvarı dersinde geliştirdiğim projeler yer almakta.
- Yazılım Laboratuvarı 1: BA - Yazılım Laboratuvarı 2: AA ile dersleri başarılı bir şekilde verdim.

## Projeler

- **1. Proje:** Market, petrol, kafe gibi yerlerden alınan rastgele bir fiş, dış ortam(karanlık ortam) veya etkenler(fiş yıpranması) farketmeksizin kamera ile çekilip sisteme tanıtılmasının ardından fiş üzerindeki bilgilerin parse edilerek GUI ekranında gösterilmesi ve veritabanına kaydedilmesi istenmiştir. **Java** ile geliştirilmiştir, **OpenCV, Tesseract** kütüphaneleri kullanılmıştır.

- **2. Proje:** Bir ana sunucu, 2 veya daha fazla ara sunucudan oluşan bir websitesi veya mobil uygulamaya sync multithreadler ile yük bindirme/azaltma ve yük dağılım işlemi yapılmıştır. Ana sunucu üzerindeki istek yüklerinin ara sunuculara dağıtılması sağlanarak ana sunucuya yeni gelecek olan isteklerin kabul edilmesi sağlanarak websitesi veya mobil uygulamaya istek yapan kullanıcıların sunucularda rahat bir şekilde işlem yapılmasına izin verilir. Bir nevi sunucular üzerinde **load balancing** işleminin prototipi yapılmıştır. **Java** ile geliştirilmiştir. İşletim Sistemleri dersinde öğrenilen bilgiler yardımıyla geliştirilmiştir. 

- **3. Proje:** Android ortamda kullanıcı galeri veya kameradan fotoğraf çekerek belirlenen oranda sıkıtırılmasını ve segmentasyon ile nesne tanımlanması istenmiştir. Sıkıştırma işlemi firebase üzerinde node.js ile yapılırken, segmentasyon işlemi Google Vision API ile yapılmıştır. **Android Studio(Java)** ve **node.js** ile **Firebase** altyapısında geliştirilmiştir.

- **4. Proje:** Bir kütüphane sisteminin web ortamında görüntü işleme ile kullanılarak otomasyonu yazılmıştır. 1 panel üzerinden middleware ile hem yönetici hem kullanıcıya özel panel/sayfalar tasarlanmıştır. Web tarafında **Laravel** geliştirilirken, görüntü işleme kısmında ise **Python** ve **OpenCV** ile geliştirilmiştir.

- **5. Proje:** Android ortamında kelime bulmacası oyunu(Word of Wonders) tasarlanmıştır. Her seviyeye ait kelimeler crossword algoritması ile iç içe bulmacaya dökülmüştür. Kullanıcıya yardımcı olması açısından harf karıştırma, bulmacada eksik olan kelimeyi tahmin etmesi için ipucu sekmeleri eklenmiştir. Her seviyede puan hesaplaması yapılıp, skorlar skor tablosunda gösterilmektedir. **Android Studio(Java)** ile geliştirilmiştir.

- **6. Proje:** Ana veri merkezimizde gelen verinin bizden veri talebinde bulunan sunucularımıza aynı anda ne kadar aktarabildiğini oluşturduğu ford fulkerson algoritmasını kullanarak projede boru hatlarına benzetildiği şekilde dizayn ettik. **Maximum flow** algoritması ile ana şebekemizden gelen suyu borularımızın hacminin ne kadar olduğunu ve tüm düğümlerimizi güncelleyerek en optimum şekilde havuzumuzu şebeke hacmindeki suyun en maksimum miktarda alarak doldurduk. Aksi yönde isterlerde minimum bir şekilde hangi boru hatlarını kesersek suyu kesebiliriz diye düşünülüp **minimum cut** algoritmasıyla sonuca vardık. **Java** ile geliştirilmiştir.
