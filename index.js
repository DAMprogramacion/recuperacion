const express = require('express')
require('dotenv').config()
const conectar = require('./bd/config')
conectar()
//y nos conectamos0
//console.log(process.env)
const usuario = require('./rutas/usuario')
const coche = require('./rutas/coche')


const app = express()

//trabajamos con json en la aplicación
app.use(express.json())

//definimos las rutas de usario
app.use('/usuarios', usuario)
//definimos las rutas de coches
app.use('/coches', coche)


app.get('/',  (req, res) => {
  res.send('Bienvenido a la app del proyecto')
})

const PORT = process.env.DEV_PORT || 3000
app.listen(PORT, () => console.log(`Servidor corriendo en el puerto ${PORT}`))