package com.blockchain.simulator.domain

import org.apache.commons.codec.digest.DigestUtils

data class Block(val height: Int, val difficulty: Int, val previousBlockHash: String, val nonce: String, val transactions: List<Transaction>) {
    companion object {
        val GENESIS_BLOCK = Block(0, 0, DigestUtils.sha256Hex(""), "", emptyList<Transaction>())
    }

    fun hash(): String =
            DigestUtils.sha256Hex(height.toString() + difficulty.toString() +
                    previousBlockHash + nonce + transactions.toString())
}

/*
A difficulty of 1 represents the fact that the miner has to find a nonce which produces a hash such that:

sha256(previousBlockHash + nonce) < 0x1000000000...
 */