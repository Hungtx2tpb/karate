function getListInforCustomer(param1){
  var arr = []
  var listActiveTrue = []

    for(var i = 0; i < param1.RandomNum; i++){
    if(param1.response_get[i].isActive == false){
        listActiveTrue.push(param1.response_get[i])
    }
    }
    var number = Math.floor(Math.random() * listActiveTrue.length)
    if(listActiveTrue[number].t24Code != null && listActiveTrue[number].t24Id == null){
        arr.push(listActiveTrue[number].t24Code)
    }
    else{
        arr.push(listActiveTrue[number].t24Id)
    }
   arr.push(listActiveTrue[number].id)
   if(listActiveTrue[number].itemNameEn != null && listActiveTrue[number].nameEn == null){
           arr.push(listActiveTrue[number].itemNameEn)
       }
       else{
           arr.push(listActiveTrue[number].nameEn)
       }
   if(listActiveTrue[number].itemNameVn != null && listActiveTrue[number].nameVn == null){
              arr.push(listActiveTrue[number].itemNameVn)
          }
          else{
              arr.push(listActiveTrue[number].nameVn)
          }
    return arr

}

