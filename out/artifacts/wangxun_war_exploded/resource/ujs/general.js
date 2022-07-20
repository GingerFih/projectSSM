
function backRegister(){
    location.href = "Uregiste.html";
}
function backLogin(){
    location.href = "Ulogin.html";
}

var lim ={
    check:function (){
        $.ajax({
        type:"get",
        url:"limit",
        async: false,   //同步属性，：此方法优先于body里面执行；
        success:function (data){
            console.log(data);
            if(data.code==0){
                location.href="Ulogin.html";
            }
        }
    })
    }
}

lim.check();





// function limit() {
//     $.ajax({
//         type:"get",
//         url:"limit",
//         async: false,   //同步属性，：此方法优先于body里面执行；
//         success:function (data){
//             console.log(data);
//             if(data.code==0){
//                 location.href="Ulogin.html";
//             }
//         }
//     })
// }
// limit();


