window.onload = function(){
	var signInBtn = document.getElementById("signIn");
	var signUpBtn = document.getElementById("signUp");
	var firstForm = document.getElementById("form1");
	var secondForm = document.getElementById("userForm");
	var container = document.querySelector(".container");

	signInBtn.addEventListener("click", () => {
		container.classList.remove("right-panel-active");
	});

	signUpBtn.addEventListener("click", () => {
		container.classList.add("right-panel-active");
	});

	firstForm.addEventListener("submit", (e) => e.preventDefault());
	secondForm.addEventListener("submit", (e) => e.preventDefault());



	var usernameElt = $("#username");
	var nameErrorSpan = $("#nameError");
	usernameElt.blur( function(){
		//获取用户名
		let username = usernameElt.val();
		//去除前后空白
		username = $.trim(username);
		usernameElt.val(username);
		//用户名不能为空，不能为空串
		if(username==""){
			nameErrorSpan.html("用户名不能为空");
		}
	})
	//用户名获得焦点
	usernameElt.focus(function(){
		nameErrorSpan.html("");
	})

	//密码
	var pwdElt = $("#userpwd");
	var userpwdErrorSpan =$("#userpwdError");
	pwdElt.onblur = function(){
		var password = pwdElt.value;
		if(password==""){
			userpwdErrorSpan.html("密码不能为空");
			$(".remember1").css('top','-20px');
		}
	}
	//密码获得焦点
	pwdElt.onfocus = function(){
		userpwdErrorSpan.html("");
		$(".remember1").css('top','0px');
	}

	//按钮提交
	$("#regbtn").click(function(){
		usernameElt.focus();//触发文本框获取焦点事件
		usernameElt.blur();//触发文本框失去焦点事件
		pwdElt.focus();
		pwdElt.blur();
		//当所有的span都是空的表示都合法了
		if(nameErrorSpan.html() == "" && userpwdErrorSpan.html() ==""){
			//提交
			var formObj = $("#userForm");
			//通过调用submit(方法来完成表单提交)
			formObj.submit();
		}
	})

	$("#registbtn").onclick = function(){
		var registusernameerror = $("#registusernameerror");
		var registpassworderror = $("#registpassworderror");
		var registconfirmerror = $("#registconfirmerror");

		var username = $("#registusername");
		var password = $("#registconfirmpassword");
		var passwordold = $("#registpassword");
		username.focus();//触发文本框获取焦点事件
		username.blur();//触发文本框失去焦点事件
		password.focus();
		password.blur();
		passwordold.focus();
		passwordold.blur();
		//当所有的span都是空的表示都合法了
		if(registusernameerror.html() == "用户名合法" && registpassworderror.html() =="密码合法" && registconfirmerror.html() =="密码相符"){
			//提交
			var formObj = $("#form1");
			//通过调用submit(方法来完成表单提交)
			formObj.method="post";
			formObj.submit();

		}}



}
			

			
