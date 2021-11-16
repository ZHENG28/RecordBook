window.onload = function(){
				var usernameElt = document.getElementById("username");
				var nameErrorSpan = document.getElementById("nameError");
				usernameElt.onblur = function(){
					//获取用户名
					var username = usernameElt.value;
					//去除前后空白
					username = username.trim();
					//用户名不能为空，不能为空串
					if(username==""){
						nameErrorSpan.innerHTML = "用户名不能为空";
					}
				}
				//用户名获得焦点
				usernameElt.onfocus = function(){
					nameErrorSpan.innerHTML = "";
				}
				
				//密码
				var pwdElt = document.getElementById("userpwd");
				var userpwdErrorSpan =document.getElementById("userpwdError");
				pwdElt.onblur = function(){
					var password = pwdElt.value;
					if(password==""){
						userpwdErrorSpan.innerHTML="密码不能为空";
						$(".remember1").css('top','-20px');
					}
				}
				//密码获得焦点
				pwdElt.onfocus = function(){
					userpwdErrorSpan.innerHTML = "";
					$(".remember1").css('top','0px');
				}
				
				//按钮提交
				document.getElementById("regbtn").onclick = function(){
					usernameElt.focus();//触发文本框获取焦点事件
					usernameElt.blur();//触发文本框失去焦点事件
					pwdElt.focus();
					pwdElt.blur();
					//当所有的span都是空的表示都合法了
					if(nameErrorSpan.innerHTML == "" && userpwdErrorSpan.innerHTML ==""){
						//提交
						var formObj = document.getElementById("userForm");
						//通过调用submit(方法来完成表单提交)
						formObj.method="post"
						formObj.submit();
				
				}
			}
			
			document.getElementById("signUp").onclick = function(){
					var registusernameerror = document.getElementById("registusernameerror");
					var registpassworderror = document.getElementById("registpassworderror");
					var registconfirmerror = document.getElementById("registconfirmerror");
					
					var username = document.getElementById("registusername");
					var password = document.getElementById("registconfirmpassword");
       				var passwordold = document.getElementById("registpassword");
					
					username.focus();//触发文本框获取焦点事件
					username.blur();//触发文本框失去焦点事件
					password.focus();
					password.blur();
					passwordold.focus();
					passwordold.blur();
					//当所有的span都是空的表示都合法了
					if(registusernameerror.innerHTML == "用户名合法" && registpassworderror.innerHTML =="密码合法" && registconfirmerror.innerHTML =="密码相符"){
						//提交
						var formObj = document.getElementById("form1");
						//通过调用submit(方法来完成表单提交)
						formObj.method="post";
						formObj.submit();

				}}
			
}
