package org.example.asymetric.create;

import org.bouncycastle.util.encoders.Base64;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Scanner;

public class CreateSignature {
    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private Signature signature;

    public CreateSignature() throws NoSuchAlgorithmException {
        this.keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        this.keyPairGenerator.initialize(2048);
        this.keyPair=keyPairGenerator.generateKeyPair();
        this.signature=Signature.getInstance("SHA256withRSA");
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public byte[] generateSignature(String message) throws InvalidKeyException, SignatureException, UnsupportedEncodingException {
        signature.initSign(getPrivateKey());
        byte[] bytes=message.getBytes();
        signature.update(bytes);
        byte[] finalSignature=signature.sign();
        return finalSignature;
    }

    public String convertSignature(byte[] signature){//convert signature
        return new String(Base64.encode(signature));
    }

    public String convertPublicKey(PublicKey publicKey){//convert publicKey
        return new String(Base64.encode(publicKey.getEncoded()));
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, SignatureException, InvalidKeyException {
        //CREATE PUBLIC AND PRIVATE KEY
        CreateSignature createSignature = new CreateSignature();//create object
        System.out.println("== Private Key ==");
        System.out.println(createSignature.getPrivateKey());
        System.out.println("== Public Key ==");
        System.out.println(createSignature.getPublicKey());

        //CREATE SIGNATURE
        Scanner input = new Scanner(System.in);
        System.out.println("== INSERT THE MESSAGE TO ENCRYPT ==");
        String message = input.nextLine();
        byte[] signature = createSignature.generateSignature(message);
        System.out.println("== SIGNATURE BEFORE CONVERT ==");
        System.out.println(signature);

        //CONVERT SIGNATURE
        String signatureString = createSignature.convertSignature(signature);
        System.out.println("== SIGNATURE AFTER CONVERT ==");
        System.out.println(signatureString);

        //CONVERT PUBLIC KEY
        String publicKeyString = createSignature.convertPublicKey(createSignature.getPublicKey());
        System.out.println("== PUBLIC KEY AFTER CONVERT ==");
        System.out.println(publicKeyString);

    }
}
