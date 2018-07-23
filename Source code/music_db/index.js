var express = require('express');
var app = express();
var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectID;
var url = "mongodb://localhost:27017/";
var bodyParser = require('body-parser')

app.set('view engine', 'ejs');

app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header('Access-Control-Allow-Methods', 'DELETE, PUT, GET, POST');
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({'extended':'false'}))

//LAY HET NHẠC
app.get('/music-list', function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    //var query = { address: "Park Lane 38" };
    dbo.collection("Baihat").find({}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
});

//LAY THONG TIN BAI HAT
app.get('/music-info', function (req, res) {
  var movieIdObj = new ObjectID(req.query.id);
  //console.log(movieId);
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    var query = { "_id": movieIdObj };
    dbo.collection("Baihat").findOne(query, function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
});
//-------THELOAI----------
//Nhac tre
app.get('/music-list/nhac-tre',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Trẻ"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//Nhac thieu nhi
app.get('/music-list/nhac-thieu-nhi',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Thiếu Nhi"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})

//nhac bolero
app.get('/music-list/nhac-bolero',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Bolero"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//KINH-DI-MA
app.get('/music-list/nhac-au-my',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Âu Mỹ"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//-------------THELOAI
//ÂU -MỸ
app.get('/music-list/quoc-gia/au-my',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Âu Mỹ"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//VIETNAM
app.get('/music-list/quoc-gia/viet-nam',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Việt Nam"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//TRUNG QUOC
app.get('/music-list/quoc-gia/trung-quoc',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Trung Quốc"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//HAN QUOC
app.get('/music-list/quoc-gia/han-quoc',function (req, res) {
  MongoClient.connect(url, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Hàn Quốc"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})



app.listen(3000);
console.log('3000 is the magic port');