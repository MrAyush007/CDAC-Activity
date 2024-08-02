const express=require("express");
const Course = require("../model/cource");
const router=express.Router();



//get all courses


router.get("/courses", async (req , res) => {
        const course = await Course.find({});
        if (!course) {
            return res.status(404).json({ err: "notfound" });
        }
        res.render('display_course', { coursdata: course }); // Use res.json to send data as JSON
    
});


// router.get("/courses", async (req, res) => {
//     try {
//         const coursdata = await Course.find({});
//         if (!coursdata) {
//             return res.status(404).json({ err: "notfound" });
//         }
//         return res.json(coursdata); // Use res.json to send data as JSON
//     } catch (error) {
//         return res.status(500).json({ err: "server error", message: error.message });
//     }
// });

//empty form to add data
router.get("/addcourseform",function(req,resp){
    resp.render("add_course")
})


//add course
router.post('/insertcourse', async (req, res) => {
    try {
        const newCourse = new Course({
            cid: req.body.cid,
            cname: req.body.cname,
            qty: req.body.qty
        });
        await newCourse.save();
        res.redirect('/courses');
    } catch (err) {
        res.status(500).send('Data not inserted!!');
    }
});


//delete course
router.get('/deletecourse/:id', async (req, res) => {
    try {
        const result = await Course.deleteOne({ cid: req.params.id });
        if (result.deletedCount > 0) {
            res.redirect('/courses');
        } else {
            res.status(404).send('Data not found!!');
        }
    } catch (err) {
        res.status(500).send('Error Occurred!!');
    }
});


//update firstly take id
router.get('/editcourse/:id', async (req, res) => {
    try {
        const course = await Course.findOne({ cid: req.params.id });
        if (course) {
            res.render('update_course', { cour: course });
        } else {
            res.status(404).send('Data not found!!');
        }
    } catch (err) {
        res.status(500).send('Error Occurred!!');
    }
});

//update actual data
router.post('/updatecourse', async (req, res) => {
    try {
        const result = await Course.updateOne(
            { cid: req.body.cid },
            { cname: req.body.cname, qty: req.body.qty }
        );
        if (result) {
            res.redirect('/courses');
        } else {
            res.status(404).send('Data not found!!');
        }
    } catch (err) {
        res.status(500).send('Data not updated!!');
    }
});

module.exports=router;