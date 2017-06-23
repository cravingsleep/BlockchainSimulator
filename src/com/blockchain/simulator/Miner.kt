package com.blockchain.simulator

import com.blockchain.simulator.domain.Block
import com.blockchain.simulator.domain.Rules
import com.blockchain.simulator.domain.Transaction
import java.math.BigInteger
import java.util.*

/**
 * We assume this blockchain is being mined by only one miner!
 */
data class Miner(val address: String, val blockChain: List<Block> = listOf(Block.GENESIS_BLOCK)) {
    fun findNextBlock(transactions: List<Transaction>): Miner {
        // add the mining reward to the transactions
        val amendedTransactions = transactions + Transaction("created", address, Rules.MINING_REWARD)

        val previousBlock = blockChain.last()

        val difficulty = Rules.difficulty(blockChain.size)

        val correctNonce = (0..Long.MAX_VALUE).find { nonce ->
            val attemptedBlock = Block(previousBlock.height + 1,
                                        difficulty,
                                        previousBlock.hash(),
                                        nonce.toString(),
                                        amendedTransactions)

            println(attemptedBlock.hash().toByteArray(Charsets.UTF_8).size)

            BigInteger(attemptedBlock.hash(), 16) < BigInteger(Rules.difficultyHash(difficulty), 16)
        }

        val correctBlock = Block(previousBlock.height + 1,
                difficulty,
                previousBlock.hash(),
                correctNonce.toString(),
                amendedTransactions)

        return Miner(address, blockChain + correctBlock)
    }
}