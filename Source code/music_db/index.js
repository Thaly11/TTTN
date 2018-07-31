var express = require('express');
var app = express();
var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectID;
var url = "mongodb://localhost:27017/";
var bodyParser = require('body-parser')
var dateTime = require('node-datetime');

app.set('view engine', 'ejs');

app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header('Access-Control-Allow-Methods', 'DELETE, PUT, GET, POST');
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});

app.use(bodyParser.urlencoded({'extended':'false'}))
app.use(bodyParser.json())

//LAY HET BH
app.get('/music-list', function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
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
//BINH LUAN
app.get('/add-comment', function (req, res) {
  var movieIdObj = new ObjectID(req.query.id);
  var dt = dateTime.create();
  var currentTime = dt.format('Y-m-d H:M:S');
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    var myquery = { "_id": movieIdObj };
    var newvalues = { $push: {"nhac.binhluan":{email: req.query.email, noidung: req.query.noidung, thoigian: currentTime}}};
    dbo.collection("Baihat").updateOne(myquery, newvalues, function(err, addresult) {
      resultmsg = {};
     if (err){
      resultmsg = {message: "Failed new comment"};
      throw err;
     }
     else{
      resultmsg = {message: "Added new comment"}
     }
      res.render('output', { result: resultmsg });
      db.close();
    });
  });
});
//LAY THONG TIN 
app.get('/music-info', function (req, res) {
  var movieIdObj = new ObjectID(req.query.id);
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
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
//NHAC TRE
app.get('/music-list/nhac-tre',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Trẻ"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//NHAC AU MY
app.get('/music-list/nhac-au-my',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Âu Mỹ"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})

//NHAC BOLERO
app.get('/music-list/nhac-bolero',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Bolero"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//NHAC THIEU NHI
app.get('/music-list/nhac-thieu-nhi',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.theloai":"Nhạc Thiếu Nhi"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//-------------THELOAI
//AU MY
app.get('/music-list/quoc-gia/au-my',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("movie").find({"nhac.quocgia":"Âu Mỹ"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//TRUNGQUOC
app.get('/music-list/quoc-gia/trung-quoc',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Trung Quốc"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//HANQUOC
app.get('/music-list/quoc-gia/han-quoc',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Hàn Quốc"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})
//VIET NAM
app.get('/music-list/quoc-gia/viet-nam',function (req, res) {
  MongoClient.connect(url,{ useNewUrlParser: true }, function (err, db) {
    if (err) throw err;
    var dbo = db.db("MUSIC");
    dbo.collection("Baihat").find({"nhac.quocgia":"Việt Nam"}).toArray(function (err, result) {
      if (err) throw err;
      res.render('output', { result: result });
      db.close();
    });
  });
})

console.log('3000 is the magic port');

app.listen(3000);
