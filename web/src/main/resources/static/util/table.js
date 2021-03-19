//删除
function remove(id){
    confirm("deleteModal","删除"+moduleName,"确认删除",function(){
        requestDelete(id,function(){
            $("#deleteModal").modal("hide")
            $table.bootstrapTable('refresh')
        })
    })
}
//修改
function update(id){
    editModal("updateModal","修改"+moduleName,$formHtmlG.html(),function(){
        var data = getFormData($("#addForm"))
        requestUpdate({id:id,...data},function(res){
            $("#updateModal").modal("hide")
            $table.bootstrapTable('refresh')
        })
    },function(){
        $("#upload").on("change",function(){
            myFileUpload("/oss/upload",$("#upload"),function(res){
                $("#links").val(res)
            })
        })
        requestDetail(id,function(data){
            initFormValue($("#addForm"),data.data)
        })
    })
}

//添加
function add(addHTML){
    editModal("addModal","添加"+moduleName,addHTML,function(){
        var data = getFormData($("#addForm"))
        requestAdd(data,function(res){
            $("#addModal").modal("hide")
            $table.bootstrapTable('refresh')
        })
    },function(){
        $("#upload").on("change",function(){
            myFileUpload("/oss/upload",$("#upload"),function(res){
                $("#links").val(res)
            })
        })
    })
}
var $formHtmlG ;
function myTable($table,requests,toolbarId,moduleName,$formHtml,columns,showDelete,showEdit,$addButton){
    var requestPage = requests.requestPage;
    var requestDetail = requests.requestDetail;
    var requestDelete =  requests.requestDelete;
    var requestAdd = requests.requestAdd;
    var requestUpdate = requests.requestUpdate;
    var addHTML;

    $(function(){
        $formHtmlG = $formHtml
        addHTML = $formHtml.html()
        $formHtml.remove();
        $table.bootstrapTable({
          ajax: function(params){
            var pageRequest = {
                pageNumber: params.data.offset/params.data.limit+1,
                pageSize: params.data.limit
            }
            requestPage(pageRequest,{search:params.data.search},function(data){
                params.success({rows:data.data.content,total:data.data.total})
            })
          },
          sidePagination:'server',
          locale: "zh-CN",
          pagination: true,
          toolbar: toolbarId,
          search: true,
          searchHighlight: true,
          columns: [
          ...columns,
          {
            title : '操作',
            field : 'id',
            align : 'center',
            formatter : function(value, row, index) {
                var e = ''
                if(showEdit){
                    var e = '<a class="btn btn-primary btn-sm" href="javascript:void(0);" mce_href="#" title="编辑" onclick="update(\''
                            + row.id
                            + '\')"><i class="fa fa-edit"></i></a> ';
                }
                if(showDelete){
                    var d = '<a class="btn btn-warning btn-sm" href="javascript:void(0);" title="删除"  mce_href="#" onclick="remove(\''
                    + row.id
                    + '\')"><i class="fa fa-minus"></i></a> ';
                }
                return e + d;
            }
          }],
        })
        $addButton.on("click",function(){
            add(addHTML)
        })

        $("#opsDelete").on("click",function(){
           update($(this).data('id'),addHTML)
       })
    })
}