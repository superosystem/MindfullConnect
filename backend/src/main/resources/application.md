ktor {
    deployment {
        port = 8080
        port = ${?PORT}
    }
    application {
        modules = [ dev.gusriil.mindfullconnect.backend.ApplicationKt.module ]
    }
}
db {
   host = ${DBHOST}
   port = ${DBPORT}
   name = ${DBNAME}
   user = ${DBUSER}
   password = ${DBPASSWORD}
   driver = ${DBDRIVER}
}
jwt {
   secret = ${JWTSECRET}
   issuer = ${JWTISSUER}
   audience = ${JWTAUDIENCE}
   realm = ${JWTREALM}
}

aws{
   accessKey = ${AWSACCESSKEY}
   secretKey = ${AWSSECRETKEY}
}

cloudinary{
    cloudName = ${CLNAME}
    apiKey = ${CLAPIKEY}
    apiSecret = ${CLAPISECRET}
}
