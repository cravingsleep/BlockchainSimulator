package com.blockchain.simulator.domain

object Rules {
    val MINING_REWARD = 50.0

    fun difficulty(blockChainHeight: Int): Int = Math.max(1, blockChainHeight / 2016)

    fun difficultyHash(difficulty: Int): String = "0FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"
}