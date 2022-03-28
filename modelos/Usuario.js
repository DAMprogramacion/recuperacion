const { Schema, model } = require('mongoose')

const UsarioSchema = new Schema (
    {
        nombre: { type: String, required : true },
        email : { type: String, required : true, unique : true},
        password : { type: String, required : true },
    }
)

const Usuario = model('Usuario', UsarioSchema)

module.exports = Usuario