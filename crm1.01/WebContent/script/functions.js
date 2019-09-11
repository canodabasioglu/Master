
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
	

//genel yazýlar
	var TEXT_2 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,2}$/
	var TEXT_10 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,10}$/
	var TEXT_10_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,10}$/
	var TEXT_15 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,15}$/
	var TEXT_15_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,15}$/
	var TEXT_20 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,20}$/
	var TEXT_20_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,20}$/
	var TEXT_30 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,30}$/
	var TEXT_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,30}$/
	var TEXT_40 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,40}$/
	var TEXT_40_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,40}$/
	var TEXT_50 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,50}$/
	var TEXT_50_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,50}$/
	var TEXT_100 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,100}$/
	var TEXT_100_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,100}$/
	var TEXT_150 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,150}$/
	var TEXT_150_NULL = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{0,150}$/
	var TEXT_200 = /^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç,._ ]{1,200}$/
	var TRUE_FALSE = /^[0-1]$/
	var INTEGER = /^\d{1,10}$/
	var INTEGER_NULL = /^\d{0,10}$/
	var TWO_DIGIT_CODE = /^\d{1,2}$/
	var TWO_DIGIT_CODE_NULL = /^\d{0,2}$/
	var YEAR = /^\d{4}$/
	var ZIPCODE = /^\d{0,6}$/
	
	var REALIZATIONCODE = /^\d{1,10}$/
	var STATUS_TYPE = /^d{1}$/
	var DATE = /^[0-31]{1}\-[0-12]{1}\-d{4}$/
	
	var ADDRESS_NULL=/^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç .-/:\_+*]{0,20}$/
	
	var WEBADDRESS=/^[a-zA-Z0-9 :/._-]{0,100}$/
	var USERNAME=TEXT_20;
	var PASSWORD=/^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç ]{1,8}$/
	var USERNAME=TEXT_20;	
	
	//Create user
	var NAME=TEXT_30;
	var SURNAME=TEXT_30;
	var TEL = /^\d{10}$/;
	var ADDRESS=/^[a-zA-Z0-9ÐÜÞÝÖÇðüþýöç .-/:\_+*]{1,200}$/;
	var EMAIL=/^[a-zA-Z0-9 @._-]{1,80}$/
	var PASSWORD=/^\w{6,16}$/;
	var AMOUNT=/^\d{1,2}$/;
	
	

