# asymetric-java
In This project i describe How to create PublicKey, privateKey, Signature and VerifySignature
# Prerequisite
1. You understand the concept of asymetric
2. You familiar create maven project using intellij idea


In this tutorial i will use this scenario
1. create publicKey and privateKey
2. generate signature using private key and message(signature=privatekey+message)
3. convert signature into readable format(Base64)
4. convert publickey into readable format(to store public key into database)
5. verify signature using publickey


Let's jump right in

A. PREPARATION
1. add dependency in pom.xml
2. create class CreateSignature and add property KeyPairGenerator, KeyPair, PrivateKey, PublicKey and Signature 
3. create constructor 
   - and initialize keyPairGenerator with RSA algorithm
   - generate private and public key using keyPair
   - create signature using algorithm SHA256withRSA

B. GET KEYPAIR(Private and Public)
1. create method to get PrivateKey and get PublicKey
2. create Object and try to call getPrivateKey and getPublicKey

C.CREATE SIGNATURE 
1. after public and private key already created, 
2. create method to generate signature using private key and message


D. CONVERT PUBLIC KEY and SIGNATURE
1. if you want public key store in database, convert it using Base64 BouncyCastle's
2. create method to convert PublicKey into readable format using Base64 BouncyCastle's
3. create method to convert signature into readable format using Base64 BouncyCastle's
4. backup signature, publicKey and message
--BACKUP--
 === AtUZR4G1TGaGoaygIRDU8c6ZgOthoX/uoF153lcxGpcJBeVlFasnbmQOfkNGiRccTZ9FOOzZr2Z51G1VMoAD4ibeNbnI7ED7E7SR06N4yKW8UQrxXRy5+qT8UqlS6aOXmh3Pupp36ICXFk6BD27G9t4k5bkbVkvWwJkE2TP/+0Et38JiEmcDzjuiClx2H1K8FWR4X+6NLCAFyLMHMyfYRS26X8b6kxt+kB3JfT0wVAEpjoRmkP6A2OUxz7oBBevPW2Yerv/eLZv15NwmnUNnt3SyRjQ89HI9eNVwBwUqCRpiGUdskLgBIC2HyqZoBrGhGTzpout2CKDIZV+v4M1yrw==
 === MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAikUEjc12iIGp9gcILcx3Zq0mN3c59QuB9LSTA4uQAPAhQc21fY9wRqHMBxNYn7xwrsU5Yt/wfmuiWruGhCM6WsYofJXce2l+TIezkFLoqIqhbNJhlRHYLvEwNk6z72W2EbOSe0kghMiVaZkkZJk7lHNg1v+Lc1pa/E/maJhiAPWAVnhGee415A87I/YiyaXij9gpPkQrG5rzEm6OSDGOOvYcwgBQg5p2rTXQnFwuPZlurnAE2Po0ctbwprHIdirVqHdODDBBRqMTMxHog8rrJRGvrZXfE7J1gUme8hIg3JyYHFoAifAeq6zTZx3yCKOzB1maLPcIzSKlmXMZxEzsQQIDAQAB
 === MESSAGE

E. VERIFY SIGNATURE
0. create class to verify signature
1. create method for deconvert signature from string into byte
2. create method for deconvert publicKey from string into public key
3. create method to verify signature

SUCCESS, HAPPY LEARNING AND HAPPY SHARING.
