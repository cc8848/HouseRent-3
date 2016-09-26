<html>
<body>
<h2>Hello World!</h2>
<input type="text" id="captcha" name="captcha" maxlength="4" />
<img src="getCaptchaImage" onclick="this.src='getCaptchaImage?d='+new Date().getTime()" border="1"/>
</body>
</html>
