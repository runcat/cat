$(function() {
	$("#registForm").validate({
		"rules":{
//			email:{
//				required:true,
//				email:true,
//				remote:{
//					url:"",
//					type:"get",
//					data:{
//						email:function(){
//							return $("#inputEmail").val();
//						}
//					},
//					dataFilter:function(data) {
//						if(data.result) {
//							
//						}
//					}
//				}
//			},
			title:{
				required:true, maxlength:20,
			},
			content:{
				required:true
			}
		},
		errorElement:"span",
		errorClass:"help-inline",
//		validClass
		errorPlacement:function(error, element) {
//			element.nextAll("span.help-inline").html(error.html());
			error.appendTo(element.parent());
		},
		highlight:function(element, errorClass) {
			$(element).parent().parent().removeClass("success").addClass("error");
		},
		success:function(label, element) {
//			$(element).parent().parent().removeClass("error").addClass("success");
//			$(element).nextAll("span.help-inline").html("");
			label.text("");
		},
		unhighlight:function(element, errorClass) {
			$(element).parent().parent().removeClass("error").addClass("success");
		},
		submitHandler:function(form) {
			$("#registForm").ajaxSubmit({
				dataType:"json",
				beforeSerialize:function($form, options) {
					
				},
				beforeSubmit:function(formData, jqForm, options) {
				},
				success:function(data) {
					
				},
				error:function(jqXHR, textStatus, errorThrown) {
					
				}
			});
		}
	});
	jQuery().ajaxStart(function() {
		$(".btn-primary").attr("disabled", true).addClass("disabled");
	}).ajaxStop(function() {
		
	}).ajaxError(function(a, b, e) {
		throw e;
	});
});