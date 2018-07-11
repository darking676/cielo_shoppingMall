<script type="text/javascript">
        $(document).ready(function(){
        	$("#go_payment").on("click", function(e){
                e.preventDefault();
                fn_go_payment($(this));
            }); 
        	$("a[name='empty']").on("click", function(e){
                e.preventDefault();
                fn_go_empty($(this));
            }); 
        	$("a[name='number_mod']").on("click", function(e){
                e.preventDefault();
                fn_go_number_mod($(this));
            }); 
        	$("#product_list").on("click", function(e){
                e.preventDefault();
                fn_go_product();
            }); 
        	$("a[name='title']").on("click", function(e){
                e.preventDefault();
                fn_BoardDetail($(this));
            }); 
        	$("a[name='cart']").on("click", function(e){
                e.preventDefault();
                fn_go_cart($(this));
            }); 
        	 var chk = $("#check_all").is(":checked");  
             if(chk) $("#payment").text(${tot})	            
        });
        
        function fn_go_payment(pl){   //결제
        	if(confirm("결제하시겠습니까?") == true){
	            var comSubmit = new ComSubmit();
	            var chksize = $("input:checkbox[name='check_li']").length;
	            var id_list = "";
	            var num_list = "";
	            var sub_pay = "";
				for (var i = 1; i < chksize + 1; i++) {
					if($("#" + i).prop("checked") == true){
	            		id_list += $("#" + i).val() + ",";
	            		num_list += $("#number" + i).val() + ",";					
			            sub_pay += $("#sub_pay" + i).text() + ",";
					}
        		
        		}
            comSubmit.setUrl("<c:url value='/views/PaymentList.do' />");
            comSubmit.addParam("wish_userid", $("#user_id").val());
            comSubmit.addParam("wish_p_id", id_list);    
            comSubmit.addParam("wish_number", num_list);
            comSubmit.addParam("p_price", sub_pay);
            comSubmit.submit();
			}
        }
        function fn_go_empty(no){
            var comSubmit = new ComSubmit();
            if(confirm("정말 삭제하시겠습니까?") == true){
            comSubmit.setUrl("<c:url value='/views/ProductDel.do' />");
            comSubmit.addParam("wish_userid", $("#user_id").val());    
            comSubmit.addParam("wish_p_id", no.parent().find("#empty_no").val());
            comSubmit.submit();            	
            }
        }
        function fn_go_number_mod(no){
            var comSubmit = new ComSubmit();
            var number_mod = no.parent().parent().find("#number" + no.parent().parent().find("input[name='check_li']").attr("id"));
     
            if(confirm("수정 하시겠습니까?") == true){
            	if( number_mod.val() < 0){
            		alert("입력값 오류");
            		number_mod.val("1");
            		number_mod.focus();
            		return;
            	}else if(Number(no.parent().parent().find("#stock" + no.parent().parent().find("input[name='check_li']").attr("id")).val()) < Number(number_mod.val())){
            		alert("재고부족");
            		number_mod.val(no.parent().parent().find("#stock" + no.parent().parent().find("input[name='check_li']").attr("id")).val()).focus()
            		return;
            	}
            $(no).parent().parent().find("#sub_pay" + $(no).parent().parent().find(".input_check").attr("id")).text($(no).val() * $(no).parent().parent().find("#price_sel").text());
            comSubmit.setUrl("<c:url value='/views/ProductUp.do' />");
            comSubmit.addParam("wish_userid", $("#user_id").val());    
            comSubmit.addParam("wish_p_id", no.parent().parent().find("#empty_no").val());
            comSubmit.addParam("wish_number", number_mod.val());
            comSubmit.submit();            	
            }
        }
        function fn_go_product(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/views/ProductList.do' />");
            comSubmit.submit();
        }
        function fn_go_cart(obj){ 
            var comSubmit = new ComSubmit();
            alert(obj.parent().parent().find("#id").val());
            comSubmit.setUrl("<c:url value='/views/WishList.do' />");
            comSubmit.addParam("wish_p_id", obj.parent().parent().find("#id").val());
            comSubmit.submit();
        }
        function func1(no){		//ForEach 내부 checkbox 클릭시 호출
        	var check_all = $("input:checkbox[name='check_li']").length
        	var check_sel = $("input:checkbox[name='check_li']:checked").length
        	var sub_payment = parseInt($(no).parent().find("#sub_payment").val())
        	var post_payment = Number($("#payment").text())
        	if(check_all > check_sel){
        		$("#check_all").prop('checked', false)
        	}else{
        		$("#check_all").prop('checked', true)
        	}
        	
        	if($(no).is(":checked")){	
        		post_payment += sub_payment
        		$("#payment").text(post_payment)
			}else{
				$("#payment").text(Number($("#payment").text()) - sub_payment)
			}
        }
        function funcAllChk(b){	//ForEach 밖 최상위 체크박스 클릭시 호출
        	var chk = $("#check_all").is(":checked"); //boolean    		
        	if(chk){	
          	   $(".select_subject input").prop('checked', true); //checked attr == true 
          	   $("#payment").text(${tot})
            }else{ 	
          	   $(".select_subject input").prop('checked', false);	//checked attr == false
               $("#payment").text(Number(0))
            }
        }
</script>