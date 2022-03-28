//para la conexión usamos un paquete llamado mongoose
const mongoose = require('mongoose')

const conectar = async () => {
    try {
        await mongoose.connect('mongodb://172.17.0.2/appRecuperacion', )
        console.log('Conectado a la BD de mongoDB')
    } catch (error) {
        console.log(error)
    }
}

module.exports = conectar