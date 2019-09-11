//Popup Mesajlarý

	var MSG_DELETE_CONFIRMATION="Bu kaydi silmek istediginize eminmisiniz? Silinen kaytilar geri alýnamaktadýr.";
	var MSG_ORDER_CONFIRMATION="Lütfen tüm bilgilerin doðru olduðunu kontrol ediniz. Bu aþamada sipariþi verdikten sonra iptal edilemez."
	var MSG_PAYMENT_ADDRESS="Lütfen sipariþinizin fatura edilmesini istediðiniz adresi seçiniz.";
	var MSG_SHIPMENT_ADDRESS="Lütfen sipariþinizin teslim edilmesini istediðiniz adresi seçiniz.";
	var MSG_PAYMENT_TYPE="Lütfen sipariþinizle ilgili ödeme tipinizi seçiniz.";
	var MSG_SEARCH="Lütfen aramak istediðiniz ürünle ilgili 3 ile 20 karakter arasýnda bir aciklama giriniz.";
	var MSG_FEEDBACK_FORM="Lütfen müþteri temsilcimize iletmek istediðiniz bilgileri giriniz.";
	var	MSG_COMMENT="Lütfen ürünle ilgili yorumunuzu giriniz."
	var	MSG_NEWS_TITLE="Lütfen bir haber baþlýðý giriniz."
	var	MSG_NEWS_DESCRIPTION="Lütfen bu haber için açýklama giriniz."
	var	MSG_CATEGORY_NAME="Lütfen bir kategori ismi giriniz."
	var	MSG_CATEGORY_DESCRIPTION="Lütfen bu kategori için açýklama giriniz."
	var	MSG_CATEGORY_PICTURE="Lütfen bu kategori için bir resim giriniz."
	var MSG_NAME="Lütfen adýnýzý giriniz.";
	var MSG_SURNAME="Lütfen soyadýnýzý giriniz.";
	var MSG_TEL="Lütfen telefon numaranýzý (Örnek : 2123456789) formatýnda 10 hane olarak giriniz.";
	var MSG_EMAIL="Lütfen e-mail adresinizi giriniz.";
	var MSG_USERNAME="Lütfen kullanýcý adýnizi giriniz. Kullanýcý adýnýz 6-20 karakter arasýnda olmalý ve geçersiz karakterler içermemelidir.";
	var MSG_PASSWORD="Lütfen þifrenizi giriniz. Þifreniz 6-20 karakter arasýnda olmalý ve geçersiz karakterler içermemelidir. ";
	var MSG_SEX="Lütfen cinsiyetinizi seçiniz.";
	var MSG_AMOUNT="Lütfen adet giriniz.";
	var MSG_CURRENCY="Lütfen para birimini kontrol ediniz. (Örnek : 1.8979)";		
	var MSG_SHORTNAME= "Lütfen bu adres için kýsa bir açýklama giriniz.";
	var MSG_LINE= "Lütfen adres bilgilerinizi giriniz.";
	var MSG_STATE= "Lütfen ilçe ve/veya semt giriniz.";
	var MSG_CITY= "Lütfen þehir giriniz.";
	var MSG_COUNTRY= "Lütfen ülke giriniz.";
	var MSG_POSTALCODE = "Lütfen posta kodunuzu 5 hane olarak giriniz.";
	var MSG_PRODUCT_NAME="Lütfen ürün ad? giriniz.";
	var MSG_PRODUCT_DESCRIPTION="Lütfen bu ürünle ilgili aç?klama giriniz.";
	var MSG_PRODUCT_CODE="Lütfen ürün kodu giriniz.";
	var MSG_PRODUCT_PRICE="Lütfen ürün fiyat? giriniz.";
	

//Validations	

	var NAME= /^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,50}$/;
	var SURNAME= /^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,50}$/;
	var TEL = /^\d{10}$/;	
	var ADDRESS=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,200}$/;
	var SEARCH=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,20}$/;
	var ADDRESSNAME=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,15}$/;
	var COMMENT=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,1000}$/;
	var EMAIL=/^[a-zA-Z0-9 @._-]{8,80}$/;
	var AMOUNT=/^\d{1,2}$/; 
	var USERNAME=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{6,20}$/;
	var PASSWORD=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{6,20}$/;
	var FEEDBACK_FORM=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,1000}$/;
	var CURRENCY=/^[0-9 .]{5,6}$/;
	var SHORTNAME=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,50}$/;
	var LINE= /^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,200}$/;
	var STATE=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,50}$/;
	var CITY=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{2,40}$/;
	var COUNTRY=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{3,30}$/;
	var POSTALCODE = /^\d{5}$/;
	var NEWS_TITLE =/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,100}$/;
	var NEWS_DESCRIPTION=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,1000}$/;
	var CATEGORY_NAME =/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,100}$/;
	var CATEGORY_DESCRIPTION =/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,3000}$/;
	var CATEGORY_PICTURE = /^\d{8}$/;
	var COMMENT=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024]{1,3000}$/;
	
	
	var PRODUCT_NAME=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024\u0020\u00B6\u2386]{1,100}$/;
	var PRODUCT_DESCRIPTION=/^[a-zA-Z0-9\u00DC\u011e\u0130\u015e\u00C7\u00D6\u00FC\u011f\u0131\u015F\u00E7\u00F6 \u005C\u2386\u0020\u0027\u002F\u005F\u003D\u003F\u0040\u003B\u003A\u002E\u002D\u002C\u0026\u002B\u002A\u0029\u0028\u0021\u0025\u0024\u0020\u00B6\u2386]{1,3000}$/;
	var PRODUCT_CODE= /^\d{4}$/;
	var PRODUCT_PRICE=/^[0-9 .]{1,8}$/;
	