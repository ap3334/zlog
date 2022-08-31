let index = {
    init: function () {
        $("#join-btn").on("click", () => {
            console.log("hi");
            this.join();
        });
    },

    join: function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val()
        };

        $.ajax({
            url: "/user/join",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result) {
                alert("회원가입이 완료되었습니다.");

                location.href = "/user/login";
            },
            error: function (error) {

                alert(JSON.stringify(error));

            }
        });

    },
}

index.init();