package com.blockchain.simulator

import com.blockchain.simulator.domain.Transaction
import java.util.*

fun main(args: Array<String>) {
    val singleMiner = Miner(UUID.randomUUID().toString())
    val nextBlock = singleMiner.findNextBlock(emptyList<Transaction>())

    nextBlock.blockChain.forEach { println(it) }
}