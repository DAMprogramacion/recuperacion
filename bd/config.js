//para la conexión usamos un paquete llamado mongoose
const mongoose = require('mongoose')

const conectar = async () => {
    try {
        await mongoose.connect(process.env.URL_MONGO, )
        console.log('Conectado a la BD de mongoDB')
    } catch (error) {
        console.log(error)
    }
}

module.exports = conectar