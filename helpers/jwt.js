const jwt = require('jsonwebtoken')

const generarToken = (id, email) => {
    return new Promise ((resolve, reject) => {
        const payload = {id, email}
        console.log('payload', payload);
        jwt.sign(payload , process.env.SECRET_KEY, {expiresIn : '1h'}, (err, token) => {
            if (err) {
                console.log(err);
                reject('no se puede generar token')
            }
            resolve(token)
        })
    })
}

module.exports = { generarToken }