function toast(id,title,msg){
    var html = '<div id="'+id+'"class="toast" style="position: fixed;top: 20px; right: 20px;z-index: 1030;min-width: 300px;min-height: 70px;" data-delay="10000">'
                +   '<div class="toast-header">'
                +     '<strong class="mr-auto">'+title+'</strong>'
                +     '<button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">'
                +       '<span aria-hidden="true">&times;</span>'
                +     '</button>'
                +   '</div>'
                +   '<div class="toast-body">'
                +     msg
                +   '</div>'
                + '</div>'
    $(".container-fluid").append(html)
    $("#"+id).toast('show')
    $('#'+id).on('hidden.bs.toast', function () {
        $('#'+id).remove()
    })
}

function successToast(id,msg){
    toast(id,"操作成功",msg)
}

function failToast(id,msg){
    toast(id,"操作失败",msg)
}

function confirm(id,title,content,onOk){
    if($("#"+id).length===1){
        $("#"+id).remove()
    }
    var confirm = '<div id="'+ id +'" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">'
                        +'<div class="modal-dialog modal-sm" role="document">'
                        +    '<div class="modal-content">'
                        +        '<div class="modal-header">'
                        +            '<h5 class="modal-title" id="exampleModalLabel">'+title+'</h5>'
                        +            '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
                        +                '<span aria-hidden="true">&times;</span>'
                        +            '</button>'
                        +        '</div>'
                        +        '<div class="modal-body">'
                        +        content
                        +        '</div>'
                        +        '<div class="modal-footer">'
                        +            '<button id="ok" type="button" class="btn btn-primary">确认</button>'
                        +            '<button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>'
                        +        '</div>'
                        +    '</div>'
                        +'</div>'
                    +'</div>'
    $("body").append(confirm)
    $("#ok").on("click",onOk)

    $("#"+id).modal('show')
    $("#"+id).on('hidden.bs.modal', function (e) {
      $("#"+id).remove()
    })
}

function editModal(id,title,content,onOk,success){
    console.log("editModal")
    if($("#"+id).length===1){
        $("#"+id).remove()
    }
    var confirm = '<div id="'+ id +'" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">'
                        +'<div class="modal-dialog" role="document">'
                        +    '<div class="modal-content">'
                        +        '<div class="modal-header">'
                        +            '<h5 class="modal-title" id="exampleModalLabel">'+title+'</h5>'
                        +            '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
                        +                '<span aria-hidden="true">&times;</span>'
                        +            '</button>'
                        +        '</div>'
                        +        '<div class="modal-body">'
                        +        content
                        +        '</div>'
                        +        '<div class="modal-footer">'
                        +            '<button id="editModalOk" type="button" class="btn btn-primary">确认</button>'
                        +            '<button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>'
                        +        '</div>'
                        +    '</div>'
                        +'</div>'
                    +'</div>'
    $("body").append(confirm)
    if (typeof success === "function") {
        success()
    }
    $("#editModalOk").on("click",function(){
        onOk()
        $("#"+id).modal("hide");
    })

    $("#"+id).modal('show')
    $("#"+id).on('hidden.bs.modal', function (e) {
      $("#"+id).remove()
    })
}