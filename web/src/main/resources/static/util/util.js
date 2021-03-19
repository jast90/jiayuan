function getFormData($form){
    $form.submit(function( event ) {
      console.log( $( this ).serializeArray() );
      event.preventDefault();
    });
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function initFormValue($form,values){
    console.log("initFormValue")
    $.each(values,function(key,value){
        var ctrl = $('[name='+key+']', $form);
        switch(ctrl.prop("type")) {
            case "radio": case "checkbox":
                ctrl.each(function() {
                    if($(this).attr('value') == value) $(this).attr("checked",value);
                });
                break;
            default:
                ctrl.val(value);
        }
    })
}



function redirect(url){
    window.location = url
}

function myFileUpload(url,$fileInput,success){
    var formData = new FormData();
    formData.append('file', $fileInput[0].files[0]);
    $.ajax({
       url : url,
       type : 'POST',
       data : formData,
       processData: false,  // tell jQuery not to process the data
       contentType: false,  // tell jQuery not to set contentType
       success : success
    });
}

function houseSelect($select,success,domain){
    if(!domain){
        domain = {}
    }
    console.log("houseSelect")
    listHouse(domain,function(res){
        var options = ['<option>请选择房屋</option>']
        if(res.data){
            $.each(res.data,function(index,element){
                options.push('<option value="'+element.id+'">'+element.houseName+'</option>')
            })
        }
        $select.empty().append(options.join(""))
        if (typeof success === "function") {
            success()
        }
    })
}


function userSelect($select,success){
    console.log("userSelect")
    listUser({userType: 2,unJoin: true},function(res){
        var options = ['<option>请选择用户</option>']
        if(res.data){
            $.each(res.data,function(index,element){
                options.push('<option value="'+element.id+'">'+element.realName+'</option>')
            })
        }
        $select.empty().append(options.join(""))
        if (typeof success === "function") {
            success()
        }
    })
}
