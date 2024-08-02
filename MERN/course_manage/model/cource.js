const mongoose = require('mongoose');

const cSchema = mongoose.Schema({
    cid:{
        type:String,
        required: true
    },
    cname:{
        type:String,
        required: true
    },
    qty:{
        type:Number,
        required: true
    },

})

const Course = mongoose.model("course",cSchema)

module.exports = Course;