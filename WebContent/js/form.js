 
function doSubmit(param){
  				document.forms[0].action=param;
	  			document.forms[0].submit();
		}
function getdate(){
	var dt = new Date();
	var year = dt.getFullYear();
	var month = dt.getMonth()+1;
	var day = dt.getDate();
	var date = ""+year+"/"+month+"/"+day;
	document.getElementById("times").value = date;
}
function gettime(){
	var dt = new Date();
	var hour = dt.getHours();
	var minute = dt.getMinutes();
	var second = dt.getSeconds();
	if(minute<10){
		minute = ""+0+minute;
	}
	var time = ""+hour+":"+minute+":"+second;
	document.getElementById("rectime").value = time;
}
function switchPage(direction){
    	document.forms[0].pageDirection.value=direction;
    	post('switchPages');
    }
    function getId(){
    	var rdos=document.getElementsByName('id');
    	var c=0;
    	for(var i=0;i<rdos.length;i++){    	    
    	    if(rdos[i].checked){
    	    	document.forms[0].dataIndex.value=rdos[i].getAttribute('id');    	 
    	    	c++;   	
    	    }    	    
    	}
    	if(c!=1){
    		alert('��ѡ�����ݣ�����ѡ��һ�����ݣ�')
    		return false;
    	}    	
    	return true;
    }
    function getDeleteIndex(){
    	var rdos=document.getElementsByName('id');
    	var c=0,ids="";
    	for(var i=0;i<rdos.length;i++){    	    
    	    if(rdos[i].checked){
    	    	ids+=rdos[i].getAttribute('id')+",";    	 
    	    	c++;   	
    	    }    	    
    	}
    	if(c<1){
    		alert('��ѡ��Ҫ���ݣ�')
    		return false;
    	}else{
    		if(confirm("ȷ��Ҫɾ����ѡ���������")){
    			document.forms[0].deleteIndexs.value=ids;    	
    			return true;
    		}else
    			return false;
    	}
    }

    function getIds(){
    	var rdos=document.getElementsByName('id');
    	var ids="";
    	for(var i=0;i<rdos.length;i++){    	    
    	    if(rdos[i].checked){
    	    	ids+=rdos[i].getAttribute('id')+",";    	 
    	    }    	    
    	}
    	return ids;
    }
    function getSelectedIndex(){
    	var rdos=document.getElementsByName('id');
    	var c=0,ids="";
    	for(var i=0;i<rdos.length;i++){    	    
    	    if(rdos[i].checked){
    	    	ids+=rdos[i].getAttribute('id')+",";    	 
    	    	c++;   	
    	    }    	    
    	}
    	if(c<1){
    		alert('��ѡ�����ݣ�')
    		return false;
    	}
    	document.forms[0].deleteIndexs.value=ids;    	
    	return true;
    }
    
    function getSelectedDataId(target){
    	var rdos=document.getElementsByName('id');
    	var c=0,ids="";
    	for(var i=0;i<rdos.length;i++){    	    
    	    if(rdos[i].checked){
    	    	ids=rdos[i].getAttribute('id');    	 
    	    	c++;   	
    	    }    	    
    	}
    	if(c<1){
    		alert('��ѡ�����ݣ�')
    		return false;
    	}
    	document.getElementById(target).value=ids;
    	return true;
    }
    function selectData(all){
    	var flag=document.getElementById(all);
    	var eles= document.getElementsByName('dataid');
    	for(var i=0;i<eles.length;i++){
    		if(flag&&flag.checked)
    		    eles[i].checked=true;
    		else
    			eles[i].checked=!eles[i].checked;
    	}
    }
    
    function post(command,jsp,validate,target){
    	if(validate&&validate=='true'&&!validateForm())
    		return;
    	switch(command){
    		case 'add':
    		    break;
    		case 'edit':
    			if(!getId())
    				return ;
    			break;
    		case 'view':
    			if($('paraMap(dataId)')&&$('paraMap(dataId)').value==''){
    				alert('��ѡ��Ҫ�鿴������!');
    				return;
    			}else {
    				if(!getId())
    					return;
    			}    	
    			break;	
    		case 'delete':
    		    if(!getDeleteIndex())
    		    	return;   
    		    break;
    		default ://viewPage��query��switchPages
    		    break;    			  		     
    	}
    	if(jsp&&jsp!='')
    		document.forms[0].jspName.value=jsp;
    	if(command=='toExcel'){
    		document.forms[0].target="_blank";
    	}
    	else if(target!=''&&target=='blank'){
    		document.forms[0].target="_blank";
    	}
    	else
    	 	document.forms[0].target="_self";
    	document.forms[0].command.value=command;
    	document.forms[0].submit();
    }
    
    function postDefaultJsp(command,validate){
    	post(command,'');
    }
    
    function validatePost(command,jsp){  
    	post(command,jsp?jsp:'','true');
    }
   
   	function validateForm(){
   		var formName  =$('paraMap(formName)').value;  
   			 		
    	if(formName=='')
    		formName=document.forms[0].name;
    	var fun = 'validate'+formName.substring(0,1).toUpperCase()+formName.substring(1)+'(document.forms[0])';
    	return eval(fun);		
   	}
   	
  
   	