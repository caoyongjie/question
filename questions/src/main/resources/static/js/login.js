var code; //在全局定义验证码
//产生验证码
window.onload = function() {
    createCode();
}
function createCode() {
    code = "";
    var codeLength = 5; //验证码的长度
    var checkCode = document.getElementById("checkCode");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数
    for(var i = 0; i < codeLength; i++) { //循环操作
        var charIndex = Math.floor(Math.random() * 36); //取得随机数的索引
        code += random[charIndex]; //根据索引取得随机数加到code上
    }
    checkCode.value = code; //把code值赋给验证码
}

function login() {
    //校验验证码
    var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写
    if(inputCode.length <= 0) { //若输入的验证码长度为0
        alert("请输入验证码！"); //则弹出请输入验证码
    } else if(inputCode != code) { //若输入的验证码与产生的验证码不一致时
        alert("验证码输入错误！"); //则弹出验证码输入错误
        createCode(); //刷新验证码
    } else { //输入正确时
        //用户验证
        var username=$('#username').val();
        var password=$('#password').val();
        if (username.length<=0){
            alert('请输入用户名');
        }else if (password.length<=0){
            alert('请输入密码')
        }else {
            $.ajax({
                type:'post',
                url:'/selUser',
                data:{'username':username,'password':password},
                success:function (data) {
                    if (data=='success'){
                        $('#form1').submit();
                    }else {
                        alert('用户名或密码错误');
                    }
                }
            })
        }

    }
}
function zhuce() {
    $('#form2').form('clear');
    $('#add').dialog('open').dialog('setTitle','用户注册');
    $('#add').dialog('center');
}
function start() {
    $('#form2').form('submit', {
        onSubmit: function(){
            if ($(this).form('validate')){
                return true;
            }
            return false;
        },
        success:function(data){
            alert(data);
            $('#add').dialog('close');
        }
    });

}