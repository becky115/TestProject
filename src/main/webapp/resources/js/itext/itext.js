

function itextReportDownload(){
	var url = getResource()+"/itext/pdfDownload.do";
//	var jsonObj = $.getJSON(url, null);// {}param 
//	jsonObj.done(function(data) {
//		console.log( "second success: "+ data);
//	})
//	.fail(function(jqxhr, textStatus, error) {
//		var err = textStatus + ", " + error;
//		console.log( "Request Failed: " + err);
//	})
//	.always(function() {
//		console.log("complete");
//	});
//	
	
	
//	$.ajax({
//	    type: "GET",
//	    url: url,
//	    contentType: "application/pdf; charset=utf-8",
//	   // dataType: "json",
//	    success: function(json) {
////	    	console.log(json)
////	        alert(json);
//	    },
//	    fail: function(err){
//	    	console.log(err)
//	    }
//	});
	
	location.href = url;
	
	 
}