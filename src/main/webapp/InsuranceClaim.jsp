<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim Form</title>
<script type="text/javascript"></script>
<img align="Left" src="https://www.windshieldexperts.com/blog1/wp-content/uploads/2016/05/insurance-1.jpg" alt="carinsurance image" width="500" height="500"></img>
</head>


<body style="background-color:powderblue">
<font>
<center>
<h1 style="color: black;">Claim Details</h1>
</center>
<form action="ClaimServlet" method="get">
<div>
<table align="center" cellspacing="20">
            <tr>
				<td><span style="color: red;"></span>Reason for claiming:</td>
					<td><textarea rows="" cols="" placeholder="Reason for claim"
							name="rclaim" id="rclaim"></textarea>
						</textarea> </td>
			</tr>
			
            <tr>
             <th><span style="color: red;"></span>Type of Damage:</th>
             <td><select name="typeda" id="tdamage" onchange="updateCheckBox(this)">
                <option>----Select-----</option>
                <option value="PartiallyDamaged">Partially Damaged</option>
                <option value="FullyDamaged">Fully Damaged</option>
             
             </select></td></tr>
             
       <tr>
       <th><span style="color: red;"></span>Damage Parts:</th>
       <td>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts" value="FrontGlass,"    />FrontGlassbroke-10000Rs<br/>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts" value=" Engine,"   />Engine-50000Rs<br/>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts" value=" FrontAndBummper,"   />Front&RearBumper-15000Rs<br/>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts"  value=" Fender,"   />Fender-20000Rs<br/>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts"  value=" Hoodlid,"  />hoodLid-15000Rs<br/>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts"   value=" Trunklid,"   />trunkLid-20000Rs<br/>
          <input type="checkbox" name="dparts" disabled="disabled" id="dparts"   value=" FrontandrearDoor." 	 />Front&RearDoor-15000Rs
      </td></tr>
     
      
      
      
      
      
      <div id="div"
        style="margin-top:10px;display:block;color:green;">
    
    
     <tr>
     <td>Date of issue happened:</td>
     <td><input type="date" name="dissue" placeholder="Date of issue happened" id="dissue"></td>
     </tr>
     
     <tr>
     <td><input type="submit" value="claim" class="btn btn-success"></td>
     </tr>
    
</table>
 </div>
</form>   
</body>

<script>
    function updateCheckBox(opts){
    	var chks=document.getElementsByName("dparts");
    	
    	if(opts.value=='PartiallyDamaged'){
    		for(var i=0; i<=chks.length-1; i++){
    			chks[i].disabled=false;
    			//chks[i].checked=true;
    			document.getElementById('div').innerHTML='Checkboxes enabled';
    		}
    	}
    	else{
    		for(var i=0; i<=chks.length-1;i++){
    			chks[i].disabled=true;
    			chks[i].checked=false;
    			document.getElementById('div').innerHTML='Checkboxes disabled and unchecked';
    		}
    	}
    }
</script>
</html>