function request(url,method,data,success){
    switch(method){
        case "get":{
            $.get(url,function(res){
                if (success && typeof success === "function") {
                    success(res)
                }
            },"json")
            break;
        }
        default:{
            $.ajax({
                      headers : {
                        'Content-Type' : 'application/json;charset=utf-8'
                      },
                      type: method,
                      url: url,
                      data: JSON.stringify(data),
                      success: function(data){
                        if (success && typeof success === "function") {
                            success(data)
                        }
                        if(data.code===0){
//                            if(data.msg){
//                                successToast("successMsg",data.msg)
//                            }
                        }else{
                            if(data.msg){
                                failToast("failMsg",data.msg)
                            }
                        }
                      },
                      dataType: "json"
                });
        }

    }
}

