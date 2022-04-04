const { Schema, model } = require('mongoose')

const CocheSchema = new Schema (
    {
        marca: { 
            type: String, 
            required : true 
        },
        modelo : {
             type: String, 
             required : true
        },
        matricula : { 
            type: String, 
            unique : true,
            required : true 
        },
        id_usuario : {
            type: Schema.Types.ObjectId,
            ref: 'Usuario',
            required : true
        }
    }
)

const Coche = model('Coche', CocheSchema)

module.exports = Coche