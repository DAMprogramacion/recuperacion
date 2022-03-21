const { response } = require('express')

const registrar = (req, res = response) => {
   // console.log('body', req.body)
   const {nombre, email, password} = req.body
    
   res.status(201).json({
        ok: true,
        nombre,
        email, 
        password
    })
}

module.exports = {
    registrar
}