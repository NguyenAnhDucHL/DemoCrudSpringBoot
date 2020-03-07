var mainImage = document.getElementById('main-image');
//console.log(mainImage);
//mainImage.dataset.href="./My_Font/i284852689410739388._szw360h1280_.jpg";
//mainImage.innerHTML="<img src='./My_Font/i284852689410739388._szw360h1280_.jpg'>";
var mainTile = document.getElementById("main-title");
var listImage = document.getElementById("list-image");
listImage.addEventListener('click',function(event){
    if(event.target.tagName ==='IMG'){
        var href = event.target.src;
        var title = event.path[1].title;
        mainTile.innerHTML=title;
        mainImage.dataset.href=href;
        mainImage.innerHTML='<img src='+href+'>';
    }
    
});
