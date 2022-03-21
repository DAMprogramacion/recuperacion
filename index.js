const express = require('express')
require('dotenv').config()
//console.log(process.env)
const usuario = require('./rutas/usuario')

const app = express()

//trabajamos con json en la aplicación
app.use(express.json())

//definimos las rutas de usario
app.use('/usuarios', usuario)

app.get('/',  (req, res) => {
  res.send('Hola Mundo')
})

const PORT = process.env.DEV_PORT || 3000
app.listen(PORT, () => console.log(`Servidor corriendo en el puerto ${PORT}`))