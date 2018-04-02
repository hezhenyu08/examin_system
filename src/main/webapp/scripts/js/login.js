	layui.use([ 'layer', 'form', 'table' ], function() {
			var layer = layui.layer, form = layui.form, table = layui.table;
			$ = layui.$;

			//自定义用户名和密码的校验规则-----------------------------------
			form.verify({
				username : function(value, item) { //value：表单的值、item：表单的DOM对象
					//用户名的验证规则
					if (value == null || value == '') {
						return '用户名不能为空';
					}
					if (!new RegExp("[a-zA-Z0-9_\u4e00-\u9fa5\\s]+")
							.test(value)) {
						return '用户名不能含有特殊字符';
					}
					if (/(^\_)|(\_+$)/.test(value)) {
						return '用户名首尾不能出现下划线\'_\'';
					}
					if (!(/^\w{3,20}$/.test(value))) {
						return '用户名由3到20位字母、数字和下划线组成';
					}
				},
				//密码的验证规则
				password : function(value, item) {
					if (value == null || value == '') {
						return '密码不能为空';
					}
					if (!(/^\w{3,20}$/.test(value))) {
						return '密码由3到20位字母、数字和下划线组成';
					}
				}
			});
			//监听登录提交按钮事件,获取用户名，密码，验证码进行后端验证
			form.on('submit(submit)', function(data) {
				var data=data.field;
				$.ajax(
						{
							url : path + "/login/checkUser.do",
							type : "post",
							data : data,
							dataType : "json",
							success : function(result)
								{
									var state = result.state;
									var data=result.data;
									var message = result.message;
									if (state == 0)
										{
											//将data存入cookie中
											var str=JSON.stringify(data);
											addCookie("user",str,1);
											//跳转到主页面
											window.location.href="index.html";
										}
									if (state == "1")
										{
											layer.msg(message);
										}
									return false;//阻止表单跳转
								}
						});
				 return false;
			});
		});