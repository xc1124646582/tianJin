//head 列表
var navs=document.getElementById('navs')
var nav_list=document.getElementById('nav_list')
var switchs=true
navs.onclick=function(){
  if(switchs){
    switchs=false
    nav_list.style.height='120px'
    //navs.style.background='#ebecec'
  }else{
    switchs=true
    nav_list.style.height='0'
    navs.style.background=''
  }
}
window.document.onclick=function(e){
  var ev=e||event
  if(ev.target!=navs){
    switchs=true
    nav_list.style.height='0'
    navs.style.background=''
  }
  
}
//端口号
var ajaxUrl='http://localhost:8080/tjlog/data'

function ajax(options) {
        options = options || {};
        options.type = (options.type || "GET").toUpperCase();
        options.dataType = options.dataType || "json";
        var params = formatParams(options.data);

        //创建 - 非IE6 -
        if (window.XMLHttpRequest) {
            var xhr = new XMLHttpRequest();
        } else { //IE6及其以下版本浏览器
            var xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }

        //连接 和 发送 -
        if (options.type == "GET") {
            xhr.open("GET", options.url + "?" + params, true);
            xhr.send(null);
        } else if (options.type == "POST") {
            xhr.open("POST", options.url, true);
            //设置表单提交时的内容类型
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params);
        }

        //接收 
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var status = xhr.status;
                if (status >= 200 && status < 300) {
                    options.success && options.success(xhr.responseText, xhr.responseXML);
                } else {
                    options.fail && options.fail(status);
                }
            }
        }
    }
    //格式化参数
    function formatParams(data) {
        var arr = [];
        for (var name in data) {
            arr.push(encodeURIComponent(name) + "=" + encodeURIComponent(data[name]));
        }
        arr.push(("v=" + Math.random()).replace(".",""));
        return arr.join("&");
    }