window.onload = function () {
    // var reset = document.getElementById('reset');
    var fm = document.getElementsByTagName('form')[0];
    var stuAddMess = document.getElementById('stuPassMess');
    var password = document.getElementById('password');
    var confirmpass = document.getElementById('confirmpass');
    var code = document.getElementById('code');
    // reset.onclick = function () {
    //     password.value = '';
    //     confirmpass.value = '';
    //     code.value = '';
    //     password.focus();
    // };
    fm.addEventListener('submit', function(event) {
        if (fm.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }
        if (!/^\w{6,20}$/.test(password.value)) {// 密码验证
            stuAddMess.innerHTML = "* 密码不合法！";
            password.value = '';
            password.focus();
            event.preventDefault();
            event.stopPropagation();
        }
        if (password.value !== confirmpass.value) {// 密码确认验证
            stuAddMess.innerHTML = "* 两次输入的密码不一致，请重新输入！";
            password.value = '';
            confirmpass.value = '';
            password.focus();
            event.preventDefault();
            event.stopPropagation();
        }
        if (!/^\d{4}$/.test(code.value)) {// 验证码验证
            stuAddMess.innerHTML = "* 验证码错误！";
            code.value = '';
            code.focus();
            event.preventDefault();
            event.stopPropagation();
        }
    }, false);
};
