package com.cont.mystudy

import org.junit.Test

import org.junit.Assert.*
import java.security.*
import java.util.*
import javax.crypto.Cipher

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //*************算法***************************************************

    //****************************************************************

    @Test
    fun generateKeyPair() {
        val keyPair = KeyPairGenerator.getInstance("RSA");
        keyPair.initialize(2048, SecureRandom())
        val genKeyPair = keyPair.genKeyPair()
        val publicKey = genKeyPair.public
        val privateKey = genKeyPair.private

        val str = "你好！"
        val encrypt = encrypt(str, publicKey)
        println(encrypt)

        println(decrypt(encrypt, privateKey))

    }

    fun encrypt(str: String, publicKey: PublicKey): String {
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        val doFinal = cipher.doFinal(str.toByteArray())
        val encode = Base64.getEncoder().encode(doFinal)
        return String(encode)
    }

    fun decrypt(str: String, privateKey: PrivateKey): String {
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        val decode = Base64.getDecoder().decode(str)
        val doFinal = cipher.doFinal(decode)
        return String(doFinal)
    }

    @Test
    fun textLinkedList() {
        val linkedList = LinkedList<String>()
        linkedList.add("1")
        linkedList.add("3")
        linkedList.add("7")
        linkedList.add(0, "7")

        for (i in 0 until linkedList.size) {
            println("第${i}个元素是${linkedList.getNodeByIndex(i).data}")
        }
    }

}
