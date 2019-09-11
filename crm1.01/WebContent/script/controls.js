//pop up windows
function openWindow(page,width,height){
	if(width==null) width=500;
	if(height==null) height=250;
	win=window.open(page,"child_window","width="+width+",height="+height+",resizable=no");
    win.resizeTo(width,height);
	win.focus();  
}

//kontrol
function isValid(pattern,value)
	{
		if (value.match(pattern))
		{
			return true;
		}
		else
		{
			return false;
		}
		}
	
//radio button kontrolleri
function isRadioChecked(radio,message) {
  if (radio.length){ 
	         for(var i=0;i<radio.length;i++) {
				if(radio[i].checked) {
					return true; 	
				}			
			}		
			alert (message);
			return false;				
		}
		else
		{ if (radio.checked==false){
	         alert (message)
			 return false;				
	      } return true; 
		}
	}
	
//button kontrol 
function disableButton(button) {
	button.disabled=true;
}


	
	
	//USER
	var MSG_NAME="Lütfen adýnýzý giriniz.";
	var MSG_SURNAME="Lütfen soyadýnýzý giriniz.";
	var MSG_TEL="Lütfen telefon numaranýzý 2123456789 formatýnda 10 hane olarak giriniz.";
	var MSG_ADDRESS="Lütfen adresinizi giriniz.";
	var MSG_EMAIL="Lütfen e-posta adresiniz giriniz.";
	var MSG_PASSWORD="Lütfen 6-16 karakter arasýndaki þifrenizi giriniz.";
	var MSG_SEX="Lütfen cinsiyetinizi seçiniz.";
	var MSG_BDATE="Lütfen doðum tarihinizi giriniz.";
	var MSG_BPLACE="Lütfen doðum yerinizi giriniz.";
	var MSG_AMOUNT="Lütfen adet giriniz.";
	var MSG_PAYMENT="Lütfen ödeme tipinizi seçiniz.";
	
	
	