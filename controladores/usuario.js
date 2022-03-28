const { response } = require('express')
const Usuario =  require('../modelos/Usuario')
const { generarToken } =  require('../helpers/jwt')
const bcrypt = require('bcrypt')
const saltRounds = 10
const registrar = async (req, res = response) => {
  
   let {nombre, email, password} = req.body
 
   try {
        let nuevoUsuario = await Usuario.findOne( {email} )
  
        if (nuevoUsuario) {
        return  res.status(400).json({
            ok: false,
            msg: 'email ya existe'
            
            })
        }
        password = bcrypt.hashSync(password + '', saltRounds)
        nuevoUsuario = new Usuario({nombre, email, password})
        await nuevoUsuario.save()
        return res.status(201).json({
            ok: true,
            nombre : nuevoUsuario.nombre,
            email : nuevoUsuario.email
        })
    
    } catch (error) {
        console.log(error)
    }  
   
}

const loguear = async (req, res = response) => {
   
    const { email, password } = req.body
    //consultar la BD para saber si el email existe
    try {
        const nuevoUsuario = await Usuario.findOne( {email} )
    //si no existe, mala petición y se acaba return
    if (!nuevoUsuario) {
        return  res.status(400).json({
            ok: false,
            msg: 'no existe ese email'
            
            })
        }
    //desciframos la contraseña bcrypt.compareSync(myPlaintextPassword, hash)
    if (! bcrypt.compareSync(password + '', nuevoUsuario.password)) {
        return  res.status(400).json({
            ok: false,
            msg: 'password no válida'
            
        })
        
    }
    //si no es la misma contraseña
    //mala petición 400 status  y se acaba return
    //esto:
    //generar un token jwt
    token = await generarToken(nuevoUsuario.id, nuevoUsuario.email)
    res.status(201).json({
        ok: true,
        msg: 'usuario autenticado', 
        token
        
     })
    } catch (error) {
        console.log(error)
        return  res.status(500).json({
            ok: false,
            msg: 'error de servidor'
            
        })
       
    }
    
}

module.exports = {
    registrar, loguear
}