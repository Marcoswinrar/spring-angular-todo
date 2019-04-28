const express = require('express')
    ,app = express()
    ,bodyParser = require('body-parser')
    ,cors = require('cors');

app.use(express.static('./public'));
app.use(bodyParser.urlencoded({extended: true}));
app.use(cors());
app.use(bodyParser.json());

module.exports = app;