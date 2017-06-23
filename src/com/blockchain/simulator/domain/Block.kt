package com.blockchain.simulator.domain

import org.apache.commons.codec.digest.DigestUtils

data class Block(val height: Int, val difficulty: Int, val previousBlockHash: String, val nonce: String, val transactions: List<Transaction>) {
    companion object {
        val GENESIS_BLOCK = Block(0, 0, DigestUtils.sha256Hex(""), "0", emptyList<Transaction>())
    }

    fun hash(): String =
            DigestUtils.sha256Hex(height.toString() + difficulty.toString() +
                    previousBlockHash + nonce + transactions.toString())
}