package com.blockchain.simulator

import com.blockchain.simulator.domain.Block
import com.blockchain.simulator.domain.Rules
import com.blockchain.simulator.domain.Transaction
import java.math.BigInteger

/**
 * We assume this blockchain is being mined by only one miner!
 */
data class Miner(val address: String, val blockChain: List<Block> = emptyList<Block>()) {
    fun findNextBlock(transactions: List<Transaction>): Miner {
        (0..Int.MAX_VALUE).find { nonce ->
            val previousBlock = blockChain.last()

            val difficulty = Rules.difficulty(blockChain.size)

            // add the mining reward to the transactions
            val amendedTransactions = transactions + Transaction("created", address, Rules.MINING_REWARD)

            val attemptedBlock = Block(previousBlock.height + 1,
                                        difficulty,
                                        previousBlock.hash(),
                                        nonce.toString(),
                                        amendedTransactions)

            BigInteger(attemptedBlock.hash(), 16) < BigInteger(Rules.difficultyHash(difficulty))
        }


    }
}