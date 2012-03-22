/*******************************************************************
  Modulo	: Todos los modulos
  Descripcion	: Esta funcion permite intercambiar imagen a otra
  Autor		: Edinson Muñoz Guia
  Fecha/hora	: 19/01/2010 - 09:27 PM
  Empresa	: TOPCERT E.I.R.L.
*******************************************************************/
function set_image(button, img){
   button.src = img;
}

//Verifica navegador y version del mismo
/*var ie = document.getElementById && document.all && (navigator.appVersion.indexOf("MSIE 6.")>=0);
if (ie == false || ie == undefined) {
    alert("Use Microsoft Internet Explorer 6 o superior. Si usa Explorer 8, habilite la\n"+
        "compatibilidad con navegadores anteriores");
    direccion=("faces/sesionError.jsp"); 
    window.location=direccion; 
}*/

/*******************************************************************
  Modulo	: Todos los modulos
  Descripcion	: Esta funcion permite inhabilitar algunas teclas presionadas
  Autor		: Edinson Muñoz Guia
  Fecha/hora	: 30/11/2009 - 12:08 PM
  Empresa	: TOPCERT E.I.R.L.
*******************************************************************/
/*document.onkeydown = myKeyHandler;
function myKeyHandler(event) {
    //keyCode 116 = F5
    //keyCode 122 = F11
    //keyCode 8 = Backspace
    //keyCode 37 = LEFT ROW
    //keyCode 78 = N
    //keyCode 39 = RIGHT ROW
    //keyCode 67 = C
    //keyCode 86 = V
    //keyCode 85 = U
    //keyCode 45 = Insert
    event = event || window.event;
    var tgt = event.target || event.srcElement;
    if(event.keyCode == 8 || event.keyCode == 116 || event.keyCode==45 ||
        event.keyCode == 122 || event.keyCode == 37 || event.keyCode == 39){
            alert("Funcion deshabilitada. EsSalud");
            event.cancelBubble = true;
            event.returnValue = false;
            return false;
    }
}*/

function trim(str, chars) {
  return ltrim(rtrim(str, chars), chars);
}
 
function ltrim(str, chars) {
  chars = chars || "\\s";
  return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
}
 
function rtrim(str, chars) {
  chars = chars || "\\s";
  return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
}

/*******************************************************************
  Modulo	: Todos los modulos
  Descripcion	: Esta funcion permite inhabilitar el clic derecho en las paginas
  Autor		: Edinson Muñoz Guia
  Fecha/hora	: 27/12/2008 - 12:08 PM
  Empresa	: TOPCERT E.I.R.L.
*******************************************************************/


/*******************************************************************
  Modulo	: Todos los modulos
  Descripcion	: Esta funcion permite setear en titulo de ventana de explorador, el dominio donde la aplicacion
                  esta desplegada
  Autor		: Edinson Muñoz Guia
  Fecha/hora	: 27/12/2008 - 12:08 PM
  Empresa	: TOPCERT E.I.R.L.
*******************************************************************/
function titulo(){
    document.title = "*** SSAI *** Sistema de Seguro Agrario Independiente - "+document.domain;
}
   
/*******************************************************************
	Modulo		: 	Todos los modulos
	Descripcion	: 	Esta funcion valida numeros flotantes
	Autor		: 	Edinson Muñoz Guia
	Fecha/hora	: 	27/12/2008 - 12:08 PM
	Empresa		: 	TOPCERT E.I.R.L.
*******************************************************************/
//Valida Formato de Numero Flotante
function NumberFormat(tamanio, num, numDec, decSep, thousandSep){ 
    var arg; 
    var Dec; 
	var numOri = num;
	var maxCar = tamanio;

    Dec = Math.pow(10, numDec);  
	
    if (typeof(num) == 'undefined') 
		return;  
    if (typeof(decSep) == 'undefined') 
		decSep = ','; 
    if (typeof(thousandSep) == 'undefined') 
		thousandSep = '.';
	
    if (thousandSep == '.') 
     	arg=/./g; 
    else 
    	if (thousandSep == ',') 
			arg=/,/g; 
		
	if (typeof(arg) != 'undefined') 
		num = num.toString().replace(arg,''); 
	num = num.toString().replace(/,/g, '.');  
	
	if (isNaN(num)) 
		num = "0"; 
	sign = (num == (num = Math.abs(num))); 
	num = Math.floor(num * Dec + 0.50000000001); 
	cents = num % Dec; 
	num = Math.floor(num/Dec).toString();  
	
	if (cents < (Dec / 10)) cents = "0" + cents;  
	
	for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++) 
		num = num.substring(0, num.length - (4 * i + 3)) + thousandSep + num.substring(num.length - (4 * i + 3)); 

	
	//if(num == 0){
		//return ("");
	//}else{
		var numLength ;
			if (Dec == 1){
				numLength=(((sign)? '': '-') + num).length;
				//alert("Tama�o Dec: "+numLength);
				//alert("Tama�o Num: "+numOri.length);
				//alert("Tama�o NumC: "+numOri);
				var pos=numOri.length-1;
				//alert("Posicion: "+pos);
				//alert("Ultimo Caracter: "+numOri.charAt(pos));
				if(numOri.length == maxCar || numOri.length == maxCar-1 || numOri.length == maxCar-2){
				
					if((numOri.length == maxCar-2 ) && numOri.indexOf(".",0) != -1){
						return (((sign)? '': '-') + num + decSep + cents); 	
					}
				
					if(numOri.length == maxCar-1 && numOri.indexOf(".", 0) != -1){
						if(numOri.indexOf(".", 0) == pos){
							return (""+numOri.substring(0,pos));		
						}else{
							return (((sign)? '': '-') + num); 
						}
					}
				
					if(numOri.charAt(numOri.length-1)  == '.'){
						return (""+numOri.substring(0,pos));
					}
					
					return numOri;
					
				}else{
					return (((sign)? '': '-') + num); 
				}
			} 		
			else{
				numLength=(((sign)? '': '-') + num + decSep + cents).length;
				//alert("Tama�o Cen: "+numLength);
				//alert("Tama�o Num: "+numOri.length);
				//alert("Tama�o NumC: "+numOri);
				var pos=numOri.length-1;
				//alert("Posicion: "+pos);
				//alert("Ultimo Caracter: "+numOri.charAt(pos));
				if(numOri.length == maxCar || numOri.length == maxCar-1 || numOri.length == maxCar-2){
					
					if((numOri.length == maxCar-2) && numOri.indexOf(".",0) != -1){
						return (((sign)? '': '-') + num + decSep + cents); 	
					}
					
					if(numOri.length == maxCar-1 && numOri.indexOf(".", 0) != -1){
						if(numOri.indexOf(".", 0) == pos){
							return (""+numOri.substring(0,pos));		
						}else{
							return (((sign)? '': '-') + num + decSep + cents); 	
						}
					}
					
					if(numOri.charAt((numOri.length)-1)  == "."){
						return (""+numOri.substring(0,pos));
					}
					
					return numOri;
					
				}else{
					return (((sign)? '': '-') + num + decSep + cents); 	
				}
			}
			
	//}
		
   }  

//Valida Formato de Numero Flotante (KM)
function NumberFormatKm(tamanio, num, numDec, decSep, thousandSep){ 
    var arg; 
    var Dec; 
	var numOri = num;
	var maxCar = tamanio;

    Dec = Math.pow(10, numDec);  
	
    if (typeof(num) == 'undefined') 
		return;  
    if (typeof(decSep) == 'undefined') 
		decSep = ','; 
    if (typeof(thousandSep) == 'undefined') 
		thousandSep = '.';
	
    if (thousandSep == '.') 
     	arg=/./g; 
    else 
    	if (thousandSep == ',') 
			arg=/,/g; 
		
	if (typeof(arg) != 'undefined') 
		num = num.toString().replace(arg,''); 
	num = num.toString().replace(/,/g, '.');  
	
	if (isNaN(num)) 
		num = "0"; 
	sign = (num == (num = Math.abs(num))); 
	num = Math.floor(num * Dec + 0.50000000001); 
	cents = num % Dec; 
	num = Math.floor(num/Dec).toString();  
	
	if (cents < (Dec / 10)) cents = "0" + cents;  
	
	for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++) 
		num = num.substring(0, num.length - (4 * i + 3)) + thousandSep + num.substring(num.length - (4 * i + 3)); 

	
	if(num == 0){
		return ("");
	}else{
		var numLength ;
			if (Dec == 1){
				numLength=(((sign)? '': '-') + num).length;
				//alert("Tama�o Dec: "+numLength);
				//alert("Tama�o Num: "+numOri.length);
				//alert("Tama�o NumC: "+numOri);
				var pos=numOri.length-1;
				//alert("Posicion: "+pos);
				//alert("Ultimo Caracter: "+numOri.charAt(pos));
				if(numOri.length == maxCar || numOri.length == maxCar-1 || numOri.length == maxCar-2){
				
					if((numOri.length == maxCar-2 ) && numOri.indexOf(".",0) != -1){
						return (((sign)? '': '-') + num + decSep + cents); 	
					}
				
					if(numOri.length == maxCar-1 && numOri.indexOf(".", 0) != -1){
						if(numOri.indexOf(".", 0) == pos){
							return (""+numOri.substring(0,pos));		
						}else{
							return (((sign)? '': '-') + num); 
						}
					}
				
					if(numOri.charAt(numOri.length-1)  == '.'){
						return (""+numOri.substring(0,pos));
					}
					
					return numOri;
					
				}else{
					return (((sign)? '': '-') + num); 
				}
			} 		
			else{
				numLength=(((sign)? '': '-') + num + decSep + cents).length;
				//alert("Tama�o Cen: "+numLength);
				//alert("Tama�o Num: "+numOri.length);
				//alert("Tama�o NumC: "+numOri);
				var pos=numOri.length-1;
				//alert("Posicion: "+pos);
				//alert("Ultimo Caracter: "+numOri.charAt(pos));
				if(numOri.length == maxCar || numOri.length == maxCar-1 || numOri.length == maxCar-2){
					
					if((numOri.length == maxCar-2) && numOri.indexOf(".",0) != -1){
						return (((sign)? '': '-') + num + decSep + cents); 	
					}
					
					if(numOri.length == maxCar-1 && numOri.indexOf(".", 0) != -1){
						if(numOri.indexOf(".", 0) == pos){
							return (""+numOri.substring(0,pos));		
						}else{
							return (((sign)? '': '-') + num + decSep + cents); 	
						}
					}
					
					if(numOri.charAt((numOri.length)-1)  == "."){
						return (""+numOri.substring(0,pos));
					}
					
					return numOri;
					
				}else{
					return (((sign)? '': '-') + num + decSep + cents); 	
				}
			}
			
	}
		
   } 

   //Evalua cadena ingresada
   function EvaluateText(cadena, obj){ 
    opc = false;  
    if (cadena == "%d") 
     if (event.keyCode > 47 && event.keyCode < 58) 
      opc = true; 
    if (cadena == "%f"){  
     if (event.keyCode > 47 && event.keyCode < 58) 
      opc = true; 
     if (obj.value.search("[.*]") == -1 && obj.value.length != 0) 
      if (event.keyCode == 46) 
       opc = true; 
    } 
    if(opc == false) 
     event.returnValue = false;  
   } 

/*******************************************************************
	Modulo		: 	Gestion Individual / Colectiva
	Descripcion	: 	Esta funcion valida si se ingresa numero flotante
					hasta con dos decimales como maximo
	Autor		: 	Edinson Muñoz
	Fecha/hora	: 	27/12/2008 - 12:08 PM
	Empres		: 	TOPCERT E.I.R.L.
*******************************************************************/
/*function esNumeroFlotanteValido(num){
	if (num != undefined && num.value != "" ){
		if (!/^[0-9]*\.[0-9]{2}$/.test(num.value) & !/^[0-9]*$/.test(num.value)){
        	alert("Numero flotante no valido, solo ingresar dos digitos decimales");
			num.focus();
            return false;
        }
	}
}*/
 
/*******************************************************************
	Modulo		: 	Todos los modulos
	Descripcion	: 	Esta funcion permite ingresar solo numeros
					en una caja de texto
	Autor		: 	Edinson Muñoz Guia
	Fecha/hora	: 	27/12/2008 - 12:08 PM
	Empresa		: 	TOPCERT E.I.R.L.
*******************************************************************/
function verificaEntero(){
    valKey=event.keyCode;
    if ((valKey=='48') || (valKey=='49') || (valKey=='50') || (valKey=='51') || (valKey=='52') || (valKey=='53') || (valKey=='54') || (valKey=='55') || (valKey=='56') || (valKey=='57') || (valKey=='8'))  
        return true;
    else
        return false;
}

//Verifica Texto Valido
/*function esTextoValido(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true;
    patron =/[A-Za-z\s\�\�\�\�\�\�\�\�\�\�\�\�]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}*/

//Verifica Texto
/*function verificaTexto(){
    valKey=event.keyCode;
    if ((valKey!='48') || (valKey!='49') || (valKey!='50') || (valKey!='51') || (valKey!='52') || (valKey!='53') || (valKey!='54') || (valKey!='55') || (valKey!='56') || (valKey!='57') || (valKey!='8'))  
        return true;
    else
        return false;
}*/


/*******************************************************************
	Modulo		: 	Todos los modulos
	Descripcion	: 	Esta funcion valida numero de caracteres
					en una caja de texto y convierte a mayusculas
	Autor		: 	Edinson Muñoz Guia
	Fecha/hora	: 	27/12/2008 - 12:08 PM
	Empresa		: 	TOPCERT E.I.R.L.
*******************************************************************/
function validarMaxCaracteres(valor,max)  { 
	if(valor.length < max){
		key = window.event.keyCode;
		if ((key > 0x60 && key < 0x7B) || key==209 || key==241 || key==225 || key==233 || key==237 || key==243 || key==250 )
			window.event.keyCode = key;//-0x20;
		return true;  
	}
    return false;  
} 

/*******************************************************************
	Modulo			: 	Gesti�n Individual / Colectiva
	Descripcion		: 	Esta funcion convierte texto ingresado a 
						mayusculas
	Autor			: 	Edinson Muñoz Guia
	Fecha/hora		: 	27/12/2008 - 12:08 PM
	Empresa			: 	TOPCERT E.I.R.L.
    Ejemplo de uso  :   onKeypress="javascript:cambiarMayusculas();"
	Modificacion	:	Se incluyeron otros caracteres: ñ, Ñ
/*******************************************************************/
function cambiarMayusculas(){
  key = window.event.keyCode;
  if ((key > 0x60 && key < 0x7B) || key==209 || key==241 || key==225 || key==233 || key==237 || key==243 || key==250 )
	window.event.keyCode = key-0x20;
}

/*******************************************************************
	Modulo		: 	Todos los modulos
	Descripcion	: 	Esta funcion valida si se ingresa email en
					el formato correcto
	Autor		: 	Edinson Muñoz Guia
	Fecha/hora	: 	27/12/2008 - 12:08 PM
	Empresa		: 	TOPCERT E.I.R.L.
*******************************************************************/
function esEmailValido(email){
	if (email != undefined && email.value != "" ){
		if (!/^[A-Za-z][A-Za-z0-9_.]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/.test(email.value)){
        	alert("Formato de Correo Electronico no valido");
			email.focus();
            return false;
        }
	}
}

/******************************************************************
	Modulo		: 	Gestion Individual / Colectiva
	Descripcion	: 	Esta funcion valida tipo de documento
					ingresado y limita tamanio de campo
	Autor		: 	Edinson Muñoz Guia
	Fecha/hora	: 	13/03/2009 - 18:47
	Empresa		: 	TOPCERT E.I.R.L.
******************************************************************/
function validaTipoDocumento(tipoDoc, nroDoc){
	//Si tipo de  documento es DNI
	if(tipoDoc == "DNI"){
	    if (verificaEntero() && nroDoc.length  <= 7)
			return true;
        else 
			return false;
	}else if(tipoDoc == "C.E. / PASAPORTE"){
		if (verificaEntero() && nroDoc.length  <= 8)
			return true;
        else 
			return false;
	}
	
}


/******************************************************************
    Modulo		: 	Modulo Individual, Colectivo, Reportes, etc.
    Descripción	: 	Esta funcion permite verificar si una fecha 
					introducida por teclado es valida
    Autor		: 	Edinson Muñoz Guia
    Fecha/hora	: 	28/10/2009 - 16:31
    Empresa		: 	TOPCERT E.I.R.L.
******************************************************************/
function esFechaValida(fecha){
	if (fecha != undefined && fecha.value != "" ){
		if (!/^\d{2}\/\d{2}\/\d{4}$/.test(fecha.value)){
        	alert("Formato de fecha no valido (dd/mm/aaaa)");
			fecha.focus();
            return false;
        }
        var dia  =  parseInt(fecha.value.substring(0,2),10);
        var mes  =  parseInt(fecha.value.substring(3,5),10);
        var anio =  parseInt(fecha.value.substring(6),10);
		switch(mes){
         	case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
	            numDias=31;
                break;
            case 4: case 6: case 9: case 11:
                numDias=30;
                break;
            case 2:
                if (comprobarSiBisisesto(anio)){ numDias=29 }else{ numDias=28};
	            break;
            default:
                alert("Fecha introducida erronea");
				fecha.focus();
                return false;
          }
		  if (dia>numDias || dia==0){
          	alert("Fecha introducida erronea");
			fecha.focus();
            return false;
          }
          return true;
      }
}

//Valida de fecha
/*function esFechaValidaBoolean(fecha){
	if (fecha != undefined && fecha.value != "" ){
    	
		if (!/^\d{2}\/\d{2}\/\d{4}$/.test(fecha.value)){
        	//alert("Formato de fecha no valido (dd/mm/aaaa)");
			return '0';
			fecha.focus();
            return false;
        }
		
        var dia  =  parseInt(fecha.value.substring(0,2),10);
		var mes  =  parseInt(fecha.value.substring(3,5),10);
        var anio =  parseInt(fecha.value.substring(6),10);
 
         switch(mes){
         	case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
	            numDias=31;
                break;
            case 4: case 6: case 9: case 11:
                numDias=30;
                break;
            case 2:
                if (comprobarSiBisisesto(anio)){ numDias=29 }else{ numDias=28};
	            break;
            default:
                //alert("Fecha introducida erronea");
				fecha.focus();
                return '1';
          }
          
		  if (dia>numDias || dia==0){
          	//alert("Fecha introducida erronea");
			fecha.focus();
            return '1';
          }
 
          return '2';

      }
}*/

/******************************************************************
    Modulo		: 	Modulo Individual, Colectivo, Reportes, etc.
    Descripción	: 	Esta funcion permite verificar si un año es 
					bisiesto
    Autor		: 	Edinson Muñoz Guia
    Fecha/hora	: 	28/10/2009 - 16:31
    Empresa		: 	TOPCERT E.I.R.L.
******************************************************************/
function comprobarSiBisisesto(anio){
	if ( ( anio % 100 != 0) && ((anio % 4 == 0) || (anio % 400 == 0))) {
 	   return true;
    }else {
       return false;
    }
}



function validaMontos(cantDecimales,cantEnteros,indNega,event,obj){
	alert("llll");
	return CatchNonNumbers_(event,indNega,1,'.',obj,cantDecimales,cantEnteros,obj);
}

function CatchNonNumbers_(e, negative, decimals, decimalSeparator, txt, cantdec, cantent, obj)
{	
	tecla = e.keyCode? e.keyCode : e.charCode;
	var sKey = String.fromCharCode(tecla);
	if((sKey == '|') || (sKey == '�') || (sKey == '`') || (sKey == '~') ||(sKey == '"') || (sKey == '&') || (sKey == ' ') || (sKey == '�') || (sKey == '!') || (sKey == '�') || (sKey == '#') || (sKey == '$') || (sKey == '%') || (sKey == '/') || (sKey == '(') || (sKey == ')') || (sKey == '=') || (sKey == '?') || (sKey == '�') || (sKey == '@') || (sKey == '*') || (sKey == '+') || (sKey == '[') || (sKey == ']') || (sKey == '{') || (sKey == '}') || (sKey == ';') || (sKey == ',') || (sKey == ':') || (sKey == '_') )
	{	
	 return false;
	}
	return CatchNonNumbers(e, negative, decimals, decimalSeparator, txt, cantdec, cantent);
}

function CatchNonNumbers(e, negative, decimals, decimalSeparator, txt, cantdec, cantent)
{
	var uni = e.keyCode? e.keyCode : e.charCode; // get the keyCode
	var decUni = getDecimalSeparatorCode(decimalSeparator); // get the decimal separator keyCode
	var evt = window.event? event : e; // event for crtl, alt and shift key
	if(evt.ctrlKey || evt.altKey || evt.shiftKey) 
		return true;
	else 
	{
	    var ubidec = txt.value.indexOf(decimalSeparator);
	    var ubientxt = getSelectionStart(txt);
	    ubidec +=1;
        if (cantdec <1)
	    {
    	    decimals=false;
	    }
	    if (ubidec > 0 ) //Existe signo Decimal
	    {
	        if (ubientxt >= ubidec) //Ubicado en los decimales
	        {
	            if ((txt.value.length - ubidec) == cantdec &&(uni != 8)) 
	            {	        
        	        return false;
	            }
	        }
	        else //ubicado en los enteros
	        {
	            if ( ubientxt <= ( ubidec - 1 ) )
	            {
	                if ((ubidec-1) >= cantent) 
	                {	        
    	                return false;
	                }
	            }
	        }
	    }
	    else
	    {
	        if ( ubidec == 0 )
	        {
	            if ( (txt.value.length >= cantent) && ( uni != decUni )&&(uni != 8) )
	            {	        
    	            return false;
	            }
	        }
	        else
	        {
	            if ((ubidec-1) >= cantent) 
	            {	        
    	            return false;
	            }
	        }
	    }
	    switch(uni)
	    {
	        case 0:
	            // safari
	            return true;
	        case decUni:
	            if(txt.value.replace("-", "").length > 0 && ((getCursorPosition(txt) > 0 ) || (getCursorPosition(txt) > 1 && txt.value.indexOf("-") > -1)) && txt.value.indexOf(decimalSeparator) == -1 && decimals)
	                return true;
	            else
	                return false;
	            break;
	        case 45: // minus sign
	        	if(negative=='0'){
	        		return false;
	        	}
	            if(getCursorPosition(txt) == 0 && negative)
	                return true;
	            else
	                return false;
	            break;
	        default:
				return IsAllowed(uni);
				break;
	    }
	} 
}


