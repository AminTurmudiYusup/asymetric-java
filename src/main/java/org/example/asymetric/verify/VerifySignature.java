package org.example.asymetric.verify;

import org.bouncycastle.util.encoders.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class VerifySignature {
    public static PublicKey deConvertPublicKey(String publicKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicKeyByte = Base64.decode(publicKeyString.getBytes());
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyByte));
        return publicKey;
    }

    public static byte[] deConvertSignature(String signatureString) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] signature = Base64.decode(signatureString.getBytes());
        return signature;
    }

    public static boolean verifySignature(String message, byte[] signature, PublicKey publicKey) throws InvalidKeyException, SignatureException, UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] messageByte = message.getBytes();
        Signature signature1 = Signature.getInstance("SHA256withRSA");
        signature1.initVerify(publicKey);
        signature1.update(messageByte);
        return signature1.verify(signature);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException, SignatureException, InvalidKeyException {
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAikUEjc12iIGp9gcILcx3Zq0mN3c59QuB9LSTA4uQAPAhQc21fY9wRqHMBxNYn7xwrsU5Yt/wfmuiWruGhCM6WsYofJXce2l+TIezkFLoqIqhbNJhlRHYLvEwNk6z72W2EbOSe0kghMiVaZkkZJk7lHNg1v+Lc1pa/E/maJhiAPWAVnhGee415A87I/YiyaXij9gpPkQrG5rzEm6OSDGOOvYcwgBQg5p2rTXQnFwuPZlurnAE2Po0ctbwprHIdirVqHdODDBBRqMTMxHog8rrJRGvrZXfE7J1gUme8hIg3JyYHFoAifAeq6zTZx3yCKOzB1maLPcIzSKlmXMZxEzsQQIDAQAB";
        String signature = "AtUZR4G1TGaGoaygIRDU8c6ZgOthoX/uoF153lcxGpcJBeVlFasnbmQOfkNGiRccTZ9FOOzZr2Z51G1VMoAD4ibeNbnI7ED7E7SR06N4yKW8UQrxXRy5+qT8UqlS6aOXmh3Pupp36ICXFk6BD27G9t4k5bkbVkvWwJkE2TP/+0Et38JiEmcDzjuiClx2H1K8FWR4X+6NLCAFyLMHMyfYRS26X8b6kxt+kB3JfT0wVAEpjoRmkP6A2OUxz7oBBevPW2Yerv/eLZv15NwmnUNnt3SyRjQ89HI9eNVwBwUqCRpiGUdskLgBIC2HyqZoBrGhGTzpout2CKDIZV+v4M1yrw==";
        String message = "MESSAGE";
        System.out.println("== PUBLIC KEY AFTER DECONVERT ==");
        PublicKey publicKeyDeConvert = VerifySignature.deConvertPublicKey(publicKey);
        System.out.println(publicKeyDeConvert);

        System.out.println("== SIGNATURE AFTER DECONVERT ==");
        byte[] signatureDeConvert = VerifySignature.deConvertSignature(signature);
        System.out.println(signatureDeConvert);

        System.out.println("== VERIFY SIGNATURE ==");
        boolean result = VerifySignature.verifySignature(message, signatureDeConvert, publicKeyDeConvert);
        System.out.println(result);

    }
}
