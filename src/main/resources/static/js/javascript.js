function photoSelect(params) {
    if(document.getElementById('info-image')!='<img class="d-block w-100" src="images/'+params+'.jpg" alt="...">'){
        document.getElementById('info-image').innerHTML='<img class="d-block w-100" src="images/'+params+'.jpg" alt="...">';
        console.log("Done");
        console.log(document.getElementById('info-image').getElementsByTagName('img'));
    }
    
}