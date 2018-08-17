const fs = require("fs");
const http = require("http");
const path = require("path")

function getAllSubFolders(flag, res){

  var list = [];
  console.log("ok");
  fs.readdir("/home/hoanglong/git/WebPage", function(err, files){
    console.log("sss");
    for (var i = 0; i < files.length; i++){
      fs.stat(files[i], function(err, stat){
        if (stat.isDirectory()){
          list.push()
        }
      })
      console.log(files[i]);
    }
  }
);
}

http.createServer(function(req, res){
  console.log("hello");
  res.write("abc");
  var flag = 0;
  //getAllSubFolders(flag, res);
  var folderStructure = new FolderStructure("/home/hoanglong/git/WebPage");
  console.log(folderStructure.getFolderName());
  var subFolderList = folderStructure.getSubfolderList();
  var i;
  for (i = 0; i < subFolderList.length; i++){
    console.log(subFolderList[i].getFolderName());
  }
  //while (flag == 0);
  res.end();
}).listen(8080);

class FolderStructure{
  constructor(folderPath){
    this.folderName = path.basename(folderPath);
    this.folderList = []; //list of subfolders
    fs.readdir(folderPath, function(err, files){
      var i = 0;
      for (i = 0; i < files.length; i++){
        //console.log(files[i]);
        (function(file){
          fs.stat(file, function(err, stats){
            console.log(file);
            console.log(stats);
            console.log(err);
            if (err.errno < 0){
              console.log(err.code);
            }
            else{
              if (stats.isDirectory()){
                var newFolder = FolderStructure(folderPath + "/" +file);
                this.folderList.append(newFolder);
              }
            }
          });
        })(files[i]);

      };
    });
  }
  addFolder(){

  }
  getFolderName(){
    return this.folderName;
  }
  getSubfolderList(){
    return this.folderList;
  }
}
