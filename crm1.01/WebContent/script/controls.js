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
	var MSG_NAME="L�tfen ad�n�z� giriniz.";
	var MSG_SURNAME="L�tfen soyad�n�z� giriniz.";
	var MSG_TEL="L�tfen telefon numaran�z� 2123456789 format�nda 10 hane olarak giriniz.";
	var MSG_ADDRESS="L�tfen adresinizi giriniz.";
	var MSG_EMAIL="L�tfen e-posta adresiniz giriniz.";
	var MSG_PASSWORD="L�tfen 6-16 karakter aras�ndaki �ifrenizi giriniz.";
	var MSG_SEX="L�tfen cinsiyetinizi se�iniz.";
	var MSG_BDATE="L�tfen do�um tarihinizi giriniz.";
	var MSG_BPLACE="L�tfen do�um yerinizi giriniz.";
	var MSG_AMOUNT="L�tfen adet giriniz.";
	var MSG_PAYMENT="L�tfen �deme tipinizi se�iniz.";
	
	
	