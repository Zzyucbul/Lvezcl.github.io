var win=0;
var lose=0;
var same=0;   //平局


function dochange(){
    var select=document.getElementById("select").value;
    var current=document.getElementById("current");
    if(select==1){
        current.src="pic/qt.jpg";
    }
    else if(select==2) {
        current.src = "pic/jd.jpg";
    }
    else if(select==3) {
        current.src = "pic/bu.jpg";
    }
    else{
        current.src="pic/zb.jpg";
    }
}
function doConfirm(){
        var select=document.getElementById("select").value;
        var you=document.getElementById("you");
        var computer=document.getElementById("computer");
    if(select==1){
        you.src="pic/qt.jpg";
    }
    else if(select==2) {
       you.src = "pic/jd.jpg";
    }
    else if(select==3) {
        you.src = "pic/bu.jpg";
    }
    else{
       alert("请先选择再出拳！");
       return;
    }
    //电脑出拳
    var x=parseInt(Math.random()*3+1);
    if(x==1){
        computer.src="pic/qt.jpg";
    }
    else if(x==2) {
        computer.src = "pic/jd.jpg";
    }
    else if(x==3) {
        computer.src = "pic/bu.jpg";
    }
     //进行判断
        var result=document.getElementById("result");
        var dd=select-x;
        if(dd==0){
            result.innerText="平局";// innerText改变result的文字
            same++;
        }
        else if (dd==-1   || dd==2){
            result.innerText="胜利";
            win++;
        }
        else{
            result.innerHTML="失败";
            lose++;
        }
        document.getElementById("total").innerText=win+lose+same;    //把html里面的0改为win的值；
        document.getElementById("win").innerText=win;
        document.getElementById("lose").innerText=lose;
        document.getElementById("same").innerText=same;
}