package com.teknohane.teknoHane.dataSeeder;

import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.ProductsDetail;
import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.repository.CategoryRepository;
import com.teknohane.teknoHane.repository.ProductDetailRepository;
import com.teknohane.teknoHane.repository.ProductsRepository;
import com.teknohane.teknoHane.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductsRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        if (usersRepository.count() == 0) {
            Users user = new Users();
            user.setFirstName("Ferhat");
            user.setLastName("Urper");
            user.setEposta("ferhaturper716@gmail.com");
            user.setPhone("05524347573");
            user.setGender("male");
            user.setBirthday(new SimpleDateFormat("dd-MM-yyyy").parse("19-06-2004"));
            user.setRole("USER_ROLE");
            user.setPassword(passwordEncoder.encode("231Ferhat"));
            usersRepository.save(user);
            System.out.println("✔ Kullanıcı başarıyla eklendi: Ferhat Urper");
        }


        if (categoryRepository.count() > 0 || productRepository.count() > 0 || productDetailRepository.count() > 0) {
            return;
        }

        // Akıllı Telefonlar Kategorisi
        Category telefon = new Category();
        telefon.setCategoryName("Akıllı Telefonlar");
        telefon.setCategoryDescription("Yüksek teknolojili akıllı telefonlar.");
        telefon.setCategoryImages(List.of("https://www.beko.com.tr/media/resize/9232981600_LO2_20230922_082122.png/2000Wx2000H/image.webp"));
        telefon = categoryRepository.save(telefon);

        Products tel1 = new Products();
        tel1.setProductName("iPhone 14 Pro");
        tel1.setDescription("Üst seviye performans ve kamera deneyimi.");
        tel1.setPrice(45000);
        tel1.setStockQuantity(10);
        tel1.setProductInfo("6.1 inç ekran, A16 Bionic işlemci.");
        tel1.setCategoryId(telefon.getCategoryId());
        tel1.setSellerId(1L);
        tel1.setProductImages(List.of("https://assets.getmobil.com/uploads/55430/getmobil-apple-iphone14pro-deeppurple-00png.png"));
        tel1 = productRepository.save(tel1);

        ProductsDetail tel1Detay = new ProductsDetail();
        tel1Detay.setProductId(tel1.getProductId());
        tel1Detay.setBrand("Apple");
        tel1Detay.setModel("iPhone 14 Pro");
        tel1Detay.setFeatures(
                "• Dynamic Island\n" +
                        "• Always-On Display\n" +
                        "• ProMotion 120Hz\n" +
                        "• Ceramic Shield ön yüzey\n" +
                        "• Face ID ile güvenli kimlik doğrulama"
        );
        tel1Detay.setTechnicalDetails(
                "• Apple A16 Bionic işlemci (3.46GHz, 6 çekirdekli)\n" +
                        "• 6.1 inç Super Retina XDR OLED ekran\n" +
                        "• 6GB RAM, 256GB depolama\n" +
                        "• 48MP Ana kamera, 12MP Ultra Geniş, Telefoto\n" +
                        "• 3200mAh batarya, MagSafe desteği"
        );
        productDetailRepository.save(tel1Detay);
        Category laptop = new Category();
        laptop.setCategoryName("Dizüstü Bilgisayarlar");
        laptop.setCategoryDescription("Günlük ve profesyonel kullanım için laptoplar.");
        laptop.setCategoryImages(List.of("https://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c08501326.png"));
        laptop = categoryRepository.save(laptop);

        Products laptop1 = new Products();
        laptop1.setProductName("HP Spectre x360");
        laptop1.setDescription("Hafif ve güçlü dönüştürülebilir dizüstü bilgisayar.");
        laptop1.setPrice(15000);
        laptop1.setStockQuantity(15);
        laptop1.setProductInfo("13.5 inç OLED ekran, Intel i7 işlemci.");
        laptop1.setCategoryId(laptop.getCategoryId());
        tel1.setSellerId(1L);
        laptop1.setProductImages(List.of("https://www.slashgear.com/img/gallery/hp-spectre-x360-13-15-laptops-launch-with-premium-style-and-features/intro-import.jpg"));
        laptop1 = productRepository.save(laptop1);

        ProductsDetail laptop1Detay = new ProductsDetail();
        laptop1Detay.setProductId(laptop1.getProductId());
        laptop1Detay.setBrand("HP");
        laptop1Detay.setModel("Spectre x360");
        laptop1Detay.setFeatures(
                "• 13.5\" OLED dokunmatik ekran\n" +
                        "• 360 derece katlanabilir tasarım\n" +
                        "• Arkadan aydınlatmalı klavye\n" +
                        "• Parmak izi okuyucu\n" +
                        "• Windows Ink kalem desteği"
        );
        laptop1Detay.setTechnicalDetails(
                "• Intel Core i7 12. Nesil işlemci\n" +
                        "• 16GB LPDDR4x RAM\n" +
                        "• 512GB NVMe SSD depolama\n" +
                        "• Intel Iris Xe grafik birimi\n" +
                        "• Yaklaşık 1.3 kg hafif tasarım"
        );
        productDetailRepository.save(laptop1Detay);

// Tabletler Kategorisi
        Category tablet = new Category();
        tablet.setCategoryName("Tabletler");
        tablet.setCategoryDescription("Mobil kullanım için hafif ve güçlü tabletler.");
        tablet.setCategoryImages(List.of("https://cdn.dsmcdn.com/ty949/product/media/images/20230613/9/385169649/968025185/2/2_org_zoom.jpeg"));
        tablet = categoryRepository.save(tablet);

        Products tablet1 = new Products();
        tablet1.setProductName("iPad Pro 12.9");
        tablet1.setDescription("Profesyonel kullanım için güçlü tablet.");
        tablet1.setPrice(20000);
        tablet1.setStockQuantity(12);
        tablet1.setProductInfo("12.9 inç Liquid Retina, M2 çip.");
        tablet1.setCategoryId(tablet.getCategoryId());
        tel1.setSellerId(1L);
        tablet1.setProductImages(List.of("https://www.gaming.gen.tr/wp-content/uploads/2023/09/apple-ipad-pro-12-9-inc-6-nesil-m2-256gb-gumus-mnxt3tu-a.jpg"));
        tablet1 = productRepository.save(tablet1);

        ProductsDetail tablet1Detay = new ProductsDetail();
        tablet1Detay.setProductId(tablet1.getProductId());
        tablet1Detay.setBrand("Apple");
        tablet1Detay.setModel("iPad Pro 12.9");
        tablet1Detay.setFeatures(
                "• Apple M2 çip\n" +
                        "• ProMotion 120Hz ekran\n" +
                        "• True Tone ve P3 renk gamı\n" +
                        "• Face ID ile güvenli kimlik doğrulama\n" +
                        "• Apple Pencil (2. nesil) desteği"
        );

        tablet1Detay.setTechnicalDetails(
                "• 16GB RAM, 1TB SSD depolama\n" +
                        "• 12.9 inç Liquid Retina XDR ekran\n" +
                        "• Thunderbolt / USB 4 bağlantı\n" +
                        "• 5G desteği (Cellular modelde)\n" +
                        "• Yaklaşık 682g ağırlık"
        );
        productDetailRepository.save(tablet1Detay);

// Akıllı Saatler Kategorisi
        Category saat = new Category();
        saat.setCategoryName("Akıllı Saatler");
        saat.setCategoryDescription("Sağlık takibi ve bildirimler için modern saatler.");
        saat.setCategoryImages(List.of("https://statics.vestel.com.tr/productimages/20292605_r1_1000_1000.jpg"));
        saat = categoryRepository.save(saat);

        Products saat1 = new Products();
        saat1.setProductName("Apple Watch Series 8");
        saat1.setDescription("Gelişmiş sağlık ve aktivite takibi.");
        saat1.setPrice(7000);
        saat1.setStockQuantity(20);
        saat1.setProductInfo("Blood Oxygen, ECG, Always-On Retina ekran.");
        saat1.setCategoryId(saat.getCategoryId());
        tel1.setSellerId(1L);
        saat1.setProductImages(List.of("https://cdn2.a101.com.tr/dbmk89vnr/CALL/Image/getcl/mnresize/480/480/livephotos/8/26052978DEFAULT/26052978.jpg"));
        saat1 = productRepository.save(saat1);

        ProductsDetail saat1Detay = new ProductsDetail();
        saat1Detay.setProductId(saat1.getProductId());
        saat1Detay.setBrand("Apple");
        saat1Detay.setModel("Watch Series 8");
        saat1Detay.setFeatures(
                "• Kan oksijen sensörü\n" +
                        "• Düşme ve çarpma algılama\n" +
                        "• Vücut sıcaklığı takibi\n" +
                        "• EKG çekimi\n" +
                        "• Her zaman açık Retina ekran"
        );

        saat1Detay.setTechnicalDetails(
                "• 1GB RAM, 32GB depolama\n" +
                        "• 45 mm kasa boyutu\n" +
                        "• IP6X toz direnci, WR50 suya dayanıklılık\n" +
                        "• Bluetooth 5.3, Wi-Fi desteği\n" +
                        "• Yaklaşık 45g ağırlık"
        );
        productDetailRepository.save(saat1Detay);

// Oyun Konsolları Kategorisi
        Category oyun = new Category();
        oyun.setCategoryName("Oyun Konsolları");
        oyun.setCategoryDescription("Popüler oyun konsolları ve ekipmanları.");
        oyun.setCategoryImages(List.of("https://gmedia.playstation.com/is/image/SIEPDC/ps5-product-thumbnail-01-en-14sep21?$facebook$"));
        oyun = categoryRepository.save(oyun);

        Products oyun1 = new Products();
        oyun1.setProductName("PlayStation 5");
        oyun1.setDescription("Yeni nesil oyun konsolu.");
        oyun1.setPrice(8500);
        oyun1.setStockQuantity(25);
        oyun1.setProductInfo("Ultra hızlı SSD, 4K oyun deneyimi.");
        oyun1.setCategoryId(oyun.getCategoryId());
        tel1.setSellerId(1L);
        oyun1.setProductImages(List.of("https://cdn2.a101.com.tr/dbmk89vnr/CALL/Image/getcl/mnresize/480/480/livephotos/8/26052978DEFAULT/26052978.jpg"));
        oyun1 = productRepository.save(oyun1);

        ProductsDetail oyun1Detay = new ProductsDetail();
        oyun1Detay.setProductId(oyun1.getProductId());
        oyun1Detay.setBrand("Sony");
        oyun1Detay.setModel("PlayStation 5");
        oyun1Detay.setFeatures(
                "• 4K UHD grafik desteği\n" +
                        "• Ray Tracing teknolojisi\n" +
                        "• Hızlı yükleme için özel SSD\n" +
                        "• DualSense titreşimli kontrolcü\n" +
                        "• Geriye dönük PS4 uyumluluğu"
        );

        oyun1Detay.setTechnicalDetails(
                "• 16GB GDDR6 RAM\n" +
                        "• 825GB NVMe SSD depolama\n" +
                        "• AMD Zen 2 8 çekirdekli işlemci\n" +
                        "• RDNA 2 mimarili özel GPU (10.28 TFLOPS)\n" +
                        "• HDMI 2.1, USB-C ve USB-A bağlantıları"
        );
        productDetailRepository.save(oyun1Detay);

// Kameralar Kategorisi
        Category kamera = new Category();
        kamera.setCategoryName("Kameralar");
        kamera.setCategoryDescription("Profesyonel fotoğrafçılık için kameralar.");
        kamera.setCategoryImages(List.of("https://i1.adis.ws/i/canon/xa55-xa50-frt-01_800x800_266754992397187?w=300"));
        kamera = categoryRepository.save(kamera);

        Products kamera1 = new Products();
        kamera1.setProductName("Canon EOS R6");
        kamera1.setDescription("Yüksek performanslı aynasız kamera.");
        kamera1.setPrice(30000);
        kamera1.setStockQuantity(8);
        kamera1.setProductInfo("20MP, 4K video kayıt.");
        kamera1.setCategoryId(kamera.getCategoryId());
        tel1.setSellerId(1L);
        kamera1.setProductImages(List.of("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdFYPRtR_k4p-pdbqg8PbZ6r5QlJkrQNn3fA&s"));
        kamera1 = productRepository.save(kamera1);

        ProductsDetail kamera1Detay = new ProductsDetail();
        kamera1Detay.setProductId(kamera1.getProductId());
        kamera1Detay.setBrand("Canon");
        kamera1Detay.setModel("EOS R6");
        kamera1Detay.setFeatures(
                "• 5 eksenli gövde içi görüntü sabitleme (IBIS)\n" +
                        "• Dual Pixel CMOS AF II\n" +
                        "• Döndürülebilir dokunmatik ekran\n" +
                        "• Dahili Wi-Fi ve Bluetooth\n" +
                        "• Elektronik vizör (EVF) desteği"
        );

        kamera1Detay.setTechnicalDetails(
                "• 20.1 MP Full-Frame CMOS sensör\n" +
                        "• 4K UHD video kaydı (60 fps'e kadar)\n" +
                        "• 8 fps sürekli çekim (mekanik obtüratörle)\n" +
                        "• ISO aralığı 100–102400\n" +
                        "• Çift SD kart yuvası"
        );

        productDetailRepository.save(kamera1Detay);

// Kulaklıklar Kategorisi
        Category kulaklik = new Category();
        kulaklik.setCategoryName("Kulaklıklar");
        kulaklik.setCategoryDescription("Kablosuz ve kablolu yüksek ses kalitesi sunan kulaklıklar.");
        kulaklik.setCategoryImages(List.of("https://zoreaksesuar.com/lenyes-lh23-anc-ozellikli-kulak-ustu-bluetooth-kulaklik-v54-kulakliklar-lenyes-398364-34-B.jpg"));
        kulaklik = categoryRepository.save(kulaklik);

        Products kulaklik1 = new Products();
        kulaklik1.setProductName("Sony WH-1000XM4");
        kulaklik1.setDescription("Aktif gürültü engelleme teknolojisine sahip kablosuz kulaklık.");
        kulaklik1.setPrice(3500);
        kulaklik1.setStockQuantity(30);
        kulaklik1.setProductInfo("30 saat pil ömrü, hızlı şarj.");
        kulaklik1.setCategoryId(kulaklik.getCategoryId());
        tel1.setSellerId(1L);
        kulaklik1.setProductImages(List.of("https://m.media-amazon.com/images/I/71ARBeyX02L.jpg"));
        kulaklik1 = productRepository.save(kulaklik1);

        ProductsDetail kulaklik1Detay = new ProductsDetail();
        kulaklik1Detay.setProductId(kulaklik1.getProductId());
        kulaklik1Detay.setBrand("Sony");
        kulaklik1Detay.setModel("WH-1000XM4");
        kulaklik1Detay.setFeatures(
                "• Aktif gürültü engelleme (ANC)\n" +
                        "• Bluetooth 5.0 kablosuz bağlantı\n" +
                        "• Şeffaf mod (ortam sesi duyma)\n" +
                        "• Katlanabilir ve hafif tasarım\n" +
                        "• Dokunmatik kontrol paneli"
        );

        kulaklik1Detay.setTechnicalDetails(
                "• 40 mm sürücüler\n" +
                        "• 1.5GB firmware belleği\n" +
                        "• 30 saat pil ömrü (ANC kapalı)\n" +
                        "• USB-C hızlı şarj desteği\n" +
                        "• Ağırlık: 254 gram"
        );
        productDetailRepository.save(kulaklik1Detay);

// Monitörler Kategorisi
        Category monitor = new Category();
        monitor.setCategoryName("Monitörler");
        monitor.setCategoryDescription("Yüksek çözünürlük ve hızlı tepki süresi.");
        monitor.setCategoryImages(List.of("https://cdn.vatanbilgisayar.com/Upload/PRODUCT/lg/thumb/139112-2_large.jpg"));
        monitor = categoryRepository.save(monitor);

        Products monitor1 = new Products();
        monitor1.setProductName("LG UltraFine 5K");
        monitor1.setDescription("Profesyonel kullanıma uygun yüksek çözünürlüklü monitör.");
        monitor1.setPrice(12000);
        monitor1.setStockQuantity(10);
        monitor1.setProductInfo("27 inç, 5120x2880 çözünürlük.");
        monitor1.setCategoryId(monitor.getCategoryId());
        tel1.setSellerId(1L);
        monitor1.setProductImages(List.of("https://ares.shiftdelete.net/2022/03/apple-lg-ultrafine-5k-ekran.jpg"));
        monitor1 = productRepository.save(monitor1);

        ProductsDetail monitor1Detay = new ProductsDetail();
        monitor1Detay.setProductId(monitor1.getProductId());
        monitor1Detay.setBrand("LG");
        monitor1Detay.setModel("UltraFine 5K");
        monitor1Detay.setFeatures(
                "• 5K çözünürlük (5120x2880), 27 inç IPS panel\n" +
                        "• 500 cd/m² parlaklık, DCI-P3 %99 renk gamı\n" +
                        "• Thunderbolt 3 ve 3 adet USB-C portu\n" +
                        "• Dahili kamera, mikrofon ve hoparlör\n" +
                        "• Eğilebilir ve yüksekliği ayarlanabilir stand"
        );

        monitor1Detay.setTechnicalDetails(
                "• 60Hz yenileme hızı\n" +
                        "• 14ms tepki süresi (GtG)\n" +
                        "• 1.5GB dahili bellek (görüntü kontrolü için)\n" +
                        "• macOS ve Windows uyumlu\n" +
                        "• Ağırlık: 5.5 kg"
        );
        productDetailRepository.save(monitor1Detay);

        System.out.println("✔ 8 kategori, ürünler ve ürün detayları başarıyla oluşturuldu.");
    }
}
