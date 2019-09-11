//Popup Mesajlar�

	var MSG_DELETE_CONFIRMATION="Bu kaydi silmek istediginize eminmisiniz? Silinen kaytilar geri al�namaktad�r.";
	var MSG_ORDER_CONFIRMATION="L�tfen t�m bilgilerin do�ru oldu�unu kontrol ediniz. Bu a�amada sipari�i verdikten sonra iptal edilemez."
	var MSG_PAYMENT_ADDRESS="L�tfen sipari�inizin fatura edilmesini istedi�iniz adresi se�iniz.";
	var MSG_SHIPMENT_ADDRESS="L�tfen sipari�inizin teslim edilmesini istedi�iniz adresi se�iniz.";
	var MSG_PAYMENT_TYPE="L�tfen sipari�inizle ilgili �deme tipinizi se�iniz.";
	var MSG_SEARCH="L�tfen aramak istedi�iniz �r�nle ilgili 3 ile 20 karakter aras�nda bir aciklama giriniz.";
	var MSG_FEEDBACK_FORM="L�tfen m��teri temsilcimize iletmek istedi�iniz bilgileri giriniz.";
	var	MSG_COMMENT="L�tfen �r�nle ilgili yorumunuzu giriniz."
	var	MSG_NEWS_TITLE="L�tfen bir haber ba�l��� giriniz."
	var	MSG_NEWS_DESCRIPTION="L�tfen bu haber i�in a��klama giriniz."
	var	MSG_CATEGORY_NAME="L�tfen bir kategori ismi giriniz."
	var	MSG_CATEGORY_DESCRIPTION="L�tfen bu kategori i�in a��klama giriniz."
	var	MSG_CATEGORY_PICTURE="L�tfen bu kategori i�in bir resim giriniz."
	var MSG_NAME="L�tfen ad�n�z� giriniz.";
	var MSG_SURNAME="L�tfen soyad�n�z� giriniz.";
	var MSG_TEL="L�tfen telefon numaran�z� (�rnek : 2123456789) format�nda 10 hane olarak giriniz.";
	var MSG_EMAIL="L�tfen e-mail adresinizi giriniz.";
	var MSG_USERNAME="L�tfen kullan�c� ad�nizi giriniz. Kullan�c� ad�n�z 6-20 karakter aras�nda olmal� ve ge�ersiz karakterler i�ermemelidir.";
	var MSG_PASSWORD="L�tfen �ifrenizi giriniz. �ifreniz 6-20 karakter aras�nda olmal� ve ge�ersiz karakterler i�ermemelidir. ";
	var MSG_SEX="L�tfen cinsiyetinizi se�iniz.";
	var MSG_AMOUNT="L�tfen adet giriniz.";
	var MSG_CURRENCY="L�tfen para birimini kontrol ediniz. (�rnek : 1.8979)";		
	var MSG_SHORTNAME= "L�tfen bu adres i�in k�sa bir a��klama giriniz.";
	var MSG_LINE= "L�tfen adres bilgilerinizi giriniz.";
	var MSG_STATE= "L�tfen il�e ve/veya semt giriniz.";
	var MSG_CITY= "L�tfen �ehir giriniz.";
	var MSG_COUNTRY= "L�tfen �lke giriniz.";
	var MSG_POSTALCODE = "L�tfen posta kodunuzu 5 hane olarak giriniz.";
	var MSG_PRODUCT_NAME="L�tfen �r�n ad? giriniz.";
	var MSG_PRODUCT_DESCRIPTION="L�tfen bu �r�nle ilgili a�?klama giriniz.";
	var MSG_PRODUCT_CODE="L�tfen �r�n kodu giriniz.";
	var MSG_PRODUCT_PRICE="L�tfen �r�n fiyat? giriniz.";
	

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
	