function addAnnouncement(domain,success){
    request("/announcement","post",domain,success)
}
function deleteAnnouncement(id,success){
    request("/announcement/"+id,"delete",{},success)
}
function updateAnnouncement(domain,success){
    request("/announcement","put",domain,success)
}
function getAnnouncement(id,success){
    request("/announcement/"+id,"get",{},success)
}
function pageAnnouncement(pageRequest,domain,success){
    request("/announcement/page","post",{pageRequest:pageRequest,domain:domain},success)
}

function addComplaint(domain,success){
    request("/complaint","post",domain,success)
}
function deleteComplaint(id,success){
    request("/complaint/"+id,"delete",{},success)
}
function updateComplaint(domain,success){
    request("/complaint","put",domain,success)
}
function getComplaint(id,success){
    request("/complaint/"+id,"get",{},success)
}
function pageComplaint(pageRequest,domain,success){
    request("/complaint/page","post",{pageRequest:pageRequest,domain:domain},success)
}

function addHouse(domain,success){
    request("/house","post",domain,success)
}
function deleteHouse(id,success){
    request("/house/"+id,"delete",{},success)
}
function updateHouse(domain,success){
    request("/house","put",domain,success)
}
function getHouse(id,success){
    request("/house/"+id,"get",{},success)
}
function pageHouse(pageRequest,domain,success){
    request("/house/page","post",{pageRequest:pageRequest,domain:domain},success)
}
function listHouse(domain,success){
    request("/house/condition","post",domain,success)
}

function addHouseFee(domain,success){
    request("/house/fee","post",domain,success)
}
function deleteHouseFee(id,success){
    request("/house/fee/"+id,"delete",{},success)
}
function updateHouseFee(domain,success){
    request("/house/fee","put",domain,success)
}
function getHouseFee(id,success){
    request("/house/fee/"+id,"get",{},success)
}
function pageHouseFee(pageRequest,domain,success){
    request("/house/fee/page","post",{pageRequest:pageRequest,domain:domain},success)
}


function payHouseFee(id,success){
    request("/house/fee/pay/"+id,"post",{},success)
}


function addMessage(domain,success){
    request("/message","post",domain,success)
}
function deleteMessage(id,success){
    request("/message/"+id,"delete",{},success)
}
function updateMessage(domain,success){
    request("/message","put",domain,success)
}
function getMessage(id,success){
    request("/message/"+id,"get",{},success)
}
function pageMessage(pageRequest,domain,success){
    request("/message/page","post",{pageRequest:pageRequest,domain:domain},success)
}

function addRepair(domain,success){
    request("/repair","post",domain,success)
}
function deleteRepair(id,success){
    request("/repair/"+id,"delete",{},success)
}
function updateRepair(domain,success){
    request("/repair","put",domain,success)
}
function getRepair(id,success){
    request("/repair/"+id,"get",{},success)
}
function pageRepair(pageRequest,domain,success){
    request("/repair/page","post",{pageRequest:pageRequest,domain:domain},success)
}

function addUser(domain,success){
    request("/user","post",domain,success)
}
function deleteUser(id,success){
    request("/user/"+id,"delete",{},success)
}
function updateUser(domain,success){
    request("/user","put",domain,success)
}
function getUser(id,success){
    request("/user/"+id,"get",{},success)
}
function pageUser(pageRequest,domain,success){
    request("/user/page","post",{pageRequest:pageRequest,domain:domain},success)
}
function listUser(domain,success){
    request("/user/condition","post",domain,success)
}
function changePassword(domain,success){
    request("/user/change/password","put",domain,success)
}

function addUserHouse(domain,success){
    request("/user/house","post",domain,success)
}
function deleteUserHouse(id,success){
    request("/user/house/"+id,"delete",{},success)
}
function updateUserHouse(domain,success){
    request("/user/house","put",domain,success)
}
function getUserHouse(id,success){
    request("/user/house/"+id,"get",{},success)
}
function pageUserHouse(pageRequest,domain,success){
    request("/user/house/page","post",{pageRequest:pageRequest,domain:domain},success)
}









function login(data,success){
     request("/login","post",data,success)
}

function exportUserTemplate(){
    window.location="/excel/user/template"
}





