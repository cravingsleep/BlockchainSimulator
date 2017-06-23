package com.blockchain.simulator.domain

object Rules {
    val MINING_REWARD = 50.0

    fun difficulty(blockChainHeight: Int): Int = 1

    fun difficultyHash(difficulty: Int): String = ("".padStart(difficulty, '0') + "1").padEnd(255 - difficulty, '0')
}