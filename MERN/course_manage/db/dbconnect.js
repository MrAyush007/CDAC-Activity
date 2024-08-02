// const mysql=require("mysql2")

// var mysqlConnection=mysql.createConnection({
//     host:'127.0.0.1',
//     user:'root',
//     password:'1233',
//     database:'courses',
//     port:3306
// })

// mysqlConnection.connect((err)=>{
//     if(!err){
//         console.log("Db connected!!")
//     }
//     else{
//         console.log(err)
//     }
// })



const mongooose = require("mongoose")

async function connectDb(url) {

    return mongooose.connect(url);
    
}

module.exports = {connectDb}