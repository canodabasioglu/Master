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

function confirmation()
{
  if (confirm(MSG_DELETE_CONFIRMATION)==true)
     return true;  
  else
     return false;
}


function confirmOrder()
{
  if (confirm(MSG_ORDER_CONFIRMATION)==true)
     return true;  
  else
     return false;
}

function addbookmark()
{
bookmarkurl="http://www.yatmarketi.com"
bookmarktitle="YatMarketi.com"
if (document.all)
window.external.AddFavorite(bookmarkurl,bookmarktitle)
}
//sadece sayi
function OnlyNumeric(e) {
    var whichCode = (window.Event) ? e.which : e.keyCode;

    if (whichCode > 57 ){
    return false;}
    if (whichCode < 48 && whichCode > 13){
    return false;}
}

function OnlyLetter(e) { 
	var whichCode = (window.Event) ? e.which : e.keyCode;

	if (whichCode == 0) return true;  //Delete etc.
	if ((whichCode >=97 && whichCode <=122) || (whichCode <=90 && whichCode >=65)){
	      return true;
	}
	alert("Sadece 0-9 arasi sayi giriniz.");
	return false;
}

//tr karakterler haric
function OnlyUSLetter(e) { 
	var whichCode = (window.Event) ? e.which : e.keyCode;

	if ((whichCode >=97 && whichCode <=122) || (whichCode <=90 && whichCode >=65)){
	      return true;
	}

	return false;
}
//sadece sayi ve en karakterler
function OnlyAlphaNumeric(e) { 
var whichCode = (window.Event) ? e.which : e.keyCode;

if ((whichCode >=97 && whichCode <=122) || (whichCode <=90 && whichCode >=65) || (whichCode <=57 && whichCode >=48)){
      return true;
}

return false;

}

function CurrencyFormatted(amount)
{

      var i = parseFloat(amount);
      if(isNaN(i)) { i = 0.00; }
      var minus = '';
      if(i < 0) { minus = '-'; }
      i = Math.abs(i);
      i = parseInt((i + .005) * 100);
      i = i / 100;
      s = new String(i);
      if(s.indexOf('.') < 0) { s += '.00'; }
      if(s.indexOf('.') == (s.length - 2)) { s += '0'; }
      s = minus + s;
      return s;
}

function onEnter(e) {
	var whichCode = (window.Event) ? e.which : e.keyCode;
	 if (whichCode == 13) {
		 form.submit();
		 return true;
	 }
	 return false;
}




