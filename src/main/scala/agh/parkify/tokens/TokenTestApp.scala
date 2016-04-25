package agh.parkify

import agh.parkify.tokens.TokenManager

object TokenTestApp extends App {

  override def main(args: Array[String]) {
    val tokenManager: TokenManager = new TokenManager(1, 3)
    tokenManager.addSubmissionBonus(1)
    tokenManager.addSubmissionBonus(1, 10)
    tokenManager.addUsageLoss(1, 5)
    tokenManager.addSubmissionBonus(2, 4)
    println(tokenManager.tryAddUsageLoss(1, 10))
    println(tokenManager.getUserPointsSum(1))
  }
}
