$(function(){
	var menuName = $(".selectMenu").html();
	if(menuName=='首页'){
		$("a[title='"+menuName+"']").parent().addClass("current");
	}else{
		$("a[title='"+menuName+"']").parent().addClass("current");
		$("a[title='"+menuName+"']").parent().parent().parent().css("display","block");
	}
	$(".btn-blue").click(function(){
		$(".btn-blue").removeClass("btn-blue-select");
		$(this).addClass("btn-blue-select");
		var value = $(this).val();
		if(value=='全部'){
			value="";
		}
		var inputId = $(this).attr("inputId");
		$("#"+inputId).val(value);
		
		var form = $(this).attr("form");
		$("#"+form).submit();
	});
	$(".btn-green").click(function(){
		$(".btn-green").removeClass("btn-green-select");
		$(this).addClass("btn-green-select");
		var value = $(this).val();
		if(value=='全部'){
			value="";
		}
		var inputId = $(this).attr("inputId");
		$("#"+inputId).val(value);
		var form = $(this).attr("form");
		$("#"+form).submit();
	});
	$(".btn-yellow").click(function(){
		$(".btn-yellow").removeClass("btn-yellow-select");
		$(this).addClass("btn-yellow-select");
		var value = $(this).val();
		if(value=='全部'){
			value="";
		}
		var inputId = $(this).attr("inputId");
		$("#"+inputId).val(value);
		var form = $(this).attr("form");
		$("#"+form).submit();
	});
	$("input[btn]").each(function(){
		var btnClass = $(this).attr("btn");
		var value = $(this).val();
		if(value==''){
			value = '全部';
		}
		var id = $(this).attr("id");
		$("input."+btnClass+"[inputId="+id+"][value="+value+"]").addClass(btnClass+"-select");
	});
	
	$("select[selectValue]").each(function(){
		var value = $(this).attr("selectValue");
		$(this).find("option[value="+value+"]").prop("selected","selected");
	});
	$(".checkboxSelect[value]").each(function(){
		var name = $(this).attr("inputName");
		var values = $(this).val();
		var valueArr = values.split(",");
		$("input[type=checkbox][name="+name+"]").each(function(){
			for(var i=0;i<valueArr.length;i++){
				$("input[type=checkbox][name="+name+"][value="+valueArr[i]+"]").attr("checked","checked");
			}
			
		});
	});
	$(".disabled").each(function(){
		$(this).attr("disabled","disabled");
	});
	$(".readonly").each(function(){
		$(this).attr("readonly","readonly");
	});
})

/*打开连接*/
function openUrl(title,url,w,h){
	layer_show(title,url,w,h);
}
function formDisabled(id){
	$("#"+id+" input,select,radio,textarea").each(function(){
		$(this).attr("disabled","disabled");
	});
}
function formReadonly(id){
	$("#"+id+" input,select,radio,textarea").each(function(){
		$(this).attr("readonly","readonly");
	});
}
