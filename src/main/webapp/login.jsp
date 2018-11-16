<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<h1>Login</h1>
	<form name="f" action="login_check" method="post">
		<input type="text" name="usname" placeholder="Username"><br>
		<br> <input type="password" name="password"
			placeholder="Password"><br> <br> <input
			type="checkbox" name="remember-me" checked hidden>
		<button type="submit">Login</button>
		<br> <br> <a
			href="https://accounts.google.com/o/oauth2/v2/auth?scope=email&redirect_uri=http://localhost:8080/GoogleLogin/login-google&response_type=code&client_id=844064446614-47m4njhoqitnvotek75lp9r5916bf1c2.apps.googleusercontent.com&approval_prompt=force">Login
			With Gmail</a>
	</form>
</body>
</html>
