function getListAvrIncom(){
  var arr = ['KHONG-CO-THU-NHAP','DUOI-10-TRIEU','10-DUOI-25-TRIEU','25-DUOI-70-TRIEU','70-DUOI-110-TRIEU','TREN-110-TRIEU']

    return avrIncome=  arr[Math.floor(Math.random() * arr.length)];
}

