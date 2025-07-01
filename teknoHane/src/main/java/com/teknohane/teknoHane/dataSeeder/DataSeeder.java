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
        Products tel2 = new Products();
        tel2.setProductName("Samsung Galaxy S24");
        tel2.setDescription("Yüksek performans, şık tasarım ve güçlü kamera.");
        tel2.setPrice(40000);
        tel2.setStockQuantity(15);
        tel2.setProductInfo("6.2 inç ekran, Exynos 2400 işlemci.");
        tel2.setCategoryId(telefon.getCategoryId());
        tel2.setSellerId(1L);
        tel2.setProductImages(List.of("https://m.media-amazon.com/images/I/61gyimiqfGL.jpg"));
        tel2 = productRepository.save(tel2);

        ProductsDetail tel2Detay = new ProductsDetail();
        tel2Detay.setProductId(tel2.getProductId());
        tel2Detay.setBrand("Samsung");
        tel2Detay.setModel("Galaxy S24");
        tel2Detay.setFeatures(
                "• AMOLED ekran\n" +
                        "• Yüz tanıma\n" +
                        "• 120Hz ekran yenileme hızı\n" +
                        "• IP68 suya dayanıklılık\n" +
                        "• Kablosuz şarj"
        );
        tel2Detay.setTechnicalDetails(
                "• Exynos 2400 işlemci\n" +
                        "• 6.2 inç Dynamic AMOLED 2X ekran\n" +
                        "• 8GB RAM, 256GB depolama\n" +
                        "• 50MP + 12MP + 10MP üçlü kamera\n" +
                        "• 4000mAh batarya, 25W hızlı şarj"
        );
        productDetailRepository.save(tel2Detay);
        Products tel3 = new Products();
        tel3.setProductName("Oppo Reno10 Pro");
        tel3.setDescription("Şık tasarımıyla dikkat çeken güçlü bir akıllı telefon.");
        tel3.setPrice(30000);
        tel3.setStockQuantity(20);
        tel3.setProductInfo("6.7 inç ekran, Snapdragon 778G işlemci.");
        tel3.setCategoryId(telefon.getCategoryId());
        tel3.setSellerId(1L);
        tel3.setProductImages(List.of("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvTLeRDzThgwQqk_orvxyCv3vBFaQm3tIb7Q&s"));
        tel3 = productRepository.save(tel3);

        ProductsDetail tel3Detay = new ProductsDetail();
        tel3Detay.setProductId(tel3.getProductId());
        tel3Detay.setBrand("Oppo");
        tel3Detay.setModel("Reno10 Pro");
        tel3Detay.setFeatures(
                "• AMOLED ekran\n" +
                        "• Hızlı şarj\n" +
                        "• Ultra net portre modu\n" +
                        "• In-display parmak izi sensörü\n" +
                        "• Hafif ve ince tasarım"
        );
        tel3Detay.setTechnicalDetails(
                "• Snapdragon 778G işlemci\n" +
                        "• 6.7 inç AMOLED ekran\n" +
                        "• 12GB RAM, 256GB depolama\n" +
                        "• 50MP + 32MP + 8MP üçlü kamera\n" +
                        "• 4600mAh batarya, 80W hızlı şarj"
        );
        productDetailRepository.save(tel3Detay);
        Products tel4 = new Products();
        tel4.setProductName("iPhone 15");
        tel4.setDescription("En yeni iPhone modeli, güçlü donanımıyla öne çıkıyor.");
        tel4.setPrice(50000);
        tel4.setStockQuantity(8);
        tel4.setProductInfo("6.1 inç ekran, A17 Pro işlemci.");
        tel4.setCategoryId(telefon.getCategoryId());
        tel4.setSellerId(1L);
        tel4.setProductImages(List.of("https://st-troy.mncdn.com/mnresize/775/775/Content/media/ProductImg/original/mtp43tua-apple-iphone-15-128gb-blue-638305552289935305.jpg"));
        tel4 = productRepository.save(tel4);

        ProductsDetail tel4Detay = new ProductsDetail();
        tel4Detay.setProductId(tel4.getProductId());
        tel4Detay.setBrand("Apple");
        tel4Detay.setModel("iPhone 15");
        tel4Detay.setFeatures(
                "• Dynamic Island\n" +
                        "• USB-C portu\n" +
                        "• Geliştirilmiş kamera sistemi\n" +
                        "• Ceramic Shield\n" +
                        "• Face ID"
        );
        tel4Detay.setTechnicalDetails(
                "• Apple A17 Pro işlemci\n" +
                        "• 6.1 inç Super Retina XDR ekran\n" +
                        "• 6GB RAM, 128GB depolama\n" +
                        "• 48MP Ana kamera, 12MP Ultra Geniş\n" +
                        "• 3349mAh batarya, MagSafe desteği"
        );
        productDetailRepository.save(tel4Detay);

        Products tel5 = new Products();
        tel5.setProductName("iPhone 15 Pro");
        tel5.setDescription("Titanyum gövde, profesyonel kamera sistemi ve A17 Pro gücü.");
        tel5.setPrice(63000);
        tel5.setStockQuantity(5);
        tel5.setProductInfo("6.1 inç ekran, A17 Pro işlemci.");
        tel5.setCategoryId(telefon.getCategoryId());
        tel5.setSellerId(1L);
        tel5.setProductImages(List.of("https://assets.getmobil.com/uploads/56993/getmobil-iphone-15-pro-max-black-titanium-1webp.webp"));
        tel5 = productRepository.save(tel5);

        ProductsDetail tel5Detay = new ProductsDetail();
        tel5Detay.setProductId(tel5.getProductId());
        tel5Detay.setBrand("Apple");
        tel5Detay.setModel("iPhone 15 Pro");
        tel5Detay.setFeatures(
                "• Titanyum tasarım\n" +
                        "• Action Button\n" +
                        "• USB-C 3.0 veri aktarımı\n" +
                        "• ProMotion 120Hz ekran\n" +
                        "• LiDAR tarayıcı"
        );
        tel5Detay.setTechnicalDetails(
                "• Apple A17 Pro işlemci\n" +
                        "• 6.1 inç ProMotion OLED ekran\n" +
                        "• 8GB RAM, 256GB depolama\n" +
                        "• 48MP + 12MP + 12MP kamera\n" +
                        "• 3274mAh batarya, MagSafe desteği"
        );
        productDetailRepository.save(tel5Detay);
        Products tel6 = new Products();
        tel6.setProductName("iPhone 14");
        tel6.setDescription("Güçlü performans ve etkileyici kamera deneyimi sunar.");
        tel6.setPrice(40000);
        tel6.setStockQuantity(10);
        tel6.setProductInfo("6.1 inç ekran, A15 Bionic işlemci.");
        tel6.setCategoryId(telefon.getCategoryId());
        tel6.setSellerId(1L);
        tel6.setProductImages(List.of("https://cepmarketavm.com/cdn/shop/files/replika-iphone-14-pro-max-5-akillicepmarket.com_7b2960f8-4d65-463e-8a01-6fd22734520d.png?v=1691763463&width=1445"));
        tel6 = productRepository.save(tel6);

        ProductsDetail tel6Detay = new ProductsDetail();
        tel6Detay.setProductId(tel6.getProductId());
        tel6Detay.setBrand("Apple");
        tel6Detay.setModel("iPhone 14");
        tel6Detay.setFeatures(
                "• Ceramic Shield ekran\n" +
                        "• Fotoğrafik Stiller\n" +
                        "• Acil SOS ve çarpışma algılama\n" +
                        "• 5G desteği\n" +
                        "• Face ID"
        );
        tel6Detay.setTechnicalDetails(
                "• Apple A15 Bionic işlemci\n" +
                        "• 6.1 inç Super Retina XDR ekran\n" +
                        "• 6GB RAM, 128GB depolama\n" +
                        "• 12MP çift kamera sistemi\n" +
                        "• 3279mAh batarya, MagSafe"
        );
        productDetailRepository.save(tel6Detay);

        Products tel7 = new Products();
        tel7.setProductName("iPhone SE (2022)");
        tel7.setDescription("Uygun fiyatlı, kompakt tasarım ve güçlü performans.");
        tel7.setPrice(25000);
        tel7.setStockQuantity(20);
        tel7.setProductInfo("4.7 inç ekran, A15 Bionic işlemci.");
        tel7.setCategoryId(telefon.getCategoryId());
        tel7.setSellerId(1L);
        tel7.setProductImages(List.of("https://cdn.cimri.io/image/1000x1000/apple-iphone-se-2022-64gb-kirmizi_581531108.jpg"));
        tel7 = productRepository.save(tel7);

        ProductsDetail tel7Detay = new ProductsDetail();
        tel7Detay.setProductId(tel7.getProductId());
        tel7Detay.setBrand("Apple");
        tel7Detay.setModel("iPhone SE 2022");
        tel7Detay.setFeatures(
                "• Touch ID parmak izi okuyucu\n" +
                        "• IP67 suya dayanıklılık\n" +
                        "• Kompakt ve klasik tasarım\n" +
                        "• 5G bağlantısı"
        );
        tel7Detay.setTechnicalDetails(
                "• Apple A15 Bionic işlemci\n" +
                        "• 4.7 inç Retina HD ekran\n" +
                        "• 4GB RAM, 128GB depolama\n" +
                        "• 12MP arka, 7MP ön kamera\n" +
                        "• 2018mAh batarya, 18W hızlı şarj"
        );
        productDetailRepository.save(tel7Detay);

        Products tel8 = new Products();
        tel8.setProductName("iPhone 13 Mini");
        tel8.setDescription("Küçük boyut, büyük performans.");
        tel8.setPrice(37000);
        tel8.setStockQuantity(7);
        tel8.setProductInfo("5.4 inç ekran, A15 Bionic işlemci.");
        tel8.setCategoryId(telefon.getCategoryId());
        tel8.setSellerId(1L);
        tel8.setProductImages(List.of("https://www.apple.com/newsroom/images/product/iphone/geo/Apple_iphone13_hero_geo_09142021_inline.jpg.large.jpg"));
        tel8 = productRepository.save(tel8);

        ProductsDetail tel8Detay = new ProductsDetail();
        tel8Detay.setProductId(tel8.getProductId());
        tel8Detay.setBrand("Apple");
        tel8Detay.setModel("iPhone 13 Mini");
        tel8Detay.setFeatures(
                "• Kompakt tasarım\n" +
                        "• Face ID\n" +
                        "• 5G destekli\n" +
                        "• Ceramic Shield ekran\n" +
                        "• Gece modu"
        );
        tel8Detay.setTechnicalDetails(
                "• Apple A15 Bionic işlemci\n" +
                        "• 5.4 inç Super Retina XDR OLED ekran\n" +
                        "• 4GB RAM, 128GB depolama\n" +
                        "• 12MP çift kamera sistemi\n" +
                        "• 2438mAh batarya, MagSafe"
        );
        productDetailRepository.save(tel8Detay);


        //laptop
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
        Products laptop2 = new Products();
        laptop2.setProductName("ASUS ZenBook 14");
        laptop2.setDescription("İnce, hafif ve yüksek performanslı bir ultrabook.");
        laptop2.setPrice(18000);
        laptop2.setStockQuantity(12);
        laptop2.setProductInfo("14 inç ekran, AMD Ryzen 7 işlemci.");
        laptop2.setCategoryId(laptop.getCategoryId());
        laptop2.setSellerId(1L);
        laptop2.setProductImages(List.of("https://dlcdnwebimgs.asus.com/gain/26b2a6c1-fa0f-4de9-87e7-3cbde6b4fd77/"));
        laptop2 = productRepository.save(laptop2);

        ProductsDetail laptop2Detay = new ProductsDetail();
        laptop2Detay.setProductId(laptop2.getProductId());
        laptop2Detay.setBrand("ASUS");
        laptop2Detay.setModel("ZenBook 14");
        laptop2Detay.setFeatures(
                "• İnce ve hafif tasarım\n" +
                        "• Uzun pil ömrü\n" +
                        "• HDMI, USB-C ve MicroSD desteği\n" +
                        "• Ergonomik klavye"
        );
        laptop2Detay.setTechnicalDetails(
                "• AMD Ryzen 7 5800U işlemci\n" +
                        "• 16GB RAM\n" +
                        "• 1TB SSD depolama\n" +
                        "• 14\" FHD IPS ekran\n" +
                        "• Entegre AMD Radeon grafikleri"
        );
        productDetailRepository.save(laptop2Detay);

        Products laptop3 = new Products();
        laptop3.setProductName("Apple MacBook Air M2");
        laptop3.setDescription("Apple’ın M2 çipli ince ve sessiz dizüstü bilgisayarı.");
        laptop3.setPrice(28000);
        laptop3.setStockQuantity(10);
        laptop3.setProductInfo("13.6 inç Liquid Retina ekran, Apple M2 işlemci.");
        laptop3.setCategoryId(laptop.getCategoryId());
        laptop3.setSellerId(1L);
        laptop3.setProductImages(List.of("https://cdn.vatanbilgisayar.com/Upload/PRODUCT/apple/thumb/mlxw3tu-a_large.jpg"));
        laptop3 = productRepository.save(laptop3);

        ProductsDetail laptop3Detay = new ProductsDetail();
        laptop3Detay.setProductId(laptop3.getProductId());
        laptop3Detay.setBrand("Apple");
        laptop3Detay.setModel("MacBook Air M2");
        laptop3Detay.setFeatures(
                "• M2 çip ile yüksek verimlilik\n" +
                        "• Sessiz fanless tasarım\n" +
                        "• MagSafe şarj bağlantısı\n" +
                        "• Touch ID"
        );
        laptop3Detay.setTechnicalDetails(
                "• Apple M2 çip (8 çekirdek CPU, 10 çekirdek GPU)\n" +
                        "• 8GB RAM\n" +
                        "• 256GB SSD\n" +
                        "• 13.6 inç Liquid Retina ekran\n" +
                        "• macOS işletim sistemi"
        );
        productDetailRepository.save(laptop3Detay);


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
        Products tablet2 = new Products();
        tablet2.setProductName("Samsung Galaxy Tab S9 Ultra");
        tablet2.setDescription("Geniş ekranlı, yüksek performanslı Android tablet.");
        tablet2.setPrice(18000);
        tablet2.setStockQuantity(10);
        tablet2.setProductInfo("14.6 inç AMOLED ekran, Snapdragon 8 Gen 2.");
        tablet2.setCategoryId(tablet.getCategoryId());
        tablet2.setSellerId(1L);
        tablet2.setProductImages(List.of("https://reimg-teknosa-cloud-prod.mncdn.com/mnresize/600/600/productimage/125049604/125049604_0_MC/4c4b7b14.png"));
        tablet2 = productRepository.save(tablet2);

        ProductsDetail tablet2Detay = new ProductsDetail();
        tablet2Detay.setProductId(tablet2.getProductId());
        tablet2Detay.setBrand("Samsung");
        tablet2Detay.setModel("Galaxy Tab S9 Ultra");
        tablet2Detay.setFeatures(
                "• S Pen dahili\n" +
                        "• IP68 suya ve toza dayanıklı\n" +
                        "• 120Hz AMOLED ekran\n" +
                        "• Samsung DeX desteği\n" +
                        "• Dörtlü hoparlör (AKG)"
        );
        tablet2Detay.setTechnicalDetails(
                "• Snapdragon 8 Gen 2 for Galaxy işlemci\n" +
                        "• 12GB RAM, 256GB depolama\n" +
                        "• 14.6 inç WQXGA+ AMOLED ekran\n" +
                        "• 11200mAh batarya, 45W hızlı şarj\n" +
                        "• Android 13 işletim sistemi"
        );
        productDetailRepository.save(tablet2Detay);

        Products tablet3 = new Products();
        tablet3.setProductName("Lenovo Tab P12 Pro");
        tablet3.setDescription("Eğlence ve üretkenlik için güçlü Android tablet.");
        tablet3.setPrice(14000);
        tablet3.setStockQuantity(8);
        tablet3.setProductInfo("12.6 inç AMOLED ekran, Snapdragon 870 işlemci.");
        tablet3.setCategoryId(tablet.getCategoryId());
        tablet3.setSellerId(1L);
        tablet3.setProductImages(List.of("https://p3-ofp.static.pub//fes/cms/2024/05/23/n6d78gf6yukz0nxo8yj3myjp6dyhbn157528.png"));
        tablet3 = productRepository.save(tablet3);

        ProductsDetail tablet3Detay = new ProductsDetail();
        tablet3Detay.setProductId(tablet3.getProductId());
        tablet3Detay.setBrand("Lenovo");
        tablet3Detay.setModel("Tab P12 Pro");
        tablet3Detay.setFeatures(
                "• AMOLED ekran\n" +
                        "• Kalem desteği (Precision Pen 3)\n" +
                        "• Klavye bağlantısı\n" +
                        "• Dolby Vision ve Dolby Atmos desteği\n" +
                        "• Uzun pil ömrü"
        );
        tablet3Detay.setTechnicalDetails(
                "• Qualcomm Snapdragon 870 işlemci\n" +
                        "• 8GB RAM, 256GB SSD\n" +
                        "• 12.6 inç AMOLED ekran, 120Hz\n" +
                        "• 10200mAh batarya, 30W hızlı şarj\n" +
                        "• Android 12 işletim sistemi"
        );
        productDetailRepository.save(tablet3Detay);

        Products tablet4 = new Products();
        tablet4.setProductName("Xiaomi Pad 6");
        tablet4.setDescription("Günlük kullanım ve eğlence için yüksek performanslı tablet.");
        tablet4.setPrice(11000);
        tablet4.setStockQuantity(10);
        tablet4.setProductInfo("11 inç 2.8K ekran, Snapdragon 870 işlemci.");
        tablet4.setCategoryId(tablet.getCategoryId());
        tablet4.setSellerId(1L);
        tablet4.setProductImages(List.of("https://cdn.cimri.io/image/1000x1000/xiaomi-mi-pad-6-256gb-11-inc-tablet-pc_821152351.jpg"));
        tablet4 = productRepository.save(tablet4);

        ProductsDetail tablet4Detay = new ProductsDetail();
        tablet4Detay.setProductId(tablet4.getProductId());
        tablet4Detay.setBrand("Xiaomi");
        tablet4Detay.setModel("Pad 6");
        tablet4Detay.setFeatures(
                "• 144Hz ekran yenileme hızı\n" +
                        "• Dolby Vision ve Dolby Atmos desteği\n" +
                        "• Metal gövde\n" +
                        "• MIUI for Pad arayüzü\n" +
                        "• Klavye ve kalem desteği"
        );
        tablet4Detay.setTechnicalDetails(
                "• Qualcomm Snapdragon 870 işlemci\n" +
                        "• 8GB RAM, 256GB depolama\n" +
                        "• 11 inç 2.8K LCD ekran (2880x1800), 144Hz\n" +
                        "• 8840mAh batarya, 33W hızlı şarj\n" +
                        "• Android 13 tabanlı MIUI"
        );
        productDetailRepository.save(tablet4Detay);

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
