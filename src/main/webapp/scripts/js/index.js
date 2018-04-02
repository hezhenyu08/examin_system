layui.use(
			[ 'layer', 'form', 'table', 'element' ], function()
			{
				var element = layui.element, layer = layui.layer, form = layui.form, table = layui.table;
				$ = layui.$;
				$(function()
					{
						var str = getCookie("user");//从Cookie中取出管理员信息
						var data = JSON.parse(str);
						var user_id = null;//管理员ID
						if (data != null)
							{
								$("#user_name").append(data.user_name);
								user_id = data.user_id;
							}
						//发送AJAX根据user_id查询对应的用户模板信息
						$.ajax(
							{
								url : path + "/index/findUserModule.do",
								type : "post",
								data :
									{
										"user_id" : user_id
									},
								dataType : "json",
								success : function(result)
									{
										var state = result.state;
										var data = result.data;
										var message = result.message;
										if (state == 0)
											{
												var len = data.length;
												for (var i = 0; i < len; i++)
													{
														var authority_name = data[i].AUTHORITY_NAME;
														switch (authority_name)
															{
															case '题库管理':
																var id="subject_manage";
																addModuleData(id,data[i]);
																break;
															case '用户管理':
																var id="user_manage";
																addModuleData(id,data[i]);
																break;
															case '考试编排':
																var id="examin_arrange";
																addModuleData(id,data[i]);
																break;
															case '考试管理':
																var id="examin_manage";
																addModuleData(id,data[i]);
																break;
															case '我的练习':
																var id="my_test";
																addModuleData(id,data[i]);
																break;
															case '我的考试':
																var id="my_examin";
																addModuleData(id,data[i]);
																break;
															case '我的成绩':
																var id="my_score";
																addModuleData(id,data[i]);
																break;
															default:
																alert("该管理员没有分配任何权限");
																break;
															}
													}
											} else
											{
												//跳转到登录面
												window.location.href = "login.html";
											}
										return false;
									}
							});
						//点击模块跳转到对应的页面
						$('#examin_pic_ul>li').click(function(){
							var html=$(this).find('a').attr("href-url");
							window.location.href=html;
						})
						//加载模板名称,模本描述,模板对应的URL
						function addModuleData(id,data){
							var funciton_name = data.FUNCITON_NAME;
							var function_url = data.FUNCTION_URL;
							var function_desc = data.FUNCTION_DESC;
							$("#"+id+"").show();
							var $p='';
							 $p+='<p class="funciton_name">'+funciton_name+'</p>';
							 $p+='<p class="function_desc">'+function_desc+'</p>';
							$("#"+id+"").append($($p));
							$("#"+id+"").attr("href-url",function_url);
						}
					})
			});