const express=require("express")
const app=express();
const path=require("path")
const routes=require("./routes/router")
const bodyParser=require("body-parser");
const { connectDb } = require("./db/dbconnect");

connectDb("mongodb://localhost:27017/Wpt_test").then(()=>console.log("database connected"));

app.set("views",path.join(__dirname,"views"))
app.set("view engine","ejs");


app.use(express.urlencoded({extended:false}))
app.use("/",routes)

app.listen(8080,function(){
    console.log("Server started on port 3002")
})

module.exports=app;