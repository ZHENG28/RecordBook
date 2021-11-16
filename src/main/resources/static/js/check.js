
    function getxhr() {
    var xhr;
    xhr = new XMLHttpRequest();
    return xhr;
}
    function checkname()
    {
        console.log("!!!!!!!!!");
        var username = document.getElementById("registusername");
        var namevalue = username.value;
        var nametip = document.getElementById("registusernameerror");
        var xhr = getxhr();
        xhr.open("post", "/checkname", true);
        xhr.setRequestHeader("Content-Type",
        "application/x-www-form-urlencoded");
        xhr.send("username=" + namevalue);
        var regExp = /^[a-zA-Z0-9]+$/;
		var ok = regExp.test(namevalue);
		if(ok){
	        xhr.onreadystatechange =  function()
		    {
		        if(xhr.readyState == 4 && xhr.status == 200)
			    {
			        var state = xhr.responseText;
			        console.log(state);
			        if(state == 1)
			    	{
			        nametip.style.color= 'red';
			        nametip.innerHTML = "用户名已注册";
			    	}
			        else if(state == 2)
			        {
			            nametip.style.color = "green";
			            nametip.innerHTML = "用户名合法";
			        }
			        else if(state == 3)
			        {
			            nametip.style.color = "red";
			            nametip.innerHTML = "用户名不能为空";
			        }
			    }
		    }
		 }
		 else
		 {
		 	nametip.style.color = "red";
			nametip.innerHTML = "用户名必须由字母或数字组成";
		 }
    }
    function checkpassword() {
    var password = document.getElementById("registpassword");
    var passwordvalue = password.value;
    var passwordtip = document.getElementById("registpassworderror");
    var xhr = getxhr();
    xhr.open("post", "/checkregistpassword", true);
    xhr.setRequestHeader("Content-Type",
    "application/x-www-form-urlencoded");
    xhr.send("password=" + passwordvalue);
    
    var regExp = /^[\w_-]{5,16}$/;
	var ok = regExp.test(passwordvalue);
    if(ok){
		    xhr.onreadystatechange =  function()
		{
		    if(xhr.readyState == 4 && xhr.status == 200)
		{
		    var state = xhr.responseText;
		    if(state == 1)
		{
		    passwordtip.style.color = "red";
		    passwordtip.innerHTML = "密码不合法";
		}
		    else if(state == 2)
		{
		    passwordtip.style.color = "green";
		    passwordtip.innerHTML = "密码合法";
		}
		}
		}
	}
	else
	{
		passwordtip.style.color = "red";
		passwordtip.innerHTML = "密码5-18位，允许字母、数字、下划线";
	}
}
    function checkconfirmpassword() {
        var password = document.getElementById("registconfirmpassword");
        var passwordold = document.getElementById("registpassword");
        var passwordvalue = password.value;
        var passwordoldvalue = passwordold.value;
        var passwordtip = document.getElementById("registconfirmerror");
        var xhr = getxhr();
        xhr.open("post", "/checkconfirmpassword", true);
        xhr.setRequestHeader("Content-Type",
            "application/x-www-form-urlencoded");
        xhr.send("password=" + passwordvalue + "&passwordold=" + passwordoldvalue);
        xhr.onreadystatechange =  function()
        {
            console.log(xhr.readyState + ' ' + xhr.status);

            if(xhr.readyState == 4 && xhr.status == 200)
            {
                var state = xhr.responseText;
                if(state == 1)
                {
                    passwordtip.style.color = "red";
                    passwordtip.innerHTML = "密码不符";
                }
                else if(state == 2)
                {
                    passwordtip.style.color = "green";
                    passwordtip.innerHTML = "密码相符";
                }
            }
        }
    }