function getListInforCustomer(param1){
  var arr = []
  var listActiveTrue = []

    for(var i = 0; i < param1.RandomNum; i++){
    if(param1.response_get[i].isActive != false){
        listActiveTrue.push(param1.response_get[i])
    }
    }
    var number = Math.floor(Math.random() * listActiveTrue.length)
    if(listActiveTrue[number].t24Code != null && listActiveTrue[number].t24Id == null){
    karate.log('run vao if')
        arr.push(listActiveTrue[number].t24Code)
    }
    else{
    karate.log('run vao else')
        arr.push(listActiveTrue[number].t24Id)
    }
   arr.push(listActiveTrue[number].id)

    return arr

}

