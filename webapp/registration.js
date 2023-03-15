function clearErrorMessage() {
	document.getElementById("errorMsgVehicleRegNo").innerHTML = "";
	document.getElementById("errorMsgVehicleMake").innerHTML = "";
	document.getElementById("errorMsgVehicleModel").innerHTML = "";
	document.getElementById("errorMsgVehicleCC").innerHTML = "";
	document.getElementById("errorMsgChassisNo").innerHTML = "";
	document.getElementById("errorMsgEngineNo").innerHTML = "";
	document.getElementById("errorMsgFuelType").innerHTML = "";
	document.getElementById("errorMsgMyear").innerHTML = "";
	document.getElementById("errorMsgVehicleRegDate").innerHTML = "";
	document.getElementById("errorMsgIname").innerHTML = "";
	document.getElementById("errorMsgPolicyNo").innerHTML = "";
	document.getElementById("errorMsgStartDate").innerHTML = "";
	document.getElementById("errorMsgExpiryDate").innerHTML = "";
	document.getElementById("errorMsgName").innerHTML = "";
	document.getElementById("errorMsgEmailId").innerHTML = "";
	document.getElementById("errorMsgMobileNo").innerHTML = "";
	
}

function validcheck() { 
	var vregno = document.getElementById("vregno").value;
	var vmake= document.getElementById("vmake").value;
	var vmodel = document.getElementById("vmodel").value;
	var vcc = document.getElementById("vcc").value;
	var fueltype = document.getElementById("fueltype").value;
	var chassisno = document.getElementById("chassisno").value;
	var engineno = document.getElementById("engineno").value;
	var mfno = document.getElementById("mfno").value;
	var vrdate = document.getElementById("vrdate").value;
	var Iname = document.getElementById("Iname").value;
	var policyno = document.getElementById("policyno").value;
	var startdate = document.getElementById("startdate").value;
	var expirydate = document.getElementById("expirydate").value;
	var name = document.getElementById("name").value;
	var emailid = document.getElementById("emailid").value;
	var mobileno = document.getElementById("mobileno").value;

	if (vregno== "" || vregno == null) {
		document.getElementById("errorMsgVehicleRegNo").innerHTML = "please Vehicle RegNo";
		return false;
	} else if (vmake == "" || vmake == null) {
		document.getElementById("errorMsgVehicleMake").innerHTML = "please enter Vehicle Make";
		return false;
	} else if (vmodel == "" || vmodel == null) {
		document.getElementById("errorMsgVehicleModel").innerHTML = "please enter Vehicle Model";
		return false;
	} else if (vcc == "" || vcc == null) {
		document.getElementById("errorMsgVehicleCC").innerHTML = "please enter Vehicle CC";
		return false;
	} else if (fueltype == "" || fueltype == null
			|| fueltype == "Select an Option") {
		document.getElementById("errorMsgFuelType").innerHTML = "please enter Fuel type";
		return false;
	
	} else if (chassisno == "" ||chassisno == null) {
		document.getElementById("errorMsgChassisNo").innerHTML = "please enter Chassis No";
		return false;
	} else if (engineno == "" ||engineno == null) {
		document.getElementById("errorMsgEngineNo").innerHTML = "please enter Engine No";
		return false;
	} else if (mfno == "" ||mfno == null) {
		document.getElementById("errorMsgMyear").innerHTML = "please enter Manufacturing Year";
		return false;
	} else if (vrdate == "" ||vrdate == null) {
		document.getElementById("errorMsgVehicleRegDate").innerHTML = "please enter Vehicle RegNo";
		return false;
	} else if (Iname == "" ||Iname == null) {
		document.getElementById("errorMsgIname").innerHTML = "please enter Insured Name";
		return false;
	} else if (policyno == "" ||policyno == null) {
		document.getElementById("errorMsgPolicyNo").innerHTML = "please enter Policy No";
		return false;
	} else if (startdate == "" ||startdate == null) {
		document.getElementById("errorMsgStartDate").innerHTML = "please enter start date";
		return false;
	} else if (expirydate == "" ||expirydate == null) {
		document.getElementById("errorMsgExpiryDate").innerHTML = "please enter Expiry date";
		return false;
	} else if (name == "" ||name == null) {
		document.getElementById("errorMsgName").innerHTML = "please enter Name";
		return false;
	} else if (emailid == "" ||emailid == null) {
		document.getElementById("errorMsgEmailId").innerHTML = "please enter email id";
		return false;
	} else if (mobileno == "" ||mobileno == null) {
		document.getElementById("errorMsgMobileNo").innerHTML = "please enter Mobile Number";
		return false;
	}else {
		return true;
	}

}