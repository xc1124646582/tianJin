var token=JSON.parse(window.sessionStorage.getItem('user')).token

var Ajaxs={
    POST:function(url,params,callback){
        url = this.replaceUrlAllSpecialSymbol(url);
        const reqParams = Object.assign({},params);
        let req = this.createXMLHttpRequest();
        req.responseType='json';
        req.open('POST', url, true);
        req.setRequestHeader('Content-Type','application/x-www-form-urlencoded',token);
        req.onreadystatechange = this.processResponse.bind(req,callback,reqParams);
        req.send(this.getParams(reqParams));
    
    },
    GET:function(url,params,callback){
        url = this.replaceUrlAllSpecialSymbol(url);
        const reqParams = Object.assign({},params);
        //DomUtils.appendLoading();
        let req = this.createXMLHttpRequest();
        req.open('GET', url+'?'+this.getParams(reqParams), true);
        req.setRequestHeader('Content-Type','application/x-www-form-urlencoded',token);
        req.onreadystatechange = this.processResponse.bind(req,callback,reqParams);
        req.send(null);
    
    },
    PUT:function(url,params,callback){
        url = this.replaceUrlAllSpecialSymbol(url);
        //DomUtils.appendLoading();
        let req = this.createXMLHttpRequest();
        req.open('PUT', url, true);
        req.setRequestHeader('Content-Type','application/x-www-form-urlencoded',token);
        req.onreadystatechange = this.processResponse.bind(req,callback,Object.assign({},params));
        req.send(this.getParams(params));

    },
    DELETE:function(url,params,callback){
        url = this.replaceUrlAllSpecialSymbol(url);
        //DomUtils.appendLoading();
        let req = this.createXMLHttpRequest();
        req.open('DELETE', url, true);
        req.setRequestHeader('Content-Type','application/x-www-form-urlencoded',token);
        req.onreadystatechange = this.processResponse.bind(req,callback,Object.assign({},params));
        req.send(this.getParams(params));
    
    },
    createXMLHttpRequest:function(){

        let XMLHttpReq;
        try {

            XMLHttpReq = new ActiveXObject('Msxml2.XMLHTTP');
            
        }catch(E) {

            try {

                XMLHttpReq = new ActiveXObject('Microsoft.XMLHTTP');
            
            }catch(E) {

                XMLHttpReq = new XMLHttpRequest();
            
            }
            return XMLHttpReq ;
        
        }
    
    },
    processResponse:function(callback,params){

        if (this.readyState == 4) {

            //DomUtils.removeLoading();
            let json = this.response;
            if(typeof(json) === 'string'){

                json = JSON.parse(json);
 
            }
            if(!!json && this.status == 200){

//请求正常
                if(!!callback && typeof(callback) === 'function'){

                    const code = json.code;
                    if(code == 0){

                        return callback.call(null,json,params);
                    
                    }else{

                        //DomUtils.showMessage(json.message);
                        return callback.call(null,json,params);
                    
                    }
                
                }
            
            }else{

//非正常返回
                if(this.status == 404 ){

                    //DomUtils.showMessage('服务器异常: 404 The requested resource is not available.');
                
                }
                if(json){

                    //DomUtils.showMessage(json.message);
                
                }else{
                    
                   // DomUtils.showMessage('服务器出错啦!'+JSON.stringify(this.response));
                
                }
            
            }
         
        }
    
    },
    getParams:function(json){

        let params = null;
        if(json){

            params='';
            for(let key in json){

                const v = json[key];
                if(v instanceof Array){

                    params += this.array2params(key,v);
                
                }else{

                    params+= key+'='+ this.replaceAllSpecialSymbol(json[key]) +'&';
                
                }
            
            }
        
        }
        return params;
    
    },
    //特殊符号处理
    replaceAllSpecialSymbol:function(params){

        params = params+'';
        //params=params.replace(/\ /g,"%20");
        params=params.replace(/\"/g,'%22');
       // params=params.replace(/\#/g,"%23");
        params=params.replace(/\%/g,'%25');
        params=params.replace(/\&/g,'%26');
        params=params.replace(/\(/g,'%28');
        params=params.replace(/\)/g,'%29');
        params=params.replace(/\+/g,'%2B');
        params=params.replace(/\,/g,'%2C');
        params=params.replace(/\//g,'%2F');
        params=params.replace(/\:/g,'%3A');
        params=params.replace(/\;/g,'%3B');
        params=params.replace(/\</g,'%3C');
        params=params.replace(/\=/g,'%3D');
        params=params.replace(/\>/g,'%3E');
        params=params.replace(/\?/g,'%3F');
        params=params.replace(/\@/g,'%40');
        params=params.replace(/\\/g,'%5C');
        params=params.replace(/\|/g,'%7C');
        return params;
    
    },

    replaceUrlAllSpecialSymbol:function(url){

        url = url+'';
        //params=params.replace(/\ /g,"%20");
        url=url.replace(/\"/g,'%22');
       // params=params.replace(/\#/g,"%23");
        url=url.replace(/\%/g,'%25');
        //url=url.replace(/\&/g,'%26');
        // url=url.replace(/\(/g,'%28');
        // url=url.replace(/\)/g,'%29');
        // url=url.replace(/\+/g,'%2B');
        // url=url.replace(/\,/g,'%2C');
        // url=url.replace(/\//g,'%2F');
        // url=url.replace(/\:/g,'%3A');
        // url=url.replace(/\;/g,'%3B');
        // url=url.replace(/\</g,'%3C');
        // url=url.replace(/\=/g,'%3D');
        // url=url.replace(/\>/g,'%3E');
        // url=url.replace(/\?/g,'%3F');
        // url=url.replace(/\@/g,'%40');
        // url=url.replace(/\\/g,'%5C');
        // url=url.replace(/\|/g,'%7C');
        return url;
    
    },

    array2params:function(key,valueArray){

        let result = '' ;
        for (let val of valueArray){

            result+=key+'='+this.replaceAllSpecialSymbol(val)+'&' ;
        
        }
        return result;
    
    }
};