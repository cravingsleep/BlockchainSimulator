package com.blockchain.simulator

import org.apache.commons.codec.digest.DigestUtils

fun main(args: Array<String>) {
    println(DigestUtils.sha256Hex("0"))
}