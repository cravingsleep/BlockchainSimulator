package com.blockchain.simulator.domain

data class Block(val height: Int, val hash: String, val transactions: List<Transaction>) {
    companion object {
        val GENESIS_BLOCK = Block(0, "0", emptyList<Transaction>())
    }
}